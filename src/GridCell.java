
public class GridCell 
{
	private int value;
	private boolean given;
	
	
	GridCell(int val)
	{
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
	
	
	public boolean getGiven ()
	{
		return given;
	}
	
	public void setGiven (boolean giv)
	{
		given = giv;
	}

}
