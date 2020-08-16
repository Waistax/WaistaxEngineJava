package waistax.registry;

import java.util.*;

/**
 * Stores a list of entries
 *
 * Author: Waistax
 * Created: 0.4 / 15 Aðu 2020 / 23:07:47
 *
 */
@SuppressWarnings("unchecked")
public class Registry
{
	/** Registered namespaces */
	public final ArrayList<Namespace> namespaces;
	
	/** Map of sub registeries and the classes of the objects they hold */
	public final HashMap<Class<?>, SubRegistry<?>> subRegistries;
	
	/** Default */
	public Registry()
	{
		namespaces = new ArrayList<>();
		subRegistries = new HashMap<>();
	}
	
	/** Create a namespace
	 * Returns null if a namespace with the given name already exists. */
	public Namespace createNamespace(String name)
	{
		// For every namespace in the list
		for (Namespace namespace : namespaces)
			
			// If the given name is the same as the namespace
			if (namespace.equals(name))
				
				// Return null
				return null;
		
		// If no namespace in the list has the same name
		// Create, add and return the namespace
		Namespace namespace = new Namespace(name);
		namespaces.add(namespace);
		return namespace;
	}
	
	/** Get an already existing namespace
	 * Return null if an namespace with this name does not exist inside this registry. */
	public Namespace getNamespace(String name)
	{
		// For every namespace in the list
		for (Namespace namespace : namespaces)

			// If the given name is the same as the namespace
			if (namespace.equals(name))
				
				// Return that namespace
				return namespace;
		
		// If no namespace in the list has the same name
		// Return null
		return null;
	}
	
	/** Get a sub registry for the given type
	 * Creates a new sub registry for the given type if it does not exists. */
	public <T> SubRegistry<T> getSubRegistry(Class<T> entryType)
	{
		// Get the sub registry for the type
		SubRegistry<?> subRegistry = subRegistries.get(entryType);
		
		// If the sub registry does not exist
		if (subRegistry == null)
		{
			// Create a new sub registry and put it into the map
			subRegistry = new SubRegistry<T>();
			subRegistries.put(entryType, subRegistry);
		}
		
		// Return the sub registry after casting it to the correct type
		return (SubRegistry<T>) subRegistry;
	}
	
	/** Add an entry
	 * Returns false if the given namespace is not from this registry.
	 * Returns false if the given name already exists inside the namespace. */
	public <T> boolean add(String id, T t)
	{
		// Get the index of the separator in the id
		int separatorIndex = id.indexOf(':');
		
		// Make sure the separator is there and it is at the middle
		if (separatorIndex < 1 || separatorIndex >= id.length() - 1)
			
			return false;
		
		// Get the namespace
		String namespaceName = id.substring(0, separatorIndex);
		Namespace namespace = getNamespace(namespaceName);
		
		// If the namespace does not exists
		if (namespace == null)

			// Create a new one
			namespace = createNamespace(namespaceName);
		
		// Create the identifier
		String name = id.substring(separatorIndex + 1);
		Identifier identifier = namespace.createIdentifier(name);
		
		// If the name already exists
		if (identifier == null)
			
			// Return false
			return false;
		
		// Get the sub registry for the type
		SubRegistry<T> subRegistry = getSubRegistry((Class<T>) t.getClass());

		// Add the entry and return true
		subRegistry.add(identifier, t);
		return true;
	}
	
	/** Get an entry
	 * Returns null if the id is not valid.
	 * Returns null if there is no entry with the given id. */
	public <T> T get(String id, Class<T> entryType)
	{
		// Get the index of the separator in the id
		int separatorIndex = id.indexOf(':');
		
		// Make sure the separator is there and it is at the middle
		if (separatorIndex < 1 || separatorIndex >= id.length() - 1) return null;
		
		// Make sure the namespace exists
		Namespace namespace = getNamespace(id.substring(0, separatorIndex));
		if (namespace == null) return null;
		
		// Make sure the identifier exists
		Identifier identifier = namespace.getIdentifier(id.substring(separatorIndex + 1));
		if (identifier == null) return null;
		
		// Return what the sub registry returns
		return getSubRegistry(entryType).get(identifier);
	}
}
