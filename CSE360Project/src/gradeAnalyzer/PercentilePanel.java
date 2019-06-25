package gradeAnalyzer;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.ComponentOrientation;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {75, 75, 75, 75, 75, 75, 0};
		gbl_panel.rowHeights = new int[]{42, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		JLabel lblA = new JLabel();
		LetterPercentLabel(lblA, "A", 33);
		GridBagConstraints gbc_lblA = new GridBagConstraints();
		gbc_lblA.fill = GridBagConstraints.VERTICAL;
		gbc_lblA.insets = new Insets(0, 0, 0, 5);
		gbc_lblA.gridx = 0;
		gbc_lblA.gridy = 0;
		panel.add(lblA, gbc_lblA);
		
		JLabel lblB = new JLabel("B: 20%");
		GridBagConstraints gbc_lblB = new GridBagConstraints();
		gbc_lblB.fill = GridBagConstraints.VERTICAL;
		gbc_lblB.insets = new Insets(0, 0, 0, 5);
		gbc_lblB.gridx = 1;
		gbc_lblB.gridy = 0;
		panel.add(lblB, gbc_lblB);
		
		JLabel lblC = new JLabel("C: 20%");
		GridBagConstraints gbc_lblC = new GridBagConstraints();
		gbc_lblC.fill = GridBagConstraints.VERTICAL;
		gbc_lblC.insets = new Insets(0, 0, 0, 5);
		gbc_lblC.gridx = 2;
		gbc_lblC.gridy = 0;
		panel.add(lblC, gbc_lblC);
		
		JLabel lblD = new JLabel("D: 20%");
		GridBagConstraints gbc_lblD = new GridBagConstraints();
		gbc_lblD.fill = GridBagConstraints.VERTICAL;
		gbc_lblD.insets = new Insets(0, 0, 0, 5);
		gbc_lblD.gridx = 3;
		gbc_lblD.gridy = 0;
		panel.add(lblD, gbc_lblD);
		
		JLabel lblF = new JLabel("F: 20%");
		GridBagConstraints gbc_lblF = new GridBagConstraints();
		gbc_lblF.insets = new Insets(0, 0, 0, 5);
		gbc_lblF.fill = GridBagConstraints.VERTICAL;
		gbc_lblF.gridx = 4;
		gbc_lblF.gridy = 0;
		panel.add(lblF, gbc_lblF);
		
		JLabel lblStudentsInEach = new JLabel("Students in Each Grade Range");
		lblStudentsInEach.setVerticalAlignment(SwingConstants.BOTTOM);
		add(lblStudentsInEach);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {75, 75, 75, 75, 75, 75, 0};
		gbl_panel_1.rowHeights = new int[] {42, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblA_1 = new JLabel("A:");
		GridBagConstraints gbc_lblA_1 = new GridBagConstraints();
		gbc_lblA_1.ipadx = 5;
		gbc_lblA_1.anchor = GridBagConstraints.WEST;
		gbc_lblA_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblA_1.gridx = 0;
		gbc_lblA_1.gridy = 0;
		panel_1.add(lblA_1, gbc_lblA_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 0;
		panel_1.add(textField_1, gbc_textField_1);
		textField_1.setText("90");
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setColumns(2);
		
		JLabel label_1 = new JLabel("%");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		panel_1.add(label_1, gbc_label_1);
		
		JLabel lblB_1 = new JLabel("B:");
		GridBagConstraints gbc_lblB_1 = new GridBagConstraints();
		gbc_lblB_1.anchor = GridBagConstraints.WEST;
		gbc_lblB_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblB_1.gridx = 1;
		gbc_lblB_1.gridy = 0;
		panel_1.add(lblB_1, gbc_lblB_1);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 0, 5);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 0;
		panel_1.add(textField_2, gbc_textField_2);
		textField_2.setText("80");
		textField_2.setColumns(2);
		
		JLabel label_3 = new JLabel("%");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 0;
		panel_1.add(label_3, gbc_label_3);
		
		JLabel lblC_1 = new JLabel("C:");
		GridBagConstraints gbc_lblC_1 = new GridBagConstraints();
		gbc_lblC_1.anchor = GridBagConstraints.WEST;
		gbc_lblC_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblC_1.gridx = 2;
		gbc_lblC_1.gridy = 0;
		panel_1.add(lblC_1, gbc_lblC_1);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 0, 5);
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 0;
		panel_1.add(textField_3, gbc_textField_3);
		textField_3.setText("70");
		textField_3.setColumns(2);
		
		JLabel label_2 = new JLabel("%");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 2;
		gbc_label_2.gridy = 0;
		panel_1.add(label_2, gbc_label_2);
		
		JLabel lblD_1 = new JLabel("D:");
		GridBagConstraints gbc_lblD_1 = new GridBagConstraints();
		gbc_lblD_1.anchor = GridBagConstraints.WEST;
		gbc_lblD_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblD_1.gridx = 3;
		gbc_lblD_1.gridy = 0;
		panel_1.add(lblD_1, gbc_lblD_1);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 0, 5);
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 0;
		panel_1.add(textField_4, gbc_textField_4);
		textField_4.setText("60");
		textField_4.setColumns(2);
		
		JLabel label = new JLabel("%");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 0;
		panel_1.add(label, gbc_label);
		
		JLabel lblF_1 = new JLabel("F:");
		GridBagConstraints gbc_lblF_1 = new GridBagConstraints();
		gbc_lblF_1.anchor = GridBagConstraints.WEST;
		gbc_lblF_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblF_1.gridx = 4;
		gbc_lblF_1.gridy = 0;
		panel_1.add(lblF_1, gbc_lblF_1);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 0, 5);
		gbc_textField_5.gridx = 4;
		gbc_textField_5.gridy = 0;
		panel_1.add(textField_5, gbc_textField_5);
		textField_5.setText("50");
		textField_5.setColumns(2);
		
		JLabel label_6 = new JLabel("%");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 0, 5);
		gbc_label_6.gridx = 4;
		gbc_label_6.gridy = 0;
		panel_1.add(label_6, gbc_label_6);
		
		JButton btnUpdate = new JButton("Update");
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.gridx = 5;
		gbc_btnUpdate.gridy = 0;
		panel_1.add(btnUpdate, gbc_btnUpdate);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setHgap(35);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		add(panel_2);
		
		JLabel lblA_2 = new JLabel("A: 20");
		panel_2.add(lblA_2);
		
		JLabel lblB_2 = new JLabel("B: 20");
		panel_2.add(lblB_2);
		
		JLabel lblC_2 = new JLabel("C: 20");
		panel_2.add(lblC_2);
		
		JLabel lblD_2 = new JLabel("D: 20");
		panel_2.add(lblD_2);
		
		JLabel lblF_2 = new JLabel("F: 20");
		panel_2.add(lblF_2);
		
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
