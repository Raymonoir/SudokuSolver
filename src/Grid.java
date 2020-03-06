
/**
 * 
 * @author Raymond Ward
 * @date 20/12/2019
 * 
 * 
 * The class grid creates and maintains a 2x2 array of GridCells acting as a Sudoku Table.
 * This class also contains the backtracking algorithm, which solves any sudoku.

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
	
	
	@SuppressWarnings("unused")
	/**
	 * returns the solved grid array
	 * @return gridArray, solved sudoku
	 */
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
	
	
	
	/**
	 * Creates array of GridCells, inputting value of cell
	 */
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
	/**
	 * 
	 * @param row, row of current cell
	 * @param col, column of current cell
	 * @param val, value of current cell
	 * @return a boolean depending on if the value is valid in current cell depending on row, column and sub-box
	 */
	private boolean validPos(int row, int col, int val)
	{
		return checkRow(row,col,val) && checkColumn(row,col,val) && checkBox(row,col,val);
	
	}
	
	
	@SuppressWarnings("unused")
	/**
	 * Outputs sudoku to console
	 */
	private void outputGrid()
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
	/**
	 * Checks if row is valid
	 * 
	 * @param row, row of current cell
	 * @param col, column of current cell
	 * @param val, value in the current cell
	 * @return valid, a boolean depending on if val is valid in the given row
	 * 
	 */
	private boolean checkRow (int row, int col,int val)
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
	
	/**
	 * Checks if column is valid
	 * 
	 * @param row, row of current cell
	 * @param col, column of current cell
	 * @param val, value in the current cell
	 * @return valid, a boolean depending on if val is valid in the given column
	 */
	private boolean checkColumn (int row, int col, int val)
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
	
	@SuppressWarnings("unused")
	/**
	 * 
	 * @param row, row of current cell
	 * @param col, column of current cell
	 * @return array of closest previous not fixed cell
	 */
	private int [] getPreviousCell (int row, int col)
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
	
	/**
	 * This method checks if the sudoku is solved, by checking if any cells are not assigned
	 * @return solved, depending on if sudoku is solved
	 */
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
	
	/**
	 * This gets the next cell that needs to be assigned a value, 
	 * @param row, row of current cell
	 * @param col, column of current cell
	 * @return array of next cell co-ordinates
	 */
	private int [] getNextCell (int row, int col)
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
	
	/**
	 * This checks if the current cells sub-box is valid
	 * @param row, row of current cell
	 * @param col, column of current cell
	 * @param val, value of current cell
	 * @return valid, depending on if cell is valid in box or not
	 */
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
		
		
		

