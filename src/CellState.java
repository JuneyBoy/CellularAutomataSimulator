import java.util.HashMap;
public enum CellState {
	
	OFF('.'), 
	ON('O');
	
	private char symbol;
	private static final HashMap<Character, CellState> SYMBOL_TO_MAP = new HashMap<>();
	
	static {
		SYMBOL_TO_MAP.put(OFF.symbol, OFF);
		SYMBOL_TO_MAP.put(ON.symbol, ON);
	}
	
	private CellState(char symbol) {
		this.symbol = symbol;
	}
	
	public static CellState getState(char symbol) {
		return SYMBOL_TO_MAP.get(symbol);
	}
	
	@Override
	public String toString() {
		return Character.toString(symbol);
	}

}
