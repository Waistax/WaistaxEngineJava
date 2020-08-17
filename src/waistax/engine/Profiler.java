package waistax.engine;

/**
 * Profiles the time each processes in the engine takes
 *
 * Author: Waistax
 * Created: 0.3 / 14 Aðu 2020 / 10:30:34
 *
 */
public class Profiler
{
	/** The accumulated time from the last calculation in nanoseconds */
	private float time;
	
	/** The time at the start of the profiler in nanoseconds */
	private float start;
	
	/** The number of times the profiler was started from the last calculation */
	private int count;
	
	/** The result of the last calculation in milliseconds */
	private float average;
	
	/** Start the profiler */
	public void start()
	{
		start = Engine.nanoTime();
	}
	
	/** Stop the profiler */
	public void stop()
	{
		// Add the amount of time passed from the start of the profiler
		time += Engine.nanoTime() - start;
		
		// Increase the count
		count++;
	}
	
	/** Calculate the average time of the profiler */
	public void calculate()
	{
		// Convert the accumulated time to milliseconds and divide it by the count
		average = time / 1000000.0F / count;
		
		// Reset the time and the counter
		time = 0.0F;
		count = 0;
	}

	/** Get the average time in milliseconds */
	public float getAverage()
	{
		return average;
	}
}
