package waistax.registry;

import java.util.*;

/**
 * A scope where the names are unique
 *
 * Author: Waistax
 * Created: 0.4 / 15 Aðu 2020 / 23:18:28
 *
 */
public class Namespace
{
	/** The name of the namespace */
	public final String name;
	
	/** The list of identifiers */
	public final ArrayList<Identifier> identifiers;
	
	/** Initialize an empty namespace from the given name */
	public Namespace(String name)
	{
		this.name = name;
		identifiers = new ArrayList<>();
	}
	
	/** Create an identifier in this namespace
	 * Returns null if the name is already used inside this namespace. */
	public Identifier createIdentifier(String name)
	{
		// For every identifier in the list
		for (Identifier identifier : identifiers)
			
			// If the given name is the same as the identifier
			if (identifier.equals(name))
				
				// Return null
				return null;
		
		// If no identifier in the list has the same name
		// Create, add and return the identifier
		Identifier identifier = new Identifier(this, name);
		identifiers.add(identifier);
		return identifier;
	}
	
	/** Get an already existing identifier
	 * Return null if an identifier with this name does not exist inside this namespace. */
	public Identifier getIdentifier(String name)
	{
		// For every identifier in the list
		for (Identifier identifier : identifiers)
			
			// If the given name is the same as the identifier
			if (identifier.equals(name))
				
				// Return that identifier
				return identifier;
		
		// If no identifier in the list has the same name
		// Return null
		return null;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
	
	/** Returns true if the names are the same */
	public boolean equals(String name)
	{
		return this.name.equals(name);
	}
}
