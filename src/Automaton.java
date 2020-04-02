import java.util.List;

public class Automaton {
	
	private Rule rule;
	private List<Generation> generations;
	private BoundaryConditions bc;
	
	public Automaton(Rule rule, Generation init, BoundaryConditions bc) {
		this.rule = rule;
		generations.add(init);
		this.bc = bc;
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
			Generation newGen = rule.evolve(this.getGeneration(this.getTotalSteps() - 1), bc);
			generations.add(newGen);
		}
	}
	
	public int getTotalSteps() {
		return generations.size();
	}
	
	public String toString() {
		Generation currentGen = this.getGeneration(this.getTotalSteps() - 1);
		return currentGen.toString();
	}
	
	public String getHistory() {
		String returnString = "";
		for(int i = 0; i <= generations.size(); ++i) {
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
