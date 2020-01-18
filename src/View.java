import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View 
{
	
	public static int lives = 3;
	Dimension windowSize = new Dimension(600,650);
	JFrame frame = new JFrame("Sudoku Solver");
	int [][] unsolvedGrid;
	SudokuCell [][] cellGrid;
	GridCell [][] solvedGrid;
	
	
	
	
	View(int [][] grid)
	{
		cellGrid = new SudokuCell[9][9];
		unsolvedGrid = grid;
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMaximumSize(windowSize);
		frame.setMinimumSize(windowSize);
		frame.setPreferredSize(windowSize);
		solvedGrid = solve();
		createGrid();
		
		frame.setVisible(true);
		
		
		
	}
	
	public void createGrid()
	{
		JPanel panel = new JPanel();
		Dimension panelSize = new Dimension(663,663);
		panel.setMaximumSize(panelSize);
		panel.setMinimumSize(panelSize);
		panel.setPreferredSize(panelSize);
		panel.setLayout(new GridLayout(9,9));
		
		//System.out.println(panel.get);
		
		
		for (int x = 0; x < 9; x ++)
		{
			for (int y = 0; y < 9; y ++)
			{
				SudokuCell currentCell = new SudokuCell(unsolvedGrid[x][y],x,y);
				panel.add(currentCell);
				cellGrid[x][y] = currentCell;
			}
		}
		
		frame.add(panel);
	}
	
	public GridCell[][] solve()
	{
		Grid solve = new Grid(unsolvedGrid);
		solvedGrid = solve.returnSolve();
		
		return solvedGrid;
	}
	public void showSolve()
	{
		for (int x = 0; x < 9; x ++)
		{
			for (int y = 0; y < 9; y ++)
			{
				cellGrid[x][y].cellLabel(solvedGrid[x][y].getVal());
			}
		}
	}
	
	public  class SudokuCell extends JPanel
	{
		/**
		 * 
		 */
		private Dimension panelSize = new Dimension(60,60);
		private static final long serialVersionUID = 1L;
		private int  value;
		JLabel cellLabel = new JLabel();
		int posx, posy;
		
		
		SudokuCell(int val,int posx,int posy)
		{
			this.posx = posx;
			this.posy = posy;
			this.setPreferredSize(panelSize);
			this.setMaximumSize(panelSize);
			this.setMinimumSize(panelSize);
			
			setBorder(BorderFactory.createLineBorder(Color.black, 2));
			setBackground(Color.GRAY);
			 
			if (val == 0)
			{
				this.setLayout(new GridLayout(3,3));
				
				for (int i =0; i < 3; i ++)
				{
					for (int j = 0; j < 3; j ++)
					{
						int buttonVal = i * 3 + j+1;
						JButton currentButton = new JButton(" " + buttonVal);
						currentButton.setSize(20, 20);
						currentButton.addActionListener( source -> 
						{
							
							if (buttonVal == solvedGrid[posx][posy].getVal())
							{
								this.removeAll();
								this.setBackground(Color.GREEN);
								this.add(cellLabel);
								
								cellLabel(buttonVal);
							
								
							}
							else
							{
								System.out.println(buttonVal);
								currentButton.setVisible(false);
								this.setBackground(Color.RED);
								
								
							}
							
					
						});
						this.add(currentButton);
					}
				}
			}
			else
			{
				this.add(cellLabel);
				cellLabel(val);
			}
			
			
		}
		
		public void cellLabel (int val)
		{
			cellLabel.setText(val + " ");
		    
		}

		
	}
	

}
