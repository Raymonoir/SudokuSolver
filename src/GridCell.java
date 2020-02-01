/**
 * 
 * @author Raymond Ward
 * 
 * This class acts as a cell for a sudoku, including the value of the cell and if the cell is given by the sudoku.
 *
 */
public class GridCell 
{
	private int value;
	private boolean fixed;
	
	
	GridCell(int val)
	{
		if (val != 0)
			fixed = true;
		
		value = val;
	}
	
	/**
	 * 
	 * @return value, value of current cell
	 */
	public int getVal ()
	{
		return value;
	}
	
	/**
	 * increments the value by 1
	 */
	public void incVal()
	{
		value++;
	}
	
	/**
	 * 
	 * @param val, value of the current cell
	 */
	public void setVal(int val)
	{
		value = val;
	}
	
	/**
	 * 
	 * @return fixed, if the current cell is given
	 */
	public boolean getFix ()
	{
		return fixed;
	}

}
