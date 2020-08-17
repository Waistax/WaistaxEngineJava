package waistax.engine;

/**
 * Implements an application to the engine
 *
 * Author: Waistax
 * Created: 0.1 / 13 Aðu 2020 / 15:28:54
 *
 */
public interface App
{
	/** Load the application */
	public void load();
	
	/** Save the application */
	public void save();
	
	/** Update and draw the application */
	public void frame();
}
