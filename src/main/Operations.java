package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Operations {

	public static final Operations INSTANCE = new Operations();
	
	private final Map<String, Operation> commands = new HashMap<String, Operation>();
	
	public void register(Operation op) {
		assert(commands.get(op.getName()) == null);
		commands.put(op.getName(), op);
	}
	
	public void reset() {
		commands.clear();
	}
	
	public Operation getOperation(String name) {
		return commands.get(name);
	}
	
	public int size() {
		return commands.size();
	}
	
	public String getOperationName(int i) {
		String keys[] = new String[commands.keySet().size()];
		(commands.keySet()).toArray(keys);
		Arrays.sort(keys);
		return keys[i];
	}
}
