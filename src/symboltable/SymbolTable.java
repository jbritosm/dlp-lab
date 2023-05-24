package symboltable;

import java.util.*;
import ast.definition.Definition;

public class SymbolTable {
	
	private int scope = -1;
	private List<Map<String,Definition>> table;
	public SymbolTable()  {
		table = new ArrayList<>();
		set();
	}

	public void set() {
		scope++;
		table.add(new HashMap<>());
	}
	
	public void reset() {
		table.remove(scope);
		scope--;
	}

	/*
	* If the definition is already defined return false.
	* */
	public boolean insert(Definition definition) {
		// If the definition is defined in the current scope return false.
		if(findInCurrentScope(definition.getName()) != null)
			return false;

		definition.setScope(scope);
		table.get(scope).put(definition.getName(), definition);
		return table.get(scope).containsKey(definition.getName());
	}
	
	public Definition find(String id) {
		for(Map<String, Definition> map : table) {
			if(map.containsKey(id))
				return map.get(id);
		}
		return null;
	}

	public Definition findInCurrentScope(String id) {
		return table.get(scope).get(id);
	}
}
