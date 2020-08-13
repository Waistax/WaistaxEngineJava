package waistax.engine;

/**
 * Implements a game to the engine
 *
 * Author: Waistax
 * Created: 0.1 / 13 A�u 2020 / 15:28:54
 *
 */
public interface Game
{
	/** Load the game */
	public void load();
	
	/** Save the game */
	public void save();
	
	/** Update and draw the game */
	public void frame();
}
