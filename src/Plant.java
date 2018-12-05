
import java.awt.Point;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.ImageIcon;

public class Plant extends LivingThings {

    private final ImageIcon image = new ImageIcon("src/plant.gif");
    private Pasture pasture;
    private int tickCount = 0;

    public Plant(Pasture pasture) {
        this.pasture = pasture;
    }

    public Plant(Pasture pasture, Point position) {
        this.pasture = pasture;
        this.position = position;
    }

    public void tick() {
        tickCount++;
        if (tickCount % 3 == 0) {
            tickCount = 0;

            int dx = newDirection();
            int dy = newDirection();
            
            pasture.newPlantPosition();

            if (getPosition().getX() + dx < pasture.getWidth()
                    && getPosition().getX() + dx >= 0
                    && getPosition().getY() + dy < pasture.getHeight()
                    && getPosition().getY() + dy >= 0) {

                boolean emptySpace = true;

                Collection world = pasture.getEntities();
                Iterator it = world.iterator();
                // går igenom hela världen och undersöker varje objekt och
                // se om det har samma koordinater som den puntkt vi går på

                while (it.hasNext() && emptySpace) {
                    // hämta ut entity ur listan
                    Entity whatIsHere = (Entity) it.next();
                    // undersök om positionen är upptagen.
                    int existingX = (int) whatIsHere.getPosition().getX();
                    int existingY = (int) whatIsHere.getPosition().getY();
                    if (existingX == this.getPosition().getX() + dx
                            && existingY == this.getPosition().getY() + dy) {
                        emptySpace = false;

                    }
                }
                if(emptySpace){
                    
                    // skapa planta och plantera
                    
                    Point newPlantPosition = new Point();
                    newPlantPosition.x = (int)this.getPosition().getX() + dx;
                    newPlantPosition.y = (int)this.getPosition().getY() + dy;
                    
                    Entity plant = new Plant(pasture,newPlantPosition);
                }

            }

        }

    }

    public ImageIcon getImage() {
        return image;

    }

    public String type() {
        return "Plant";
    }
}
