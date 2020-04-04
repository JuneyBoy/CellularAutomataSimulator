import static org.junit.Assert.*;

import org.junit.Test;

public class EvolvedCellTest {

	@Test
	public void testEvolvedCell() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSubruleNum() {
		EvolvedCell eCell = new EvolvedCell(CellState.ON, 5);
		
		assertEquals(5, eCell.getSubruleNum());
	}

}
