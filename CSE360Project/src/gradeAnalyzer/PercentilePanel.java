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
	private JTextField textField;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	public PercentilePanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{458, 0};
		gridBagLayout.rowHeights = new int[] {35, 45, 35, 45, 45, 35, 45, 45, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblGradeDistribution = new JLabel("Grade Distribution");
		lblGradeDistribution.setVerticalAlignment(SwingConstants.BOTTOM);
		lblGradeDistribution.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblGradeDistribution = new GridBagConstraints();
		gbc_lblGradeDistribution.anchor = GridBagConstraints.SOUTH;
		gbc_lblGradeDistribution.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblGradeDistribution.insets = new Insets(0, 5, 5, 0);
		gbc_lblGradeDistribution.gridx = 0;
		gbc_lblGradeDistribution.gridy = 0;
		add(lblGradeDistribution, gbc_lblGradeDistribution);
		
		JPanel pnlGradeDistribution = new JPanel();
		GridBagConstraints gbc_pnlGradeDistribution = new GridBagConstraints();
		gbc_pnlGradeDistribution.fill = GridBagConstraints.BOTH;
		gbc_pnlGradeDistribution.insets = new Insets(0, 0, 5, 0);
		gbc_pnlGradeDistribution.gridx = 0;
		gbc_pnlGradeDistribution.gridy = 1;
		add(pnlGradeDistribution, gbc_pnlGradeDistribution);
		GridBagLayout gbl_pnlGradeDistribution = new GridBagLayout();
		gbl_pnlGradeDistribution.columnWidths = new int[] {75, 75, 75, 75, 75, 75, 0};
		gbl_pnlGradeDistribution.rowHeights = new int[]{42, 0};
		gbl_pnlGradeDistribution.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlGradeDistribution.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlGradeDistribution.setLayout(gbl_pnlGradeDistribution);
		JLabel lblA = new JLabel();
		LetterPercentLabel(lblA, "A", 33);
		GridBagConstraints gbc_lblA = new GridBagConstraints();
		gbc_lblA.fill = GridBagConstraints.VERTICAL;
		gbc_lblA.insets = new Insets(0, 0, 0, 5);
		gbc_lblA.gridx = 0;
		gbc_lblA.gridy = 0;
		pnlGradeDistribution.add(lblA, gbc_lblA);
		
		JLabel lblB = new JLabel("B: 20%");
		GridBagConstraints gbc_lblB = new GridBagConstraints();
		gbc_lblB.fill = GridBagConstraints.VERTICAL;
		gbc_lblB.insets = new Insets(0, 0, 0, 5);
		gbc_lblB.gridx = 1;
		gbc_lblB.gridy = 0;
		pnlGradeDistribution.add(lblB, gbc_lblB);
		
		JLabel lblC = new JLabel("C: 20%");
		GridBagConstraints gbc_lblC = new GridBagConstraints();
		gbc_lblC.fill = GridBagConstraints.VERTICAL;
		gbc_lblC.insets = new Insets(0, 0, 0, 5);
		gbc_lblC.gridx = 2;
		gbc_lblC.gridy = 0;
		pnlGradeDistribution.add(lblC, gbc_lblC);
		
		JLabel lblD = new JLabel("D: 20%");
		GridBagConstraints gbc_lblD = new GridBagConstraints();
		gbc_lblD.fill = GridBagConstraints.VERTICAL;
		gbc_lblD.insets = new Insets(0, 0, 0, 5);
		gbc_lblD.gridx = 3;
		gbc_lblD.gridy = 0;
		pnlGradeDistribution.add(lblD, gbc_lblD);
		
		JLabel lblF = new JLabel("F: 20%");
		GridBagConstraints gbc_lblF = new GridBagConstraints();
		gbc_lblF.insets = new Insets(0, 0, 0, 5);
		gbc_lblF.fill = GridBagConstraints.VERTICAL;
		gbc_lblF.gridx = 4;
		gbc_lblF.gridy = 0;
		pnlGradeDistribution.add(lblF, gbc_lblF);
		
		JLabel lblGradeRange = new JLabel("Students in Each Grade Range");
		lblGradeRange.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblGradeRange = new GridBagConstraints();
		gbc_lblGradeRange.anchor = GridBagConstraints.SOUTH;
		gbc_lblGradeRange.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblGradeRange.insets = new Insets(0, 5, 5, 0);
		gbc_lblGradeRange.gridx = 0;
		gbc_lblGradeRange.gridy = 2;
		add(lblGradeRange, gbc_lblGradeRange);
		
		JPanel pnlSetGradeRange = new JPanel();
		GridBagConstraints gbc_pnlSetGradeRange = new GridBagConstraints();
		gbc_pnlSetGradeRange.fill = GridBagConstraints.BOTH;
		gbc_pnlSetGradeRange.insets = new Insets(0, 0, 5, 0);
		gbc_pnlSetGradeRange.gridx = 0;
		gbc_pnlSetGradeRange.gridy = 3;
		add(pnlSetGradeRange, gbc_pnlSetGradeRange);
		GridBagLayout gbl_pnlSetGradeRange = new GridBagLayout();
		gbl_pnlSetGradeRange.columnWidths = new int[] {75, 75, 75, 75, 75, 75, 0};
		gbl_pnlSetGradeRange.rowHeights = new int[] {42, 0};
		gbl_pnlSetGradeRange.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlSetGradeRange.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlSetGradeRange.setLayout(gbl_pnlSetGradeRange);
		
		JLabel lblA_1 = new JLabel("A:");
		GridBagConstraints gbc_lblA_1 = new GridBagConstraints();
		gbc_lblA_1.ipadx = 5;
		gbc_lblA_1.anchor = GridBagConstraints.WEST;
		gbc_lblA_1.insets = new Insets(0, 10, 0, 0);
		gbc_lblA_1.gridx = 0;
		gbc_lblA_1.gridy = 0;
		pnlSetGradeRange.add(lblA_1, gbc_lblA_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 0;
		pnlSetGradeRange.add(textField_1, gbc_textField_1);
		textField_1.setText("90");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(2);
		
		JLabel label_1 = new JLabel("%");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 0, 15);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		pnlSetGradeRange.add(label_1, gbc_label_1);
		
		JLabel lblB_1 = new JLabel("B:");
		GridBagConstraints gbc_lblB_1 = new GridBagConstraints();
		gbc_lblB_1.anchor = GridBagConstraints.WEST;
		gbc_lblB_1.insets = new Insets(0, 10, 0, 0);
		gbc_lblB_1.gridx = 1;
		gbc_lblB_1.gridy = 0;
		pnlSetGradeRange.add(lblB_1, gbc_lblB_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 0, 5);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 0;
		pnlSetGradeRange.add(textField_2, gbc_textField_2);
		textField_2.setText("80");
		textField_2.setColumns(2);
		
		JLabel label_3 = new JLabel("%");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 0, 15);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 0;
		pnlSetGradeRange.add(label_3, gbc_label_3);
		
		JLabel lblC_1 = new JLabel("C:");
		GridBagConstraints gbc_lblC_1 = new GridBagConstraints();
		gbc_lblC_1.anchor = GridBagConstraints.WEST;
		gbc_lblC_1.insets = new Insets(0, 10, 0, 0);
		gbc_lblC_1.gridx = 2;
		gbc_lblC_1.gridy = 0;
		pnlSetGradeRange.add(lblC_1, gbc_lblC_1);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 0, 5);
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 0;
		pnlSetGradeRange.add(textField_3, gbc_textField_3);
		textField_3.setText("70");
		textField_3.setColumns(2);
		
		JLabel label_2 = new JLabel("%");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 0, 15);
		gbc_label_2.gridx = 2;
		gbc_label_2.gridy = 0;
		pnlSetGradeRange.add(label_2, gbc_label_2);
		
		JLabel lblD_1 = new JLabel("D:");
		GridBagConstraints gbc_lblD_1 = new GridBagConstraints();
		gbc_lblD_1.anchor = GridBagConstraints.WEST;
		gbc_lblD_1.insets = new Insets(0, 10, 0, 0);
		gbc_lblD_1.gridx = 3;
		gbc_lblD_1.gridy = 0;
		pnlSetGradeRange.add(lblD_1, gbc_lblD_1);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 0, 5);
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 0;
		pnlSetGradeRange.add(textField_4, gbc_textField_4);
		textField_4.setText("60");
		textField_4.setColumns(2);
		
		JLabel label = new JLabel("%");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 0, 15);
		gbc_label.gridx = 3;
		gbc_label.gridy = 0;
		pnlSetGradeRange.add(label, gbc_label);
		
		JLabel lblF_1 = new JLabel("F:");
		GridBagConstraints gbc_lblF_1 = new GridBagConstraints();
		gbc_lblF_1.anchor = GridBagConstraints.WEST;
		gbc_lblF_1.insets = new Insets(0, 10, 0, 0);
		gbc_lblF_1.gridx = 4;
		gbc_lblF_1.gridy = 0;
		pnlSetGradeRange.add(lblF_1, gbc_lblF_1);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 0, 5);
		gbc_textField_5.gridx = 4;
		gbc_textField_5.gridy = 0;
		pnlSetGradeRange.add(textField_5, gbc_textField_5);
		textField_5.setText("50");
		textField_5.setColumns(2);
		
		JLabel label_6 = new JLabel("%");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 0, 15);
		gbc_label_6.gridx = 4;
		gbc_label_6.gridy = 0;
		pnlSetGradeRange.add(label_6, gbc_label_6);
		
		JButton btnUpdate = new JButton("Update");
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.gridx = 5;
		gbc_btnUpdate.gridy = 0;
		pnlSetGradeRange.add(btnUpdate, gbc_btnUpdate);
		
		JPanel pnlGiveGradeRange = new JPanel();
		GridBagConstraints gbc_pnlGiveGradeRange = new GridBagConstraints();
		gbc_pnlGiveGradeRange.fill = GridBagConstraints.BOTH;
		gbc_pnlGiveGradeRange.insets = new Insets(0, 0, 5, 0);
		gbc_pnlGiveGradeRange.gridx = 0;
		gbc_pnlGiveGradeRange.gridy = 4;
		add(pnlGiveGradeRange, gbc_pnlGiveGradeRange);
		GridBagLayout gbl_pnlGiveGradeRange = new GridBagLayout();
		gbl_pnlGiveGradeRange.columnWidths = new int[] {75, 75, 75, 75, 75, 75, 0};
		gbl_pnlGiveGradeRange.rowHeights = new int[] {42, 0};
		gbl_pnlGiveGradeRange.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlGiveGradeRange.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlGiveGradeRange.setLayout(gbl_pnlGiveGradeRange);
		
		JLabel lblA_2 = new JLabel("A: 20");
		GridBagConstraints gbc_lblA_2 = new GridBagConstraints();
		gbc_lblA_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblA_2.gridx = 0;
		gbc_lblA_2.gridy = 0;
		pnlGiveGradeRange.add(lblA_2, gbc_lblA_2);
		
		JLabel lblB_2 = new JLabel("B: 20");
		GridBagConstraints gbc_lblB_2 = new GridBagConstraints();
		gbc_lblB_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblB_2.gridx = 1;
		gbc_lblB_2.gridy = 0;
		pnlGiveGradeRange.add(lblB_2, gbc_lblB_2);
		
		JLabel lblC_2 = new JLabel("C: 20");
		GridBagConstraints gbc_lblC_2 = new GridBagConstraints();
		gbc_lblC_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblC_2.gridx = 2;
		gbc_lblC_2.gridy = 0;
		pnlGiveGradeRange.add(lblC_2, gbc_lblC_2);
		
		JLabel lblD_2 = new JLabel("D: 20");
		GridBagConstraints gbc_lblD_2 = new GridBagConstraints();
		gbc_lblD_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblD_2.gridx = 3;
		gbc_lblD_2.gridy = 0;
		pnlGiveGradeRange.add(lblD_2, gbc_lblD_2);
		
		JLabel lblF_2 = new JLabel("F: 20");
		GridBagConstraints gbc_lblF_2 = new GridBagConstraints();
		gbc_lblF_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblF_2.gridx = 4;
		gbc_lblF_2.gridy = 0;
		pnlGiveGradeRange.add(lblF_2, gbc_lblF_2);
		
		JLabel lblPercentile = new JLabel("Students in Each Percentile");
		lblPercentile.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblPercentile = new GridBagConstraints();
		gbc_lblPercentile.anchor = GridBagConstraints.SOUTH;
		gbc_lblPercentile.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPercentile.insets = new Insets(0, 5, 5, 0);
		gbc_lblPercentile.gridx = 0;
		gbc_lblPercentile.gridy = 5;
		add(lblPercentile, gbc_lblPercentile);
		
		JPanel pnlSetPercentile = new JPanel();
		GridBagConstraints gbc_pnlSetPercentile = new GridBagConstraints();
		gbc_pnlSetPercentile.fill = GridBagConstraints.BOTH;
		gbc_pnlSetPercentile.insets = new Insets(0, 0, 5, 0);
		gbc_pnlSetPercentile.gridx = 0;
		gbc_pnlSetPercentile.gridy = 6;
		add(pnlSetPercentile, gbc_pnlSetPercentile);
		GridBagLayout gbl_pnlSetPercentile = new GridBagLayout();
		gbl_pnlSetPercentile.columnWidths = new int[] {65, 10, 65, 55, 65, 10, 65, 0, 0};
		gbl_pnlSetPercentile.rowHeights = new int[] {42, 0};
		gbl_pnlSetPercentile.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlSetPercentile.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlSetPercentile.setLayout(gbl_pnlSetPercentile);
		
		JLabel lblTop = new JLabel("Top");
		GridBagConstraints gbc_lblTop = new GridBagConstraints();
		gbc_lblTop.anchor = GridBagConstraints.EAST;
		gbc_lblTop.insets = new Insets(0, 0, 0, 5);
		gbc_lblTop.gridx = 0;
		gbc_lblTop.gridy = 0;
		pnlSetPercentile.add(lblTop, gbc_lblTop);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("90");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		pnlSetPercentile.add(textField, gbc_textField);
		textField.setColumns(2);
		
		JLabel lblPercentile_1 = new JLabel("percentile");
		GridBagConstraints gbc_lblPercentile_1 = new GridBagConstraints();
		gbc_lblPercentile_1.anchor = GridBagConstraints.WEST;
		gbc_lblPercentile_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblPercentile_1.gridx = 2;
		gbc_lblPercentile_1.gridy = 0;
		pnlSetPercentile.add(lblPercentile_1, gbc_lblPercentile_1);
		
		JLabel lblBottom = new JLabel("Bottom");
		GridBagConstraints gbc_lblBottom = new GridBagConstraints();
		gbc_lblBottom.anchor = GridBagConstraints.EAST;
		gbc_lblBottom.insets = new Insets(0, 0, 0, 5);
		gbc_lblBottom.gridx = 4;
		gbc_lblBottom.gridy = 0;
		pnlSetPercentile.add(lblBottom, gbc_lblBottom);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setText("10");
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 0, 5);
		gbc_textField_6.gridx = 5;
		gbc_textField_6.gridy = 0;
		pnlSetPercentile.add(textField_6, gbc_textField_6);
		textField_6.setColumns(2);
		
		JLabel lblPercentile_2 = new JLabel("percentile");
		GridBagConstraints gbc_lblPercentile_2 = new GridBagConstraints();
		gbc_lblPercentile_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblPercentile_2.anchor = GridBagConstraints.WEST;
		gbc_lblPercentile_2.gridx = 6;
		gbc_lblPercentile_2.gridy = 0;
		pnlSetPercentile.add(lblPercentile_2, gbc_lblPercentile_2);
		
		JButton btnUpdate_1 = new JButton("Update");
		GridBagConstraints gbc_btnUpdate_1 = new GridBagConstraints();
		gbc_btnUpdate_1.gridx = 7;
		gbc_btnUpdate_1.gridy = 0;
		pnlSetPercentile.add(btnUpdate_1, gbc_btnUpdate_1);
		
		JPanel pnlGivePercentile = new JPanel();
		GridBagConstraints gbc_pnlGivePercentile = new GridBagConstraints();
		gbc_pnlGivePercentile.fill = GridBagConstraints.BOTH;
		gbc_pnlGivePercentile.gridx = 0;
		gbc_pnlGivePercentile.gridy = 7;
		add(pnlGivePercentile, gbc_pnlGivePercentile);
		GridBagLayout gbl_pnlGivePercentile = new GridBagLayout();
		gbl_pnlGivePercentile.columnWidths = new int[]{0};
		gbl_pnlGivePercentile.rowHeights = new int[]{0};
		gbl_pnlGivePercentile.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_pnlGivePercentile.rowWeights = new double[]{Double.MIN_VALUE};
		pnlGivePercentile.setLayout(gbl_pnlGivePercentile);

	}

	public void LetterPercentLabel(JLabel label, String letter, float percent) {
		label.setText("A: 20%");
	}
}
