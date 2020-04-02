import java.util.List;
import java.util.ArrayList;

public class Automaton {
	
	private Rule rule;
	private List<Generation> generations = new ArrayList<Generation>();
	private BoundaryConditions bc;
	private int idxOfCurrentGen;
	
	public Automaton(Rule rule, Generation init, BoundaryConditions bc) {
		this.rule = rule;
		generations.add(init);
		this.bc = bc;
		this.idxOfCurrentGen = 0;
	}
	
	public Rule getRule() {
		return rule;
	}
	
	public Generation getGeneration(int stepNum) {
		return generations.get(stepNum);
	}
	
	public BoundaryConditions getBoundaryConditions() {
		return bc;
	}
	
	public void evolve(int numSteps) {
		
		for(int i = 0; i < numSteps; ++i) {
			Generation newGen = rule.evolve(this.getGeneration(idxOfCurrentGen), bc);
			generations.add(newGen);
			++idxOfCurrentGen;
		}
	}
	
	public int getTotalSteps() {
		return (generations.size() - 1);
	}
	
	public String toString() {
		Generation currentGen = this.getGeneration(this.getTotalSteps());
		return currentGen.toString();
	}
	
	public String getHistory() {
		String returnString = "";
		for(int i = 0; i < generations.size(); ++i) {
			if (i == generations.size()) {
				returnString += this.getGeneration(i).toString();
			}
			else {
				returnString += this.getGeneration(i).toString() + "\n";
			}
		}
		return returnString;
	}
}
