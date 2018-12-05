import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class PastureGUI extends JFrame implements ActionListener {

    

    public static void main(String[] args) {
        PastureGUI gui = new PastureGUI();
    }
    
    /** Icon for an empty position in the pasture */
    private final ImageIcon    II_EMPTY       = new ImageIcon("empty.gif");
      /** The pasture this class should display */
    private Pasture            pasture;
    /** The grid, i.e., the field containing the images to display. */
    private JLabel[][]         grid;
    /** The button for starting the simulation. */
    private JButton            startButton    = new JButton("Start");
    
    private JButton            stopButton     = new JButton("Stop");
    
    private JButton            exitButton     = new JButton("Exit");
    
    public PastureGUI() {
	pasture = new Pasture(this);
	initPastureGUI();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void initPastureGUI() {
        setSize(pasture.getWidth()*30, pasture.getHeight()*30);
	
	startButton.addActionListener(this);
        stopButton.addActionListener(this);
        exitButton.addActionListener(this);
             	
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1,1));
        buttons.add(startButton);
        buttons.add(stopButton);
        buttons.add(exitButton);

	JPanel field = new JPanel();
        field.setBackground(new Color(27,204,89));
        field.setLayout(new GridLayout(pasture.getHeight(),
				       pasture.getWidth()));
        grid = new JLabel[pasture.getWidth()][pasture.getHeight()];
	
        for (int y = 0; y < pasture.getHeight(); y++) {
            for (int x = 0; x < pasture.getWidth(); x++) {
                grid[x][y] = new JLabel(II_EMPTY);
                grid[x][y].setVisible(true);
                field.add(grid[x][y]);
            }
        }
	
	Container display = getContentPane();
        display.setBackground(new Color(27,204,89));
        display.setLayout(new BorderLayout());
        display.add(field,BorderLayout.CENTER);
        display.add(buttons,BorderLayout.SOUTH);

	startButton.setEnabled(true);
	updateAll();
	setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == startButton) {
	    startButton.setEnabled(false);	
	    pasture.start();
            stopButton.setEnabled(true);
	}
        if (e.getSource() == stopButton) {
	    stopButton.setEnabled(false);	
	    pasture.stop();  
            startButton.setEnabled(true);
	}
        if (e.getSource() == exitButton) {
	    exitButton.setEnabled(false);
            pasture.exit();
	}
    }

    

    public void updateAll() {
	int width  = pasture.getWidth();
	int height = pasture.getHeight();
	
        Entity[][] tempGrid = 
	    new Entity[width][height];


        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                tempGrid[x][y] = null;
	
        Collection world  = pasture.getEntities();
	Iterator   it     = world.iterator();
	
	while (it.hasNext()) {
	    Entity e = (Entity)it.next(); 
	    int    x = (int)e.getPosition().getX();
	    int    y = (int)e.getPosition().getY();
                
	    if (tempGrid[x][y] == null)	tempGrid[x][y] = e;
	}
	
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
		ImageIcon icon ;
                Entity    e    = tempGrid[x][y];
		
                if (e == null) icon = II_EMPTY;
		else icon = e.getImage();
		grid[x][height - y - 1].setIcon(icon);
            }
        }
    }
}

