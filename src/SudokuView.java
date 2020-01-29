import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JSplitPane;

public class SudokuView {

	private JFrame frame;
	JPanel lowerPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SudokuView window = new SudokuView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SudokuView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
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
		
		JPanel upperPanel = new JPanel();
		upperPanel.setBackground(Color.PINK);
		splitPane.setLeftComponent(upperPanel);
		
		lowerPanel = new JPanel();
		lowerPanel.setBorder(null);
		lowerPanel.setBackground(Color.CYAN);
		lowerPanel.setLayout(new GridLayout(9,9));
		splitPane.setRightComponent(lowerPanel);
		splitPane.setDividerLocation(100);
		
		createGrid();
		
		frame.setVisible(true);
	}
	
	public void createGrid()
	{
		for (int x = 0; x < 9; x ++)
		{
			for (int y = 0; y < 9; y ++)
			{
				//SudokuCell currentCell = new SudokuCell(unsolvedGrid[x][y],x,y);
				JPanel currentCell = new JPanel();
				currentCell.setBackground(Color.YELLOW);
				lowerPanel.add(currentCell);
				//cellGrid[x][y] = currentCell;
			}
		}
		
		
	}

}
