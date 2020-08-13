package waistax.math;

/**
 * Two dimensional vector of floating point numbers
 *
 * Author: Waistax
 * Created: 0.2 / 13 Aðu 2020 / 20:39:09
 *
 */
public class Vec2f
{
	/** First component */
	public float x;
	
	/** Second component */
	public float y;

	/** Initialize from a pair of numbers */
	public Vec2f(float x, float y)
	{
		set(x, y);
	}
	
	/** Copy */
	public Vec2f(Vec2f v)
	{
		set(v);
	}
	
	/** Default */
	public Vec2f() {}
	
	/** Set the components */
	public Vec2f set(float x, float y)
	{
		this.x = x;
		this.y = y;
		return this;
	}
	
	/** Set the components */
	public Vec2f set(Vec2f v)
	{
		return set(v.x, v.y);
	}
	
	/** Set the components */
	public Vec2f set(Vec2i v)
	{
		return set((float) v.x, (float) v.y);
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
	
	/** Check the components one by one
	 * Returns true if both of the components are equal to the given numbers.
	 * Returns false if any one of them is not equal. */
	public boolean equals(float x, float y)
	{
		return this.x == x && this.y == y;
	}
	
	/** Check the components one by one
	 * Returns true if both of the components are equal to the given numbers.
	 * Returns false if any one of them is not equal. */
	public boolean equals(Vec2f v)
	{
		return equals(v.x, v.y);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		// Make sure it does not call itself!
		// This should call the method above.
		return equals((Vec2f) obj);
	}
	
	/** Set the addition of two vectors */
	public Vec2f add(Vec2f left, Vec2f right)
	{
		return set(left.x + right.x, left.y + right.y);
	}
	
	/** Set the subtraction of two vectors */
	public Vec2f sub(Vec2f left, Vec2f right)
	{
		return set(left.x - right.x, left.y - right.y);
	}
	
	/** Set the multiplication of a vector and a scalar */
	public Vec2f mul(Vec2f left, float right)
	{
		return set(left.x * right, left.y * right);
	}

	/** Set the division of a vector and a scalar */
	public Vec2f div(Vec2f left, float right)
	{
		return set(left.x / right, left.y / right);
	}
	
	/** Set the division of a scalar to a vector */
	public Vec2f div(float left, Vec2f right)
	{
		return set(left / right.x, left / right.y);
	}
	
	/** Set the minimum components from two vectors */
	public Vec2f min(Vec2f left, Vec2f right)
	{
		return set(left.x < right.x ? left.x : right.x, left.y < right.y ? left.y : right.y);
	}
	
	/** Set the maximum components from two vectors */
	public Vec2f max(Vec2f left, Vec2f right)
	{
		return set(left.x > right.x ? left.x : right.x, left.y > right.y ? left.y : right.y);
	}
}
