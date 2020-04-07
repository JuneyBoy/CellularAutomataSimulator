import java.util.Arrays;
import java.util.HashMap;
/**
 * This Rule depends evolves a Cell based on its current state as well as the states of its left and right neighbors.
 * As 3 Cells are used to determine the state of any given Cell's state in the next Generation and each Cell can be in 1 of 2 states,
 * there are 8 subrules.
 * 
 * @author Arjun Ganesan
 * @version
 *
 */
public class ElementaryRule extends Rule{
	
	private final int NUM_OF_SUBRULES = 8;
	//# of Cells used in determining the state of the Cell in the next Generation
	private final int NEIGHBORHOOD_RADIUS = 3;
	//stores the rule # in binary
	private String ruleInBinary;
	
	//stores all the possible combinations of the 8 Cells
	private static final CellState[] ZERO_SUBRULE = {CellState.OFF, CellState.OFF, CellState.OFF};
	private static final CellState[] ONE_SUBRULE = {CellState.OFF, CellState.OFF, CellState.ON};
	private static final CellState[] TWO_SUBRULE = {CellState.OFF, CellState.ON, CellState.OFF};
	private static final CellState[] THREE_SUBRULE = {CellState.OFF, CellState.ON, CellState.ON};
	private static final CellState[] FOUR_SUBRULE = {CellState.ON, CellState.OFF, CellState.OFF};
	private static final CellState[] FIVE_SUBRULE = {CellState.ON, CellState.OFF, CellState.ON};
	private static final CellState[] SIX_SUBRULE = {CellState.ON, CellState.ON, CellState.OFF};
	private static final CellState[] SEVEN_SUBRULE = {CellState.ON, CellState.ON, CellState.ON};
	
	private static final HashMap<CellState[], Integer> NEIGHBORHOOD_TO_SUBRULE = new HashMap<>();
	
	//HashMap maps each combination to its subrule number, which will be used to find the relevant char in the ruleInBinary Strng
	static {
		NEIGHBORHOOD_TO_SUBRULE.put(ZERO_SUBRULE, 0);
		NEIGHBORHOOD_TO_SUBRULE.put(ONE_SUBRULE, 1);
		NEIGHBORHOOD_TO_SUBRULE.put(TWO_SUBRULE, 2);
		NEIGHBORHOOD_TO_SUBRULE.put(THREE_SUBRULE, 3);
		NEIGHBORHOOD_TO_SUBRULE.put(FOUR_SUBRULE, 4);
		NEIGHBORHOOD_TO_SUBRULE.put(FIVE_SUBRULE, 5);
		NEIGHBORHOOD_TO_SUBRULE.put(SIX_SUBRULE, 6);
		NEIGHBORHOOD_TO_SUBRULE.put(SEVEN_SUBRULE, 7);
	}
	
	//stores all the possible combinations of the 8 Cells, but in binary form to be easily compared
	private static boolean[] ZERO_SUBRULE_AS_BOOLEAN = (new Generation(ZERO_SUBRULE)).getGenerationAsBooleanArray();
	private static boolean[] ONE_SUBRULE_AS_BOOLEAN = (new Generation(ONE_SUBRULE)).getGenerationAsBooleanArray();
	private static boolean[] TWO_SUBRULE_AS_BOOLEAN = (new Generation(TWO_SUBRULE)).getGenerationAsBooleanArray();
	private static boolean[] THREE_SUBRULE_AS_BOOLEAN = (new Generation(THREE_SUBRULE)).getGenerationAsBooleanArray();
	private static boolean[] FOUR_SUBRULE_AS_BOOLEAN = (new Generation(FOUR_SUBRULE)).getGenerationAsBooleanArray();
	private static boolean[] FIVE_SUBRULE_AS_BOOLEAN = (new Generation(FIVE_SUBRULE)).getGenerationAsBooleanArray();
	private static boolean[] SIX_SUBRULE_AS_BOOLEAN = (new Generation(SIX_SUBRULE)).getGenerationAsBooleanArray();
	private static boolean[] SEVEN_SUBRULE_AS_BOOLEAN = (new Generation(SEVEN_SUBRULE)).getGenerationAsBooleanArray();
	
	/**
	 * 
	 * @param ruleNum is the elementary rule
	 * @throws InvalidRuleNumException with there being 8 subrules and 2 states each subrule can specify, there 256 total elementary rules. This exception throws any ruleNum that isn't between 0 and 255.
	 */
	public ElementaryRule(int ruleNum) throws InvalidRuleNumException{
		super(ruleNum);
		
		if(ruleNum < 0 || ruleNum > 255) {
			throw new InvalidRuleNumException();
		}
		//gets the ruleNum as an 8-bit String
		ruleInBinary = String.format("%8s", Integer.toBinaryString(ruleNum)).replace(' ', '0');
	}
	
	/**
	 * returns 8 for any ElementaryRule object
	 */
	public int getNumSubrules() {
		return NUM_OF_SUBRULES;
	}
	
	public Cell[] getNeighborhood(int cellIdx, Generation gen, BoundaryConditions bc) {
		Cell[] neighborhood = new Cell[NEIGHBORHOOD_RADIUS];
		//gets the left neighbor of the Cell and stores it at index 0
		neighborhood[0] = bc.getNeighbor(cellIdx, -1, gen);
		//stores the Cell at index 1
		neighborhood[1] = bc.getNeighbor(cellIdx, 0, gen);
		//gets the right neighbor of the Cell and stores it at index 2
		neighborhood[2] = bc.getNeighbor(cellIdx, 1, gen);
		
		return neighborhood;
		
	}
	
	/**
	 * 
	 * @param neighborhood the 3 Cells(the Cell that is being evolved and its left and right neighbor)
	 * @return an EvolvedCell
	 */
	public EvolvedCell evolve(Cell[] neighborhood) {
		EvolvedCell returnCell;
		int subrule = 0;
		char relevantBit;
		//gets the neighborhood of Cells as a boolean[] for easy comparison
		boolean[] neighborhoodAsBoolean = (new Generation(neighborhood)).getGenerationAsBooleanArray();
		
		//compares the nieghborhood to every possible combination of 3 Cells and gets the appriopriate subrule number
		if(Arrays.equals(neighborhoodAsBoolean, ZERO_SUBRULE_AS_BOOLEAN)) {
			subrule = NEIGHBORHOOD_TO_SUBRULE.get(ZERO_SUBRULE);
		}
		else if(Arrays.equals(neighborhoodAsBoolean, ONE_SUBRULE_AS_BOOLEAN)) {
			subrule = NEIGHBORHOOD_TO_SUBRULE.get(ONE_SUBRULE);
		}
		else if(Arrays.equals(neighborhoodAsBoolean, TWO_SUBRULE_AS_BOOLEAN)) {
			subrule = NEIGHBORHOOD_TO_SUBRULE.get(TWO_SUBRULE);
		}
		else if(Arrays.equals(neighborhoodAsBoolean, THREE_SUBRULE_AS_BOOLEAN)) {
			subrule = NEIGHBORHOOD_TO_SUBRULE.get(THREE_SUBRULE);
		}
		else if(Arrays.equals(neighborhoodAsBoolean, FOUR_SUBRULE_AS_BOOLEAN)) {
			subrule = NEIGHBORHOOD_TO_SUBRULE.get(FOUR_SUBRULE);
		}
		else if(Arrays.equals(neighborhoodAsBoolean, FIVE_SUBRULE_AS_BOOLEAN)) {
			subrule = NEIGHBORHOOD_TO_SUBRULE.get(FIVE_SUBRULE);
		}
		else if(Arrays.equals(neighborhoodAsBoolean, SIX_SUBRULE_AS_BOOLEAN)) {
			subrule = NEIGHBORHOOD_TO_SUBRULE.get(SIX_SUBRULE);
		}
		else if(Arrays.equals(neighborhoodAsBoolean, SEVEN_SUBRULE_AS_BOOLEAN)) {
			subrule = NEIGHBORHOOD_TO_SUBRULE.get(SEVEN_SUBRULE);
		}
		
		//the relevant bit in the binary string is at the "opposite" index of the subrule number
		relevantBit = ruleInBinary.charAt(ruleInBinary.length() - (subrule + 1));
		
		//if the relevantBit is 1 then the state of the EvolvedCell is ON
		if(relevantBit == '1') {
			returnCell = new EvolvedCell(CellState.ON, subrule);
		}
		//Otherwise the state of the EvolvedCell is OFF
		else {
			returnCell = new EvolvedCell(CellState.OFF, subrule);
		}
		
		return returnCell;
		
	}
	
	/**
	 * @return a String representation of the Rule table
	 * For example, for ruleNum = 110 the String would be 
	 * OOO OO. O.O O.. .OO .O. ..O ...
 .   *	O   O   .   O   O   O   . 
	 */
	public String toString() {
		StringBuilder firstLine = new StringBuilder("OOO OO. O.O O.. .OO .O. ..O ...");
		
		StringBuilder secondLine = new StringBuilder();
		
		for(int i = 0; i < ruleInBinary.length(); ++i) {
			CellState state;
			
			if(ruleInBinary.charAt(i) == '0') {
				state = CellState.OFF;
			}
			else {
				state = CellState.ON;
			}
			
			if(i == (ruleInBinary.length() - 1)) {
				secondLine.append(" " + state.toString() + " ");
			}
			else {
				secondLine.append(" " + state.toString() + "  ");
			}
		}
		
		StringBuilder returnString = firstLine.append("\n").append(secondLine);
		
		return returnString.toString();
	}
}
