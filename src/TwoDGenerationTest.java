import static org.junit.Assert.*;

import org.junit.Test;

public class TwoDGenerationTest {

	@Test
	public void testTwoDGenerationCellStateArrayArray() {
		CellState[][] cells = { {CellState.OFF, CellState.ON}, {CellState.ON, CellState.OFF} };
		TwoDGeneration gen = new TwoDGeneration(cells);
		
		assertEquals(CellState.OFF, gen.getCell(0, 0).getState());
		assertEquals(CellState.ON, gen.getCell(0, 1).getState());
		assertEquals(CellState.ON, gen.getCell(1, 0).getState());
		assertEquals(CellState.OFF, gen.getCell(1, 1).getState());
	}

	@Test
	public void testTwoDGenerationStringIntInt() {
		String cells = ".O"
				+ "O.";
		TwoDGeneration gen = new TwoDGeneration(cells, 2, 2);
		
		assertEquals(CellState.OFF, gen.getCell(0, 0).getState());
		assertEquals(CellState.ON, gen.getCell(0, 1).getState());
		assertEquals(CellState.ON, gen.getCell(1, 0).getState());
		assertEquals(CellState.OFF, gen.getCell(1, 1).getState());
		
	}

	@Test
	public void testTwoDGenerationCellArrayArray() {
		Cell[][] cells = {{new Cell(CellState.ON), new Cell(CellState.ON)}, {new Cell(CellState.OFF), new Cell(CellState.OFF)}};
		TwoDGeneration gen = new TwoDGeneration(cells);
		
		assertEquals(CellState.ON, gen.getCell(0, 0).getState());
		assertEquals(CellState.ON, gen.getCell(0, 1).getState());
		assertEquals(CellState.OFF, gen.getCell(1, 0).getState());
		assertEquals(CellState.OFF, gen.getCell(1, 1).getState());
		
	}

	@Test
	public void testNumOfRows() {
		CellState[][] cells = { {CellState.OFF, CellState.ON, CellState.ON}, {CellState.ON, CellState.OFF, CellState.OFF} };
		
		TwoDGeneration gen = new TwoDGeneration(cells);
		
		assertEquals(2, gen.numOfRows());
		
	}

	@Test
	public void testNumOfCols() {
		CellState[][] cells = { {CellState.OFF, CellState.ON, CellState.ON}, {CellState.ON, CellState.OFF, CellState.ON} };
		
		TwoDGeneration gen = new TwoDGeneration(cells);
		
		assertEquals(3, gen.numOfCols());
	}

	@Test
	public void testSize() {
		CellState[][] cells = { {CellState.OFF, CellState.ON, CellState.ON}, {CellState.ON, CellState.OFF, CellState.ON} };
		
		TwoDGeneration gen = new TwoDGeneration(cells);
		
		assertEquals(6, gen.size());
	}

	@Test
	public void testGetCell() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		CellState[][] cells = { {CellState.OFF, CellState.ON, CellState.ON}, {CellState.ON, CellState.OFF, CellState.OFF}, {CellState.OFF, CellState.OFF, CellState.OFF}  };
		TwoDGeneration gen = new TwoDGeneration(cells);
		
		String expectedString = ".OO/n" + "O../n" + ".../n";
		
		assertEquals(expectedString, gen.toString());
		
	}

}
