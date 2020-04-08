import java.util.List;
import java.util.ArrayList;

/**
 * This class is the actual Automaton that will implement almost all other classes
 * in the program
 * 
 * @author Arjun Ganesan
 * @version 1.0
 *
 */
public class Automaton {
	
	private Rule rule;
	//Lsit that will hold all Generations of the Automaton
	private List<Generation> generations = new ArrayList<Generation>();
	private BoundaryConditions bc;
	private int idxOfCurrentGen;
	
	/**
	 * 
	 * @param rule is the Rule that the Automaton will be following
	 * @param init is the initial Generation of the Automaton holding no EvolvedCells
	 * @param bc is the BoundaryConditions that the Automaton will be following
	 */
	public Automaton(Rule rule, Generation init, BoundaryConditions bc) {
		this.rule = rule;
		generations.add(init);
		this.bc = bc;
		//tracks the index of the current Generation in the generations list
		this.idxOfCurrentGen = 0;
	}
	
	/**
	 * 
	 * @return the Rule object the Automaton is following
	 */
	public Rule getRule() {
		return rule;
	}
	
	/**
	 * 
	 * @param stepNum the index of the generations list that needs to be accessed
	 * @return the Generation at the stepNum index
	 */
	public Generation getGeneration(int stepNum) {
		if(stepNum < 0) {
			throw new IllegalArgumentException();
		}
		return generations.get(stepNum);
	}
	
	/**
	 * 
	 * @return the BoundaryConditions object the Automaton is following
	 */
	public BoundaryConditions getBoundaryConditions() {
		return bc;
	}
	
	/**
	 * 
	 * @param numSteps the number of times the Automaton will evolve
	 */
	public void evolve(int numSteps) {
		//for loop iterates numSteps times
		for(int i = 0; i < numSteps; ++i) {
			//creates a new Generation using the evolve method of the Rule class
			Generation newGen = rule.evolve(this.getGeneration(idxOfCurrentGen), bc);
			//adds the new Generation to the generations list and updates the idxOfCurrentGen
			generations.add(newGen);
			++idxOfCurrentGen;
		}
	}
	
	/**
	 * 
	 * @return the number of times the Automaton has evolved
	 */
	public int getTotalSteps() {
		return (generations.size() - 1);
	}
	
	/**
	 * 
	 * @return the String representation of the most current Generation
	 */
	public String toString() {
		Generation currentGen = this.getGeneration(this.getTotalSteps());
		return currentGen.toString();
	}
	
	/**
	 * 
	 * @return the String representation of the entire evolution of the Automaton
	 */
	public String getHistory() {
		String returnString = "";
		//loop iterates over the number of Generations the Automaton has
		for(int i = 0; i < generations.size(); ++i) {
			//if the Generation is the last one, no newline character is added
			if (i == generations.size() - 1) {
				returnString += this.getGeneration(i).toString();
			}
			//otherwise, the toString of the Generation is called and a newline 
			//character is added to seperate the Generations
			else {
				returnString += this.getGeneration(i).toString() + "\n";
			}
		}
		return returnString;
	}
}
