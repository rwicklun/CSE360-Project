package gradeAnalyzer;

import javax.swing.JPanel;
import javax.swing.JLabel;
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
	private JTextField txtSetTop_Value;
	private JTextField txtSetBottom_Value;
	private Float floatArray[];
	private PercentileMath percentileMath;

	/**
	 * GUI for the Percentile Panel
	 */
	public PercentilePanel() {
		// Creates percentileMath
		// 100 used temporarily for max possible
		percentileMath = new PercentileMath(floatArray, 100);
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
		btnPossible.addActionListener(new maxPossibleListener());
		// Max earned button
		JButton btnEarned = new JButton("Earned");
		GridBagConstraints gbc_btnEarned = new GridBagConstraints();
		gbc_btnEarned.gridx = 2;
		gbc_btnEarned.gridy = 0;
		pnlSetGradeRangeLabel.add(btnEarned, gbc_btnEarned);
		btnEarned.addActionListener(new maxEarnedListener());
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
		JLabel lblGradeDistributionA = new JLabel();
		LetterPercentLabel(lblGradeDistributionA, "A", 33);
		GridBagConstraints gbc_lblGradeDistributionA = new GridBagConstraints();
		gbc_lblGradeDistributionA.fill = GridBagConstraints.VERTICAL;
		gbc_lblGradeDistributionA.insets = new Insets(0, 0, 0, 5);
		gbc_lblGradeDistributionA.gridx = 0;
		gbc_lblGradeDistributionA.gridy = 0;
		pnlGradeDistribution.add(lblGradeDistributionA, gbc_lblGradeDistributionA);
		// Grade Distribution Results - B
		JLabel lblGradeDistributionB = new JLabel("B: 20%");
		GridBagConstraints gbc_lblGradeDistributionB = new GridBagConstraints();
		gbc_lblGradeDistributionB.fill = GridBagConstraints.VERTICAL;
		gbc_lblGradeDistributionB.insets = new Insets(0, 0, 0, 5);
		gbc_lblGradeDistributionB.gridx = 1;
		gbc_lblGradeDistributionB.gridy = 0;
		pnlGradeDistribution.add(lblGradeDistributionB, gbc_lblGradeDistributionB);
		// Grade Distribution Results - C
		JLabel lblGradeDistributionC = new JLabel("C: 20%");
		GridBagConstraints gbc_lblGradeDistributionC = new GridBagConstraints();
		gbc_lblGradeDistributionC.fill = GridBagConstraints.VERTICAL;
		gbc_lblGradeDistributionC.insets = new Insets(0, 0, 0, 5);
		gbc_lblGradeDistributionC.gridx = 2;
		gbc_lblGradeDistributionC.gridy = 0;
		pnlGradeDistribution.add(lblGradeDistributionC, gbc_lblGradeDistributionC);
		// Grade Distribution Results - D
		JLabel lblGradeDistributionD = new JLabel("D: 20%");
		GridBagConstraints gbc_lblGradeDistributionD = new GridBagConstraints();
		gbc_lblGradeDistributionD.fill = GridBagConstraints.VERTICAL;
		gbc_lblGradeDistributionD.insets = new Insets(0, 0, 0, 5);
		gbc_lblGradeDistributionD.gridx = 3;
		gbc_lblGradeDistributionD.gridy = 0;
		pnlGradeDistribution.add(lblGradeDistributionD, gbc_lblGradeDistributionD);
		// Grade Distribution Results - F
		JLabel lblGradeDistributionF = new JLabel("F: 20%");
		GridBagConstraints gbc_lblGradeDistributionF = new GridBagConstraints();
		gbc_lblGradeDistributionF.insets = new Insets(0, 0, 0, 5);
		gbc_lblGradeDistributionF.fill = GridBagConstraints.VERTICAL;
		gbc_lblGradeDistributionF.gridx = 4;
		gbc_lblGradeDistributionF.gridy = 0;
		pnlGradeDistribution.add(lblGradeDistributionF, gbc_lblGradeDistributionF);
		
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
		JLabel lblStuPerGradeA = new JLabel("A: 20");
		GridBagConstraints gbc_lblStuPerGradeA = new GridBagConstraints();
		gbc_lblStuPerGradeA.insets = new Insets(0, 0, 0, 5);
		gbc_lblStuPerGradeA.gridx = 0;
		gbc_lblStuPerGradeA.gridy = 0;
		pnlStudentsPerGrade.add(lblStuPerGradeA, gbc_lblStuPerGradeA);
		// Displays Students in B
		JLabel lblStuPerGradeB = new JLabel("B: 20");
		GridBagConstraints gbc_lblStuPerGradeB = new GridBagConstraints();
		gbc_lblStuPerGradeB.insets = new Insets(0, 0, 0, 5);
		gbc_lblStuPerGradeB.gridx = 1;
		gbc_lblStuPerGradeB.gridy = 0;
		pnlStudentsPerGrade.add(lblStuPerGradeB, gbc_lblStuPerGradeB);
		// Displays Students in C
		JLabel lblStuPerGradeC = new JLabel("C: 20");
		GridBagConstraints gbc_lblStuPerGradeC = new GridBagConstraints();
		gbc_lblStuPerGradeC.insets = new Insets(0, 0, 0, 5);
		gbc_lblStuPerGradeC.gridx = 2;
		gbc_lblStuPerGradeC.gridy = 0;
		pnlStudentsPerGrade.add(lblStuPerGradeC, gbc_lblStuPerGradeC);
		// Displays Students in D
		JLabel lblStuPerGradeD = new JLabel("D: 20");
		GridBagConstraints gbc_lblStuPerGradeD = new GridBagConstraints();
		gbc_lblStuPerGradeD.insets = new Insets(0, 0, 0, 5);
		gbc_lblStuPerGradeD.gridx = 3;
		gbc_lblStuPerGradeD.gridy = 0;
		pnlStudentsPerGrade.add(lblStuPerGradeD, gbc_lblStuPerGradeD);
		// Displays Students in F
		JLabel lblStuPerGradeF = new JLabel("F: 20");
		GridBagConstraints gbc_lblStuPerGradeF = new GridBagConstraints();
		gbc_lblStuPerGradeF.insets = new Insets(0, 0, 0, 5);
		gbc_lblStuPerGradeF.gridx = 4;
		gbc_lblStuPerGradeF.gridy = 0;
		pnlStudentsPerGrade.add(lblStuPerGradeF, gbc_lblStuPerGradeF);
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
		JLabel lblSetTop_Top = new JLabel("Top");
		GridBagConstraints gbc_lblSetTop_Top = new GridBagConstraints();
		gbc_lblSetTop_Top.anchor = GridBagConstraints.EAST;
		gbc_lblSetTop_Top.insets = new Insets(0, 0, 0, 5);
		gbc_lblSetTop_Top.gridx = 0;
		gbc_lblSetTop_Top.gridy = 0;
		pnlSetPercentile.add(lblSetTop_Top, gbc_lblSetTop_Top);
		// Top Percentile Input - Top text field
		txtSetTop_Value = new JTextField();
		txtSetTop_Value.setHorizontalAlignment(SwingConstants.CENTER);
		txtSetTop_Value.setText("90");
		GridBagConstraints gbc_txtSetTop_Value = new GridBagConstraints();
		gbc_txtSetTop_Value.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSetTop_Value.insets = new Insets(0, 0, 0, 5);
		gbc_txtSetTop_Value.gridx = 1;
		gbc_txtSetTop_Value.gridy = 0;
		pnlSetPercentile.add(txtSetTop_Value, gbc_txtSetTop_Value);
		txtSetTop_Value.setColumns(2);
		// Top Percentile Input - Percentile label
		JLabel lblSetTop_Percentile = new JLabel("percentile");
		GridBagConstraints gbc_lblSetTop_Percentile = new GridBagConstraints();
		gbc_lblSetTop_Percentile.anchor = GridBagConstraints.WEST;
		gbc_lblSetTop_Percentile.insets = new Insets(0, 0, 0, 5);
		gbc_lblSetTop_Percentile.gridx = 2;
		gbc_lblSetTop_Percentile.gridy = 0;
		pnlSetPercentile.add(lblSetTop_Percentile, gbc_lblSetTop_Percentile);
		// Bottom Percentile Input - Bottom label
		JLabel lblSetBottom_Bottom = new JLabel("Bottom");
		GridBagConstraints gbc_lblSetBottom_Bottom = new GridBagConstraints();
		gbc_lblSetBottom_Bottom.anchor = GridBagConstraints.EAST;
		gbc_lblSetBottom_Bottom.insets = new Insets(0, 0, 0, 5);
		gbc_lblSetBottom_Bottom.gridx = 4;
		gbc_lblSetBottom_Bottom.gridy = 0;
		pnlSetPercentile.add(lblSetBottom_Bottom, gbc_lblSetBottom_Bottom);
		// Bottom Percentile Input - Bottom text field
		txtSetBottom_Value = new JTextField();
		txtSetBottom_Value.setHorizontalAlignment(SwingConstants.CENTER);
		txtSetBottom_Value.setText("10");
		GridBagConstraints gbc_txtSetBottom_Value = new GridBagConstraints();
		gbc_txtSetBottom_Value.insets = new Insets(0, 0, 0, 5);
		gbc_txtSetBottom_Value.gridx = 5;
		gbc_txtSetBottom_Value.gridy = 0;
		pnlSetPercentile.add(txtSetBottom_Value, gbc_txtSetBottom_Value);
		txtSetBottom_Value.setColumns(2);
		// Bottom Percentile Input - Percentile label
		JLabel lblSetBottom_Percentile = new JLabel("percentile");
		GridBagConstraints gbc_lblSetBottom_Percentile = new GridBagConstraints();
		gbc_lblSetBottom_Percentile.insets = new Insets(0, 0, 0, 5);
		gbc_lblSetBottom_Percentile.anchor = GridBagConstraints.WEST;
		gbc_lblSetBottom_Percentile.gridx = 6;
		gbc_lblSetBottom_Percentile.gridy = 0;
		pnlSetPercentile.add(lblSetBottom_Percentile, gbc_lblSetBottom_Percentile);
		// Percentile Input - Update button
		JButton btnSetPercentileUpdate = new JButton("Update");
		GridBagConstraints gbc_btnSetPercentileUpdate = new GridBagConstraints();
		gbc_btnSetPercentileUpdate.insets = new Insets(0, 8, 0, 0);
		gbc_btnSetPercentileUpdate.gridx = 7;
		gbc_btnSetPercentileUpdate.gridy = 0;
		pnlSetPercentile.add(btnSetPercentileUpdate, gbc_btnSetPercentileUpdate);
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
		JLabel lblDispScoAbove_Title = new JLabel("Score above ");
		GridBagConstraints gbc_lblDispScoAbove_Title = new GridBagConstraints();
		gbc_lblDispScoAbove_Title.anchor = GridBagConstraints.WEST;
		gbc_lblDispScoAbove_Title.insets = new Insets(0, 0, 5, 5);
		gbc_lblDispScoAbove_Title.gridx = 0;
		gbc_lblDispScoAbove_Title.gridy = 0;
		pnlGivePercentile.add(lblDispScoAbove_Title, gbc_lblDispScoAbove_Title);
		// Percentile Display - Score above - Above score
		JLabel lblDispScoAbove_Score = new JLabel("89%");
		GridBagConstraints gbc_lblDispScoAbove_Score = new GridBagConstraints();
		gbc_lblDispScoAbove_Score.anchor = GridBagConstraints.WEST;
		gbc_lblDispScoAbove_Score.insets = new Insets(0, 0, 5, 5);
		gbc_lblDispScoAbove_Score.gridx = 1;
		gbc_lblDispScoAbove_Score.gridy = 0;
		pnlGivePercentile.add(lblDispScoAbove_Score, gbc_lblDispScoAbove_Score);
		// Percentile Display - Score below - "Score below" label
		JLabel lblDispScoBelow_Title = new JLabel("Score below");
		GridBagConstraints gbc_lblDispScoBelow_Title = new GridBagConstraints();
		gbc_lblDispScoBelow_Title.anchor = GridBagConstraints.WEST;
		gbc_lblDispScoBelow_Title.insets = new Insets(0, 0, 5, 5);
		gbc_lblDispScoBelow_Title.gridx = 3;
		gbc_lblDispScoBelow_Title.gridy = 0;
		pnlGivePercentile.add(lblDispScoBelow_Title, gbc_lblDispScoBelow_Title);
		// Percentile Display - Score below - Below score
		JLabel lblDispScoBelow_Score = new JLabel("31%");
		GridBagConstraints gbc_lblDispScoBelow_Score = new GridBagConstraints();
		gbc_lblDispScoBelow_Score.anchor = GridBagConstraints.WEST;
		gbc_lblDispScoBelow_Score.insets = new Insets(0, 0, 5, 0);
		gbc_lblDispScoBelow_Score.gridx = 4;
		gbc_lblDispScoBelow_Score.gridy = 0;
		pnlGivePercentile.add(lblDispScoBelow_Score, gbc_lblDispScoBelow_Score);
		// Percentile Display - Students above - "Students above" label
		JLabel lblDispStuAbove_Title = new JLabel("Students above");
		GridBagConstraints gbc_lblDispStuAbove_Title = new GridBagConstraints();
		gbc_lblDispStuAbove_Title.anchor = GridBagConstraints.WEST;
		gbc_lblDispStuAbove_Title.insets = new Insets(0, 0, 0, 5);
		gbc_lblDispStuAbove_Title.gridx = 0;
		gbc_lblDispStuAbove_Title.gridy = 1;
		pnlGivePercentile.add(lblDispStuAbove_Title, gbc_lblDispStuAbove_Title);
		// Percentile Display - Students above - Number of students above
		JLabel lblDispStuAbove_Value = new JLabel("18");
		GridBagConstraints gbc_lblDispStuAbove_Value = new GridBagConstraints();
		gbc_lblDispStuAbove_Value.anchor = GridBagConstraints.WEST;
		gbc_lblDispStuAbove_Value.insets = new Insets(0, 0, 0, 5);
		gbc_lblDispStuAbove_Value.gridx = 1;
		gbc_lblDispStuAbove_Value.gridy = 1;
		pnlGivePercentile.add(lblDispStuAbove_Value, gbc_lblDispStuAbove_Value);
		// Percentile Display - Students below - "Students below" label
		JLabel lblDispStuBelow_Title = new JLabel("Students below");
		GridBagConstraints gbc_lblDispStuBelow_Title = new GridBagConstraints();
		gbc_lblDispStuBelow_Title.anchor = GridBagConstraints.WEST;
		gbc_lblDispStuBelow_Title.insets = new Insets(0, 0, 0, 5);
		gbc_lblDispStuBelow_Title.gridx = 3;
		gbc_lblDispStuBelow_Title.gridy = 1;
		pnlGivePercentile.add(lblDispStuBelow_Title, gbc_lblDispStuBelow_Title);
		// Percentile Display - Students below - Number of students below
		JLabel lblDispStuBelow_Value = new JLabel("21");
		GridBagConstraints gbc_lblDispStuBelow_Value = new GridBagConstraints();
		gbc_lblDispStuBelow_Value.anchor = GridBagConstraints.WEST;
		gbc_lblDispStuBelow_Value.gridx = 4;
		gbc_lblDispStuBelow_Value.gridy = 1;
		pnlGivePercentile.add(lblDispStuBelow_Value, gbc_lblDispStuBelow_Value);
		
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
		label.setText(letter + ": " + percent + "%");
	}
	
	private class maxPossibleListener implements ActionListener {
		 @Override
		 public void actionPerformed(ActionEvent event) {
			 percentileMath.setMaxToPossible();
		 }
		
	}
	
	private class maxEarnedListener implements ActionListener {
		 @Override
		 public void actionPerformed(ActionEvent event) {
			 percentileMath.setMaxToEarned();
		 }
		
	}
}
