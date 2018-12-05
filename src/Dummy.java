
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Dummy implements Entity {

    private final ImageIcon image = new ImageIcon("src/unknown.gif");

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

    public void setPosition(Point newPosition) {
        position = newPosition;
    }

    public int newDirection() {
        return (int) (Math.floor(Math.random() * Math.floor(3)) - 1);
    }

    public void tick() {

        //slumpar fram nya koordinater
        int dx = newDirection();
        int dy = newDirection();

        //kolla om x och y-koordinat är inom griden
        if (getPosition().getX() + dx < pasture.getWidth()
                && getPosition().getX() + dx >= 0
                && getPosition().getY() + dy < pasture.getHeight()
                && getPosition().getY() + dy >= 0) {

            // sätt in ny punkt
            setPosition(
                    new Point(
                            (int) getPosition().getX() + dx,
                            (int) getPosition().getY() + dy));
        }
    }

    public String type() {
        return "Dummy";
    }

    public ImageIcon getImage() {
        return image;
    }

}
