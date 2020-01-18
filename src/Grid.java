
/**
 * 
 * @author Raymond Ward
 * @date 20/12/2019
 * 
 * 
 * The class grid creates and maintains a 2x2 array of GridCells acting as a Sudoku Table.
 * 
 * 
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
		numberGrid = sudoku;
		formGridArray();
		
	}
	
	public GridCell[][] returnSolve ()
	{
		if (gridArray[0][0].getFix())
		{
			int [] nextCell = getNextCell(0,0);
			backtrackCell(nextCell[0],nextCell[1]);
		}
		else
		{
			backtrackCell(0,0);
		}
		
		return gridArray;
	}
	
	
	
	
	private void formGridArray()
	{
		gridArray  = new GridCell [9][9];
		
		for (int row = 0; row < numberGrid.length; row ++)
		{
			for (int col = 0; col < numberGrid[row].length; col ++)
			{
				gridArray[row][col] = new GridCell(numberGrid[row][col]);		
				
			}
			
		}
		
	}
	
	public boolean validPos(int row, int col, int val)
	{
		return checkRow(row,col,val) && checkColumn(row,col,val) && checkBox(row,col,val);
	
	}
	
	
	public void outputGrid()
	{
		System.out.println("-------------------------");
		for (int row = 0; row < 9; row ++)
		{
			System.out.println("| " + gridArray[row][0].getVal() + " " + gridArray[row][1].getVal() + " " + gridArray[row][2].getVal() + " | " + gridArray[row][3].getVal()+ " " + gridArray[row][4].getVal() + " "+ gridArray[row][5].getVal() + " | " + gridArray[row][6].getVal()+ " " + gridArray[row][7].getVal() + " "+ gridArray[row][8].getVal() + " | ");
			
			if ((row + 1) % 3 == 0)
			{
				System.out.println("-------------------------");
			}
		}
		
		System.out.println();
	}
	
	public boolean checkRow (int row, int col,int val)
	{
		boolean valid = true;
		
		for (int x = 0; x < numberGrid.length; x ++ )
		{
			if (x != col && gridArray[row][x].getVal() == val)
			{
				valid = false;
			}
		}
		
		return valid;
	}
	
	public boolean checkColumn (int row, int col, int val)
	{
		boolean valid = true;
		for (int x = 0; x < numberGrid[row].length; x++)
			
			
		{
			if (x != row && gridArray[x][col].getVal() == val)
			{
				valid = false;
			}
			 
		}
		return valid;
		
	}
	
	public int [] getPreviousCell (int row, int col)
	{
		if (col == 0)
		{
			row = row -1;
			col = 8;
		}
		else
		{
			col--;
		}
		
		if (gridArray[row][col].getFix())
		{
			return getPreviousCell(row,col);
		}
		else
		{
			return new int [] {row,col};
		}
		
		
	}
	
	private boolean checkSolve ()
	{
		boolean solved = true;
		for (int row = 0; row < 9; row ++)
		{
			for (int col = 0; col < 9; col++)
			{
				if (gridArray[row][col].getVal() == 0)
					solved = false;
			}
		}
		
		return solved;
	}
	
	
	public int [] getNextCell (int row, int col)
	{
		if (col == 8)
		{
			row = row + 1;
			col = 0;
		}
		else
		{
			col++;
		}
		
		//System.out.println("ROW IS NOW: " + row + "COL IS NOW:" + col);
		
		if (col > 8 || row > 8)
		{
			return new int []  {0,0}; //
		}
		else if (gridArray[row][col].getFix())
		{
			return getNextCell(row,col);
		}
	
		else
		{
			return new int [] {row,col};
		}	
	}
	
	public boolean checkBox (int row, int col, int val)
	{
		boolean valid = true;
		
		int boxRow = Math.floorDiv(row, 3); // row of box
		int boxCol = Math.floorDiv(col, 3); // column of box
		
		for (int x = boxRow * 3; x < boxRow*3 +3; x ++)
		{
			for (int y = boxCol * 3; y < boxCol*3 +3; y++)
			{
				if ((val == gridArray[x][y].getVal()) && (x != row || y != col))
				{
					valid = false;
				}
				
			}
			
		}
		
		return valid;
	}
	/**
	 * 
	 * @param row - The row of the current working cell
	 * @param col - The column of the current working cell
	 * @return True if board is already solved or the rest of board can be solved using current cell value, false otherwise
	 * 
	 * This recursive function is called for each cell within the sudoku grid, then depending on the rest of the grid will return true or false
	 * 
	 */
	public boolean backtrackCell(int row, int col)
	{		
		if (checkSolve())   //If no 0s left return true as sudoku is solved
			return true;
		
		else
		{
			for (int val = 1; val < 10; val++)   //For each cell, loop through the possible values (1,2,3...8,9)
			{
				if (validPos(row,col,val))  //if that number can exist in that position
				{
					gridArray[row][col].setVal(val); //Set the value in grid
					
					int [] nextPos = getNextCell(row,col); // Get the position of next available cell
					
					if(backtrackCell(nextPos[0], nextPos[1]))   //If the rest of the board is now solvable using current value, return true,  
						return true;
					
					else  //else set the value of current cell to 0 
						gridArray[row][col].setVal(0);
						
				}
			}
			
			return false;
			
			
		}
		
		
	}
	
	
	


	
	

		

	
		
		
			
}
		
		
		

