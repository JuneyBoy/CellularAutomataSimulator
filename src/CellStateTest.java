import static org.junit.Assert.*;

import org.junit.Test;

public class CellStateTest {

	@Test
	public void testGetState() {
		assertEquals(CellState.OFF, CellState.getState('.'));
		assertEquals(CellState.ON, CellState.getState('O'));
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
