
public class Main {

	public static void main(String[] args) 
	{
		int [][] emptyGrid =   {{0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0}};
		
		int [][] numberGrid = {{0,0,0,0,5,0,0,0,9},
								{4,0,0,0,0,6,0,0,1},
								{0,0,1,0,0,3,0,5,0},
								{0,0,0,0,0,8,4,0,0},
								{0,0,7,0,0,0,0,0,0},
								{0,2,0,1,9,0,0,8,0},
								{0,0,9,0,0,0,0,3,0},
								{6,0,0,0,3,4,0,0,0},
								{3,0,0,0,0,0,7,0,0}};
		
		
		
		Grid g = new Grid(numberGrid);
		GridCell [][] solved = g.returnSolve();
		for (GridCell [] row : solved)
		{
			for (GridCell cell : row)
			{
				System.out.print(cell.getVal() + " ");
			}	

			System.out.println();


		}
		//View v = new View(numberGrid);
		
		

	}

}
