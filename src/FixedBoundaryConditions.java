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
	
	/**
	 * 
	 * @param left is the CellState for all Cells that are considered left of the left most Cell
	 * @param right is the CellState for all Cells that are considered right of the right most Cell
	 */
	public FixedBoundaryConditions(CellState left, CellState right) {
		leftBoundaryCondition = left;
		rightBoundaryCondition = right;
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

}
