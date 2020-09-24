import static org.junit.Assert.*;

import org.junit.Test;

public class FixedBoundaryConditionsTest {

	@Test
	public void testGetLeftState() {
		FixedBoundaryConditions bc = new FixedBoundaryConditions(CellState.OFF, CellState.ON);
		
		assertEquals(CellState.OFF, bc.getLeftState());
	}

	@Test
	public void testGetRightState() {
		FixedBoundaryConditions bc = new FixedBoundaryConditions(CellState.OFF, CellState.ON);
		
		assertEquals(CellState.ON, bc.getRightState());
	}

	@Test
	public void testGetNeighbor() {
		FixedBoundaryConditions bc = new FixedBoundaryConditions(CellState.OFF, CellState.ON);
		Generation gen = new Generation("..O..");
		Cell leftEdgeTest = bc.getNeighbor(0, -1, gen);
		Cell normalTest = bc.getNeighbor(2, 1, gen);
		Cell rightEdgeTest = bc.getNeighbor(4, 1, gen);
		
		assertEquals(CellState.OFF, leftEdgeTest.getState());
		assertEquals(CellState.OFF, normalTest.getState());
		assertEquals(CellState.ON, rightEdgeTest.getState());
	}

}
