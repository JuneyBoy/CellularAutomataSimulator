import java.util.Arrays;

public class Driver {

	public static void main(String[] args)throws InvalidRuleNumException {
		ElementaryRule rule = new ElementaryRule(54);
		BoundaryConditions bc = new CircularBoundaryConditions();
		Cell offCell = new Cell(CellState.OFF);
		Cell onCell = new Cell(CellState.ON);
		Cell[] init = {offCell, offCell, offCell, offCell, offCell, onCell, offCell, offCell, offCell, offCell, offCell};
		Generation initGen = new Generation(init);
		
		System.out.println(rule.toString());
		System.out.println();
		Automaton a = new Automaton(rule, initGen, bc);
		a.evolve(2);
		System.out.println(a.getHistory());
		//System.out.println(Arrays.toString(AutomatonMeasurements.hammingDistances(a)));
	}
}
