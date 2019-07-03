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
	private JTextField txtSetGradeC;
	private JTextField txtSetGradeD;
	private JTextField txtSetGradeA;
	private JTextField txtSetGradeB;
	private JTextField txtSetGradeF;
	private JTextField textField;
	private JTextField textField_6;

	/**
	 * GUI for the Percentile Panel
	 */
	public PercentilePanel() {
		// Main panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {450, 0};
		gridBagLayout.rowHeights = new int[] {20, 20, 30, 20, 20, 20, 20, 20, 30, 40};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		// Start "Set Grade Score Ranges" functional area. 
		// Section allows edit text boxes and update button
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
		JLabel lblSetGradeA = new JLabel("A:");
		GridBagConstraints gbc_lblSetGradeA = new GridBagConstraints();
		gbc_lblSetGradeA.ipadx = 5;
		gbc_lblSetGradeA.anchor = GridBagConstraints.WEST;
		gbc_lblSetGradeA.insets = new Insets(0, 10, 0, 0);
		gbc_lblSetGradeA.gridx = 0;
		gbc_lblSetGradeA.gridy = 0;
		pnlSetGradeRange.add(lblSetGradeA, gbc_lblSetGradeA);
		// Custom set grade range section - A text field
		txtSetGradeA = new JTextField();
		GridBagConstraints gbc_txtSetGradeA = new GridBagConstraints();
		gbc_txtSetGradeA.insets = new Insets(0, 0, 0, 5);
		gbc_txtSetGradeA.gridx = 0;
		gbc_txtSetGradeA.gridy = 0;
		pnlSetGradeRange.add(txtSetGradeA, gbc_txtSetGradeA);
		txtSetGradeA.setText("90");
		txtSetGradeA.setHorizontalAlignment(SwingConstants.CENTER);
		txtSetGradeA.setColumns(2);
		// Custom set grade range section - A %
		JLabel lblSetGradeAPercent = new JLabel("%");
		GridBagConstraints gbc_lblSetGradeAPercent = new GridBagConstraints();
		gbc_lblSetGradeAPercent.anchor = GridBagConstraints.EAST;
		gbc_lblSetGradeAPercent.insets = new Insets(0, 0, 0, 15);
		gbc_lblSetGradeAPercent.gridx = 0;
		gbc_lblSetGradeAPercent.gridy = 0;
		pnlSetGradeRange.add(lblSetGradeAPercent, gbc_lblSetGradeAPercent);
		// Custom set grade range section - B
		JLabel lblSetGradeB = new JLabel("B:");
		GridBagConstraints gbc_lblSetGradeB = new GridBagConstraints();
		gbc_lblSetGradeB.anchor = GridBagConstraints.WEST;
		gbc_lblSetGradeB.insets = new Insets(0, 10, 0, 0);
		gbc_lblSetGradeB.gridx = 1;
		gbc_lblSetGradeB.gridy = 0;
		pnlSetGradeRange.add(lblSetGradeB, gbc_lblSetGradeB);
		// Custom set grade range section - B text field
		txtSetGradeB = new JTextField();
		txtSetGradeB.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_txtSetGradeB = new GridBagConstraints();
		gbc_txtSetGradeB.insets = new Insets(0, 0, 0, 5);
		gbc_txtSetGradeB.gridx = 1;
		gbc_txtSetGradeB.gridy = 0;
		pnlSetGradeRange.add(txtSetGradeB, gbc_txtSetGradeB);
		txtSetGradeB.setText("80");
		txtSetGradeB.setColumns(2);
		// Custom set grade range section - B %
		JLabel lblSetGradeBPercent = new JLabel("%");
		GridBagConstraints gbc_lblSetGradeBPercent = new GridBagConstraints();
		gbc_lblSetGradeBPercent.anchor = GridBagConstraints.EAST;
		gbc_lblSetGradeBPercent.insets = new Insets(0, 0, 0, 15);
		gbc_lblSetGradeBPercent.gridx = 1;
		gbc_lblSetGradeBPercent.gridy = 0;
		pnlSetGradeRange.add(lblSetGradeBPercent, gbc_lblSetGradeBPercent);
		// Custom set grade range section - C
		JLabel lblSetGradeC = new JLabel("C:");
		GridBagConstraints gbc_lblSetGradeC = new GridBagConstraints();
		gbc_lblSetGradeC.anchor = GridBagConstraints.WEST;
		gbc_lblSetGradeC.insets = new Insets(0, 10, 0, 0);
		gbc_lblSetGradeC.gridx = 2;
		gbc_lblSetGradeC.gridy = 0;
		pnlSetGradeRange.add(lblSetGradeC, gbc_lblSetGradeC);
		// Custom set grade range section - C text field
		txtSetGradeC = new JTextField();
		txtSetGradeC.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_txtSetGradeC = new GridBagConstraints();
		gbc_txtSetGradeC.insets = new Insets(0, 0, 0, 5);
		gbc_txtSetGradeC.gridx = 2;
		gbc_txtSetGradeC.gridy = 0;
		pnlSetGradeRange.add(txtSetGradeC, gbc_txtSetGradeC);
		txtSetGradeC.setText("70");
		txtSetGradeC.setColumns(2);
		// Custom set grade range section - C %
		JLabel lblSetGradeCPercent = new JLabel("%");
		GridBagConstraints gbc_lblSetGradeCPercent = new GridBagConstraints();
		gbc_lblSetGradeCPercent.anchor = GridBagConstraints.EAST;
		gbc_lblSetGradeCPercent.insets = new Insets(0, 0, 0, 15);
		gbc_lblSetGradeCPercent.gridx = 2;
		gbc_lblSetGradeCPercent.gridy = 0;
		pnlSetGradeRange.add(lblSetGradeCPercent, gbc_lblSetGradeCPercent);
		// Custom set grade range section - D
		JLabel lblSetGradeD = new JLabel("D:");
		GridBagConstraints gbc_lblSetGradeD = new GridBagConstraints();
		gbc_lblSetGradeD.anchor = GridBagConstraints.WEST;
		gbc_lblSetGradeD.insets = new Insets(0, 10, 0, 0);
		gbc_lblSetGradeD.gridx = 3;
		gbc_lblSetGradeD.gridy = 0;
		pnlSetGradeRange.add(lblSetGradeD, gbc_lblSetGradeD);
		// Custom set grade range section - D text field
		txtSetGradeD = new JTextField();
		txtSetGradeD.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_txtSetGradeD = new GridBagConstraints();
		gbc_txtSetGradeD.insets = new Insets(0, 0, 0, 5);
		gbc_txtSetGradeD.gridx = 3;
		gbc_txtSetGradeD.gridy = 0;
		pnlSetGradeRange.add(txtSetGradeD, gbc_txtSetGradeD);
		txtSetGradeD.setText("60");
		txtSetGradeD.setColumns(2);
		// Custom set grade range section - D %
		JLabel lblSetGradeDPercent = new JLabel("%");
		GridBagConstraints gbc_lblSetGradeDPercent = new GridBagConstraints();
		gbc_lblSetGradeDPercent.anchor = GridBagConstraints.EAST;
		gbc_lblSetGradeDPercent.insets = new Insets(0, 0, 0, 15);
		gbc_lblSetGradeDPercent.gridx = 3;
		gbc_lblSetGradeDPercent.gridy = 0;
		pnlSetGradeRange.add(lblSetGradeDPercent, gbc_lblSetGradeDPercent);
		// Custom set grade range section - F
		JLabel lblSetGradeF = new JLabel("F:");
		GridBagConstraints gbc_lblSetGradeF = new GridBagConstraints();
		gbc_lblSetGradeF.anchor = GridBagConstraints.WEST;
		gbc_lblSetGradeF.insets = new Insets(0, 10, 0, 0);
		gbc_lblSetGradeF.gridx = 4;
		gbc_lblSetGradeF.gridy = 0;
		pnlSetGradeRange.add(lblSetGradeF, gbc_lblSetGradeF);
		// Custom set grade range section - F text field
		txtSetGradeF = new JTextField();
		txtSetGradeF.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_txtSetGradeF = new GridBagConstraints();
		gbc_txtSetGradeF.insets = new Insets(0, 0, 0, 5);
		gbc_txtSetGradeF.gridx = 4;
		gbc_txtSetGradeF.gridy = 0;
		pnlSetGradeRange.add(txtSetGradeF, gbc_txtSetGradeF);
		txtSetGradeF.setText("50");
		txtSetGradeF.setColumns(2);
		// Custom set grade range section - F %
		JLabel lblSetGradeFPercent = new JLabel("%");
		GridBagConstraints gbc_lblSetGradeFPercent = new GridBagConstraints();
		gbc_lblSetGradeFPercent.anchor = GridBagConstraints.EAST;
		gbc_lblSetGradeFPercent.insets = new Insets(0, 0, 0, 15);
		gbc_lblSetGradeFPercent.gridx = 4;
		gbc_lblSetGradeFPercent.gridy = 0;
		pnlSetGradeRange.add(lblSetGradeFPercent, gbc_lblSetGradeFPercent);
		// Custom set grade range section - Update button
		JButton btnSetGradeUpdate = new JButton("Update");
		GridBagConstraints gbc_btnSetGradeUpdate = new GridBagConstraints();
		gbc_btnSetGradeUpdate.gridx = 5;
		gbc_btnSetGradeUpdate.gridy = 0;
		pnlSetGradeRange.add(btnSetGradeUpdate, gbc_btnSetGradeUpdate);
		// End Grade Score Ranges functional area
		
		// Label for "Grade Distribution"
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
		
		// Label for "Students in Each Grade Range"
		JLabel lblGradeRange = new JLabel("Students in Each Grade Range");
		lblGradeRange.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGradeRange.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblGradeRange = new GridBagConstraints();
		gbc_lblGradeRange.anchor = GridBagConstraints.SOUTH;
		gbc_lblGradeRange.insets = new Insets(0, 5, 5, 0);
		gbc_lblGradeRange.gridx = 0;
		gbc_lblGradeRange.gridy = 5;
		add(lblGradeRange, gbc_lblGradeRange);
		
		// Starts "Display Students in Each Grade Range"
		// Displays number of students in each grade range
		JPanel pnlStudentsPerGrade = new JPanel();
		GridBagConstraints gbc_pnlStudentsPerGrade = new GridBagConstraints();
		gbc_pnlStudentsPerGrade.anchor = GridBagConstraints.NORTH;
		gbc_pnlStudentsPerGrade.insets = new Insets(0, 0, 5, 0);
		gbc_pnlStudentsPerGrade.gridx = 0;
		gbc_pnlStudentsPerGrade.gridy = 6;
		add(pnlStudentsPerGrade, gbc_pnlStudentsPerGrade);
		GridBagLayout gbl_pnlStudentsPerGrade = new GridBagLayout();
		gbl_pnlStudentsPerGrade.columnWidths = new int[] {75, 75, 75, 75, 75, 75, 0};
		gbl_pnlStudentsPerGrade.rowHeights = new int[] {40, 0};
		gbl_pnlStudentsPerGrade.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlStudentsPerGrade.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlStudentsPerGrade.setLayout(gbl_pnlStudentsPerGrade);
		// Displays Students in A
		JLabel lblA_2 = new JLabel("A: 20");
		GridBagConstraints gbc_lblA_2 = new GridBagConstraints();
		gbc_lblA_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblA_2.gridx = 0;
		gbc_lblA_2.gridy = 0;
		pnlStudentsPerGrade.add(lblA_2, gbc_lblA_2);
		// Displays Students in B
		JLabel lblB_2 = new JLabel("B: 20");
		GridBagConstraints gbc_lblB_2 = new GridBagConstraints();
		gbc_lblB_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblB_2.gridx = 1;
		gbc_lblB_2.gridy = 0;
		pnlStudentsPerGrade.add(lblB_2, gbc_lblB_2);
		// Displays Students in C
		JLabel lblC_2 = new JLabel("C: 20");
		GridBagConstraints gbc_lblC_2 = new GridBagConstraints();
		gbc_lblC_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblC_2.gridx = 2;
		gbc_lblC_2.gridy = 0;
		pnlStudentsPerGrade.add(lblC_2, gbc_lblC_2);
		// Displays Students in D
		JLabel lblD_2 = new JLabel("D: 20");
		GridBagConstraints gbc_lblD_2 = new GridBagConstraints();
		gbc_lblD_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblD_2.gridx = 3;
		gbc_lblD_2.gridy = 0;
		pnlStudentsPerGrade.add(lblD_2, gbc_lblD_2);
		// Displays Students in F
		JLabel lblF_2 = new JLabel("F: 20");
		GridBagConstraints gbc_lblF_2 = new GridBagConstraints();
		gbc_lblF_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblF_2.gridx = 4;
		gbc_lblF_2.gridy = 0;
		pnlStudentsPerGrade.add(lblF_2, gbc_lblF_2);
		// End Students in each percentile
		
		// Start "Students in Each Percentile"
		// Label for "Students in Each Percentile"
		JLabel lblPercentile = new JLabel("Students in Each Percentile");
		lblPercentile.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPercentile.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblPercentile = new GridBagConstraints();
		gbc_lblPercentile.anchor = GridBagConstraints.SOUTH;
		gbc_lblPercentile.insets = new Insets(0, 5, 5, 0);
		gbc_lblPercentile.gridx = 0;
		gbc_lblPercentile.gridy = 7;
		add(lblPercentile, gbc_lblPercentile);
		// Start user input section
		// Percentile Input Panel
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
		// Top Percentile Input - Top label
		JLabel lblTop = new JLabel("Top");
		GridBagConstraints gbc_lblTop = new GridBagConstraints();
		gbc_lblTop.anchor = GridBagConstraints.EAST;
		gbc_lblTop.insets = new Insets(0, 0, 0, 5);
		gbc_lblTop.gridx = 0;
		gbc_lblTop.gridy = 0;
		pnlSetPercentile.add(lblTop, gbc_lblTop);
		// Top Percentile Input - Top text field
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
		// Top Percentile Input - Percentile label
		JLabel lblPercentile_1 = new JLabel("percentile");
		GridBagConstraints gbc_lblPercentile_1 = new GridBagConstraints();
		gbc_lblPercentile_1.anchor = GridBagConstraints.WEST;
		gbc_lblPercentile_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblPercentile_1.gridx = 2;
		gbc_lblPercentile_1.gridy = 0;
		pnlSetPercentile.add(lblPercentile_1, gbc_lblPercentile_1);
		// Bottom Percentile Input - Bottom label
		JLabel lblBottom = new JLabel("Bottom");
		GridBagConstraints gbc_lblBottom = new GridBagConstraints();
		gbc_lblBottom.anchor = GridBagConstraints.EAST;
		gbc_lblBottom.insets = new Insets(0, 0, 0, 5);
		gbc_lblBottom.gridx = 4;
		gbc_lblBottom.gridy = 0;
		pnlSetPercentile.add(lblBottom, gbc_lblBottom);
		// Bottom Percentile Input - Bottom text field
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setText("10");
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 0, 5);
		gbc_textField_6.gridx = 5;
		gbc_textField_6.gridy = 0;
		pnlSetPercentile.add(textField_6, gbc_textField_6);
		textField_6.setColumns(2);
		// Bottom Percentile Input - Percentile label
		JLabel lblPercentile_2 = new JLabel("percentile");
		GridBagConstraints gbc_lblPercentile_2 = new GridBagConstraints();
		gbc_lblPercentile_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblPercentile_2.anchor = GridBagConstraints.WEST;
		gbc_lblPercentile_2.gridx = 6;
		gbc_lblPercentile_2.gridy = 0;
		pnlSetPercentile.add(lblPercentile_2, gbc_lblPercentile_2);
		// Percentile Input - Update button
		JButton btnUpdate_1 = new JButton("Update");
		GridBagConstraints gbc_btnUpdate_1 = new GridBagConstraints();
		gbc_btnUpdate_1.insets = new Insets(0, 8, 0, 0);
		gbc_btnUpdate_1.gridx = 7;
		gbc_btnUpdate_1.gridy = 0;
		pnlSetPercentile.add(btnUpdate_1, gbc_btnUpdate_1);
		// Percentile Display - Panel
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
		// Percentile Display - Score above - "Score above" label
		JLabel lblScoreAbove = new JLabel("Score above ");
		GridBagConstraints gbc_lblScoreAbove = new GridBagConstraints();
		gbc_lblScoreAbove.anchor = GridBagConstraints.WEST;
		gbc_lblScoreAbove.insets = new Insets(0, 0, 5, 5);
		gbc_lblScoreAbove.gridx = 0;
		gbc_lblScoreAbove.gridy = 0;
		pnlGivePercentile.add(lblScoreAbove, gbc_lblScoreAbove);
		// Percentile Display - Score above - Above score
		JLabel label_4 = new JLabel("89%");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.WEST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 0;
		pnlGivePercentile.add(label_4, gbc_label_4);
		// Percentile Display - Score below - "Score below" label
		JLabel lblScoreBelow = new JLabel("Score below");
		GridBagConstraints gbc_lblScoreBelow = new GridBagConstraints();
		gbc_lblScoreBelow.anchor = GridBagConstraints.WEST;
		gbc_lblScoreBelow.insets = new Insets(0, 0, 5, 5);
		gbc_lblScoreBelow.gridx = 3;
		gbc_lblScoreBelow.gridy = 0;
		pnlGivePercentile.add(lblScoreBelow, gbc_lblScoreBelow);
		// Percentile Display - Score below - Below score
		JLabel label_7 = new JLabel("31%");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.anchor = GridBagConstraints.WEST;
		gbc_label_7.insets = new Insets(0, 0, 5, 0);
		gbc_label_7.gridx = 4;
		gbc_label_7.gridy = 0;
		pnlGivePercentile.add(label_7, gbc_label_7);
		// Percentile Display - Students above - "Students above" label
		JLabel lblStudentsAbove = new JLabel("Students above");
		GridBagConstraints gbc_lblStudentsAbove = new GridBagConstraints();
		gbc_lblStudentsAbove.anchor = GridBagConstraints.WEST;
		gbc_lblStudentsAbove.insets = new Insets(0, 0, 0, 5);
		gbc_lblStudentsAbove.gridx = 0;
		gbc_lblStudentsAbove.gridy = 1;
		pnlGivePercentile.add(lblStudentsAbove, gbc_lblStudentsAbove);
		// Percentile Display - Students above - Number of students above
		JLabel label_5 = new JLabel("18");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.WEST;
		gbc_label_5.insets = new Insets(0, 0, 0, 5);
		gbc_label_5.gridx = 1;
		gbc_label_5.gridy = 1;
		pnlGivePercentile.add(label_5, gbc_label_5);
		// Percentile Display - Students below - "Students below" label
		JLabel lblStudentsBelow = new JLabel("Students below");
		GridBagConstraints gbc_lblStudentsBelow = new GridBagConstraints();
		gbc_lblStudentsBelow.anchor = GridBagConstraints.WEST;
		gbc_lblStudentsBelow.insets = new Insets(0, 0, 0, 5);
		gbc_lblStudentsBelow.gridx = 3;
		gbc_lblStudentsBelow.gridy = 1;
		pnlGivePercentile.add(lblStudentsBelow, gbc_lblStudentsBelow);
		// Percentile Display - Students below - Number of students below
		JLabel label_8 = new JLabel("21");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.anchor = GridBagConstraints.WEST;
		gbc_label_8.gridx = 4;
		gbc_label_8.gridy = 1;
		pnlGivePercentile.add(label_8, gbc_label_8);
		
		// End of Percentile Tab GUI
		
	}

	
	/**
	 * Formats text to be sent to label.setText for Grade Distribution 
	 * In the form of "A: 20%"
	 * 
	 * @param label		JLabel that will have text changed
	 * @param letter	Grade letter to be set into string
	 * @param percent	float Percent to be associated with letter
	 */
	public void LetterPercentLabel(JLabel label, String letter, float percent) {
		label.setText("A: 20%");
	}
}
