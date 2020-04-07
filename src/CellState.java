import java.util.HashMap;

/**
 * This enum type allows a Cell to either be in an OFF or ON state, which with a corresponding character('.' and 'O' respectively)
 * 
 * @author Arjun Ganesan
 * @version 1.0
 *
 */
public enum CellState {
	
	OFF('.'), 
	ON('O');
	
	private char symbol;
	private static final HashMap<Character, CellState> SYMBOL_TO_MAP = new HashMap<>();
	
	//HashMap maps the symbols to their respective enum types
	static {
		SYMBOL_TO_MAP.put(OFF.symbol, OFF);
		SYMBOL_TO_MAP.put(ON.symbol, ON);
	}
	
	private CellState(char symbol) {
		this.symbol = symbol;
	}
	
	/**
	 * Given a symbol, this method returns the CellState associated with it
	 * @param symbol can either be '.' (returns OFF) or 'O' (returns ON)
	 * @return
	 */
	public static CellState getState(char symbol) {
		return SYMBOL_TO_MAP.get(symbol);
	}
	
	@Override
	public String toString() {
		return Character.toString(symbol);
	}

}
