import java.util.HashMap;

public class TotalisticRule extends Rule{
	
	private final int NUM_OF_SUBRULES = 6;
	private final int NEIGHBORHOOD_RADIUS = 5;
	private String ruleInBinary;
	
	public TotalisticRule(int ruleNum) throws InvalidRuleNumException{
		super(ruleNum);
		
		if(ruleNum < 0 || ruleNum > 64) {
			throw new InvalidRuleNumException();
		}
		ruleInBinary = String.format("%6s", Integer.toBinaryString(ruleNum)).replace(' ', '0');
	}
	
	public int getNumSubrules() {
		return NUM_OF_SUBRULES;
	}
	
	public Cell[] getNeighborhood(int cellIdx, Generation gen, BoundaryConditions bc) {
		
		Cell[] neighborhood = new Cell[NEIGHBORHOOD_RADIUS];
		
		neighborhood[0] = bc.getNeighbor(cellIdx, -2, gen);
		neighborhood[1] = bc.getNeighbor(cellIdx, -1, gen);
		neighborhood[2] = bc.getNeighbor(cellIdx, 0, gen);
		neighborhood[3] = bc.getNeighbor(cellIdx, 1, gen);
		neighborhood[4] = bc.getNeighbor(cellIdx, 2, gen);
		
		return neighborhood;
		
	}
	
	public EvolvedCell evolve(Cell[] neighborhood) {
		EvolvedCell returnCell;
		int numOfOnCellsInNeighborHood = 0;
		
		for(Cell cell : neighborhood) {
			if(cell.getState() == CellState.ON) {
				++numOfOnCellsInNeighborHood;
			}
		}
		
		if(ruleInBinary.charAt(NUM_OF_SUBRULES - (numOfOnCellsInNeighborHood + 1)) == '1') {
			returnCell = new EvolvedCell(CellState.ON, numOfOnCellsInNeighborHood);
		}
		
		else {
			returnCell = new EvolvedCell(CellState.OFF, numOfOnCellsInNeighborHood);
		}
		
		return returnCell;
		
	}
	
	public String toString() {
		StringBuilder firstLine = new StringBuilder();
		firstLine.append("5 4 3 2 1 0");
		
		StringBuilder secondLine = new StringBuilder();
		for(int i = NUM_OF_SUBRULES - 1; i >= 0; --i) {
			secondLine.append(" " + ruleInBinary.charAt(i) + " ");
		}
		
		StringBuilder returnString = firstLine.append("\n").append(secondLine);
		return returnString.toString();
	}

}
