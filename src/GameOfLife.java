
public class GameOfLife extends Rule {
	
	private final int NUM_OF_SUBRULES = 3;
	
	private final int CELLS_IN_NEIGHBORHOOD = 8;
	
	public GameOfLife() {
		super(-1);
	}
	
	public int getNumSubrules() {
		return NUM_OF_SUBRULES;
	}
	
	public Cell[] getNeighborhood(int cellIdx, TwoDGeneration gen, BoundaryConditions bc) {
		Cell[] neighborhood = new Cell[CELLS_IN_NEIGHBORHOOD];
	}
}
