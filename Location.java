package EcosystemCode;
import java.util.ArrayList;

public class Location {
	
	/* Starter package includes methods:
	 * toString()
	 * 
	 */
	
	private int x;
	private int y;
	protected ArrayList <Location> surrounding;
	
	public Location(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
//returns array of surrounding coordinates of a location
//If you have a location and need the surroundings you can call this method, if you have a lifeForm and need the surroundings,
//call the one in the lifeForm class
	public ArrayList <Location> getSurroundings(){
		surrounding=new ArrayList<Location>();
		surrounding.add(new Location(getX(), getY()-1));
		surrounding.add(new Location(getX()+1, getY()-1));
		surrounding.add(new Location(getX()+1, getY()));
		surrounding.add(new Location(getX()+1, getY()+1));
		surrounding.add(new Location(getX(), getY()+1));
		surrounding.add(new Location(getX()-1, getY()+1));
		surrounding.add(new Location(getX()-1, getY()));
		surrounding.add(new Location(getX()-1, getY()-1));
		return surrounding;
		
	}
	
	public boolean sameLocation(Location loc) {
		if (x == loc.getX() && y == loc.getY()) {
			return true;
			} else {
				return false; 
		}
	}
}
