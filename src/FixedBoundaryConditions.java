/**
 * The FixedBoundary condition sets a fixed state for the neighbors of Cells at the 
 * edge of the Generation
 * 
 * @author Arjun Ganesan
 * @version 1.0
 *
 */
public class FixedBoundaryConditions implements BoundaryConditions{
	
	private CellState leftBoundaryCondition;
	private CellState rightBoundaryCondition;
	private CellState aboveBoundaryCondition;
	private CellState belowBoundaryCondition;
	
	/**
	 * Constructor is for 1D Automata
	 * @param left is the CellState for all Cells that are considered left of the left most Cell
	 * @param right is the CellState for all Cells that are considered right of the right most Cell
	 */
	public FixedBoundaryConditions(CellState left, CellState right) {
		leftBoundaryCondition = left;
		rightBoundaryCondition = right;
	}
	
	/**
	 * Constructor is for 2D Automata
	 * @param left is the CellState for all Cells that are considered left of the left most column
	 * @param right is the CellState for all Cells that are considered right of the right most column
	 * @param above is the CellState for all Cells that are considered above the top row
	 * @param right is the CellState for all Cells that are considered below the bottow row
	 */
	public FixedBoundaryConditions(CellState left, CellState right, CellState above, CellState below) {
		leftBoundaryCondition = left;
		rightBoundaryCondition = right;
		aboveBoundaryCondition = above;
		belowBoundaryCondition = below;
	}
	
	/**
	 * 
	 * @return the leftBoundaryCondition that was set in the constructor
	 */
	public CellState getLeftState() {
		return leftBoundaryCondition;
	}
	
	/**
	 * 
	 * @return the rightBoundaryCondition that was set in the constructor
	 */
	public CellState getRightState() {
		return rightBoundaryCondition;
	}
	
	/**
	 * 
	 * @return the aboveBoundaryCondition that was set in the constructor
	 */
	public CellState getAboveState() {
		return aboveBoundaryCondition;
	}
	
	/**
	 * 
	 * @return the belowBoundaryCondition that was set in the constructor
	 */
	public CellState getBelowState() {
		return belowBoundaryCondition;
	}
	
	/**
	 * 
	 * @param cellIdx the index of the Cell whose neighbor we are trying to access
	 * @param offset the index of the neighbor relative to the Cell
	 * @param gen the Generation
	 * @return the Cell with index cellIdx + offset
	 */
	public Cell getNeighbor(int cellIdx, int offset, Generation gen) {
		Cell returnCell;
		int cellsInGen = gen.size();
		int neighborNum = cellIdx + offset;
		
		//if the sum of the cellIdx and offset is negative, that means the Cell is "too left",
		//so the state of the neighbor is set to the leftBoundaryCondition
		if(neighborNum < 0) {
			returnCell = new Cell(this.getLeftState());
		}
		//if the sum of the cellIdx and offset is greater than the # of Cells in the generation
		//that means the Cell is "too right", so the state of the neighbor is set to 
		//the rightBoundaryCondition
		else if(neighborNum >= cellsInGen) {
			returnCell = new Cell(this.getRightState());
		}
		//otherwise, the neighbor is simply the Cell at the neighborNum idx
		else {
			returnCell = gen.getCell(neighborNum);
		}
		return returnCell;
	}
	
	/**
	 * 
	 * @param cellRow the row of the Cell whose neighbor we are trying to access
	 * @param cellRow the row of the Cell whose neighbor we are trying to access
	 * @param rowOffset the row of the neighbor relative to the Cell
	 * @param colOffset the col of the neighbor relative to the Cell
	 * @param gen the 2D Generation
	 * @return the Cell with indices (cellIdx + rowOffset, cellIdx + colOffset)
	 */
	public Cell getNeighbor(int cellRow, int cellCol, int rowOffset, int colOffset, TwoDGeneration gen) {
		
		Cell returnCell;
		int rowsInGen = gen.numOfRows();
		int colsInGen = gen.numOfCols();
		
		int rowOfNeighbor = cellRow + rowOffset;
		int colOfNeighbor = cellCol + colOffset;
		
		//if the sum of the cellIdx and row offset is negative, that means the Cell is "too left",
		//so the state of the neighbor is set to the leftBoundaryCondition
		if(rowOfNeighbor < 0) {
			returnCell = new Cell(this.getLeftState());
		}
		//if the sum of the cellIdx and row offset is greater than the # of Cells in the generation
		//that means the Cell is "too right", so the state of the neighbor is set to 
		//the rightBoundaryCondition
		else if(rowOfNeighbor >= rowsInGen) {
			returnCell = new Cell(this.getRightState());
		}
		//if the sum of the cellIdx and col offset is negative, that means the Cell is "too left",
		//so the state of the neighbor is set to the leftBoundaryCondition
		else if(colOfNeighbor < 0) {
			returnCell = new Cell(this.belowBoundaryCondition);
		}
		//if the sum of the cellIdx and col offset is greater than the # of Cells in the generation
		//that means the Cell is "too right", so the state of the neighbor is set to 
		//the rightBoundaryCondition
		else if(colOfNeighbor >= colsInGen) {
			returnCell = new Cell(this.aboveBoundaryCondition);
		}
		
		//otherwise, the neighbor is simply the Cell at the specified indices
		else {
			returnCell = gen.getCell(rowOfNeighbor, colOfNeighbor);
		}
		
		return returnCell;
	}

}
