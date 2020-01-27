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
		
		JPanel outerPanel = new JPanel();
		outerPanel.setBackground(Color.BLUE);
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

}
