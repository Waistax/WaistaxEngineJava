package waistax.registry;

/**
 * Namespace and name pair
 *
 * Author: Waistax
 * Created: 0.4 / 15 Aðu 2020 / 23:17:57
 *
 */
public class Identifier
{
	/** The namespace */
	public final Namespace namespace;
	
	/** The name */
	public final String name;

	/** Initialize pair */
	public Identifier(Namespace namespace, String name)
	{
		this.namespace = namespace;
		this.name = name;
	}
	
	@Override
	public String toString()
	{
		// Format: namespace:name
		return new StringBuilder()
				.append(namespace)
				.append(":")
				.append(name)
				.toString();
	}
	
	/** Returns true if the names are the same */
	public boolean equals(String name)
	{
		return this.name.equals(name);
	}
}
