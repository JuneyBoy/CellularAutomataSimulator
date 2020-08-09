import java.io.IOException;



public class Driver {

	public static void main(String[] args)throws InvalidRuleNumException, InvalidStepNumException, IOException {
		
		//Rule rule = new ElementaryRule(54);
		
		BoundaryConditions fbc = new FixedBoundaryConditions(CellState.OFF, CellState.OFF, CellState.OFF, CellState.OFF);
		TwoDGeneration initGen;
		String genAsString = "..O.." + "..O.." + "..O..";
		
		initGen = new TwoDGeneration(genAsString, 3, 5);
		
		GameOfLife game = new GameOfLife();
		
		GOLAutomaton a = new GOLAutomaton(game, initGen, fbc);
		
		a.evolve(10);
		
		a.writeToFile("GOL Blinker.txt");
		
		
		/**
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
		**/
		
	}
}

