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
	}

}
