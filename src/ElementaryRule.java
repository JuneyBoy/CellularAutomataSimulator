import java.util.HashMap;

public class ElementaryRule extends Rule{
	
	private final int NUM_OF_SUBRULES = 8;
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
		Cell[] neighborhood = new Cell[3];
		
		if (cellIdx == 0) {
			neighborhood[0] = gen.getCell(gen.size() -1);
			neighborhood[1] = gen.getCell(cellIdx);
			neighborhood[2] = gen.getCell(cellIdx + 1);
		}
		
		else if (cellIdx == (gen.size() -1)) {
			neighborhood[0] = gen.getCell(gen.size() -1);
			neighborhood[1] = gen.getCell(cellIdx);
			neighborhood[2] = gen.getCell(0);
		}
		
		else {
			neighborhood[0] = gen.getCell(cellIdx - 1);
			neighborhood[1] = gen.getCell(cellIdx);
			neighborhood[2] = gen.getCell(cellIdx + 1);
		}
		return neighborhood;
		
	}
	
	public EvolvedCell evolve(Cell[] neighborhood) {
		EvolvedCell returnCell;
		int subrule = NEIGHBORHOOD_TO_SUBRULE.get(neighborhood);
		char relevantBit = ruleInBinary.charAt(subrule);
		
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
