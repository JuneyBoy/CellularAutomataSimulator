import java.util.HashMap;
public enum CellState {
	
	ON('.'), 
	OFF('O');
	
	private char symbol;
	private static final HashMap<Character, CellState> SYMBOL_TO_MAP = new HashMap<>();
	
	static {
		SYMBOL_TO_MAP.put('.', ON);
		SYMBOL_TO_MAP.put('O', OFF);
	}
	
	private CellState(char symbol) {
		this.symbol = symbol;
	}
	
	public static CellState getState(char symbol) {
		return SYMBOL_TO_MAP.get(symbol);
	}
	
	public String toString() {
		return this.name();
	}

}
