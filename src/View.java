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
	
	
	
	
	View()
	{
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMaximumSize(windowSize);
		frame.setMinimumSize(windowSize);
		frame.setPreferredSize(windowSize);
		createGrid();
		frame.setVisible(true);
		
		
	}
	
	public void createGrid()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(9,9));
		
		
		for (int x = 0; x < 9; x ++)
		{
			for (int y = 0; y < 9; y ++)
			{
				panel.add(new SudokuCell(x * 9 + y));
			}
		}
		
		frame.add(panel);
		
	}
	
	public  class SudokuCell extends JPanel implements MouseListener
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int  value;
		
		SudokuCell(int val)
		{
			setBorder(BorderFactory.createLineBorder(Color.white, 2));
			setBackground(Color.GRAY);
			addMouseListener(this);
			JLabel label1 = new JLabel();
		    label1.setText(val + " ");
		    this.add(label1);
			value = val;
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
