
/**
 * 
 * @author raymonoir
 * 
 * 
 * BACKTRACKING ALGORITHM
 * 
 * if 0, increment
 * does 1 work, if yes move on,
 * if not keep incrementing 
 * 
 * if no values work, backtrack 
 * 
 * 
 *
 */







public class Grid 
{
	GridCell [][] gridArray;
	int [][] numberGrid;
	
	
	Grid(int [][] sudoku)
	{
		int [][] numberGrid = sudoku;
		formGridArray();
		
	}
	
	
	private void formGridArray()
	{
		gridArray  = new GridCell [9][9];
		
		for (int i = 0; i < numberGrid.length; i ++)
		{
			for (int j = 0; j < numberGrid.length; j ++)
			{
				gridArray[i][j] = new GridCell(numberGrid[i][j]);
				
			}
			
		}
		
	}
	
	private boolean checkRow (int i, int j)
	{
		return false;
	}
	
	private boolean checkColumn (int i, int j)
	{
		return false;
		
	}
	
	private boolean checkBox (int i, int j)
	{
		return false;
	}
	
	
	private void backtrack (int i, int j)
	{
		if (gridArray[i][j].getVal() == 0)
			gridArray[i][j].incVal();
		
		if ()
		
	}

}
