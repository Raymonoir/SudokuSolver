
/**
 * 
 * @author raymonoir
 * 
 * 
 * i = row
 * j = column
 * 
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
		
		for (int row = 0; row < numberGrid.length; row ++)
		{
			for (int col = 0; col < numberGrid[row].length; col ++)
			{
				gridArray[row][col] = new GridCell(numberGrid[row][col]);
				
				int rowMod = row%3;
				int colMod = col%3;
				
				
			}
			
		}
		
	}
	
	private boolean checkRow (int row, int col)
	{
		boolean valid = true;
		
		for (int x = 0; x < numberGrid.length; x ++ )
		{
			if (x != col && gridArray[row][x].getVal() == gridArray[row][col].getVal())
			{
				valid = false;
			}
		}
		
		return valid;
	}
	
	private boolean checkColumn (int row, int col)
	{
		boolean valid = true;
		for (int x = 0; x < numberGrid[row].length; x++)
		{
			if (x !=row && gridArray[x][col].getVal() == gridArray[row][col].getVal())
			{
				valid = false;
			}
			 
		}
		return valid;
		
	}
	
	private boolean checkBox (int row, int col)
	{
		boolean valid = true;
		
		return valid;
	}
	
	
	private void backtrack (int row, int col)
	{
		if (gridArray[row][col].getVal() == 0)
			gridArray[row][col].incVal();
		
		
	}

}
