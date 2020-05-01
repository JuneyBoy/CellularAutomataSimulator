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
	public static int hammingDistance(int stepNum, Automaton a)throws InvalidStepNumException {
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
	public static int[] hammingDistances(Automaton a)throws InvalidStepNumException {
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
	public static int[] subruleCount(int stepNum, Automaton a)throws InvalidStepNumException {
		//creates array that is the same length as the number of subrules the Rule a is following has
		
		Rule rule = a.getRule();
		int[] subruleCountArray = new int[rule.getNumSubrules()];
		Generation gen = a.getGeneration(stepNum);
		
		
		//outer for loop iterates over each subrule
		for(int i = 0; i < subruleCountArray.length; ++i) {
			//counter keeps track of instances of current subrule used to evolve Cells in Generation
			int subruleCount = 0;
			
			//outer for loop iterates over each Cell in the Generation
			for(int j = 0; j < gen.size(); ++j) {
				//checks if subrule associated with current EvolvedCell is the same as the subrule being tracked by outer for loop
				if(((EvolvedCell)gen.getCell(j)).getSubruleNum() == i) {
					//increments counter if so
					++subruleCount;
					
				}
			}
			//stores count in appriopriate array index
			subruleCountArray[i] = subruleCount;
		}
		
		return subruleCountArray;
	}
	
	/**
	 * 
	 * @param a the Automaton
	 * @return a 2D array that holds a subruleCount array for every Generation of a
	 */
	public static int[][] subruleCounts(Automaton a)throws InvalidStepNumException {
		int[][] subruleCountsArray = new int[a.getTotalSteps()][a.getRule().getNumSubrules()];
		
		//iterates over the number of Generations in a, but does not include the initial Generation
		//as it did not evolve from anything
		for(int i = 0; i < subruleCountsArray.length; ++i) {
			subruleCountsArray[i] = subruleCount((i + 1), a);
		}
		
		return subruleCountsArray;
		
	}
	

}
