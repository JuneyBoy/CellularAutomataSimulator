/**
 * This class represents the state of an Automaton, holding an array of many Cell or EvolvedCell objects
 * 
 * @author Arjun Ganesan
 * @version 1.0
 *
 */
public class Generation {
	
	private Cell[] cells;
	
	/**
	 * This constructor takes an array of CellState objects and converts each of them into a Cell object and stores them into a Cell[]
	 * @param states is an array of CellState objects
	 */
	public Generation(CellState[] states) {
		cells = new Cell[states.length];
		int i = 0;
		for(CellState state : states) {
			cells[i] = new Cell(state);
			++i;
		}
	}
	
	/**This constructor takes a String, creates a Cell object for each symbol that is mapped to either CellState.OFF or CellState.ON, and stores each Cell into the cells array
	 * 
	 * @param string is a representation of a Generation, with the state of each Cell being represented by its respective symbol
	 */
	public Generation(String genAsString) {
		cells = new Cell[genAsString.length()];
		try {
			for(int i = 0; i < genAsString.length(); ++i) {
				cells[i] = new Cell(CellState.getState(genAsString.charAt(i)));
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println("Character in String not a valid symbol for CellState");
		}
	}
	
	/**
	 * Probably the most straightforward Generation constructor, the constructor copies the states array and stores the copy into the cells array
	 * @param cells is an array of Cell objects that will be copied without being modified
	 */
	public Generation(Cell[] cells) {
		Cell[] cellsCopy = cells.clone();
		this.cells = cellsCopy;
	}
	
	/**
	 * 
	 * @return the number of Cells in the Generation
	 */
	public int size() {
		return cells.length;
	}
	
	/**
	 * 
	 * @param idx the index of the Cell that the user wants to access
	 * @return the Cell at the specified index
	 */
	public Cell getCell(int idx) {
		return cells[idx];
	}
	
	/**
	 * This method is mainly used in the ElementaryRuleClass
	 * @return a boolean[] representation of the Generation
	 */
	public boolean[] getGenerationAsBooleanArray() {
		boolean[] generationAsBoolean = new boolean[this.size()];
		CellState state;
		
		//gets the state of each Cell object in the Generation and sets the corresponding idx of the booleanp[] to true or false 
		for(int i = 0; i < generationAsBoolean.length; ++i) {
			state = this.getCell(i).getState();
			if(state == CellState.OFF) {
				generationAsBoolean[i] = false;
			}
			else {
				generationAsBoolean[i] = true;
			}
		}
		return generationAsBoolean;
	}
	
	public String toString() {
		String returnString = "";
		
		for(Cell cell : cells) {
			returnString += cell.toString();
		}
		return returnString;
	}

}
