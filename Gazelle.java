package EcosystemCode;
import java.awt.Color;

public class Gazelle extends Animal {

	public Gazelle(Location l, World w) {
		super(l, w);
		myLifeSpan = 4;
		myColor = Color.black;
		hasEaten = false;
	}
	
	public void reproduce() {

		checkForOverCrowding();
		if (alive) {
		int newX = 0;
		int newY = 0;
		boolean locationFound = false;
		Location loc = new Location(0, 0);
		int counter = 0;

		while (!locationFound) {
			newX=getMyLocation().getX()+(int) (Math.random() * 2) - (int) (Math.random() * 2);
			newY=getMyLocation().getY()+ (int) (Math.random() * 2) - (int) (Math.random() * 2);
			if (newX>=0 && newX<20 && newY>=0 && newY<20) {

				loc.setX(newX);
				loc.setY(newY);

				for (LifeForm x : myWorld.getCreatureList()) {
					for (Location l : loc.getSurroundings()) {
						if (l.sameLocation(x.getMyLocation()) && x.myColor.equals(Color.black)) {
							counter++;
						}
					}
					if (loc.sameLocation(x.myLocation) && x.alive) {
						locationFound = false;
						break;
					} else {
						locationFound = true;
					}
				}

			}
		}
			if (counter >= 2) {
				myWorld.getCreatureList().add(new Gazelle(loc, myWorld));
			}
			}
	}
	


	public void move() {
		int newX = 0;
		int newY = 0;
		boolean locationFound = false;
		Location loc= new Location (0,0);

		while (!locationFound) {
			newX = getMyLocation().getX() + (int) (Math.random() * 4) - (int) (Math.random() * 4);
			newY = getMyLocation().getY() + (int) (Math.random() * 4) - (int) (Math.random() * 4);
			if (newX>=0 && newX<20 && newY>=0 && newY<20) {
			loc.setX(newX);
			loc.setY(newY);
			for (LifeForm x : myWorld.getCreatureList()) {
				if (loc.sameLocation(x.myLocation) && !x.getMyColor().equals(Color.green)) {
					locationFound = false;
					break;
				} else {
					locationFound = true;
				}
			}
		}
		}
		setMyLocation(loc);
	}



	public int checkNumberOfNeighbors() {
		int neighbors = 0;
		for (int y = -1; y < 2; y++) {
			for (int x = -1; x < 2; x++) {
				Location loc = new Location(myLocation.getX() + x, myLocation.getY() + y);
				for (LifeForm life : myWorld.getCreatureList()) {
					if (loc.sameLocation(life.myLocation) && life.myColor.equals(Color.black)) {
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
		for (int y = -3; y < 4; y++) {
			for (int x = -3; x < 4; x++) {
				Location loc = new Location(myLocation.getX() + x, myLocation.getY() + y);
				for (LifeForm life : myWorld.getCreatureList()) {
					if (loc.sameLocation(life.myLocation) && life.myColor.equals(Color.green)) {
						life.alive = false;
						hasEaten = true;
						break;
					}
				}
				if (hasEaten) {
					break;
				}
			}
			if (hasEaten) {
				break;
			}
		}

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
