package EcosystemCode;
import java.awt.Color;

public class ShortGrass extends Plant {
	
	public ShortGrass(Location l, World w) {
		super(l,w);
		myLifeSpan=10;
		hasEaten=true;
	}
	
	public void reproduce() {
		checkForOverCrowding();
		if (alive) {
		int newX = 0;
		int newY = 0;
		boolean locationFound = false;
		Location loc = new Location(0, 0);
		while (!locationFound) {

		newX=getMyLocation().getX()+(int) (Math.random() * 2) - (int) (Math.random() * 2);
		newY=getMyLocation().getY()+ (int) (Math.random() * 2) - (int) (Math.random() * 2);
		
			if (newX>=0 && newX<20 && newY>=0 && newY<20) {

				loc.setX(newX);
				loc.setY(newY);

				for (LifeForm x : myWorld.getCreatureList()) {
					
					if (loc.sameLocation(x.myLocation) && x.alive) {
						
						locationFound = false;
						break;
					} else {
						locationFound = true;
					}
				}


			}
		}
			myWorld.getCreatureList().add(new ShortGrass(loc, myWorld));
	}
	}
	
	public int checkNumberOfNeighbors() {
		int neighbors = 0;
		for (int y = -1; y < 2; y++) {
			for (int x = -1; x < 2; x++) {
				Location loc = new Location(myLocation.getX() + x, myLocation.getY() + y);
				for (LifeForm life : myWorld.getCreatureList()) {
					if (loc.sameLocation(life.myLocation) && life.myColor.equals(Color.orange)) {
						neighbors++;
					}
				}
			}
		}
		return neighbors;

	}
	public int checkNumberOfANYNeighbor() {
		int neighbors = 0;
		for (int y = -1; y < 2; y++) {
			for (int x = -1; x < 2; x++) {
				Location loc = new Location(myLocation.getX() + x, myLocation.getY() + y);
				for (LifeForm life : myWorld.getCreatureList()) {
					if (loc.sameLocation(life.myLocation)) {
						neighbors++;
					}
				}
			}
		}
		return neighbors;

		
	}
	
	public void eat() {
	
	}
	public void move() {
	
	}

	public void checkForOverCrowding() {
		if (myLocation.getX()==0 && myLocation.getY()==0 && checkNumberOfANYNeighbor()>=3) {
			alive=false;
		} else if (myLocation.getX()==0 && myLocation.getY()==19 && checkNumberOfANYNeighbor()>=3) {
			alive=false;
		} else if (myLocation.getX()==19 && myLocation.getY()==19 && checkNumberOfANYNeighbor()>=3) {
			alive=false;
		} else if (myLocation.getX()==19 && myLocation.getY()==0 && checkNumberOfANYNeighbor()>=3) {
			alive=false;
		} else if ((myLocation.getX()==0 ||myLocation.getX()==19||myLocation.getY()==0||myLocation.getY()==19) &&checkNumberOfANYNeighbor()>=5) {
			alive=false;
		} else if (checkNumberOfANYNeighbor()>=8) {
			alive=false;
		}	
	}

}