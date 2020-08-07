import static org.junit.Assert.*;

import org.junit.Test;

public class GameOfLifeTest {

	@Test
	public void testGetNumSubrules() {
		
		GameOfLife game = new GameOfLife();
		
		assertEquals(game.getNumSubrules(), 3);
	}

	@Test
	public void testGetNeighborhood() {
		
		TwoDGeneration gen = new TwoDGeneration("OOO"
				+ "..."
				+ "OOO", 3, 3);
		
		GameOfLife game = new GameOfLife();
		
		BoundaryConditions cbc = new CircularBoundaryConditions();
		
		CellState[] neighborhoodOfCenterCell = {CellState.ON, CellState.ON, CellState.ON, CellState.OFF, CellState.OFF, CellState.ON, CellState.ON, CellState.ON, CellState.OFF};
		
		CellState[] neighborhoodOfBottomCenterCell = {CellState.OFF, CellState.OFF, CellState.OFF, CellState.ON, CellState.ON, CellState.ON, CellState.ON, CellState.ON, CellState.ON};
		
		
		assertEquals(neighborhoodOfCenterCell[2], game.getNeighborhood(1, 1, gen, cbc)[2].getState());
		assertEquals(neighborhoodOfCenterCell[8], (game.getNeighborhood(1, 1, gen, cbc))[8].getState());
		
		assertEquals(neighborhoodOfBottomCenterCell[5], game.getNeighborhood(2, 1, gen, cbc)[5].getState());
		assertEquals(neighborhoodOfBottomCenterCell[8], (game.getNeighborhood(2, 1, gen, cbc))[8].getState());
		
	}

	@Test
	public void testEvolveCellArray() {
		
		Cell onCell = new Cell(CellState.ON);
		Cell offCell = new Cell(CellState.OFF);
		
		GameOfLife game = new GameOfLife();
		
		Cell[] neighborhood0 = {onCell, offCell, offCell, onCell, onCell, onCell, offCell, onCell, offCell};
		
		Cell[] neighborhood1 = {onCell, offCell, offCell, onCell, onCell, onCell, offCell, onCell, onCell};
		
		Cell[] neighborhood2 = {offCell, offCell, offCell, onCell, offCell, onCell, offCell, onCell, offCell};
		
		Cell[] neighborhood3 = {onCell, offCell, offCell, offCell, offCell, offCell, offCell, onCell, onCell};
		
		
		
		assertEquals(game.evolve(neighborhood0).getState(), offCell.getState());
		assertEquals(game.evolve(neighborhood1).getState(), offCell.getState());
		assertEquals(game.evolve(neighborhood2).getState(), onCell.getState());
		assertEquals(game.evolve(neighborhood3).getState(), onCell.getState());
	}

	@Test
	public void testEvolveTwoDGenerationBoundaryConditions() {
		TwoDGeneration gen = new TwoDGeneration("..."
				+ "OOO"
				+ "...", 3, 3);
		
		GameOfLife game = new GameOfLife();
		
		BoundaryConditions fbc = new FixedBoundaryConditions(CellState.OFF, CellState.OFF, CellState.OFF, CellState.OFF);
		
		TwoDGeneration evolvedGen = new TwoDGeneration(".O."
				+ ".O."
				+ ".O.", 3, 3);
		
		assertEquals((game.evolve(gen, fbc)).toString(), evolvedGen.toString());
	}

}
