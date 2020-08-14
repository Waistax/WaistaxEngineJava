package waistax.engine;

import waistax.engine.renderer.*;

/**
 * The heart of the engine
 * 
 * Has the main loop in it.
 *
 * Author: Waistax
 * Created: 0.1 / 13 Aðu 2020 / 14:46:55
 *
 */
public class Engine
{
	/** The version of the engine */
	public static final String version = "0.3";
	
	/** Profiles frame method of the game */
	public static final Profiler GAME_PROFILER = new Profiler();
	
	/** Profiles frame method of the input */
	public static final Profiler INPUT_PROFILER = new Profiler();

	/** Profiles render method of the renderer */
	public static final Profiler RENDER_PROFILER = new Profiler();
	
	/** The active renderer
	 * This should not change after the engine starts. */
	public static Renderer renderer;
	
	/** The active game
	 * This should not change after the engine starts. */
	public static Game game;
	
	/** The aimed frame rate of the engine
	 * Engine will go as fast as it can if this is 0. */
	public static float aimedFrameRate;
	
	/** True if the engine is running */
	public static boolean running;
	
	/** Frames per second */
	public static float frameRate;
	
	/** The number of frames which are waiting to be processed */
	public static float unprocessedFrames;
	
	/** Returns the time in nanoseconds as a float */
	public static float nanoTime()
	{
		return (float) System.nanoTime();
	}
	
	/** Start the engine */
	public static void start()
	{
		// Do not call the run method again if the engine is already on
		if (running) return;
		running = true;
		
		// Run the main loop
		run();
	}
	
	/** Stop the engine */
	public static void stop()
	{
/*		if (!running) return;
		
		This check is unnecessary */
		
		running = false;
	}
	
	/** Main loop */
	private static void run()
	{
		try
		{
			// Load
			renderer.create();
			game.load();
			
			// Start the loop
			
			float prevTime = nanoTime();
			float secondsTimer = 0.0F;
			int frames = 0;
			
			while (running)
			{
				// Elapsed time in nanoseconds
				float elapsedTime = nanoTime() - prevTime;
				prevTime += elapsedTime;
				
				// Elapsed time is in seconds after this point
				elapsedTime /= 1000000000.0F;
				
				if (aimedFrameRate == 0.0F) // As much as possible
				{
					frame();
					frames++;
					unprocessedFrames = 0.0F;
				}

				else
					
					for (
							unprocessedFrames += elapsedTime * aimedFrameRate;
							unprocessedFrames >= 1.0F;
							unprocessedFrames--, frames++)
						
						frame();
				
				// Calculate the rate
				secondsTimer += elapsedTime;
				
				if (secondsTimer >= 1.0F)
				{
					// Calculate the frame rate and profiler average times
					frameRate = frames / secondsTimer;
					GAME_PROFILER.calculate();
					INPUT_PROFILER.calculate();
					RENDER_PROFILER.calculate();
					
					// TODO: Get rid of this
					// Print the frame rate and average times
					System.out.println("Frame Rate: " + frameRate);
					System.out.println("Game: " + GAME_PROFILER.getAverage() + "ms");
					System.out.println("Input: " + INPUT_PROFILER.getAverage() + "ms");
					System.out.println("Render: " + RENDER_PROFILER.getAverage() + "ms");
					
					// Reset
					frames = 0;
					secondsTimer--;
				}
				
				// TODO: Get rid of this
				// To save the charge of my laptop
				Thread.sleep(5);
			}
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			// Clean up after the engine is stopped
			renderer.destroy();
			
			// Save
			game.save();
			System.exit(0);
		}
	}
	
	/** Called every frame */
	private static void frame()
	{
		INPUT_PROFILER.start();
		renderer.getInput().frame();
		INPUT_PROFILER.stop();
		
		GAME_PROFILER.start();
		game.frame();
		GAME_PROFILER.stop();
		
		RENDER_PROFILER.start();
		renderer.render();
		RENDER_PROFILER.stop();
	}

	/** Private constructor 
	 * Disables creation of an instance of this class. */
	private Engine() {}
}
