import static org.junit.Assert.*;

import org.junit.Test;

public class TotalisticRuleTest {

	@Test
	public void testTotalisticRule() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetNumSubrules()throws InvalidRuleNumException {
		Rule rule = new TotalisticRule(22);
		
		assertEquals(6, rule.getNumSubrules());
	}

	@Test
	public void testGetNeighborhood()throws InvalidRuleNumException {
		Rule rule = new TotalisticRule(22);
		BoundaryConditions circularBC = new CircularBoundaryConditions();
		BoundaryConditions fixedBC = new FixedBoundaryConditions(CellState.ON, CellState.ON);
		Generation gen = new Generation("...O...");
		
		Cell[] circularNeighborhood = rule.getNeighborhood(0, gen, circularBC);
		Cell[] fixedNeighborhood = rule.getNeighborhood(0, gen, fixedBC);
		
		assertEquals(CellState.OFF, circularNeighborhood[0].getState());
		assertEquals(CellState.ON, fixedNeighborhood[0].getState());
	}

	@Test
	public void testEvolveCellArray()throws InvalidRuleNumException {
		Rule rule = new TotalisticRule(22);
		BoundaryConditions circularBC = new CircularBoundaryConditions();
		BoundaryConditions fixedBC = new FixedBoundaryConditions(CellState.ON, CellState.ON);
		Generation gen = new Generation("..O..");
		
		Cell[] circularNeighborhood = rule.getNeighborhood(0, gen, circularBC);
		Cell[] fixedNeighborhood = rule.getNeighborhood(0, gen, fixedBC);
		
		EvolvedCell circularCell = rule.evolve(circularNeighborhood);
		EvolvedCell fixedCell = rule.evolve(fixedNeighborhood);
		
		EvolvedCell test1 = new EvolvedCell(CellState.ON, 1);
		EvolvedCell test2 = new EvolvedCell(CellState.OFF, 3);
		
		assertEquals(test1.getState(), circularCell.getState());
		assertEquals(test1.getSubruleNum(), circularCell.getSubruleNum());
		assertEquals(test2.getState(), fixedCell.getState());
		assertEquals(test2.getSubruleNum(), fixedCell.getSubruleNum());
	}

	@Test
	public void testToString()throws InvalidRuleNumException {
		Rule rule = new TotalisticRule(22);
		StringBuilder firstLine = new StringBuilder("5 4 3 2 1 0");
		StringBuilder secondLine = new StringBuilder(". O . O O .");
		StringBuilder expected = firstLine.append("\n").append(secondLine);
		
		assertEquals(expected.toString(), rule.toString());
	}
}
