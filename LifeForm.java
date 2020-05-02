package EcosystemCode;
import java.awt.Color;

import java.util.ArrayList;

public abstract class LifeForm {
	
/* Starter package includes methods:
 * toString()
 * age(int time)
 * reproduce()
 * isDead()
 * 
 */
	
	protected World myWorld;
	protected int myLifeSpan;
	protected Location myLocation;
	protected Color myColor;
	protected int myAge;
	protected boolean alive;
	protected boolean hasEaten;


	public LifeForm(int myLifeSpan, Location myLocation, Color myColor, World myWorld) {
		super();
		this.myLifeSpan = myLifeSpan;
		this.myLocation = myLocation;
		this.myColor = myColor;
		this.myWorld = myWorld;
		
//would this reset age every time a lifeform profile is opened?
		//this.myAge = 0;
		alive = true;
	}
	
	
	public LifeForm(Location myLocation, World myWorld) {
		super();
		this.myWorld = myWorld;
		this.myLocation = myLocation;
		alive = true;
	}

	public void age(int time){
		myAge+=time;
		if (myAge>myLifeSpan)
			alive=false;
	}
	
	public abstract void reproduce();
	
	public boolean isDead(){
		return !alive;
	}
	
	public int getMyLifeSpan() {
		return myLifeSpan;
	}
	
	public void setMyLifeSpan(int myLifeSpan) {
		this.myLifeSpan = myLifeSpan;
	}
	
	public Location getMyLocation() {
		return myLocation;
	}
	
	public void setMyLocation(Location myLocation) {
		this.myLocation = myLocation;
	}
	
	public Color getMyColor() {
		return myColor;
	}
	
	public void setMyColor(Color myColor) {
		this.myColor = myColor;
	}
	
	public int getAge() {
		return myAge;
	}

	public void setAge(int age) {
		this.myAge = age;
	}
	
//Returns array of surrounding Locations of a lifeForm. Compatible with getter in location class
	public ArrayList<Location> getSurroundingArray () {
		return myLocation.getSurroundings();
	}
	
	public abstract int checkNumberOfNeighbors(); 
	public abstract void eat();
	public abstract void move();
	public abstract void checkForOverCrowding();

}
	