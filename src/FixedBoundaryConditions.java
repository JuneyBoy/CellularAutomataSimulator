
public class FixedBoundaryConditions implements BoundaryConditions{
	
	private CellState leftBoundaryCondition;
	private CellState rightBoundaryCondition;
	
	public FixedBoundaryConditions(CellState left, CellState right) {
		leftBoundaryCondition = left;
		rightBoundaryCondition = right;
	}
	
	public CellState getLeftState() {
		return leftBoundaryCondition;
	}
	
	public CellState getRightState() {
		return rightBoundaryCondition;
	}
	
	public Cell getNeighbor(int cellIdx, int offset, Generation gen) {
		Cell returnCell;
		int cellsInGen = gen.size();
		int neighborNum = cellIdx + offset;
		if(neighborNum < 0) {
			returnCell = new Cell(this.getLeftState());
		}
		else if(neighborNum >= cellsInGen) {
			returnCell = new Cell(this.getRightState());
		}
		else {
			returnCell = gen.getCell(neighborNum);
		}
		return returnCell;
	}

}
