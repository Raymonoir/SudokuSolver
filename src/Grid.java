
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
		numberGrid = sudoku;
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
				
			}
			
		}
		
	}
	
	public boolean valid(int row, int col)
	{
		return checkRow(row,col) && checkColumn(row,col) && checkBox(row,col);
	
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
			if (x != row && gridArray[x][col].getVal() == gridArray[row][col].getVal())
			{
				valid = false;
			}
			 
		}
		return valid;
		
	}
	
	private int [] getPreviousCell (int row, int col)
	{
		if (col == 0)
		{
			row = row -1;
			col = 8;
		}
		
		if (gridArray[row][col].getFix())
		{
			return getPreviousCell(row,col);
		}
		
		return new int [] {row,col};
	}
	
	
	private int [] getNextCell (int row, int col)
	{
		if (col == 8)
		{
			row = row + 1;
			col = 0;
		}
		
		if (gridArray[row][col].getFix())
		{
			return getNextCell(row,col);
		}
		
		return new int [] {row,col};
		
	}
	
	private boolean checkBox (int row, int col)
	{
		boolean valid = true;
		
		int boxRow = Math.floorDiv(row, 3); // row of box
		int boxCol = Math.floorDiv(col, 3); // column of box
		
		for (int x = boxRow * 3; x < boxRow*3 +3; x ++)
		{
			for (int y = boxCol * 3; y < boxCol*3 +3; y++)
			{
				if ((gridArray[row][col].getVal() == gridArray[x][y].getVal()) && (x != row || y != col))
				{
					valid = false;
				}
				
			}
			
		}
		
		return valid;
	}
	
	
	public boolean backtrack (int row, int col)
	{
		if (!gridArray[row][col].getFix())
		{
			if (gridArray[row][col].getVal() == 0)
				gridArray[row][col].incVal();
			
			if (!valid(row,col))
			{
				if (gridArray[row][col].getVal() == 9)
				{
					gridArray[row][col].setVal(0);
					int [] pos = getPreviousCell(row,col);
					
					row = pos[0];
					col = pos[1];
					
					return backtrack(row,col);
					
				}
				else
				{
					gridArray[row][col].incVal();
					return backtrack(row,col);
				}
			}
			else
			{
				int [] pos = getNextCell(row,col);
				
				row = pos[0];
				col = pos[1];
				
				
				
				if (row ==8 && col == 8)
				{
					outputGrid();
					return true;
					
				}
				else
				{
					backtrack(row,col);
				}
				
				
			}
			
		}
		return false;
		
		
		
		
	}

}
