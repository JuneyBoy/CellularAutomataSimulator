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
	
	@Test (expected = IllegalArgumentException.class)
	public void testGenerationStringError()throws IllegalArgumentException {
		String cells = ".0.";
		Generation gen = new Generation(cells);
	}

	@Test
	public void testGenerationCellArray() {
		Cell offCell = new Cell(CellState.OFF);
		Cell onCell = new Cell(CellState.ON);
		Cell[] cells = {offCell, onCell, offCell};
		Generation gen = new Generation(cells);
		
		EvolvedCell evOffCell = new EvolvedCell(CellState.OFF, 3);
		EvolvedCell evOnCell = new EvolvedCell(CellState.ON, 3);
		Cell[] evCells = {evOffCell, evOnCell, evOffCell};
		Generation evCellGen = new Generation(evCells);
		
		
		assertEquals(offCell, gen.getCell(0));
		assertEquals(onCell, gen.getCell(1));
		assertEquals(offCell, gen.getCell(2));
		
		assertEquals(evOffCell, evCellGen.getCell(0));
		assertEquals(evOnCell, evCellGen.getCell(1));
		assertEquals(evOffCell, evCellGen.getCell(2));
		
		assertEquals(evOffCell, evCellGen.getCell(0));
		assertEquals(evOnCell, evCellGen.getCell(1));
		assertEquals(evOffCell, evCellGen.getCell(2));
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
