package waistax.engine.renderer;

import waistax.engine.*;

/**
 * Implements a rendering library to the engine
 *
 * Author: Waistax
 * Created: 0.1 / 13 Aðu 2020 / 15:16:37
 *
 */
public interface Renderer
{
	/** Create the window and input
	 * This is called before the game loads. */
	public void create();
	
	/** Destroy the window and input
	 * This is called after the game saves. */
	public void destroy();
	
	/** Render the drawn content
	 * This is called after every game frame. */
	public void render();
	
	/** Returns the created input
	 * Amount of keys and buttons will depend on the library used. */
	public Input getInput();
}
