/**
 * This class represents the state of a 2D Automaton, holding a 2D array of many Cell or EvolvedCell objects
 * 
 * @author Arjun Ganesan
 * @version 1.0
 *
 */
public class TwoDGeneration {
	private Cell[][] cells;
	
	/**
	 * This constructor takes a 2D array of CellState objects and converts each of them into a Cell object and stores them into a Cell[][]
	 * @param states is an array of CellState objects
	 */
	public TwoDGeneration(CellState[][] states) {
		cells = new Cell[states.length][states[0].length];

		//outer for loop iterates over rows
		for (int row = 0; row < cells.length; ++row) {
			//inner for loop iterates over columns
			for (int col = 0; col < cells[row].length; ++col) {
				cells[row][col] = new Cell(states[row][col]);
			}
				
		}
	}
	
	/**
	 * This constructor takes a String, creates a Cell object for each symbol that is mapped to either CellState.OFF or CellState.ON, and stores each Cell into the cells array
	 * @param string is a representation of a Generation, with the state of each Cell being represented by its respective symbol
	 */
	public TwoDGeneration(String genAsString, int numOfRows, int numOfCols) {
		
		cells = new Cell[numOfRows][numOfCols];
		int charIdx = 0;
		
		for (int row = 0; row < numOfRows; ++row) {
			
			for (int col = 0; col < numOfCols; ++col) {
				
				if(genAsString.charAt(charIdx) != '.' && genAsString.charAt(charIdx) != 'O') {
					throw new IllegalArgumentException();
				}
				
				cells[row][col] = new Cell(CellState.getState(genAsString.charAt(charIdx)));
				++charIdx;
			}
		}
		
	}
	
	/**
	 * Probably the most straightforward Generation constructor, the constructor copies the states array and stores the copy into the cells array
	 * @param cells is an array of Cell objects that will be copied without being modified
	 */
	public TwoDGeneration(Cell[][] cells) {
		Cell[][] cellsCopy = cells.clone();
		this.cells = cellsCopy;
	}
	
	/**
	 * 
	 * @return the number of rows in the Generation
	 */
	public int numOfRows() {
		return cells.length;
	}
	
	/**
	 * 
	 * @return the number of Cells in the Generation
	 */
	public int numOfCols() {
		return cells[0].length;
	}
	
	/**
	 * 
	 * @return the number of Cells in the Generation
	 */
	public int size() {
		return cells.length * cells[0].length;
	}
	
	/**
	 * 
	 * @param idx the index of the Cell that the user wants to access
	 * @return the Cell at the specified index
	 */
	public Cell getCell(int row, int col) {
		return cells[row][col];
	}
	
	public String toString() {
		String returnString = "";
		
		for(Cell[] rowOfCells : cells) {
			for(Cell cell : rowOfCells) {
				returnString += cell.toString();
			}
			returnString += "/n";
		}
		return returnString;
	}
}
