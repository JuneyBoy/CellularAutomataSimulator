
public class AutomatonMeasurements {
	
	public static int hammingDistance(Generation g1, Generation g2) throws IllegalArgumentException {
		int runningCount = 0;
		
		if(g1.size() != g2.size()) {
			throw new IllegalArgumentException();
		}
		
		for(int i = 0; i < g1.size(); ++i) {
			if(g1.getCell(i).getState() != g2.getCell(i).getState()) {
				++runningCount;
			}
		}
		
		return runningCount;
	}
	
	public static int hammingDistance(int stepNum, Automaton a) {
		Generation g1 = a.getGeneration(stepNum - 1);
		Generation g2 = a.getGeneration(stepNum + 1);
		
		return hammingDistance(g1, g2);
	}
	
	public static int[] hammingDistances(Automaton a) {
		int[] distancesArray = new int[a.getTotalSteps()];
		int counter = 0;
		for(int i : distancesArray) {
			Generation g1 = a.getGeneration(counter);
			Generation g2 = a.getGeneration(counter + 1);
			distancesArray[counter] = hammingDistance(g1, g2);
			++counter;
		}
		return distancesArray;
	}
	
	public static int[] subruleCount(int stepNum, Automaton a) {
		int[] subruleCountArray = new int[a.getRule().getNumSubrules()];
		
		for(int i = 0; i < subruleCountArray.length; ++i){
			
			int subruleCounter = 0;
			Generation workingGen = a.getGeneration(stepNum);
			
			for(int j = 0; j < workingGen.size(); ++j) {
				EvolvedCell currentCell = workingGen.getCell(j);
				if(i == currentCell.getSubruleNum()) {
					++subruleCounter;
				}
			}
			subruleCountArray[i] = subruleCounter;
		}
	}
	
	public static int[][] subruleCounts(Automaton a) {
		int[][] subruleCountsArray = new int[a.getTotalSteps()][a.getRule().getNumSubrules()];
		int idxCounter = 0;
		
		for(int i = 0; i < subruleCountsArray.length; ++i) {
			subruleCountsArray[i] = subruleCount((i + 1), a);
		}
		
		return subruleCountsArray;
		
	}
	

}
