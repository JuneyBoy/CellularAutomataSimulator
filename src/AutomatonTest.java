import static org.junit.Assert.*;

import org.junit.Test;

public class AutomatonTest {

	@Test
	public void testAutomaton() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRule()throws InvalidRuleNumException {
		Rule rule = new ElementaryRule(15);
		Generation init = new Generation("..O..");
		BoundaryConditions bc = new CircularBoundaryConditions();
		Automaton a = new Automaton(rule, init, bc);
		
		assertEquals(15, a.getRule().getRuleNum());
	}

	@Test
	public void testGetGeneration()throws InvalidRuleNumException {
		Rule rule = new ElementaryRule(15);
		Generation init = new Generation("..O..");
		BoundaryConditions bc = new CircularBoundaryConditions();
		Automaton a = new Automaton(rule, init, bc);
		
		Generation expected = new Generation("..O..");
		
		assertEquals(expected.toString(), a.getGeneration(0).toString());
	}

	@Test
	public void testGetBoundaryConditions()throws InvalidRuleNumException {
		Rule rule = new ElementaryRule(15);
		Generation init = new Generation("..O..");
		BoundaryConditions bc = new CircularBoundaryConditions();
		Automaton a = new Automaton(rule, init, bc);
		
		assertEquals(bc, a.getBoundaryConditions());
	}

	@Test
	public void testEvolve()throws InvalidRuleNumException {
		Generation init = new Generation(".O.O.O.");
		Rule elementaryRule = new ElementaryRule(60);
		Rule totalisticRule = new TotalisticRule(60);
		BoundaryConditions circularBC = new CircularBoundaryConditions();
		BoundaryConditions fixedBC = new FixedBoundaryConditions(CellState.OFF, CellState.ON);
		
		Automaton ercbc = new Automaton(elementaryRule, init, circularBC);
		ercbc.evolve(1);
		Generation expectedERCBC = new Generation(".OOOOOO");
		assertEquals(expectedERCBC.toString(), ercbc.getGeneration(1).toString());
		
		Automaton trcbc = new Automaton(totalisticRule, init, circularBC);
		trcbc.evolve(1);
		Generation expectedTRCBC = new Generation("OOOOOOO");
		assertEquals(expectedTRCBC.toString(), trcbc.getGeneration(1).toString());
		
		Automaton erfbc = new Automaton(elementaryRule, init, fixedBC);
		erfbc.evolve(1);
		Generation expectedERFBC = new Generation(".OOOOOO");
		assertEquals(expectedERFBC.toString(), erfbc.getGeneration(1).toString());
		
		Automaton trfbc = new Automaton(totalisticRule, init, fixedBC);
		trfbc.evolve(1);
		Generation expectedTRFBC = new Generation(".OOOOOO");
		assertEquals(expectedTRFBC.toString(), trfbc.getGeneration(1).toString());
	}

	@Test
	public void testGetTotalSteps()throws InvalidRuleNumException {
		Rule rule = new ElementaryRule(15);
		Generation init = new Generation("..O..");
		BoundaryConditions bc = new CircularBoundaryConditions();
		Automaton a = new Automaton(rule, init, bc);
		a.evolve(10);
		
		assertEquals(10, a.getTotalSteps());
	}

	@Test
	public void testToString()throws InvalidRuleNumException{
		Rule elementaryRule = new ElementaryRule(60);
		Generation init = new Generation("...O...");
		BoundaryConditions circularBC = new CircularBoundaryConditions();
		Automaton ercbc = new Automaton(elementaryRule, init, circularBC);
		ercbc.evolve(2);
		
		String expected = "...O.O.";
		
		assertEquals(expected, ercbc.toString());
	}

	@Test
	public void testGetHistory()throws InvalidRuleNumException {
		Rule elementaryRule = new ElementaryRule(60);
		Generation init = new Generation("...O...");
		BoundaryConditions circularBC = new CircularBoundaryConditions();
		Automaton ercbc = new Automaton(elementaryRule, init, circularBC);
		ercbc.evolve(2);
		
		String expected = ("...O..." + "\n").concat("...OO.." + "\n").concat("...O.O.");
		
		assertEquals(expected.toString(), ercbc.getHistory());
	}

}
