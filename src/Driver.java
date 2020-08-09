import java.io.IOException;



public class Driver {

	public static void main(String[] args)throws InvalidRuleNumException, InvalidStepNumException, IOException {
		Rule rule = new ElementaryRule(54);
		
		BoundaryConditions cbc = new CircularBoundaryConditions();
		Generation initGen;
		StringBuilder genAsString = new StringBuilder("");
		
	
		for(int i = 1; i <= 101; ++i) {
			if(i == 51) {
				genAsString.append('O');
			}
			else {
				genAsString.append(".");
			}
		}
		
		initGen = new Generation(genAsString.toString());
		
		Automaton a = new Automaton(rule, initGen, cbc);
		
		a.evolve(100);
		
		a.writeToFile("elementary54-100steps-circularbc.txt");
		
	}
}

