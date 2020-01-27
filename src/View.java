import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class View 
{

	Font numFont = new Font("Serif", Font.BOLD, 30);
	public static int lives = 3;
	Dimension frameSize = new Dimension(700,800);
	
	JFrame frame;
	
	int [][] unsolvedGrid;
	SudokuCell [][] cellGrid;
	GridCell [][] solvedGrid;
	
	
	
	
	View(int [][] grid)
	{
		
		buildWindow();
		
		
	}
	
	public void buildWindow()
	{
		frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		Dimension frameSize = new Dimension(700,800);
		
		frame.setSize(frameSize);
		frame.setMaximumSize(frameSize);
		frame.setMinimumSize(frameSize);
		frame.setPreferredSize(frameSize);
		
		JPanel outerPanel = new JPanel();
		//outerPanel.opa
		frame.getContentPane().add(outerPanel, BorderLayout.NORTH);
		outerPanel.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(2);
		splitPane.setEnabled(false);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel upperPanel = new JPanel();
		upperPanel.setBackground(Color.PINK);
		splitPane.setLeftComponent(upperPanel);
		
		JPanel lowerPanel = new JPanel();
		lowerPanel.setBackground(Color.CYAN);
		splitPane.setRightComponent(lowerPanel);
		splitPane.setDividerLocation(100);
		
		frame.setVisible(true);
	}
	
	public void createGrid()
	{
		for (int x = 0; x < 9; x ++)
		{
			for (int y = 0; y < 9; y ++)
			{
				//SudokuCell currentCell = new SudokuCell(unsolvedGrid[x][y],x,y);
				//innerPanel.add(currentCell);
				//cellGrid[x][y] = currentCell;
			}
		}
		
		
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
		private Dimension cellSize = new Dimension(31,31);
		private static final long serialVersionUID = 1L;
		private int  value;
		JLabel cellLabel = new JLabel();
		int posx, posy;
		
		
		SudokuCell(int val,int posx,int posy)
		{
			this.posx = posx;
			this.posy = posy;
			
			this.setLayout(new GridLayout(3,3));
			this.setPreferredSize(cellSize);
			this.setMaximumSize(cellSize);
			this.setMinimumSize(cellSize);
			
			setBorder(BorderFactory.createLineBorder(Color.black, 1));
			setBackground(Color.GRAY);
			 
			if (val == 0)
			{
				
				
				for (int i =0; i < 3; i ++)
				{
					for (int j = 0; j < 3; j ++)
					{
						int buttonVal = i * 3 + j+1;
						JButton currentButton = new JButton("" + buttonVal);
						currentButton.setSize(4, 4);
						currentButton.addActionListener( source -> 
						{
							
							if (buttonVal == solvedGrid[posx][posy].getVal())
							{
								this.removeAll();
								this.setBackground(new Color(102,255,102));
								this.add(cellLabel);
								cellLabel.setForeground(Color.WHITE);
								cellLabel.setFont(numFont);
								cellLabel(buttonVal);
							
								
							}
							else
							{
								System.out.println(buttonVal);
								currentButton.setVisible(false);
								this.setBackground(new Color(255,102,102));
								
								
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
				cellLabel.setForeground(Color.WHITE);
				cellLabel.setFont(numFont);
				
			}
			
			
		}
		
		public void cellLabel (int val)
		{
			cellLabel.setText(val + " ");
			cellLabel.setForeground(Color.WHITE);
			cellLabel.setFont(numFont);
		    
		}

		
	}
	

}
