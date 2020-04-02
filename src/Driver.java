
public class Driver {

	public static void main(String[] args) {
		ElementaryRule rule = new ElementaryRule(1);
		BoundaryConditions bc = new CircularBoundaryConditions();
		Cell offCell = new Cell(CellState.OFF);
		Cell onCell = new Cell(CellState.ON);
		Cell[] init = {offCell, onCell, offCell};
		Generation initGen = new Generation(init);
		
		Automaton a = new Automaton(rule, initGen, bc);
	}
}
