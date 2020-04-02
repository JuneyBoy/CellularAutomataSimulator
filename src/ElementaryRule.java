import java.util.Arrays;
import java.util.HashMap;

public class ElementaryRule extends Rule{
	
	private final int NUM_OF_SUBRULES = 8;
	private final int NEIGHBORHOOD_RADIUS = 3;
	private String ruleInBinary;
	
	private static final CellState[] ZERO_SUBRULE = {CellState.OFF, CellState.OFF, CellState.OFF};
	private static final CellState[] ONE_SUBRULE = {CellState.OFF, CellState.OFF, CellState.ON};
	private static final CellState[] TWO_SUBRULE = {CellState.OFF, CellState.ON, CellState.OFF};
	private static final CellState[] THREE_SUBRULE = {CellState.OFF, CellState.ON, CellState.ON};
	private static final CellState[] FOUR_SUBRULE = {CellState.ON, CellState.OFF, CellState.OFF};
	private static final CellState[] FIVE_SUBRULE = {CellState.ON, CellState.OFF, CellState.ON};
	private static final CellState[] SIX_SUBRULE = {CellState.ON, CellState.ON, CellState.OFF};
	private static final CellState[] SEVEN_SUBRULE = {CellState.ON, CellState.ON, CellState.ON};
	
	private static final HashMap<CellState[], Integer> NEIGHBORHOOD_TO_SUBRULE = new HashMap<>();
	
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
	
	private static boolean[] ZERO_SUBRULE_AS_BOOLEAN = new boolean[]{false, false, false};
	private static boolean[] ONE_SUBRULE_AS_BOOLEAN = new boolean[]{false, false, true};
	private static boolean[] TWO_SUBRULE_AS_BOOLEAN = new boolean[]{false, true, false};
	private static boolean[] THREE_SUBRULE_AS_BOOLEAN = new boolean[]{false, true, true};
	private static boolean[] FOUR_SUBRULE_AS_BOOLEAN = new boolean[]{true, false, false};
	private static boolean[] FIVE_SUBRULE_AS_BOOLEAN = new boolean[]{true, false, true};
	private static boolean[] SIX_SUBRULE_AS_BOOLEAN = new boolean[]{true, true, false};
	private static boolean[] SEVEN_SUBRULE_AS_BOOLEAN = new boolean[]{true, true, true};
	
	public ElementaryRule(int ruleNum) throws InvalidRuleNumException{
		super(ruleNum);
		
		if(ruleNum < 0 || ruleNum > 255) {
			throw new InvalidRuleNumException();
		}
		ruleInBinary = String.format("%8s", Integer.toBinaryString(ruleNum)).replace(' ', '0');
	}
	
	public int getNumSubrules() {
		return NUM_OF_SUBRULES;
	}
	
	public Cell[] getNeighborhood(int cellIdx, Generation gen, BoundaryConditions bc) {
		Cell[] neighborhood = new Cell[NEIGHBORHOOD_RADIUS];
		
		neighborhood[0] = bc.getNeighbor(cellIdx, -1, gen);
		neighborhood[1] = bc.getNeighbor(cellIdx, 0, gen);
		neighborhood[2] = bc.getNeighbor(cellIdx, 1, gen);
		
		return neighborhood;
		
	}
	
	public EvolvedCell evolve(Cell[] neighborhood) {
		EvolvedCell returnCell;
		int subrule = 0;
		char relevantBit;
		boolean[] neighborhoodAsBoolean = (new Generation(neighborhood)).getGenerationAsBooleanArray();
		
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
		
		relevantBit = ruleInBinary.charAt(ruleInBinary.length() - (subrule + 1));
		
		if(relevantBit == '1') {
			returnCell = new EvolvedCell(CellState.ON, subrule);
		}
		
		else {
			returnCell = new EvolvedCell(CellState.OFF, subrule);
		}
		
		return returnCell;
		
	}
	
	public String toString() {
		StringBuilder firstLine = new StringBuilder();
		
		for(CellState[] key : NEIGHBORHOOD_TO_SUBRULE.keySet()) {
			firstLine.append((new Generation(key)).toString());
		}
		
		StringBuilder secondLine = new StringBuilder();
		
		for(int i = NUM_OF_SUBRULES - 1; i >= 0; --i) {
			secondLine.append(" " + ruleInBinary.charAt(i) + " ");
		}
		
		StringBuilder returnString = firstLine.append("\n").append(secondLine);
		
		return returnString.toString();
	}
}
