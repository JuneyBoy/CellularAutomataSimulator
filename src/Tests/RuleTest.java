import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class RuleTest {

	@Test (expected = InvalidRuleNumException.class)
	public void testRule()throws InvalidRuleNumException {
		Rule rule = new ElementaryRule(260);
	}

	@Test
	public void testGetRuleNum()throws InvalidRuleNumException {
		Rule eRule = new ElementaryRule(255);
		Rule tRule = new TotalisticRule(39);
		
		assertEquals(255, eRule.getRuleNum());
		assertEquals(39, tRule.getRuleNum());
	}

	@Test
	public void testEvolveGenerationBoundaryConditions()throws InvalidRuleNumException {
		Rule eRule = new ElementaryRule(22);
		Rule tRule = new TotalisticRule(22);
		BoundaryConditions circular = new CircularBoundaryConditions();
		BoundaryConditions fixed = new FixedBoundaryConditions(CellState.OFF, CellState.ON);
		Generation init = new Generation(".O.O.");
		
		Generation ecResult = eRule.evolve(init, circular);
		Generation efResult = eRule.evolve(init, fixed);
		
		Generation tcResult = tRule.evolve(init, circular);
		Generation tfResult = tRule.evolve(init, fixed);
		
		
		Generation ecExpected = new Generation("OO.OO");
		Generation efExpected = new Generation("OO.O.");
		
		Generation tcExpected = new Generation("OOOOO");
		Generation tfExpected = new Generation("OOO..");
		
		assertTrue(Arrays.equals(ecExpected.getGenerationAsBooleanArray(), ecResult.getGenerationAsBooleanArray()));
		assertTrue(Arrays.equals(efExpected.getGenerationAsBooleanArray(), efResult.getGenerationAsBooleanArray()));
		
		assertTrue(Arrays.equals(tcExpected.getGenerationAsBooleanArray(), tcResult.getGenerationAsBooleanArray()));
		assertTrue(Arrays.equals(tfExpected.getGenerationAsBooleanArray(), tfResult.getGenerationAsBooleanArray()));
		
	}

}
