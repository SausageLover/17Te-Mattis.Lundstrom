import java.awt.Point;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.ImageIcon;

public class Sheep extends Animal {

	private final ImageIcon image = new ImageIcon("src/sheep.gif");

	// Så här många tick kommer fåret att överleva utan mat.
	private int maxFood = 30;
	
	// Vi behöver se till att fåret får sin mat i båda varianterna av konstruktor.
	public Sheep(Pasture pasture) {
		this.pasture = pasture;
		super.setFood(maxFood);
	}

	public Sheep(Pasture pasture, Point position) {
		this.pasture = pasture;
		this.position = position;
		super.setFood(maxFood);
	}
	
	// Slytten sker i superklassen, eftersom det är samma rörelsemönster i får och varg.
	public void tick() {
		
		// Fåret rör sig och om det hamnar på en position där det är en planta, så ska 
		// hälsa ökas till 10 och plantan försvinna.
	
		// Superklassens metod move är inte tillämpbar nu, eftersom vi behöver kunna hantera
		// att fåret äter gräs, om det finns.
//		super.move();

		// Vi börjar att slumpa en ny plats för fåret att gå till.
		int x = getRandom();
		int y = getRandom();
		
		// Först så ska vi undersöka om den nya koordinaten finns inom
		// spelplanen
		// för att kunna gå dit öht.

		if (position.getX()+x >= 0 && position.getX()+x < pasture.getWidth() && position.getY()+y >= 0
				&& position.getY()+y < pasture.getHeight()) {

			// Kolla om det finns mat på platsen dit fåret går.
			// Om ja, sätt hälsa till 10 och ta bort plantan.
			boolean isFood = false;
			Collection world = pasture.getEntities();
			Iterator it = world.iterator();

			while (it.hasNext()) {
				Entity e = (Entity) it.next();
				int existingX = (int) e.getPosition().getX();
				int existingY = (int) e.getPosition().getY();

				if (existingX == this.getPosition().getX() + x
						&& existingY == this.getPosition().getY() + y
						&& e.type().equals("Plant")){
					isFood = true;
					pasture.removeEntity(e);		
				}
			}
			// Om det inte fanns mat på nya positionen, minska food med 1 och 
			// gå till den nya positionen.
			if (isFood){ 
				// Löser problemet (fult) att food minskas i setPosition.
				super.setFood(maxFood+1);
			}
			else if(isFood && getCurrentFood()==1)
			{
				this.setFood(2);
			}
			move(x,y);
		}
	}

	public String type() {
		return "Sheep";
	}

	public ImageIcon getImage() {
		return image;
	}
}