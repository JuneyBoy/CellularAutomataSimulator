/**
 * This is the most basic unit of the Automaton, and only has one data member which holds whether it is in the OFF or ON state
 * 
 * @author Arjun Ganesan
 * @version 1.0
 *
 */
public class Cell {
	
	private CellState state;
	
	/**
	 * The default constructor will make a Cell object with the state as OFF
	 */
	public Cell() {
		state = CellState.OFF;
	}
	
	/**
	 * This constructor takes a CellState object and assigns the state of that enum type to the state field of Cell
	 * @param state sets the state of the Cell object
	 */
	public Cell(CellState state) {
		this.state = state;
	}
	
	/**
	 * 
	 * @return the state of the Cell object
	 */
	public CellState getState() {
		return state;
	}
	
	public String toString() {
		return state.toString();
	}

}
