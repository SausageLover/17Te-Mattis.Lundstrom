import java.awt.Point;

import javax.swing.ImageIcon;

public abstract class LivingThing implements Entity{

	protected Point position;
	
	protected Pasture pasture;
	
	public int getRandom()
	// Returnerar ett slumptal mellan -1 och 1, jämnt fördelat.
	{
		return (int) ((Math.random())*3)-1;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point newPosition)
	// Vi kontrollerar om den nya punkten finns inom rutnätet och byter så är fallet.
	{
		if (newPosition.getX() < pasture.getWidth() && newPosition.getX() >= 0
				&& newPosition.getY() < pasture.getHeight() && newPosition.getY() >= 0)
			position = newPosition;
	}

	abstract public void tick();

	abstract public String type();
	
	abstract public ImageIcon getImage();
	
}