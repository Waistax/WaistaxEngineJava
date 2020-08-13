package waistax.sandbox;

import waistax.engine.*;
import waistax.engine.renderer.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Tests engine
 *
 * Author: Waistax
 * Created: 0.1 / 13 Aðu 2020 / 17:04:15
 *
 */
public class Sandbox implements Game
{
	/** Start of the test */
	public static void main(String[] args)
	{
		// Set the renderer and the game
		Engine.renderer = new AWTRenderer();
		Engine.game = new Sandbox();
		// Then start the engine
		Engine.start();
	}
	
	private Graphics2D g;
	private int counter;
	private int xpos;
	
	@Override
	public void load()
	{
		System.out.println("Loading sandbox...");
		
		// Get the graphics, then set the color and the font
		g = ((AWTRenderer) Engine.renderer).graphics;
		g.setFont(new Font("Verdena", Font.ITALIC, 20));
		g.setColor(new Color(1.0F, 1.0F, 0.6F, 1.0F));
	}

	@Override
	public void save()
	{
		System.out.println("Saving sandbox...");
	}

	@Override
	public void frame()
	{
		// Get the input
		Input i = Engine.renderer.getInput();
		
		// Increase the counter if F is pressed
		if (i.keyPressed[KeyEvent.VK_F]) counter++;
		
		// Change the x position of the text with the scroll
		xpos += i.scroll * 10;
		
		// Draw the text
		g.drawString("FPS: " + Engine.frameRate, xpos, 30);
		g.drawString("Cursor: " + i.cursor + " Change: " + i.cursorChange, xpos, 50);
		g.drawString("F is pressed " + counter + " times.", xpos, 70);
		// If the space bar is down
		if (i.keyDown[KeyEvent.VK_SPACE]) g.drawString("SPACE IS DOWN!", xpos, 90);
	}
}
