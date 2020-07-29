
public class GameOfLife extends Rule {
	
	private final int NUM_OF_SUBRULES = 3;
	
	private final int CELLS_IN_NEIGHBORHOOD = 9;
	
	public GameOfLife() {
		super(-1);
	}
	
	public int getNumSubrules() {
		return NUM_OF_SUBRULES;
	}
	
	public Cell[] getNeighborhood(int cellRow, int cellCol, TwoDGeneration gen, BoundaryConditions bc) {
		Cell[] neighborhood = new Cell[CELLS_IN_NEIGHBORHOOD];
		
		neighborhood[0] = bc.getNeighbor(cellRow, cellCol, -1, -1, gen);
		neighborhood[1] = bc.getNeighbor(cellRow, cellCol, -1, 0, gen);
		neighborhood[2] = bc.getNeighbor(cellRow, cellCol, -1, 1, gen);
		neighborhood[3] = bc.getNeighbor(cellRow, cellCol, 0, -1, gen);
		neighborhood[4] = bc.getNeighbor(cellRow, cellCol, 0, 1, gen);
		neighborhood[5] = bc.getNeighbor(cellRow, cellCol, 1, -1, gen);
		neighborhood[6] = bc.getNeighbor(cellRow, cellCol, 1, 0, gen);
		neighborhood[7] = bc.getNeighbor(cellRow, cellCol, 1, 1, gen);
		neighborhood[8] = gen.getCell(cellRow, cellCol);
		
		return neighborhood;
	}
	
	public EvolvedCell evolve(Cell[] neighborhood) {
		Cell currentCell = neighborhood[8];
		int onCellCounter = 0;
		EvolvedCell returnCell = new EvolvedCell(CellState.OFF, 2);
		for (int i = 0; i < 8; ++i) {
			if(neighborhood[i].getState() == CellState.ON) {
				++ onCellCounter;
			}
		}
		
		if(currentCell.getState() == CellState.ON) {
			if(onCellCounter == 2 || onCellCounter == 3) {
				returnCell = new EvolvedCell(CellState.ON, 0);
			}
		}
		
		else if(currentCell.getState() == CellState.OFF) {
			if(onCellCounter == 3) {
				returnCell = new EvolvedCell(CellState.ON, 1);
			}
		}
		
		return returnCell;
	}
}
