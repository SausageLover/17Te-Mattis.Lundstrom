import java.awt.Point;

import javax.swing.ImageIcon;

public abstract class Animal extends LivingThing {

	private int currentFood;
	
	private int maxFood;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public int getCurrentFood(){
		return currentFood;
	}
	
	public void setFood(int food){
		currentFood = food;
	}
	
	public void move(){
		// Vi låter vårt djur gå i valfri riktning.
		setPosition(new Point((int) this.getPosition().getX() + getRandom(),
				(int) this.getPosition().getY()+getRandom()));
		
		//Oavsett om vi kunnat gå åt valfri riktning, så kommer currentFood att minska.
		currentFood -=1 ;
		if (currentFood <= 0){
			// Remove object from list of active objects.
			pasture.removeEntity(this);
		}
	}
	
	public void move(int dx, int dy){
		setPosition(new Point((int) this.getPosition().getX() + dx,
				(int) this.getPosition().getY()+dy));		
		currentFood -=1 ;
		if (currentFood <= 0){
			// Remove object from list of active objects.
			pasture.removeEntity(this);
		}
	}	

}