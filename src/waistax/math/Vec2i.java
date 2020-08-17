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

	/** Initialize from a pair of numbers */
	public Vec2i(int x, int y)
	{
		set(x, y);
	}
	
	/** Copy */
	public Vec2i(Vec2i v)
	{
		set(v);
	}
	
	/** Default */
	public Vec2i() {}
	
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
	
	/** Set the components */
	public Vec2i set(Vec2f v)
	{
		return set((int) v.x, (int) v.y);
	}
	
	@Override
	public String toString()
	{
		// (x, y)
		return new StringBuilder()
				.append("(")
				.append(x)
				.append(", ")
				.append(y)
				.append(")")
				.toString();
	}
	
	/** Check all of the components one by one */
	public boolean equals(int x, int y)
	{
		return this.x == x && this.y == y;
	}
	
	/** Check all of the components one by one */
	public boolean equals(Vec2i v)
	{
		return equals(v.x, v.y);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		// Make sure it does not call itself!
		// This should call the method above.
		return equals((Vec2i) obj);
	}
	
	/** Set the addition of two vectors */
	public Vec2i add(Vec2i left, Vec2i right)
	{
		return set(left.x + right.x, left.y + right.y);
	}
	
	/** Set the subtraction of two vectors */
	public Vec2i sub(Vec2i left, Vec2i right)
	{
		return set(left.x - right.x, left.y - right.y);
	}
	
	/** Set the multiplication of a vector and a scalar */
	public Vec2i mul(Vec2i left, int right)
	{
		return set(left.x * right, left.y * right);
	}

	/** Set the division of a vector and a scalar */
	public Vec2i div(Vec2i left, int right)
	{
		return set(left.x / right, left.y / right);
	}
	
	/** Set the division of a scalar to a vector */
	public Vec2i div(int left, Vec2i right)
	{
		return set(left / right.x, left / right.y);
	}
	
	/** Set the minimum components from two vectors */
	public Vec2i min(Vec2i left, Vec2i right)
	{
		return set(left.x < right.x ? left.x : right.x, left.y < right.y ? left.y : right.y);
	}
	
	/** Set the maximum components from two vectors */
	public Vec2i max(Vec2i left, Vec2i right)
	{
		return set(left.x > right.x ? left.x : right.x, left.y > right.y ? left.y : right.y);
	}
}
