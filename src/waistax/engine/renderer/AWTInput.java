package waistax.engine.renderer;

import waistax.engine.*;

import java.awt.event.*;

/**
 * Handles all of the inputs to a Canvas from Java AWT library
 *
 * Author: Waistax
 * Created: 0.1 / 13 Aðu 2020 / 16:51:15
 *
 */
public class AWTInput extends Input implements KeyListener, MouseListener, MouseWheelListener, MouseMotionListener
{
	/** Default */
	public AWTInput()
	{
		super(256, 8);
	}
	
	@Override
	public void keyTyped(KeyEvent e) { }
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() > -1 && e.getKeyCode() < keys)
			
			keyInput[e.getKeyCode()] = true;
	}
	
	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() > -1 && e.getKeyCode() < keys)
			
			keyInput[e.getKeyCode()] = false;
	}

	@Override public void mouseClicked(MouseEvent e) { }

	@Override
	public void mousePressed(MouseEvent e)
	{
		if (e.getButton() > -1 && e.getButton() < buttons)
			
			buttonInput[e.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if (e.getButton() > -1 && e.getButton() < buttons)
			
			buttonInput[e.getButton()] = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }

	@Override
	public void mouseWheelMoved(MouseWheelEvent e)
	{
		scrollInput += e.getWheelRotation();
	}
	
	@Override
	public void mouseDragged(MouseEvent e)
	{
		cursorInput.set(e.getX(), e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		cursorInput.set(e.getX(), e.getY());
	}
}
