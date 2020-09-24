import static org.junit.Assert.*;

import org.junit.Test;

public class CellTest {

	@Test
	public void testGetState() {
		Cell defaultCell = new Cell();
		Cell offCell = new Cell(CellState.OFF);
		Cell onCell = new Cell(CellState.ON);
		
		assertEquals(CellState.OFF, defaultCell.getState());
		assertEquals(CellState.OFF, offCell.getState());
		assertEquals(CellState.ON, onCell.getState());
	}

	@Test
	public void testToString() {
		Cell offCell = new Cell(CellState.OFF);
		Cell onCell = new Cell(CellState.ON);
		
		assertEquals(".", offCell.toString());
		assertEquals("O", onCell.toString());
	}

}
