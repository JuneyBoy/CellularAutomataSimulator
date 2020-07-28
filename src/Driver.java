import java.io.IOException;



public class Driver {

	public static void main(String[] args)throws InvalidRuleNumException, InvalidStepNumException, IOException {
		Rule rule = new ElementaryRule(55);
		Rule rule2 = new TotalisticRule(10);
		BoundaryConditions cbc = new CircularBoundaryConditions();
		BoundaryConditions fbc = new FixedBoundaryConditions(CellState.OFF, CellState.OFF);
		Generation initGen;
		StringBuilder genAsString = new StringBuilder("");
		
		System.out.println(rule.toString());
		
	
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
		
		a.evolve(20);
		
		System.out.println(a.getHistory());
		
	}
}

