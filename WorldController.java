package EcosystemCode;
import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class WorldController extends GraphicsProgram {

	
	private World theWorld;
	private GCanvas theWorldCanvas;
	public static final int APPLICATION_WIDTH = 200;
	public static final int APPLICATION_HEIGHT = 200;
	
	public void run(){	
		setUpWorld();
		runWorld();
	}
	
//adds creatures from the list onto the board
	public void setUpWorld(){
		theWorld = new World(20,20);
		for (int i=0; i<20; i++) {

			theWorld.getCreatureList().add( new ShortGrass( new Location(1,i), theWorld ));
			theWorld.getCreatureList().add( new ShortGrass( new Location(18,i), theWorld ));
			theWorld.getCreatureList().add( new ShortGrass( new Location(i,0), theWorld ));
			theWorld.getCreatureList().add( new ShortGrass( new Location(i,18), theWorld ));
			theWorld.getCreatureList().add( new ShortGrass( new Location(1,i), theWorld ));
			theWorld.getCreatureList().add( new ShortGrass( new Location(17,i), theWorld ));
			theWorld.getCreatureList().add( new ShortGrass( new Location(i,1), theWorld ));
			theWorld.getCreatureList().add( new ShortGrass( new Location(i,17), theWorld ));
			theWorld.getCreatureList().add( new ShortGrass( new Location(i,12), theWorld ));
			theWorld.getCreatureList().add( new ShortGrass( new Location(i,11), theWorld ));
		}
		for (int x=0; x<6; x++) {
			theWorld.getCreatureList().add( new Gazelle( new Location(3+x,3), theWorld ));
			theWorld.getCreatureList().add( new Gazelle( new Location(16,3+x), theWorld ));
			theWorld.getCreatureList().add( new Gazelle( new Location(16-x,16), theWorld ));
			theWorld.getCreatureList().add( new Gazelle( new Location(3,16-x), theWorld ));
			theWorld.getCreatureList().add( new Gazelle( new Location(4+ x, 4), theWorld ));
			theWorld.getCreatureList().add( new Gazelle( new Location(15,4+x), theWorld ));
			theWorld.getCreatureList().add( new Gazelle( new Location(15-x,15), theWorld ));
			theWorld.getCreatureList().add( new Gazelle( new Location(4,15-x), theWorld ));
		}
		for (int k=0; k<4; k++) {
			theWorld.getCreatureList().add( new Tiger( new Location(5+k,5), theWorld ));
			theWorld.getCreatureList().add( new Tiger( new Location(14,5+k), theWorld ));
			theWorld.getCreatureList().add( new Tiger( new Location(6+k,6), theWorld ));
			theWorld.getCreatureList().add( new Tiger( new Location(13,6+k), theWorld ));

		}
		
//		theWorld.getCreatureList().add( new Tiger( new Location(4,6), theWorld ));
//		theWorld.getCreatureList().add( new Tiger( new Location(5,6), theWorld ));
//		theWorld.getCreatureList().add( new Tiger( new Location(4,7), theWorld ));
//		theWorld.getCreatureList().add( new Tiger( new Location(5,7), theWorld ));
//		theWorld.getCreatureList().add( new Tiger( new Location(10,7), theWorld ));
//		theWorld.getCreatureList().add( new Tiger( new Location(11,7), theWorld ));
//		theWorld.getCreatureList().add( new Tiger( new Location(10,10), theWorld ));
//		theWorld.getCreatureList().add( new Tiger( new Location(11,10), theWorld ));
//		theWorld.getCreatureList().add( new Tiger( new Location(14,15), theWorld ));
//		theWorld.getCreatureList().add( new Tiger( new Location(14,16), theWorld ));
//		theWorld.getCreatureList().add( new Tiger( new Location(14,17), theWorld ));
//		theWorld.getCreatureList().add( new Tiger( new Location(13,17), theWorld ));
//		theWorld.getCreatureList().add( new Tiger( new Location(13,15), theWorld ));
//		theWorld.getCreatureList().add( new Tiger( new Location(13,16), theWorld ));
//		theWorld.getCreatureList().add( new Tiger( new Location(18,18), theWorld ));
//		theWorld.getCreatureList().add( new Tiger( new Location(17,17), theWorld ));

		theWorldCanvas = this.getGCanvas();
	}
	public void runWorld(){
		drawWorld();
		for(int i=0; i<20;i++){
			theWorld.letTimePass();
			theWorld.creaturesGetOlder();
			pause(1000);
			drawWorld();

		}
	}	

	
	public void drawWorld(){
		drawBlankWorld();
		drawCreatures();
	}
	
	public void drawBlankWorld(){
		for(int row = 0 ; row<theWorld.getWidth(); row++)
			for(int col=0; col<theWorld.getHeight(); col++){
				GRect r = new GRect(row*10, col*10, 10, 10);
				r.setFillColor(Color.WHITE);
				r.setFilled(true);
				theWorldCanvas.add(r);
			}
	}
	
	public void drawCreatures(){
		for(LifeForm x: theWorld.getCreatureList()){
			GRect r = new GRect (x.getMyLocation().getX()*10, x.getMyLocation().getY()*10,10,10);
			r.setFillColor(x.getMyColor());
			r.setFilled(true);
			theWorldCanvas.add(r);
		}
	}
}
