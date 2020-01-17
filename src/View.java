import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View 
{
	Dimension windowSize = new Dimension(900,500);
	JFrame frame = new JFrame("Sudoku Solver");
	int [][] unsolvedGrid;
	SudokuCell [][] cellGrid;
	
	
	
	
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
		createGrid();
		frame.setVisible(true);
		showSolve();
		
		
	}
	
	public void createGrid()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(9,9));
		
		
		for (int x = 0; x < 9; x ++)
		{
			for (int y = 0; y < 9; y ++)
			{
				SudokuCell currentCell = new SudokuCell(x * 9 + y);
				panel.add(currentCell);
				cellGrid[x][y] = currentCell;
			}
		}
		
		frame.add(panel);
	}
	
	public void showSolve()
	{
		Grid solve = new Grid(unsolvedGrid);
		GridCell [][] solvedGrid = solve.returnSolve();
		
		for (int x = 0; x < 9; x ++)
		{
			for (int y = 0; y < 9; y ++)
			{
				cellGrid[x][y].cellLabel(solvedGrid[x][y].getVal());
			}
		}
	}
	
	public  class SudokuCell extends JPanel implements MouseListener
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int  value;
		JLabel cellLabel = new JLabel();
		
		
		SudokuCell(int val)
		{
			this.add(cellLabel);
			setBorder(BorderFactory.createLineBorder(Color.white, 2));
			setBackground(Color.GRAY);
			addMouseListener(this);
			
		}
		
		public void cellLabel (int val)
		{
			cellLabel.setText(val + " ");
		    
		}

		@Override
		public void mouseClicked(MouseEvent e) 
		{
			setBackground(Color.DARK_GRAY);
		}

		
		public void mousePressed(MouseEvent e) {
			// Unused
			
		}

		public void mouseReleased(MouseEvent e) {
			// Unused
			
		}

		public void mouseEntered(MouseEvent e) {
			// Unused
			
		}

		public void mouseExited(MouseEvent e) {
			//Unused
			
		}
		
	}
	

}
