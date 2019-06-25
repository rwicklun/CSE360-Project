package gradeAnalyzer;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.ComponentOrientation;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PercentilePanel extends JPanel {
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public PercentilePanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblGradeDistribution = new JLabel("Grade Distribution");
		lblGradeDistribution.setVerticalAlignment(SwingConstants.BOTTOM);
		lblGradeDistribution.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblGradeDistribution);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(25);
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel);
		JLabel lblA = new JLabel();
		LetterPercentLabel(lblA, "A", 33);
		panel.add(lblA);
		
		JLabel lblB = new JLabel("B: 20%");
		panel.add(lblB);
		
		JLabel lblC = new JLabel("C: 20%");
		panel.add(lblC);
		
		JLabel lblD = new JLabel("D: 20%");
		panel.add(lblD);
		
		JLabel lblF = new JLabel("F: 20%");
		panel.add(lblF);
		
		JLabel lblStudentsInEach = new JLabel("Students in Each Grade Range");
		lblStudentsInEach.setVerticalAlignment(SwingConstants.BOTTOM);
		add(lblStudentsInEach);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		FlowLayout fl_panel_1 = new FlowLayout(FlowLayout.LEFT, 0, 5);
		panel_1.setLayout(fl_panel_1);
		
		JLabel label_4 = new JLabel("      ");
		panel_1.add(label_4);
		
		JLabel lblA_1 = new JLabel("A:");
		panel_1.add(lblA_1);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setText("90");
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setColumns(2);
		
		JLabel label_1 = new JLabel("%      ");
		panel_1.add(label_1);
		
		JLabel lblB_1 = new JLabel("B:");
		panel_1.add(lblB_1);
		
		textField_2 = new JTextField();
		panel_1.add(textField_2);
		textField_2.setText("80");
		textField_2.setColumns(2);
		
		JLabel label_3 = new JLabel("%      ");
		panel_1.add(label_3);
		
		JLabel lblC_1 = new JLabel("C:");
		panel_1.add(lblC_1);
		
		textField_3 = new JTextField();
		panel_1.add(textField_3);
		textField_3.setText("70");
		textField_3.setColumns(2);
		
		JLabel label_2 = new JLabel("%      ");
		panel_1.add(label_2);
		
		JLabel lblD_1 = new JLabel("D:");
		panel_1.add(lblD_1);
		
		textField_4 = new JTextField();
		panel_1.add(textField_4);
		textField_4.setText("60");
		textField_4.setColumns(2);
		
		JLabel label = new JLabel("%      ");
		panel_1.add(label);
		
		JLabel lblF_1 = new JLabel("F:");
		panel_1.add(lblF_1);
		
		textField_5 = new JTextField();
		panel_1.add(textField_5);
		textField_5.setText("50");
		textField_5.setColumns(2);
		
		JLabel label_6 = new JLabel("%      ");
		panel_1.add(label_6);
		
		JButton btnUpdate = new JButton("Update");
		panel_1.add(btnUpdate);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		
		JLabel lblStudentsInEach_1 = new JLabel("Students in Each Percentile");
		lblStudentsInEach_1.setVerticalAlignment(SwingConstants.BOTTOM);
		add(lblStudentsInEach_1);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);

	}

	public void LetterPercentLabel(JLabel label, String letter, float percent) {
		label.setText("A: 20%");
	}
}
