import java.io.IOException;



public class Driver {

	public static void main(String[] args)throws InvalidRuleNumException, InvalidStepNumException, IOException {
		
		Rule rule = new TotalisticRule(30);
		BoundaryConditions cbc = new CircularBoundaryConditions();
		
		/*
		BoundaryConditions fbc = new FixedBoundaryConditions(CellState.OFF, CellState.OFF, CellState.OFF, CellState.OFF);
		TwoDGeneration initGen;
		String genAsString = "..O.." + "..O.." + "..O..";
		
		initGen = new TwoDGeneration(genAsString, 3, 5);
		
		GameOfLife game = new GameOfLife();
		
		GOLAutomaton a = new GOLAutomaton(game, initGen, fbc);
		
		a.evolve(10);
		*/
		
		StringBuilder genAsString = new StringBuilder();
		
		
		for(int i = 1; i <= 101; ++i) {
			if(i == 51) {
				genAsString.append('O');
			}
			else {
				genAsString.append(".");
			}
		}
		
		Generation initGen = new Generation(genAsString.toString());
		
		Automaton a = new Automaton(rule, initGen, cbc);
		
		a.evolve(48);
		
		a.writeToFile("totalistic30-48steps-circularbc.txt");
		
		System.out.println(a.getHistory());
		
		
	}
}

