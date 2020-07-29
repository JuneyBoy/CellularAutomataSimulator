/**
 * The CircularBoundary condition basically wraps the Generation into a circle,
 * meaning the left most Cell's left neighbor is the right most Cell and the 
 * right most Cell's right neighbor is the left most Cell
 * 
 * @author Arjun Ganesan
 * @version 1.0
 *
 */
public class CircularBoundaryConditions implements BoundaryConditions{
	
	/**
	 * Constructor takes no parameters
	 */
	public CircularBoundaryConditions() {
		
	}
	
	/**
	 * @param cellIdx the index of the Cell whose neighbor we are trying to access
	 * @param offset the index of the neighbor relative to the Cell
	 * @param gen the Generation
	 * @return the Cell with index cellIdx + offset
	 */
	public Cell getNeighbor(int cellIdx, int offset, Generation gen) {
		
		int cellsInGen = gen.size();
		int indexOfNeighbor = (cellIdx + offset) % cellsInGen;
		Cell returnCell;
		
		//if the sum of the cellIdx and offset is negative, that means the Cell is "too left",
		//so we begin accessing the Cells starting from the right
		if(indexOfNeighbor < 0) {
			returnCell = gen.getCell(cellsInGen + indexOfNeighbor);
			return returnCell;
		}
		
		//we use the modulo operator to take care of the case where the sum of cellIdx and offset is greater
		//than than the size of the Generation and begin wrapping around the left of the Generation
		returnCell = gen.getCell(indexOfNeighbor);
		return returnCell;
	}
	
	/**
	 * @param cellIdx the index of the Cell whose neighbor we are trying to access
	 * @param offset the index of the neighbor relative to the Cell
	 * @param gen the Generation
	 * @return the Cell with index cellIdx + offset
	 */
	public Cell getNeighbor(int cellIdx, int rowOffset, int colOffset, TwoDGeneration gen) {
		
		int rowsInGen = gen.numOfRows();
		int colsInGen = gen.numOfCols();
		
		int rowOfNeighbor = (cellIdx + rowOffset) % rowsInGen;
		int colOfNeighbor = (cellIdx + colOffset) % colsInGen;
		
		Cell returnCell;
		
		//if the sum of the cellIdx and offset is negative, that means the Cell is "too left",
		//so we begin accessing the Cells starting from the right
		if(rowOfNeighbor < 0 && colOfNeighbor < 0) {
			returnCell = gen.getCell((rowsInGen + rowOfNeighbor), (colsInGen + colOfNeighbor));
			return returnCell;
		}
		
		else if(rowOfNeighbor < 0 && colOfNeighbor > 0) {
			returnCell = gen.getCell((rowsInGen + rowOfNeighbor), (colOfNeighbor));
			return returnCell;
		}
		
		else if(rowOfNeighbor > 0 && colOfNeighbor < 0) {
			returnCell = gen.getCell((rowOfNeighbor), (colsInGen + colOfNeighbor));
			return returnCell;
		}
		
		//we use the modulo operator to take care of the case where the sum of cellIdx and offset is greater
		//than than the size of the Generation and begin wrapping around the left of the Generation
		returnCell = gen.getCell(rowOfNeighbor, colOfNeighbor);
		return returnCell;
	}

}
