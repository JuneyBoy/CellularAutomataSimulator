import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class Driver {

	public static void main(String[] args)throws InvalidRuleNumException, InvalidStepNumException, IOException {
		Rule rule = new ElementaryRule(161);
		BoundaryConditions cbc = new CircularBoundaryConditions();
		BoundaryConditions fbc = new FixedBoundaryConditions(CellState.OFF, CellState.OFF);
		Generation initGen;
		StringBuilder genAsString = new StringBuilder("");
		
		for(int i = 1; i <= 101; ++i) {
			if(i == 50) {
				genAsString.append('O');
			}
			else {
				genAsString.append(".");
			}
		}
		
		initGen = new Generation(genAsString.toString());
		
		Automaton circularBoundaryAutomaton = new Automaton(rule, initGen, cbc);
		Automaton fixedBoundaryAutomaton = new Automaton(rule, initGen, fbc);
		
		circularBoundaryAutomaton.evolve(100);
		fixedBoundaryAutomaton.evolve(100);
		
		
		BufferedWriter writer1 = new BufferedWriter(new FileWriter("elementary32-100steps-circularbc.txt"));
		BufferedWriter writer2 = new BufferedWriter(new FileWriter("elementary32-100steps-fixedbc-off-off.txt"));
		
		BufferedWriter writer3 = new BufferedWriter(new FileWriter("hamming-elementary161-circularbc.txt"));
		BufferedWriter writer4 = new BufferedWriter(new FileWriter("hamming-elementary161-fixedbc-off-off.txt"));
		
		BufferedWriter writer5 = new BufferedWriter(new FileWriter("subrules-elementary161-circularbc.csv"));
		
		writer1.write(circularBoundaryAutomaton.getHistory());
		writer1.close();
		writer2.write(fixedBoundaryAutomaton.getHistory());
		writer2.close();
		
		int[] a1HDs = AutomatonMeasurements.hammingDistances(circularBoundaryAutomaton);
		int[] a2HDs = AutomatonMeasurements.hammingDistances(fixedBoundaryAutomaton);
		
		for(int i = 0; i < a1HDs.length; ++i) {
			writer3.write(a1HDs[i] + "\n");
			writer4.write(a2HDs[i] + "\n");
		}
		writer3.close();
		writer4.close();
		
		
		int[][] subrules = AutomatonMeasurements.subruleCounts(circularBoundaryAutomaton);
		
		for(int i = 0; i < subrules.length; ++ i) {
			int[] genArray = subrules[i];
			
			for(int j = 0; j < subrules[i].length - 1; ++j) {
				writer5.write(genArray[j] + ",");
			}
			writer5.write(genArray[subrules[i].length - 1] + "\n");
		}
		writer5.close();
	}
}

