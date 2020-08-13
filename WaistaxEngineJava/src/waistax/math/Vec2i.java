package waistax.math;

/**
 * Two dimensional vector of integers
 *
 * Author: Waistax
 * Created: 0.1 / 13 Aðu 2020 / 15:40:59
 *
 */
public class Vec2i
{
	/** First component */
	public int x;
	
	/** Second component */
	public int y;

	/** Initialize with specific components */
	public Vec2i(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/** Initialize with zero components */
	public Vec2i()
	{
		this(0, 0);
	}
	
	/** Set the components */
	public Vec2i set(int x, int y)
	{
		this.x = x;
		this.y = y;
		return this;
	}
	
	/** Set the components */
	public Vec2i set(Vec2i v)
	{
		return set(v.x, v.y);
	}
	
	@Override
	public String toString()
	{
		return new StringBuilder()
				.append("(")
				.append(x)
				.append(", ")
				.append(y)
				.append(")")
				.toString();
	}
	
	/** Check the components one by one
	 * Returns true if both of the components are equal to the given numbers.
	 * Returns false if any one of them is not equal. */
	public boolean equals(int x, int y)
	{
		return this.x == x && this.y == y;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		Vec2i v = (Vec2i) obj;
		return equals(v.x, v.y);
	}
	
	/** Add two vectors and set the result to this one */
	public Vec2i add(Vec2i left, Vec2i right)
	{
		x = left.x + right.x;
		y = left.y + right.y;
		return this;
	}
	
	/** Subtract two vectors and set the result to this one */
	public Vec2i sub(Vec2i left, Vec2i right)
	{
		x = left.x - right.x;
		y = left.y - right.y;
		return this;
	}
}
