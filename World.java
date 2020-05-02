package EcosystemCode;
import java.awt.Color;
import java.util.ArrayList;

public class World {

	private int width;
	private int height;
	private ArrayList<LifeForm> creatureList;

	public World(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.creatureList = new ArrayList<LifeForm>();
	}

	public void letTimePass() {
		updateCreatureList();
		makeNewCreatures();

		moveCreatures();

		eatThings();

		creaturesGetOlder();

		checkIfCreatureHasEaten();
	
		purgeTheDead();
	}
	
	public void updateCreatureList() {
		int numberOfGrass = 0;
		int numberOfGazelles = 0;
		int numberOfTigers = 0;

		for (int i = 0; i < creatureList.size(); i++) {
			if (creatureList.get(i).getMyColor() == (Color.green)) {
				numberOfGrass++;
			} else if (creatureList.get(i).getMyColor() == (Color.black)) {
				numberOfGazelles++;
			} else {
				numberOfTigers++;
			}
		}
		System.out.print("There are "+numberOfGrass+" grass");
		System.out.print("There are "+numberOfGazelles+" gazelles");
		System.out.print("There are "+numberOfTigers+" tigers");
	}


	public void makeNewCreatures() {

		int currentSizeOfCreatureList = creatureList.size();

		System.out.println("size of list is " + currentSizeOfCreatureList);
		for (int i = 0; i < currentSizeOfCreatureList; i++) {
			creatureList.get(i).reproduce();
		}
	}

	public void moveCreatures() {
		int currentSizeOfCreatureList = creatureList.size();
		for (int i = 0; i < currentSizeOfCreatureList; i++) {
			creatureList.get(i).move();
		}
	}
	
	public void eatThings() {
		int currentSizeOfCreatureList = creatureList.size();
		System.out.println("after eating size of list is " + currentSizeOfCreatureList);
		for (int i = 0; i < currentSizeOfCreatureList; i++) {
			creatureList.get(i).eat();
		}
	}

	public void purgeTheDead() {
		int i = 0;
		while (i < creatureList.size()) {
			if (creatureList.get(i).isDead())
				creatureList.remove(i);
			else
				i++;
		}
	}

	public void creaturesGetOlder() {
		for (LifeForm l : creatureList) {
			l.age(1);
		}
	}
	
	public void checkIfCreatureHasEaten() {
		for (LifeForm l : creatureList) {
			if (!l.hasEaten && l.getAge()>1 && l.getAge()%2!=0) {
				l.alive=false;
			} else if (l.getMyColor()!=Color.green){
				l.hasEaten=false;
			}
			
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public ArrayList<LifeForm> getCreatureList() {
		return creatureList;
	}

	public void setCreatureList(ArrayList<LifeForm> creatureList) {
		this.creatureList = creatureList;
	}

	@Override
	public String toString() {
		return "World [width=" + width + ", height=" + height + ", creatureList=" + creatureList + "]";
	}
}
