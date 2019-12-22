
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
	
	public void setSqu (int squ)
	{
		square = squ;
	}
	
	public int getSqu ()
	{
		return square;
	}
	
	public int getVal ()
	{
		return value;
	}
	
	public void incVal()
	{
		value++;
	}
	
	
	public boolean getFix ()
	{
		return fixed;
	}

}
