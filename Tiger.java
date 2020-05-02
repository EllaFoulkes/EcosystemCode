package EcosystemCode;
import java.awt.Color;

public class Tiger extends Animal {
	public Tiger(Location l, World w) {
		super(l, w);
		myLifeSpan = 4;
		myColor = Color.orange;
		hasEaten = false;
	}

	public void move() {
		int newX = 0;
		int newY = 0;
		boolean locationFound = false;
		Location loc= new Location (0,0);

		while (!locationFound) {
			newX = getMyLocation().getX() + (int) (Math.random() * 6) - (int) (Math.random() * 6);
			newY = getMyLocation().getY() + (int) (Math.random() * 6) - (int) (Math.random() * 6);
			if (newX>=0 && newX<20 && newY>=0 && newY<20) {
			loc.setX(newX);
			loc.setY(newY);
			for (LifeForm x : myWorld.getCreatureList()) {
				if (loc.sameLocation(x.myLocation) && !x.getMyColor().equals(Color.black)) {
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
						if (l.sameLocation(x.getMyLocation()) && x.myColor.equals(Color.orange)) {
							counter++;
						}
					}
					if (loc.sameLocation(x.myLocation) &&x.alive) {
						locationFound = false;
						break;
					} else {
						locationFound = true;
					}
				}

			}
		}
			if (counter >= 2) {
				myWorld.getCreatureList().add(new Tiger(loc, myWorld));
			}
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
		for (int y = -5; y < 6; y++) {
			for (int x = -5; x < 6; x++) {
				Location loc = new Location(myLocation.getX() + x, myLocation.getY() + y);
				for (LifeForm life : myWorld.getCreatureList()) {
					if (loc.sameLocation(life.myLocation) && life.myColor.equals(Color.black)) {
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
