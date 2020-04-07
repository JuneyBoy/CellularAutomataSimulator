/**
 * This class extends the Cell class and will make up any Generation of the Automaton that has been evolved.
 * The extra data member holds which subrule it was evolved by.
 * 
 * @author Arjun Ganesan
 * @version 1.0
 *
 */
public class EvolvedCell extends Cell{
	
	private int subruleNum;
	
	/**
	 * 
	 * @param state sets the state of the EvolvedCell object
	 * @param subruleNum stores the subrule of the Rule that applied to this EvolvedCell
	 */
	public EvolvedCell(CellState state, int subruleNum) {
		super(state);
		this.subruleNum = subruleNum; 
	}
	
	/**
	 * 
	 * @return the subrule that the EvolvedCell evolved by
	 */
	public int getSubruleNum() {
		return subruleNum;
	}

}
