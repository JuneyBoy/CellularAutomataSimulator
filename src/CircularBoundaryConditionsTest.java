import static org.junit.Assert.*;

import org.junit.Test;

public class CircularBoundaryConditionsTest {

	@Test
	public void testGetNeighbor() {
		CircularBoundaryConditions bc = new CircularBoundaryConditions();
		Generation gen = new Generation("..O..");
		Cell leftNeighbor = bc.getNeighbor(2, -1, gen);
		Cell centerCell = bc.getNeighbor(2, 0, gen);
		Cell rightNeighbor = bc.getNeighbor(2, 1, gen);
		
		assertEquals(CellState.OFF, leftNeighbor.getState());
		assertEquals(CellState.ON, centerCell.getState());
		assertEquals(CellState.OFF, rightNeighbor.getState());
	}

}
