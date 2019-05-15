import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Dummy implements Entity {

	private final ImageIcon image = new ImageIcon("bin/unknown.gif");

	protected Point position;

	protected Pasture pasture;

	public Dummy(Pasture pasture) {
		this.pasture = pasture;
	}

	public Dummy(Pasture pasture, Point position) {
		this.pasture = pasture;
		this.position = position;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point newPosition)
	// Vi kontrollerar om den nya punkten finns inom rutnätet och byter så är fallet.
	{
		if (newPosition.getX() < pasture.getWidth() && newPosition.getX() > 0
				&& newPosition.getY() < pasture.getHeight() && newPosition.getY() > 0)
			position = newPosition;
	}

	private int getRandom()
	// Returnerar ett slumptal mellan -1 och 1, jämnt fördelat.
	{
		return (int) ((Math.random())*3)-1;
	}
	
	public void tick() {
		setPosition(new Point((int) getPosition().getX() + getRandom(),
				(int) getPosition().getY()+getRandom()));
	}

	public String type() {
		return "Dummy";
	}

	public ImageIcon getImage() {
		return image;
	}

}