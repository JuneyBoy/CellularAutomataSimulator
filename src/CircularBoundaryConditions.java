
public class CircularBoundaryConditions implements BoundaryConditions{
	
	public CircularBoundaryConditions() {
		
	}
	
	public Cell getNeighbor(int cellIdx, int offset, Generation gen) {
		int cellsInGen = gen.size();
		Cell returnCell = gen.getCell((cellIdx + offset) % cellsInGen);
		return returnCell;
	}

}
