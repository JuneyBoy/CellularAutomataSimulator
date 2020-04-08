
/**
 * This Rule evolves a Cell based on how many Cells in a radius(which is 2 for this program) are ON.
 * As 5 Cells are used to determine the state of any given Cell's state in the next Generation and the number of Cells that can be ON are 0-5,
 * there are 6 subrules.
 * 
 * @author Arjun Ganesan
 * @version 1.0
 *
 */
public class TotalisticRule extends Rule{
	
	private final int NUM_OF_SUBRULES = 6;
	//# of Cells used in determining the state of the Cell in the next Generation
	private final int NEIGHBORHOOD_LENGTH = 5;
	//stores the rule # in binary
	private String ruleInBinary;
	
	/**
	 * 
	 * @param ruleNum is the totalistic rule
	 * @throws InvalidRuleNumException with there being 6 subrules and 2 states each subrule can specify, there 64 total elementary rules. This exception throws any ruleNum that isn't between 0 and 255.
	 */
	public TotalisticRule(int ruleNum) throws InvalidRuleNumException{
		super(ruleNum);
		
		if(ruleNum < 0 || ruleNum > 64) {
			throw new InvalidRuleNumException();
		}
		//gets the ruleNum as an 6-bit String
		ruleInBinary = String.format("%6s", Integer.toBinaryString(ruleNum)).replace(' ', '0');
	}
	
	/**
	 * returns 6 for any TotalisticRule object
	 */
	public int getNumSubrules() {
		return NUM_OF_SUBRULES;
	}
	
	public Cell[] getNeighborhood(int cellIdx, Generation gen, BoundaryConditions bc) {
		
		Cell[] neighborhood = new Cell[NEIGHBORHOOD_LENGTH];
		
		neighborhood[0] = bc.getNeighbor(cellIdx, -2, gen);
		neighborhood[1] = bc.getNeighbor(cellIdx, -1, gen);
		neighborhood[2] = bc.getNeighbor(cellIdx, 0, gen);
		neighborhood[3] = bc.getNeighbor(cellIdx, 1, gen);
		neighborhood[4] = bc.getNeighbor(cellIdx, 2, gen);
		
		return neighborhood;
		
	}
	
	/**
	 * @param neighborhood the 5 Cells (the Cell that is being evolved and the 2 Cells to its right as well as 2 Cells to its left)
	 * @return an EvolvedCell
	 */
	public EvolvedCell evolve(Cell[] neighborhood) {
		EvolvedCell returnCell;
		int numOfOnCellsInNeighborHood = 0;
		char relevantBit;
		
		//counts how many Cells in the nieghborhood were in the ON state
		for(Cell cell : neighborhood) {
			if(cell.getState() == CellState.ON) {
				++numOfOnCellsInNeighborHood;
			}
		}
		
		//the relevant bit in the binary string is at the "opposite" index of the subrule number
		relevantBit = ruleInBinary.charAt(NUM_OF_SUBRULES - (numOfOnCellsInNeighborHood + 1));
		
		//if the relevantBit is 1 then the state of the EvolvedCell is ON
		if(relevantBit == '1') {
			returnCell = new EvolvedCell(CellState.ON, numOfOnCellsInNeighborHood);
		}
		//Otherwise the state of the EvolvedCell is OFF
		else {
			returnCell = new EvolvedCell(CellState.OFF, numOfOnCellsInNeighborHood);
		}
		
		return returnCell;
		
	}
	
	/**
	 * @return a String representation of the Rule table
	 * For example, for ruleNum = 22 the String would be 
	 * 5 4 3 2 1 0
	 * . O . O O .
	 */
	public String toString() {
		//firstLine is a constant as these possible numbers for how many Cells were ON never change for a TotalisticRule
		StringBuilder firstLine = new StringBuilder();
		firstLine.append("5 4 3 2 1 0");
		
		//gets the bits of the ruleInBinary String
		StringBuilder secondLine = new StringBuilder();
		for(int i = 0; i < ruleInBinary.length(); ++i) {
			CellState state;
			
			//if the bit is 0, the state of the Cell in the next Generation following that subrule should be OFF
			if(ruleInBinary.charAt(i) == '0') {
				state = CellState.OFF;
			}
			//else the state should be ON
			else {
				state = CellState.ON;
			}
			//if the index of the char is 0, there is no space before the symbol
			if(i == 0) {
				secondLine.append(state.toString());
			}
			//else, there is a space before the symbol
			else {
				secondLine.append(" " + state.toString());
			}
		}
		
		StringBuilder returnString = firstLine.append("\n").append(secondLine);
		return returnString.toString();
	}

}
