
public class GridCell 
{
	private int value;
	private boolean fixed;
	private int square;
	
	
	GridCell(int val)
	{
		if (val != 0)
			fixed = true;
		
		value = val;
	}
	
	public int getVal ()
	{
		return value;
	}
	
	public void incVal()
	{
		value++;
	}
	
	public void setVal(int val)
	{
		value = val;
	}
	
	
	public boolean getFix ()
	{
		return fixed;
	}

}
