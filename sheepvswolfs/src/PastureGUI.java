import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class PastureGUI extends JFrame implements ActionListener {

	public static void main(String[] args) {
		PastureGUI gui = new PastureGUI();
	}

	/** Icon for an empty position in the pasture */
	private final ImageIcon II_EMPTY = new ImageIcon("src/empty.gif");
	/** The pasture this class should display */
	private Pasture pasture;
	/** The grid, i.e., the field containing the images to display. */
	private JLabel[][] grid;
	/** The button for starting the simulation. */
	private JButton startButton = new JButton("Start");
	private JButton stopButton = new JButton("Stop");
	private JButton exitButton = new JButton("Exit");
	private JButton respawnButton = new JButton("Respawn");

	public PastureGUI() {
		pasture = new Pasture(this);
		initPastureGUI();
	}

	private void initPastureGUI() {
		setSize(pasture.getWidth() * 30, pasture.getHeight() * 30);

		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		exitButton.addActionListener(this);
		respawnButton.addActionListener(this);

		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(1, 4));
		buttons.add(startButton);
		buttons.add(stopButton);
		buttons.add(respawnButton);
		buttons.add(exitButton);
		
		JPanel field = new JPanel();
		field.setBackground(new Color(27, 204, 89));
		field.setLayout(new GridLayout(pasture.getHeight(), pasture.getWidth()));
		grid = new JLabel[pasture.getWidth()][pasture.getHeight()];

		for (int y = 0; y < pasture.getHeight(); y++) {
			for (int x = 0; x < pasture.getWidth(); x++) {
				grid[x][y] = new JLabel(II_EMPTY);
				grid[x][y].setVisible(true);
				field.add(grid[x][y]);
			}
		}

		Container display = getContentPane();
		display.setBackground(new Color(127, 204, 189));
		display.setLayout(new BorderLayout());
		display.add(field, BorderLayout.CENTER);
		display.add(buttons, BorderLayout.SOUTH);

		startButton.setEnabled(true);
		stopButton.setEnabled(false);
		exitButton.setEnabled(true);
		respawnButton.setEnabled(false);
		updateAll();
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startButton) {
			startButton.setEnabled(false);
			stopButton.setEnabled(true);
			pasture.start();
		}
		if (e.getSource() == stopButton) {
			startButton.setEnabled(true);
			stopButton.setEnabled(false);
                        respawnButton.setEnabled(true);
			pasture.stop();
		}
		if (e.getSource() == respawnButton) {
		
		}
		if (e.getSource() == exitButton) {
			pasture.stop();
			System.exit(EXIT_ON_CLOSE);
		}
	}
	
	public void updateAll() {
		int width = pasture.getWidth();
		int height = pasture.getHeight();

		Entity[][] tempGrid = new Entity[width][height];

		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++)
				tempGrid[x][y] = null;

		Collection world = pasture.getEntities();
		Iterator it = world.iterator();

		while (it.hasNext()) {
			Entity e = (Entity) it.next();
			int x = (int) e.getPosition().getX();
			int y = (int) e.getPosition().getY();

			if (tempGrid[x][y] == null)
				tempGrid[x][y] = e;
		}

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				ImageIcon icon;
				Entity e = tempGrid[x][y];

				if (e == null)
					icon = II_EMPTY;
				else
					icon = e.getImage();
				grid[x][height - y - 1].setIcon(icon);
			}
		}
	}
}