/**
 * This class is an abstract class that can be extended to create specific rules the Automaton will follow when evolving
 * @author Arjun Ganesan
 * @version
 *
 */
public abstract class Rule {
	//the one data member all Rule objects must have is the rule number
	private int ruleNum;
	
	protected Rule(int ruleNum) {
		this.ruleNum = ruleNum;
	}
	
	/**
	 * 
	 * @return the rule number
	 */
	public int getRuleNum() {
		return ruleNum;
	}
	
	/**
	 * This evolve method calls the other evolve method multiple times to return the resulting Generation of the Automaton after being evolved once
	 * @param gen is the Generation that is being evolved
	 * @param bc is the BoundaryCondition the Automaton is following
	 * @return the next Generation
	 */
	public Generation evolve (Generation gen, BoundaryConditions bc) {
		EvolvedCell[] newGen = new EvolvedCell[gen.size()];
		
		for(int i = 0; i < newGen.length; ++i) {
			Cell[] neighborhood = this.getNeighborhood(i, gen, bc);
			newGen[i] = this.evolve(neighborhood);
		}
		return new Generation(newGen);
	}
	
	/**
	 * 
	 * @return the number of subrules the Rule object has
	 */
	public abstract int getNumSubrules();
	
	/**
	 * 
	 * @param cellIdx the index of the Cell that is being evolved
	 * @param gen the Generation of the Cell that is being evolved
	 * @param bc the BoundaryCondition the Automaton is following
	 * @return the Cells that determine the state of the Cell at cellIdx in the next Generation
	 */
	public abstract Cell[] getNeighborhood(int cellIdx, Generation gen, BoundaryConditions bc);
	
	/**
	 * 
	 * @param neighborhood Cells that determine the state of the Cell at cellIdx in the next Generation
	 * @return the EvolvedCell object that is a result of the Rule
	 */
	public abstract EvolvedCell evolve(Cell[] neighborhood);
	
	public abstract String toString();

}
