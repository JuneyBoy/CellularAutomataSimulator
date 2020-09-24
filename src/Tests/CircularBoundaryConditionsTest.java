import static org.junit.Assert.*;

import org.junit.Test;

public class CircularBoundaryConditionsTest {

	@Test
	public void testGetNeighbor() {
		CircularBoundaryConditions bc = new CircularBoundaryConditions();
		Generation gen = new Generation("O.O..");
		Cell leftEdgeTest = bc.getNeighbor(0, -1, gen);
		Cell normalTest = bc.getNeighbor(2, 2, gen);
		Cell rightEdgeTest = bc.getNeighbor(4, 1, gen);
		
		assertEquals(CellState.OFF, leftEdgeTest.getState());
		assertEquals(CellState.OFF, normalTest.getState());
		assertEquals(CellState.ON, rightEdgeTest.getState());
		
		Cell leftReallyEdgeTest = bc.getNeighbor(0, -5, gen);
		Cell rightReallyEdgeTest = bc.getNeighbor(4, 6, gen);
		
		assertEquals(CellState.ON, leftReallyEdgeTest.getState());
		assertEquals(CellState.ON, rightReallyEdgeTest.getState());
	}
	
	@Test
	public void testGetNeighbor2D() {
		CircularBoundaryConditions bc = new CircularBoundaryConditions();
		TwoDGeneration gen = new TwoDGeneration("O.O" + ".O." + "..O", 3, 3);
		
		Cell bottomEdgeTest = bc.getNeighbor(2, 1, 1, 0, gen);
		Cell leftEdgeTest = bc.getNeighbor(1, 0, 0, -1, gen);
		Cell normalTest = bc.getNeighbor(1, 1, -1, -1, gen);
		Cell rightEdgeTest = bc.getNeighbor(0, 2, 0, 1, gen);
		Cell topEdgeTest = bc.getNeighbor(0, 1, -1, 0, gen);
		Cell topRightEdgeTest = bc.getNeighbor(0, 0, -1, -1, gen);
		
		assertEquals(CellState.OFF, bottomEdgeTest.getState());
		assertEquals(CellState.OFF, leftEdgeTest.getState());
		assertEquals(CellState.ON, normalTest.getState());
		assertEquals(CellState.ON, rightEdgeTest.getState());
		assertEquals(CellState.OFF, topEdgeTest.getState());
		assertEquals(CellState.ON, topRightEdgeTest.getState());
	}

}
