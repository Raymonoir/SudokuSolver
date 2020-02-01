import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class View 
{

	Font numFont = new Font("Serif", Font.BOLD, 30);
	public static int lives = 3;
	Dimension frameSize = new Dimension(700,800);
	
	JFrame frame;
	JPanel upperPanel;
	JPanel lowerPanel;
	JLabel upperPanelLabel;
	
	int [][] unsolvedGrid;
	SudokuCell [][] cellGrid;
	GridCell [][] solvedGrid;
	
	
	
	
	View(int [][] grid)
	{
		unsolvedGrid = grid;
		cellGrid = new SudokuCell[9][9];
		solvedGrid = solve();
		upperPanelLabel = new JLabel();
		
		buildWindow();
		
		
	}
	
	public void decreaseLives()
	{
		lives--;
		upperPanelLabel.setText("Lives: " + lives);
		
		if (lives == 0)
		{
			System.exit(0);
		}
		
	}
	
	public void buildWindow()
	{
		frame = new JFrame("Sudoku Shenanigans");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		Dimension frameSize = new Dimension(700,800);
		
		frame.setSize(frameSize);
		frame.setMaximumSize(frameSize);
		frame.setMinimumSize(frameSize);
		frame.setPreferredSize(frameSize);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(2);
		splitPane.setEnabled(false);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		upperPanel = new JPanel();
		upperPanel.setBackground(Color.PINK);
		upperPanel.add(upperPanelLabel);
		upperPanelLabel.setText("" + lives);
		splitPane.setLeftComponent(upperPanel);
		
		lowerPanel = new JPanel();
		lowerPanel.setLayout(new GridLayout(9,9));
		lowerPanel.setBorder(null);
		splitPane.setRightComponent(lowerPanel);
		splitPane.setDividerLocation(100);
		
		createGrid();
		frame.pack();
		
		frame.setVisible(true);
	}
	
	public void createGrid()
	{
		for (int x = 0; x < 9; x ++)
		{
			for (int y = 0; y < 9; y ++)
			{
				SudokuCell currentCell = new SudokuCell(unsolvedGrid[x][y],x,y);
				lowerPanel.add(currentCell);
				cellGrid[x][y] = currentCell;
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

		private static final long serialVersionUID = 1L;
		private int  value;
		JLabel cellLabel = new JLabel();
		int posx, posy;
		
		
		SudokuCell(int val,int posx,int posy)
		{
			this.posx = posx;
			this.posy = posy;
			
			this.setLayout(new GridLayout(3,3));
			this.setBorder(new EmptyBorder(0, -1, 0, -1));
			
			System.out.println((posx + 1) % 3);
			if ((posy + 1) % 3 == 0 && (posx + 1) % 3 == 0 )
				setBorder(BorderFactory.createMatteBorder(1,1,3,3, Color.black));
			else if ((posx + 1) % 3 == 0)
				setBorder(BorderFactory.createMatteBorder(1,1,3,1, Color.black));
			else if ((posy + 1) % 3 == 0)
				setBorder(BorderFactory.createMatteBorder(1,1,1,3, Color.black));		
			else
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
								decreaseLives();
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
			
				
			}
			
			
		}
		
		public void cellLabel (int val)
		{
			cellLabel.setText(val + " ");
			cellLabel.setForeground(Color.WHITE);
			cellLabel.setFont(numFont);
			cellLabel.setHorizontalAlignment(SwingConstants.CENTER);
			cellLabel.setVerticalAlignment(SwingConstants.CENTER);
		    
		}

		
	}
	

}
