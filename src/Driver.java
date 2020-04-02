
public class Driver {

	public static void main(String[] args)throws InvalidRuleNumException {
		ElementaryRule rule = new ElementaryRule(1);
		BoundaryConditions bc = new CircularBoundaryConditions();
		Cell offCell = new Cell(CellState.OFF);
		Cell onCell = new Cell(CellState.ON);
		Cell[] init = {offCell, offCell, onCell, offCell, offCell};
		Generation initGen = new Generation(init);
		
		Automaton a = new Automaton(rule, initGen, bc);
		a.evolve(1);
		System.out.println(a.getHistory());
		
	}
}
