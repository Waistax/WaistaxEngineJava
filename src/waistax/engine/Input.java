package waistax.engine;

import waistax.math.*;

/**
 * Saves input to the engine and divides them into frames
 *
 * Author: Waistax
 * Created: 0.1 / 13 Aðu 2020 / 15:33:29
 *
 */
public class Input
{
	/** Number of keys to listen */
	public final int keys;
	
	/** Number of buttons to listen */
	public final int buttons;
	
	/** True if the key is down in this frame */
	public final boolean[] keyDown;
	
	/** True if the key is first pressed in this frame */
	public final boolean[] keyPressed;
	
	/** True if the key is down */
	public final boolean[] keyInput;
	
	/** True if the button is down in this frame */
	public final boolean[] buttonDown;
	
	/** True if the button is first pressed in this frame */
	public final boolean[] buttonPressed;
	
	/** True if the button is down */
	public final boolean[] buttonInput;
	
	/** The position of the cursor in this frame */
	public final Vec2i cursor;
	
	/** The position of the cursor */
	public final Vec2i cursorInput;
	
	/** The change in the position of the cursor in this frame */
	public final Vec2i cursorChange;
	
	/** The total amount of scroll done in this frame */
	public int scroll;
	
	/** The accumulated amount of scroll done */
	public int scrollInput;
	
	/** Initialize with the amount of keys and buttons to listen */
	public Input(int keys, int buttons)
	{
		this.keys = keys;
		this.buttons = buttons;
		keyDown = new boolean[keys];
		keyPressed = new boolean[keys];
		keyInput = new boolean[keys];
		buttonDown = new boolean[buttons];
		buttonPressed = new boolean[buttons];
		buttonInput = new boolean[buttons];
		cursor = new Vec2i();
		cursorInput = new Vec2i();
		cursorChange = new Vec2i();
	}
	
	/** Update all of the input information for this frame
	 * Real input is stored in buffers.
	 * These are the variables that end with Input.
	 * And input used by the application is updated in this method.
	 * This helps to know the total input on every frame.
	 * Because of this algorithm input is always one frame behind. */
	public void frame()
	{
		// Update all of the key information
		for (int i = 0; i < keys; i++)
		{
			// Mark the key as pressed if it wasn't down last frame
			// but it is down this frame
			keyPressed[i] = !keyDown[i] && keyInput[i];
			keyDown[i] = keyInput[i];
		}
		
		// Update all of the button information
		for (int i = 0; i < buttons; i++)
		{
			// Mark the button as pressed if it wasn't down last tick
			// but it is down this tick
			buttonPressed[i] = !buttonDown[i] && buttonInput[i];
			buttonDown[i] = buttonInput[i];
		}
		
		// Set all of the accumulated scroll in the last tick
		scroll = scrollInput;
		// Then reset the accumulator
		scrollInput = 0;
		
		// Calculate the change in the cursor position
		cursorChange.sub(cursorInput, cursor);
		// Update the cursor position
		cursor.set(cursorInput);
	}
}
