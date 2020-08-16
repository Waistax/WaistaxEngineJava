package waistax.registry;

import java.lang.reflect.*;

/**
 * Stores a list of entries that have the same type of objects
 * 
 * T is the type of object.
 *
 * Author: Waistax
 * Created: 0.4 / 15 Aðu 2020 / 23:42:21
 *
 */
@SuppressWarnings("unchecked")
public class SubRegistry<T>
{
	/** Identifiers */
	public Identifier[] identifiers;
	
	/** Objects */
	public T[] values;
	
	/** Number of entries */
	public int size;
	
	/** Class of the objects in this sub registry */
	public final Class<T> entryType;
	
	/** Initialize with the entry type */
	public SubRegistry(Class<T> entryType)
	{
		identifiers = new Identifier[10];
		values = (T[]) new Object[10];
		this.entryType = entryType;
	}
	
	/** Add an entry */
	public void add(Identifier identifier, T t)
	{
		if (size == identifiers.length)
		{
			// Expand identifiers
			// Create a bigger array, copy the old one and return it
			Identifier[] newIdentifiers = new Identifier[identifiers.length * 3 / 2];
			System.arraycopy(identifiers, 0, newIdentifiers, 0, identifiers.length);
			identifiers = newIdentifiers;
			
			// Expand values
			// Create a bigger array, copy the old one and return it
			T[] newValues = (T[]) Array.newInstance(entryType, identifiers.length * 3 / 2);
			System.arraycopy(values, 0, newValues, 0, values.length);
			values = newValues;
		}
		
		// Set the indentifier-value pair to the same index
		identifiers[size] = identifier;
		values[size] = t;
		
		// Increase the size
		size++;
	}
	
	/** Get an entry */
	public T get(Identifier identifier)
	{
		// For every index
		for (int i = 0; i < size; i++)
			
			// If the identifier is in this index
			if (identifiers[i] == identifier)
				
				// Return the value in this index
				return values[i];
		
		// If the identifier is not in the list
		// Return null
		return null;
	}
}
