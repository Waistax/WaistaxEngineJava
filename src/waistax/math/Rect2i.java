package waistax.math;

/**
 * Two dimensional rectangle of integers
 *
 * Author: Waistax
 * Created: 0.2 / 13 Aðu 2020 / 22:42:09
 *
 */
public class Rect2i
{
	/** Top-left corner */
	public Vec2i min;
	
	/** Bottom-right corner */
	public Vec2i max;

	/** Initialize from a pair of points */
	public Rect2i(Vec2i min, Vec2i max)
	{
		set(min, max);
	}
	
	/** Copy */
	public Rect2i(Rect2i r)
	{
		set(r);
	}
	
	/** Default */
	public Rect2i()
	{
		min = new Vec2i();
		max = new Vec2i();
	}
	
	/** Set the points */
	public Rect2i set(int minx, int miny, int maxx, int maxy)
	{
		min.set(minx, miny);
		max.set(maxx, maxy);
		return this;
	}
	
	/** Set the points */
	public Rect2i set(Vec2i min, Vec2i max)
	{
		return set(min.x, min.y, max.x, max.y);
	}
	
	/** Set the points */
	public Rect2i set(Rect2i r)
	{
		return set(r.min, r.max);
	}
	
	@Override
	public String toString()
	{
		// [(minx, miny), (maxx, maxy)]
		return new StringBuilder()
				.append("[")
				.append(min)
				.append(", ")
				.append(max)
				.append("]")
				.toString();
	}
	
	/** Check all of the points one by one */
	public boolean equals(int minx, int miny, int maxx, int maxy)
	{
		return min.x == minx && min.y == miny && max.x == maxx && max.y == maxy;
	}
	
	/** Check all of the points one by one */
	public boolean equals(Vec2i min, Vec2i max)
	{
		return equals(min.x, min.y, max.x, max.y);
	}
	
	/** Check all of the points one by one */
	public boolean equals(Rect2i r)
	{
		return equals(r.min, r.max);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		// Make sure it does not call itself!
		// This should call the method above.
		return equals((Rect2i) obj);
	}
}
