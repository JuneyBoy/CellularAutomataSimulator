
public abstract class Rule {
	
	private int ruleNum;
	
	protected Rule(int ruleNum) {
		this.ruleNum = ruleNum;
	}
	
	public int getRuleNum() {
		return ruleNum;
	}
	
	public Generation evolve (Generation gen, BoundaryConditions bc) {
		Cell[] newGen = new Cell[gen.size()];
		
		for(int i = 0; i < newGen.length; ++i) {
			Cell[] neighborhood = this.getNeighborhood(i, gen, bc);
			newGen[i] = this.evolve(neighborhood);
		}
		return new Generation(newGen);
	}
	
	public abstract int getNumSubrules();
	
	public abstract Cell[] getNeighborhood(int cellIdx, Generation gen, BoundaryConditions bc);
	
	public abstract EvolvedCell evolve(Cell[] neighborhood);
	
	public abstract String toString();

}
