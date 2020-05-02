package EcosystemCode;
import java.awt.Color;

public abstract class Plant extends LifeForm {
	
/* No additional methods in starter
 * 
 */

	public Plant(Location loc, World w) {
		super(loc, w);
		myColor = Color.green;
	}
}