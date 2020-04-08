import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class AutomatonMeasurementsTest {

	@Test
	public void testHammingDistanceGenerationGeneration() {
		Generation gen1 = new Generation("..O..");
		Generation gen2 = new Generation("O.O.O");
		int distance = AutomatonMeasurements.hammingDistance(gen1, gen2);
		
		assertEquals(2, distance);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testHammingDistanceGenerationGenerationError() {
		Generation gen1 = new Generation("..O..");
		Generation gen2 = new Generation(".O.O.O");
		int distance = AutomatonMeasurements.hammingDistance(gen1, gen2);
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
		
		assertTrue(Arrays.equals(expected, count));
	}

	@Test
	public void testSubruleCounts()throws InvalidRuleNumException {
		ElementaryRule rule = new ElementaryRule(54);
		BoundaryConditions bc = new CircularBoundaryConditions();
		Cell offCell = new Cell(CellState.OFF);
		Cell onCell = new Cell(CellState.ON);
		Cell[] init = {offCell, offCell, onCell, offCell, offCell};
		Generation initGen = new Generation(init);
		
		Automaton a = new Automaton(rule, initGen, bc);
		a.evolve(2);
		int[][] counts = AutomatonMeasurements.subruleCounts(a);
		
		int [] expectedArr1 = {2, 1, 1, 0, 1, 0, 0, 0};
		int [] expectedArr2 = {0, 1, 0, 1, 1, 0, 1, 1};
		
		assertTrue(Arrays.equals(expectedArr1, counts[0]));
		assertTrue(Arrays.equals(expectedArr2, counts[1]));
	}

}
