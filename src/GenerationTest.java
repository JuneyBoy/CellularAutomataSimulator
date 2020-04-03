import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class GenerationTest {

	@Test
	public void testGenerationCellStateArray() {
		CellState[] cells = {CellState.OFF, CellState.ON, CellState.OFF};
		Generation gen = new Generation(cells);
		
		assertEquals(CellState.OFF, gen.getCell(0).getState());
		assertEquals(CellState.ON, gen.getCell(1).getState());
		assertEquals(CellState.OFF, gen.getCell(2).getState());
	}

	@Test
	public void testGenerationString() {
		String cells = ".O.";
		Generation gen = new Generation(cells);
		
		assertEquals(CellState.OFF, gen.getCell(0).getState());
		assertEquals(CellState.ON, gen.getCell(1).getState());
		assertEquals(CellState.OFF, gen.getCell(2).getState());
	}

	@Test
	public void testGenerationCellArray() {
		Cell offCell = new Cell(CellState.OFF);
		Cell onCell = new Cell(CellState.ON);
		Cell[] cells = {offCell, onCell, offCell};
		Generation gen = new Generation(cells);
		
		assertEquals(offCell, gen.getCell(0));
		assertEquals(onCell, gen.getCell(1));
		assertEquals(offCell, gen.getCell(2));
	}

	@Test
	public void testSize() {
		Cell offCell = new Cell(CellState.OFF);
		Cell onCell = new Cell(CellState.ON);
		Cell[] cells = {offCell, onCell, offCell};
		Generation gen = new Generation(cells);
		assertEquals(3, gen.size());
	}

	@Test
	//not sure if it is necessary to test this separately as I call it in almost all of the constructor tests
	public void testGetCell() {
	}

	@Test
	public void testGetGenerationAsBooleanArray() {
		Cell offCell = new Cell(CellState.OFF);
		Cell onCell = new Cell(CellState.ON);
		Cell[] cells = {offCell, onCell, offCell};
		Generation gen = new Generation(cells);
		boolean[] booleanArr = gen.getGenerationAsBooleanArray();
		boolean[] expectedArr = {false, true, false};
		
		assertTrue(Arrays.equals(expectedArr, booleanArr));
	}

	@Test
	public void testToString() {
		Cell offCell = new Cell(CellState.OFF);
		Cell onCell = new Cell(CellState.ON);
		Cell[] cells = {offCell, onCell, offCell};
		Generation gen = new Generation(cells);
		String expectedString = ".O.";
		
		assertEquals(expectedString, gen.toString());
	}

}
