import static org.junit.Assert.*;

import org.junit.Test;

public class AutomatonMeasurementsTest {

	@Test
	public void testHammingDistanceGenerationGeneration() {
		Generation gen1 = new Generation("..O..");
		Generation gen2 = new Generation("O.O.O");
		int distance = AutomatonMeasurements.hammingDistance(gen1, gen2);
		
		assertEquals(2, distance);
	}

	@Test
	public void testHammingDistanceIntAutomaton()throws InvalidRuleNumException {
		ElementaryRule rule = new ElementaryRule(54);
		BoundaryConditions bc = new CircularBoundaryConditions();
		Cell offCell = new Cell(CellState.OFF);
		Cell onCell = new Cell(CellState.ON);
		Cell[] init = {offCell, offCell, offCell, offCell, offCell, onCell, offCell, offCell, offCell, offCell, offCell};
		Generation initGen = new Generation(init);
		
		Automaton a = new Automaton(rule, initGen, bc);
		a.evolve(3);
		
		int distance = AutomatonMeasurements.hammingDistance(2, a);
		
		assertEquals(5, distance);
	}

	@Test
	public void testHammingDistances()throws InvalidRuleNumException {
		ElementaryRule rule = new ElementaryRule(54);
		BoundaryConditions bc = new CircularBoundaryConditions();
		Cell offCell = new Cell(CellState.OFF);
		Cell onCell = new Cell(CellState.ON);
		Cell[] init = {offCell, offCell, offCell, offCell, offCell, onCell, offCell, offCell, offCell, offCell, offCell};
		Generation initGen = new Generation(init);
		
		Automaton a = new Automaton(rule, initGen, bc);
		a.evolve(3);
		
		int[] distances = AutomatonMeasurements.hammingDistances(a);
		int[] expected = {2, 5, 4};
		
		assertEquals(expected[0], distances[0]);
		assertEquals(expected[1], distances[1]);
		assertEquals(expected[2], distances[2]);
	}

	@Test
	public void testSubruleCount()throws InvalidRuleNumException {
		ElementaryRule rule = new ElementaryRule(54);
		BoundaryConditions bc = new CircularBoundaryConditions();
		Cell offCell = new Cell(CellState.OFF);
		Cell onCell = new Cell(CellState.ON);
		Cell[] init = {offCell, offCell, offCell, offCell, offCell, onCell, offCell, offCell, offCell, offCell, offCell};
		Generation initGen = new Generation(init);
		
		Automaton a = new Automaton(rule, initGen, bc);
		a.evolve(3);
		int[] count = AutomatonMeasurements.subruleCount(2, a);
		
		int[] expected = {6, 1, 0, 1, 1, 0, 1, 1};
		
		assertEquals(expected[0], count[0]);
		assertEquals(expected[1], count[1]);
		assertEquals(expected[2], count[2]);
		assertEquals(expected[3], count[3]);
		assertEquals(expected[4], count[4]);
		assertEquals(expected[5], count[5]);
		assertEquals(expected[6], count[6]);
		assertEquals(expected[7], count[7]);
	}

	@Test
	public void testSubruleCounts() {
		fail("Not yet implemented");
	}

}
