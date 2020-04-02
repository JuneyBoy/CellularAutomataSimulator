import static org.junit.Assert.*;

import org.junit.Test;

public class CellStateTest {

	@Test
	public void testGetState() {
		//tests default symbols for each state
		assertEquals(CellState.OFF, CellState.getState('.'));
		assertEquals(CellState.ON, CellState.getState('O'));
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
