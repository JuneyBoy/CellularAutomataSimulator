/**
 * This class shouldn't be instantiated, but rather its static methods can be called to 
 * get some information about an Automaton
 * 
 * @author Arjun Ganesan
 * @version 1.0
 * 
 */
public class AutomatonMeasurements {
	
	/**
	 * 
	 * @param g1 first Generation to be compared
	 * @param g2 second Generation to be compared
	 * @return the number of Cells that would need to be changed for the two Generations to become identical
	 * @throws IllegalArgumentException if the size of the Generations is not the same
	 */
	public static int hammingDistance(Generation g1, Generation g2) throws IllegalArgumentException {
		int runningCount = 0;
		
		if(g1.size() != g2.size()) {
			throw new IllegalArgumentException();
		}
		//compares the states of the Cells each index of the Generations and increments
		//runningCount if the states are not the same
		for(int i = 0; i < g1.size(); ++i) {
			if(g1.getCell(i).getState() != g2.getCell(i).getState()) {
				++runningCount;
			}
		}
		
		return runningCount;
	}
	
	/**
	 * 
	 * @param stepNum the index of a Generation in the Automaton
	 * @param a the Automaton
	 * @return the number of Cells that would need to be changed for the two Generations to become identical.
	 */
	public static int hammingDistance(int stepNum, Automaton a) {
		//gets the 2 Generations before and after the stepNum index to compare 
		Generation g1 = a.getGeneration(stepNum - 1);
		Generation g2 = a.getGeneration(stepNum + 1);
		//calls the first hammingDistances method
		return hammingDistance(g1, g2);
	}
	
	/**
	 * 
	 * @param a the Automaton
	 * @return an array if ints that holds the hamming distances between each subsequent Generation in the Automaton
	 */
	public static int[] hammingDistances(Automaton a) {
		//creates an array that has a length of the number of Generations in a - 1
		int[] distancesArray = new int[a.getTotalSteps()];
		int counter = 0;
		//loop iterates over the size of the array
		for(int i : distancesArray) {
			//gets the the two subsequent Generations and calculates the hamming distances
			//between them and stores it into the array
			Generation g1 = a.getGeneration(counter);
			Generation g2 = a.getGeneration(counter + 1);
			distancesArray[counter] = hammingDistance(g1, g2);
			++counter;
		}
		return distancesArray;
	}
	
	/**
	 * 
	 * @param stepNum the index of a Generation in the Automaton
	 * @param a the Automaton
	 * @return an array of ints that holds the number of times each subrule was used in creating the Generation at stepNum
	 */
	public static int[] subruleCount(int stepNum, Automaton a) {
		//creates array that is the same length as the number of subrules the Rule a is following has
		Rule rule = a.getRule();
		int[] subruleCountArray = new int[rule.getNumSubrules()];
		
		//what follows is me essentially recreating the evolution method in the Rule class because I'm unsure how to access EvolvedCells
		//in a Generation because the getCell method in Generation can only access Cell objects
		
		BoundaryConditions bc = a.getBoundaryConditions();
		//gets the Generation right before the one at the stepNum index
		Generation workingGen = a.getGeneration(stepNum - 1);
		EvolvedCell[] cells = new EvolvedCell[workingGen.size()];
		
		//basically recreates the Generation at stepNum but is explicitly an EvolvedCell array
		for(int i = 0; i < workingGen.size(); ++i) {
			Cell[] neighborhood = rule.getNeighborhood(i, workingGen, bc);
			cells[i] = rule.evolve(neighborhood);
		}
		
		//once the array is created this outer for loop iterates over the number of subrules there are
		for(int j = 0; j < subruleCountArray.length; ++j) {
			//keeps track of how many Cells were evolved using the subrule j
			int subruleCount = 0;
			
			//inner for loop iterates over the length of the Generation
			for(int k = 0; k < cells.length; ++k) {
				//if the subrule of the EvolvedCell == j, then subRuleCount is incremented
				if(j == cells[k].getSubruleNum()) {
					++subruleCount;
				}
			}
			//subruleCount is stored in the array
			subruleCountArray[j] = subruleCount;
		}
		return subruleCountArray;
	}
	
	/**
	 * 
	 * @param a the Automaton
	 * @return a 2D array that holds a subruleCount array for every Generation of a
	 */
	public static int[][] subruleCounts(Automaton a) {
		int[][] subruleCountsArray = new int[a.getTotalSteps()][a.getRule().getNumSubrules()];
		
		//iterates over the number of Generations in a, but does not include the initial Generation
		//as it did not evolve from anything
		for(int i = 0; i < subruleCountsArray.length; ++i) {
			subruleCountsArray[i] = subruleCount((i + 1), a);
		}
		
		return subruleCountsArray;
		
	}
	

}
