
public class Generation {
	
	private Cell[] cells;
	
	public Generation(CellState[] states) {
		cells = new Cell[states.length];
		int i = 0;
		for(CellState state : states) {
			cells[i] = new Cell(state);
			++i;
		}
	}
	
	public Generation(String string) {
		cells = new Cell[string.length()];
		try {
			for(int i = 0; i < string.length(); ++i) {
				cells[i] = new Cell(CellState.getState(string.charAt(i)));
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println("Character in String not a valid symbol for CellState");
		}
	}
	
	public Generation(Cell[] cells) {
		Cell[] cellsCopy = cells.clone();
		cells = cellsCopy;
	}
	
	public int size() {
		return cells.length;
	}
	
	public Cell getCell(int idx) {
		return cells[idx];
	}
	
	public boolean[] getGenerationAsBooleanArray() {
		boolean[] generationAsBoolean = new boolean[this.size()];
		CellState state;
		
		for(int i = 0; i < generationAsBoolean.length; ++i) {
			state = this.getCell(i).getState();
			if(state == CellState.OFF) {
				generationAsBoolean[i] = false;
			}
			else {
				generationAsBoolean[i] = true;
			}
		}
		return generationAsBoolean;
	}
	
	public String toString() {
		String returnString = "";
		
		for(Cell cell : cells) {
			returnString += cell.toString();
		}
		return returnString;
	}

}
