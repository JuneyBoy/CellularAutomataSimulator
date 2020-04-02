
public class Driver {

	public static void main(String[] args)throws InvalidRuleNumException {
		TotalisticRule rule = new TotalisticRule(22);
		BoundaryConditions bc = new CircularBoundaryConditions();
		Cell offCell = new Cell(CellState.OFF);
		Cell onCell = new Cell(CellState.ON);
		Cell[] init = {offCell, offCell, offCell, onCell, onCell, onCell, onCell, onCell, offCell, offCell, offCell};
		Generation initGen = new Generation(init);
		
		Automaton a = new Automaton(rule, initGen, bc);
		a.evolve(1);
		System.out.println(a.getHistory());
	}
}
