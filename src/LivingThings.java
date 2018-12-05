
import java.awt.Point;
import javax.swing.ImageIcon;

public abstract class LivingThings implements Entity {

    protected Point position;

    public int newDirection() {
        return (int) (Math.floor(Math.random() * Math.floor(3)) - 1);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point newPosition) {
        position = newPosition;
    }

    abstract public void tick();

    abstract public ImageIcon getImage();

    abstract public String type();
}
