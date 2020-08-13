package waistax.sandbox;

import waistax.engine.*;
import waistax.engine.renderer.*;

import java.awt.*;

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
	
	@Override
	public void load()
	{
		System.out.println("Loading sandbox...");
		
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
		g.drawString("FPS: " + Engine.frameRate, 10, 30);
	}
}
