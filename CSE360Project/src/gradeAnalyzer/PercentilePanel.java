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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
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
		// Main panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {450, 0};
		gridBagLayout.rowHeights = new int[] {20, 20, 30, 20, 20, 20, 20, 20, 30, 40, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		// Start Set Grade Score Ranges functional area. Edit text boxes and update button
		JLabel lblSetGradeScore = new JLabel("Set Grade Score Ranges");
		lblSetGradeScore.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblSetGradeScore = new GridBagConstraints();
		gbc_lblSetGradeScore.anchor = GridBagConstraints.SOUTH;
		gbc_lblSetGradeScore.insets = new Insets(0, 5, 5, 0);
		gbc_lblSetGradeScore.gridx = 0;
		gbc_lblSetGradeScore.gridy = 0;
		add(lblSetGradeScore, gbc_lblSetGradeScore);
		lblSetGradeScore.setHorizontalAlignment(SwingConstants.LEFT);
		// Panel for Set Max section
		JPanel pnlSetGradeRangeLabel = new JPanel();
		GridBagConstraints gbc_pnlSetGradeRangeLabel = new GridBagConstraints();
		gbc_pnlSetGradeRangeLabel.insets = new Insets(0, 0, 5, 0);
		gbc_pnlSetGradeRangeLabel.fill = GridBagConstraints.VERTICAL;
		gbc_pnlSetGradeRangeLabel.gridx = 0;
		gbc_pnlSetGradeRangeLabel.gridy = 1;
		add(pnlSetGradeRangeLabel, gbc_pnlSetGradeRangeLabel);
		GridBagLayout gbl_pnlSetGradeRangeLabel = new GridBagLayout();
		gbl_pnlSetGradeRangeLabel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlSetGradeRangeLabel.rowHeights = new int[]{14, 0};
		gbl_pnlSetGradeRangeLabel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlSetGradeRangeLabel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlSetGradeRangeLabel.setLayout(gbl_pnlSetGradeRangeLabel);
		// Label for Set max section
		JLabel lblSetMaxBased = new JLabel("Set Max based on:");
		GridBagConstraints gbc_lblSetMaxBased = new GridBagConstraints();
		gbc_lblSetMaxBased.anchor = GridBagConstraints.WEST;
		gbc_lblSetMaxBased.insets = new Insets(0, 5, 0, 5);
		gbc_lblSetMaxBased.gridx = 0;
		gbc_lblSetMaxBased.gridy = 0;
		pnlSetGradeRangeLabel.add(lblSetMaxBased, gbc_lblSetMaxBased);
		// Max possible button
		JButton btnPossible = new JButton("Possible");
		GridBagConstraints gbc_btnPossible = new GridBagConstraints();
		gbc_btnPossible.insets = new Insets(0, 0, 0, 5);
		gbc_btnPossible.gridx = 1;
		gbc_btnPossible.gridy = 0;
		pnlSetGradeRangeLabel.add(btnPossible, gbc_btnPossible);
		// Max earned button
		JButton btnEarned = new JButton("Earned");
		GridBagConstraints gbc_btnEarned = new GridBagConstraints();
		gbc_btnEarned.gridx = 2;
		gbc_btnEarned.gridy = 0;
		pnlSetGradeRangeLabel.add(btnEarned, gbc_btnEarned);
		// Custom set grade range section
		JPanel pnlSetGradeRange = new JPanel();
		GridBagConstraints gbc_pnlSetGradeRange = new GridBagConstraints();
		gbc_pnlSetGradeRange.anchor = GridBagConstraints.NORTH;
		gbc_pnlSetGradeRange.insets = new Insets(0, 0, 5, 0);
		gbc_pnlSetGradeRange.gridx = 0;
		gbc_pnlSetGradeRange.gridy = 2;
		add(pnlSetGradeRange, gbc_pnlSetGradeRange);
		GridBagLayout gbl_pnlSetGradeRange = new GridBagLayout();
		gbl_pnlSetGradeRange.columnWidths = new int[] {75, 75, 75, 75, 75, 75, 0};
		gbl_pnlSetGradeRange.rowHeights = new int[] {40, 0};
		gbl_pnlSetGradeRange.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlSetGradeRange.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlSetGradeRange.setLayout(gbl_pnlSetGradeRange);
		// Custom set grade range section - A
		JLabel lblA_1 = new JLabel("A:");
		GridBagConstraints gbc_lblA_1 = new GridBagConstraints();
		gbc_lblA_1.ipadx = 5;
		gbc_lblA_1.anchor = GridBagConstraints.WEST;
		gbc_lblA_1.insets = new Insets(0, 10, 0, 0);
		gbc_lblA_1.gridx = 0;
		gbc_lblA_1.gridy = 0;
		pnlSetGradeRange.add(lblA_1, gbc_lblA_1);
		// Custom set grade range section - A text field
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 0;
		pnlSetGradeRange.add(textField_1, gbc_textField_1);
		textField_1.setText("90");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(2);
		// Custom set grade range section - A %
		JLabel label_1 = new JLabel("%");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 0, 15);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		pnlSetGradeRange.add(label_1, gbc_label_1);
		// Custom set grade range section - B
		JLabel lblB_1 = new JLabel("B:");
		GridBagConstraints gbc_lblB_1 = new GridBagConstraints();
		gbc_lblB_1.anchor = GridBagConstraints.WEST;
		gbc_lblB_1.insets = new Insets(0, 10, 0, 0);
		gbc_lblB_1.gridx = 1;
		gbc_lblB_1.gridy = 0;
		pnlSetGradeRange.add(lblB_1, gbc_lblB_1);
		// Custom set grade range section - B text field
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 0, 5);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 0;
		pnlSetGradeRange.add(textField_2, gbc_textField_2);
		textField_2.setText("80");
		textField_2.setColumns(2);
		// Custom set grade range section - B %
		JLabel label_3 = new JLabel("%");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 0, 15);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 0;
		pnlSetGradeRange.add(label_3, gbc_label_3);
		// Custom set grade range section - C
		JLabel lblC_1 = new JLabel("C:");
		GridBagConstraints gbc_lblC_1 = new GridBagConstraints();
		gbc_lblC_1.anchor = GridBagConstraints.WEST;
		gbc_lblC_1.insets = new Insets(0, 10, 0, 0);
		gbc_lblC_1.gridx = 2;
		gbc_lblC_1.gridy = 0;
		pnlSetGradeRange.add(lblC_1, gbc_lblC_1);
		// Custom set grade range section - C text field
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 0, 5);
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 0;
		pnlSetGradeRange.add(textField_3, gbc_textField_3);
		textField_3.setText("70");
		textField_3.setColumns(2);
		// Custom set grade range section - C %
		JLabel label_2 = new JLabel("%");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 0, 15);
		gbc_label_2.gridx = 2;
		gbc_label_2.gridy = 0;
		pnlSetGradeRange.add(label_2, gbc_label_2);
		// Custom set grade range section - D
		JLabel lblD_1 = new JLabel("D:");
		GridBagConstraints gbc_lblD_1 = new GridBagConstraints();
		gbc_lblD_1.anchor = GridBagConstraints.WEST;
		gbc_lblD_1.insets = new Insets(0, 10, 0, 0);
		gbc_lblD_1.gridx = 3;
		gbc_lblD_1.gridy = 0;
		pnlSetGradeRange.add(lblD_1, gbc_lblD_1);
		// Custom set grade range section - D text field
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 0, 5);
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 0;
		pnlSetGradeRange.add(textField_4, gbc_textField_4);
		textField_4.setText("60");
		textField_4.setColumns(2);
		// Custom set grade range section - D %
		JLabel label = new JLabel("%");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 0, 15);
		gbc_label.gridx = 3;
		gbc_label.gridy = 0;
		pnlSetGradeRange.add(label, gbc_label);
		// Custom set grade range section - F
		JLabel lblF_1 = new JLabel("F:");
		GridBagConstraints gbc_lblF_1 = new GridBagConstraints();
		gbc_lblF_1.anchor = GridBagConstraints.WEST;
		gbc_lblF_1.insets = new Insets(0, 10, 0, 0);
		gbc_lblF_1.gridx = 4;
		gbc_lblF_1.gridy = 0;
		pnlSetGradeRange.add(lblF_1, gbc_lblF_1);
		// Custom set grade range section - F text field
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 0, 5);
		gbc_textField_5.gridx = 4;
		gbc_textField_5.gridy = 0;
		pnlSetGradeRange.add(textField_5, gbc_textField_5);
		textField_5.setText("50");
		textField_5.setColumns(2);
		// Custom set grade range section - F %
		JLabel label_6 = new JLabel("%");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 0, 15);
		gbc_label_6.gridx = 4;
		gbc_label_6.gridy = 0;
		pnlSetGradeRange.add(label_6, gbc_label_6);
		// Custom set grade range section - Update button
		JButton btnUpdate = new JButton("Update");
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.gridx = 5;
		gbc_btnUpdate.gridy = 0;
		pnlSetGradeRange.add(btnUpdate, gbc_btnUpdate);
		// End Grade Score Ranges functional area
		
		// Label for Grade Distribution
		JLabel lblGradeDistribution = new JLabel("Grade Distribution");
		lblGradeDistribution.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGradeDistribution.setVerticalAlignment(SwingConstants.BOTTOM);
		lblGradeDistribution.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblGradeDistribution = new GridBagConstraints();
		gbc_lblGradeDistribution.anchor = GridBagConstraints.SOUTH;
		gbc_lblGradeDistribution.insets = new Insets(0, 5, 5, 0);
		gbc_lblGradeDistribution.gridx = 0;
		gbc_lblGradeDistribution.gridy = 3;
		add(lblGradeDistribution, gbc_lblGradeDistribution);
		
		// Grade Distribution Results - Panel
		JPanel pnlGradeDistribution = new JPanel();
		GridBagConstraints gbc_pnlGradeDistribution = new GridBagConstraints();
		gbc_pnlGradeDistribution.anchor = GridBagConstraints.NORTH;
		gbc_pnlGradeDistribution.insets = new Insets(0, 0, 5, 0);
		gbc_pnlGradeDistribution.gridx = 0;
		gbc_pnlGradeDistribution.gridy = 4;
		add(pnlGradeDistribution, gbc_pnlGradeDistribution);
		GridBagLayout gbl_pnlGradeDistribution = new GridBagLayout();
		gbl_pnlGradeDistribution.columnWidths = new int[] {75, 75, 75, 75, 75, 75, 0};
		gbl_pnlGradeDistribution.rowHeights = new int[] {40, 0};
		gbl_pnlGradeDistribution.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlGradeDistribution.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlGradeDistribution.setLayout(gbl_pnlGradeDistribution);
		// Grade Distribution Results - A
		JLabel lblA = new JLabel();
		LetterPercentLabel(lblA, "A", 33);
		GridBagConstraints gbc_lblA = new GridBagConstraints();
		gbc_lblA.fill = GridBagConstraints.VERTICAL;
		gbc_lblA.insets = new Insets(0, 0, 0, 5);
		gbc_lblA.gridx = 0;
		gbc_lblA.gridy = 0;
		pnlGradeDistribution.add(lblA, gbc_lblA);
		// Grade Distribution Results - B
		JLabel lblB = new JLabel("B: 20%");
		GridBagConstraints gbc_lblB = new GridBagConstraints();
		gbc_lblB.fill = GridBagConstraints.VERTICAL;
		gbc_lblB.insets = new Insets(0, 0, 0, 5);
		gbc_lblB.gridx = 1;
		gbc_lblB.gridy = 0;
		pnlGradeDistribution.add(lblB, gbc_lblB);
		// Grade Distribution Results - C
		JLabel lblC = new JLabel("C: 20%");
		GridBagConstraints gbc_lblC = new GridBagConstraints();
		gbc_lblC.fill = GridBagConstraints.VERTICAL;
		gbc_lblC.insets = new Insets(0, 0, 0, 5);
		gbc_lblC.gridx = 2;
		gbc_lblC.gridy = 0;
		pnlGradeDistribution.add(lblC, gbc_lblC);
		// Grade Distribution Results - D
		JLabel lblD = new JLabel("D: 20%");
		GridBagConstraints gbc_lblD = new GridBagConstraints();
		gbc_lblD.fill = GridBagConstraints.VERTICAL;
		gbc_lblD.insets = new Insets(0, 0, 0, 5);
		gbc_lblD.gridx = 3;
		gbc_lblD.gridy = 0;
		pnlGradeDistribution.add(lblD, gbc_lblD);
		// Grade Distribution Results - F
		JLabel lblF = new JLabel("F: 20%");
		GridBagConstraints gbc_lblF = new GridBagConstraints();
		gbc_lblF.insets = new Insets(0, 0, 0, 5);
		gbc_lblF.fill = GridBagConstraints.VERTICAL;
		gbc_lblF.gridx = 4;
		gbc_lblF.gridy = 0;
		pnlGradeDistribution.add(lblF, gbc_lblF);
		
		JLabel lblGradeRange = new JLabel("Students in Each Grade Range");
		lblGradeRange.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGradeRange.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblGradeRange = new GridBagConstraints();
		gbc_lblGradeRange.anchor = GridBagConstraints.SOUTH;
		gbc_lblGradeRange.insets = new Insets(0, 5, 5, 0);
		gbc_lblGradeRange.gridx = 0;
		gbc_lblGradeRange.gridy = 5;
		add(lblGradeRange, gbc_lblGradeRange);
		
				
		JPanel pnlGiveGradeRange = new JPanel();
		GridBagConstraints gbc_pnlGiveGradeRange = new GridBagConstraints();
		gbc_pnlGiveGradeRange.anchor = GridBagConstraints.NORTH;
		gbc_pnlGiveGradeRange.insets = new Insets(0, 0, 5, 0);
		gbc_pnlGiveGradeRange.gridx = 0;
		gbc_pnlGiveGradeRange.gridy = 6;
		add(pnlGiveGradeRange, gbc_pnlGiveGradeRange);
		GridBagLayout gbl_pnlGiveGradeRange = new GridBagLayout();
		gbl_pnlGiveGradeRange.columnWidths = new int[] {75, 75, 75, 75, 75, 75, 0};
		gbl_pnlGiveGradeRange.rowHeights = new int[] {40, 0};
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
		lblPercentile.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPercentile.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblPercentile = new GridBagConstraints();
		gbc_lblPercentile.anchor = GridBagConstraints.SOUTH;
		gbc_lblPercentile.insets = new Insets(0, 5, 5, 0);
		gbc_lblPercentile.gridx = 0;
		gbc_lblPercentile.gridy = 7;
		add(lblPercentile, gbc_lblPercentile);
		
		JPanel pnlSetPercentile = new JPanel();
		GridBagConstraints gbc_pnlSetPercentile = new GridBagConstraints();
		gbc_pnlSetPercentile.anchor = GridBagConstraints.NORTH;
		gbc_pnlSetPercentile.insets = new Insets(0, 0, 5, 0);
		gbc_pnlSetPercentile.gridx = 0;
		gbc_pnlSetPercentile.gridy = 8;
		add(pnlSetPercentile, gbc_pnlSetPercentile);
		GridBagLayout gbl_pnlSetPercentile = new GridBagLayout();
		gbl_pnlSetPercentile.columnWidths = new int[] {65, 30, 65, 50, 65, 30, 65, 0, 0};
		gbl_pnlSetPercentile.rowHeights = new int[] {40, 0};
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
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
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
		gbc_btnUpdate_1.insets = new Insets(0, 8, 0, 0);
		gbc_btnUpdate_1.gridx = 7;
		gbc_btnUpdate_1.gridy = 0;
		pnlSetPercentile.add(btnUpdate_1, gbc_btnUpdate_1);
		
		JPanel pnlGivePercentile = new JPanel();
		GridBagConstraints gbc_pnlGivePercentile = new GridBagConstraints();
		gbc_pnlGivePercentile.anchor = GridBagConstraints.NORTH;
		gbc_pnlGivePercentile.gridx = 0;
		gbc_pnlGivePercentile.gridy = 9;
		add(pnlGivePercentile, gbc_pnlGivePercentile);
		GridBagLayout gbl_pnlGivePercentile = new GridBagLayout();
		gbl_pnlGivePercentile.columnWidths = new int[] {90, 50, 55, 90, 50, 0};
		gbl_pnlGivePercentile.rowHeights = new int[] {20, 20, 0};
		gbl_pnlGivePercentile.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlGivePercentile.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlGivePercentile.setLayout(gbl_pnlGivePercentile);
		
		JLabel lblScoreAbove = new JLabel("Score above ");
		GridBagConstraints gbc_lblScoreAbove = new GridBagConstraints();
		gbc_lblScoreAbove.anchor = GridBagConstraints.WEST;
		gbc_lblScoreAbove.insets = new Insets(0, 0, 5, 5);
		gbc_lblScoreAbove.gridx = 0;
		gbc_lblScoreAbove.gridy = 0;
		pnlGivePercentile.add(lblScoreAbove, gbc_lblScoreAbove);
		
		JLabel label_4 = new JLabel("89%");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.WEST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 0;
		pnlGivePercentile.add(label_4, gbc_label_4);
		
		JLabel lblScoreBelow = new JLabel("Score below");
		GridBagConstraints gbc_lblScoreBelow = new GridBagConstraints();
		gbc_lblScoreBelow.anchor = GridBagConstraints.WEST;
		gbc_lblScoreBelow.insets = new Insets(0, 0, 5, 5);
		gbc_lblScoreBelow.gridx = 3;
		gbc_lblScoreBelow.gridy = 0;
		pnlGivePercentile.add(lblScoreBelow, gbc_lblScoreBelow);
		
		JLabel label_7 = new JLabel("31%");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.anchor = GridBagConstraints.WEST;
		gbc_label_7.insets = new Insets(0, 0, 5, 0);
		gbc_label_7.gridx = 4;
		gbc_label_7.gridy = 0;
		pnlGivePercentile.add(label_7, gbc_label_7);
		
		JLabel lblStudentsAbove = new JLabel("Students above");
		GridBagConstraints gbc_lblStudentsAbove = new GridBagConstraints();
		gbc_lblStudentsAbove.anchor = GridBagConstraints.WEST;
		gbc_lblStudentsAbove.insets = new Insets(0, 0, 0, 5);
		gbc_lblStudentsAbove.gridx = 0;
		gbc_lblStudentsAbove.gridy = 1;
		pnlGivePercentile.add(lblStudentsAbove, gbc_lblStudentsAbove);
		
		JLabel label_5 = new JLabel("18");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.WEST;
		gbc_label_5.insets = new Insets(0, 0, 0, 5);
		gbc_label_5.gridx = 1;
		gbc_label_5.gridy = 1;
		pnlGivePercentile.add(label_5, gbc_label_5);
		
		JLabel lblStudentsBelow = new JLabel("Students below");
		GridBagConstraints gbc_lblStudentsBelow = new GridBagConstraints();
		gbc_lblStudentsBelow.anchor = GridBagConstraints.WEST;
		gbc_lblStudentsBelow.insets = new Insets(0, 0, 0, 5);
		gbc_lblStudentsBelow.gridx = 3;
		gbc_lblStudentsBelow.gridy = 1;
		pnlGivePercentile.add(lblStudentsBelow, gbc_lblStudentsBelow);
		
		JLabel label_8 = new JLabel("21");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.anchor = GridBagConstraints.WEST;
		gbc_label_8.gridx = 4;
		gbc_label_8.gridy = 1;
		pnlGivePercentile.add(label_8, gbc_label_8);

	}

	public void LetterPercentLabel(JLabel label, String letter, float percent) {
		label.setText("A: 20%");
	}
}
