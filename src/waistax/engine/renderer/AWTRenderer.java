package waistax.engine.renderer;

import static java.awt.RenderingHints.*;

import waistax.engine.*;
import waistax.math.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.*;

/**
 * Rendering using Java AWT library
 *
 * Author: Waistax
 * Created: 0.1 / 13 Aðu 2020 / 16:44:04
 *
 */
public class AWTRenderer implements Renderer
{
	/** The title of the window */
	public String title;
	
	/** The dimensions of the window */
	public Vec2i dimension;
	
	/** The number of buffers the canvas has */
	public int numBuffers = 3;
	
	/** Anti-aliasing */
	public boolean antiAliasing = true;
	
	/** The initial color of the background */
	public Color clearColor = new Color(0.2F, 0.2F, 0.2F, 1.0F);
	
	/** The icon of the window */
	public Image icon;
	
	/** The cursor to be used when the pointer is inside the window */
	public Cursor cursor;
	
	/** Acts like a window */
	public JFrame frame;
	
	/** The object that is drawn onto */
	public Canvas canvas;
	
	/** The buffer strategy of the canvas */
	public BufferStrategy bufferStrategy;
	
	/** The drawing tool */
	public Graphics2D graphics;
	
	/** The input listener */
	public AWTInput input;
	
	/** Initialize with a given window title and dimension */
	public AWTRenderer(String title, Vec2i dimension)
	{
		this.title = title;
		this.dimension = dimension;
	}
	
	/** Initialize with standard window title and dimension  */
	public AWTRenderer()
	{
		this("Waistax Engine " + Engine.VERSION, new Vec2i(16 * 50, 9 * 50));
	}
	
	@Override
	public void create()
	{
		// Do not continue if the window is already there
		if (frame != null) return;
		
		// Create the frame with the title
		frame = new JFrame(title);
		canvas = new Canvas();
		
		// Set the dimensions of the canvas
		Dimension dimension = new Dimension(this.dimension.x, this.dimension.y);
		canvas.setMaximumSize(dimension);
		canvas.setMinimumSize(dimension);
		canvas.setPreferredSize(dimension);
		
		// Add the canvas to the frame and make the frame fit around it
		frame.add(canvas);
		frame.pack();
		
		// Make the frame impossible to resize so it always fits the canvas
		frame.setResizable(false);
		
		// If there is an icon given
		if (icon != null)
		
			// Set the frame icon
			frame.setIconImage(icon);
			
		// If there is a cursor given
		if (cursor != null)
			
			// Set the frame cursor
			frame.setCursor(cursor);
		
		// Put the frame to the middle of the screen and make it visible
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		// Add a listener that will call the stop on engine
		frame.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				Engine.stop();
			}
		});
		
		input = new AWTInput();
		
		// Add the input as a lister to the canvas
		canvas.addKeyListener(input);
		canvas.addMouseListener(input);
		canvas.addMouseWheelListener(input);
		canvas.addMouseMotionListener(input);
		
		// Take the focus to the canvas so we can listen to the keyboard
		frame.requestFocus();
		canvas.requestFocus();

		// Get the buffer strategy and the graphics objects
		canvas.setBackground(clearColor);
		canvas.createBufferStrategy(numBuffers);
		bufferStrategy = canvas.getBufferStrategy();
		graphics = (Graphics2D) bufferStrategy.getDrawGraphics();

		// Set anti-aliasing
		graphics.setRenderingHint(KEY_ANTIALIASING, antiAliasing ? VALUE_ANTIALIAS_ON : VALUE_ANTIALIAS_OFF);
		graphics.setRenderingHint(KEY_TEXT_ANTIALIASING, antiAliasing ? VALUE_TEXT_ANTIALIAS_ON : VALUE_TEXT_ANTIALIAS_OFF);
	}

	@Override
	public void destroy()
	{
		// Do not continue if there is no window
		if (frame == null) return;
		
		// Make the frame invisible and then let the GC clean it
		frame.setVisible(false);
		graphics = null;
		bufferStrategy = null;
		canvas = null;
		frame = null;
	}

	@Override
	public void render()
	{
		// Show what is drawn and clear the buffer
		bufferStrategy.show();
		graphics.clearRect(0, 0, dimension.x, dimension.y);
	}

	@Override
	public Input getInput()
	{
		return input;
	}
	
	/** Set the anti-aliasing rendering hints */
	public void setAntializing(boolean antiAliasing)
	{
		this.antiAliasing = antiAliasing;
		
		// If the window is already created
		if (frame != null)
		{
			// Set anti-aliasing
			graphics.setRenderingHint(KEY_ANTIALIASING, antiAliasing ? VALUE_ANTIALIAS_ON : VALUE_ANTIALIAS_OFF);
			graphics.setRenderingHint(KEY_TEXT_ANTIALIASING, antiAliasing ? VALUE_TEXT_ANTIALIAS_ON : VALUE_TEXT_ANTIALIAS_OFF);
		}
	}
	
	/** Set the background color of the graphics */
	public void setClearColor(Color clearColor)
	{
		this.clearColor = clearColor;
		
		// If the window is already created
		if (frame != null)
			
			// Set the clear color
			graphics.setBackground(clearColor);
	}
	
	/** Set the icon of the window */
	public void setIcon(Image icon)
	{
		this.icon = icon;
		
		// If the window is already created
		if (frame != null)
			
			// Set the icon of the frame
			frame.setIconImage(icon);
	}

	/** Set the cursor of the window*/
	public void setCursor(Cursor cursor)
	{
		this.cursor = cursor;
		
		// If the window is already created
		if (frame != null)
			
			// Set the cursor of the frame
			frame.setCursor(cursor);
	}
}
