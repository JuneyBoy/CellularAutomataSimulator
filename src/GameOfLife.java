
public class GameOfLife {
	//Rule 0: Any live cell with two or three live neighbors survives into the next generation
	//Rule 1: Any dead cell with three or more live neighbors will be reborn in the next generation
	//Rule 2: All other cells will be dead in the next generation.
	private final int NUM_OF_SUBRULES = 3;
	//8 cells are the surrounding cells and the 9th cell is the cell itself
	private final int CELLS_IN_NEIGHBORHOOD = 9;
	
	public GameOfLife() {
	}
	
	public int getNumSubrules() {
		return NUM_OF_SUBRULES;
	}
	
	/**
	 * 
	 * @param cellRow row of TwoDGeneration current cell is in
	 * @param cellCol column of TwoDGeneration current cell is in
	 * @param gen 
	 * @param bc
	 * @return Cell[] of all 8 surrounding cells and current cell itself
	 */
	public Cell[] getNeighborhood(int cellRow, int cellCol, TwoDGeneration gen, BoundaryConditions bc) {
		Cell[] neighborhood = new Cell[CELLS_IN_NEIGHBORHOOD];
		
		//cell to upper left
		neighborhood[0] = bc.getNeighbor(cellRow, cellCol, -1, -1, gen);
		//cell directly above
		neighborhood[1] = bc.getNeighbor(cellRow, cellCol, -1, 0, gen);
		//cell to upper right
		neighborhood[2] = bc.getNeighbor(cellRow, cellCol, -1, 1, gen);
		//cell directly left
		neighborhood[3] = bc.getNeighbor(cellRow, cellCol, 0, -1, gen);
		//cell directly right
		neighborhood[4] = bc.getNeighbor(cellRow, cellCol, 0, 1, gen);
		//cell to lower left
		neighborhood[5] = bc.getNeighbor(cellRow, cellCol, 1, -1, gen);
		//cell directly below
		neighborhood[6] = bc.getNeighbor(cellRow, cellCol, 1, 0, gen);
		//cell to lower right
		neighborhood[7] = bc.getNeighbor(cellRow, cellCol, 1, 1, gen);
		//current cell(used to figure out state of current cell)
		neighborhood[8] = gen.getCell(cellRow, cellCol);
		
		return neighborhood;
	}
	
	/**
	 * 
	 * @param neighborhood cells surrounding cell to be evolved
	 * @return EvolvedCell based on Game of Life rules
	 */
	public EvolvedCell evolve(Cell[] neighborhood) {
		Cell currentCell = neighborhood[8];
		int onCellCounter = 0;
		//by default, the cell will be dead in the next generation
		EvolvedCell returnCell = new EvolvedCell(CellState.OFF, 2);
		//iterates over neighborhood and counts how many cells were alive
		for (int i = 0; i < 8; ++i) {
			if(neighborhood[i].getState() == CellState.ON) {
				++ onCellCounter;
			}
		}
		
		//if the current cell is alive and there were 2 or 3 neighbors that were alive, the current cell will remain alive in the next generation
		if(currentCell.getState() == CellState.ON) {
			if(onCellCounter == 2 || onCellCounter == 3) {
				returnCell = new EvolvedCell(CellState.ON, 0);
			}
		}
		//if the current cell is dead and 3 of its neighbors were alive, the current cell will be alive in the next generation
		else if(currentCell.getState() == CellState.OFF) {
			if(onCellCounter == 3) {
				returnCell = new EvolvedCell(CellState.ON, 1);
			}
		}
		
		return returnCell;
	}
	
	/**
	 * Calls other evolve method on each cell in the TwoDGeneration
	 * @param gen 
	 * @param bc
	 * @return TwoDGeneration of all cells in evolved state
	 */
	public TwoDGeneration evolve(TwoDGeneration gen, BoundaryConditions bc) {
		EvolvedCell[][] newGen = new EvolvedCell[gen.numOfRows()][gen.numOfCols()];
		
		for(int row = 0; row < newGen.length; ++row) {
			for(int col = 0; col < newGen[row].length; ++col) {
				Cell[] neighborhood = this.getNeighborhood(row, col, gen, bc);
				newGen[row][col] = this.evolve(neighborhood);
			}
		}
		
		return new TwoDGeneration(newGen);
		
	}
	
	public String toString() {
		String ruleString = "Rule 0: Any live cell with two or three live neighbors survives into the next generation." + "/n";
		ruleString += "Rule 1: Any dead cell with three or more live neighbors will be reborn in the next generation." + "/n";
		ruleString += "Rule 2: All other cells will be dead in the next generation.";
		
		return ruleString;
	}
	
}
