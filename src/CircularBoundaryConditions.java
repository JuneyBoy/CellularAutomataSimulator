
public class CircularBoundaryConditions implements BoundaryConditions{
	
	public CircularBoundaryConditions() {
		
	}
	
	public Cell getNeighbor(int cellIdx, int offset, Generation gen) {
		int cellsInGen = gen.size();
		int uncorrectedIndexOfNeighbor = cellIdx + offset;
		Cell returnCell;
		if(uncorrectedIndexOfNeighbor < 0) {
			returnCell = gen.getCell(gen.size() + uncorrectedIndexOfNeighbor);
			return returnCell;
		}
		returnCell = gen.getCell(uncorrectedIndexOfNeighbor % cellsInGen);
		return returnCell;
	}

}
