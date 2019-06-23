package experimental;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;

public class TestGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestGUI window = new TestGUI();
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
	public TestGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel background = new JPanel();
		frame.getContentPane().add(background, BorderLayout.CENTER);
		background.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		background.setLayout(null);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(679, 427, 89, 23);
		background.add(btnClose);
		
		JButton gradeStat = new JButton("Grade Statistics");
		gradeStat.setForeground(Color.BLACK);
		gradeStat.setBackground(Color.GRAY);
		gradeStat.setBounds(10, 93, 137, 40);
		background.add(gradeStat);
		
		JButton home = new JButton("Home");
		home.setForeground(Color.BLACK);
		home.setBackground(Color.GRAY);
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		home.setBounds(10, 11, 137, 40);
		background.add(home);
		
		JButton loadFile = new JButton("Load a File");
		loadFile.setForeground(Color.BLACK);
		loadFile.setBackground(Color.GRAY);
		loadFile.setBounds(10, 52, 137, 40);
		background.add(loadFile);
		
		JButton gradePercent = new JButton("Grade Percentiles");
		gradePercent.setForeground(Color.BLACK);
		gradePercent.setBackground(Color.GRAY);
		gradePercent.setBounds(10, 134, 137, 40);
		background.add(gradePercent);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(140, 180, 1, 1);
		background.add(layeredPane);
		
		JPanel panelHome = new JPanel();
		panelHome.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelHome.setBounds(157, 11, 611, 405);
		background.add(panelHome);
		
		JButton changeGrades = new JButton("Change Grades");
		changeGrades.setForeground(Color.BLACK);
		changeGrades.setBackground(Color.GRAY);
		changeGrades.setBounds(10, 175, 137, 40);
		background.add(changeGrades);
	}
}
