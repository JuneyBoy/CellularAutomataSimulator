import java.util.Arrays;

public class Driver {

	public static void main(String[] args)throws InvalidRuleNumException, InvalidStepNumException {
		Rule rule = new ElementaryRule(3);
		BoundaryConditions bc = new CircularBoundaryConditions();
		Generation initGen = new Generation("......O......");
		
		System.out.println(rule.toString());
		System.out.println();
		Automaton a = new Automaton(rule, initGen, bc);
		a.evolve(10);
		
		System.out.println(a.getHistory());
		System.out.println();
		System.out.println("Hamming Distances: " + Arrays.toString(AutomatonMeasurements.hammingDistances(a)));
		System.out.println("Subrule Counts: " + Arrays.deepToString(AutomatonMeasurements.subruleCounts(a)));
	}
}
