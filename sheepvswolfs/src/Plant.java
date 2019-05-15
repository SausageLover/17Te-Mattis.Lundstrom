import java.awt.Point;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.ImageIcon;

public class Plant extends LivingThing {

	private int currentTick = 0;

	private final ImageIcon image = new ImageIcon("src/plant.gif");

	public Plant(Pasture pasture) {
		this.pasture = pasture;
	}

	public Plant(Pasture pasture, Point position) {
		this.pasture = pasture;
		this.position = position;
	}

	public void tick() {

		int countPlants = pasture.countEntity("Plant");
		
		currentTick++;
		if (currentTick % 5 == 0) {
			// Slumpa i vilken riktning plantan ska växa.
			int x = getRandom();
			int y = getRandom();
			currentTick = 0;

			// Först så ska vi undersöka om den nya koordinaten finns inom
			// spelplanen
			// för att kunna skapa den öht.

			if (position.getX()+x >= 0 && position.getX()+x < pasture.getWidth() && position.getY()+y >= 0
					&& position.getY()+y < pasture.getHeight()) {

				// Kolla om det finns någonting på den plats där en planta
				// kommer att växa upp.
				// Om inte, så låt en planta växa där.
				boolean emptySpace = true;
				Collection world = pasture.getEntities();
				Iterator it = world.iterator();

				while (it.hasNext()) {
					Entity e = (Entity) it.next();
					int existingX = (int) e.getPosition().getX();
					int existingY = (int) e.getPosition().getY();

					if (existingX == this.getPosition().getX() + x
							&& existingY == this.getPosition().getY() + y)
						emptySpace = false;
				}

				if (emptySpace){
					// Skapa en ny planta på ny position
					Point position = new Point();
					position.x = (int) this.getPosition().getX() + x;
					position.y = (int) this.getPosition().getY() + y;

					// Sätt ut en planta på den nya positionen, om den inte är
					// utanför planen.
					Entity plant = new Plant(pasture, position);
					pasture.addEntity(plant);					
				}
			}
		}
	}

	public String type() {
		return "Plant";
	}

	public ImageIcon getImage() {
		return image;
	}
}