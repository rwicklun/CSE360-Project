package gradeAnalyzer;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class PercentilePanel extends JPanel {
	
	private Calculations calculations;
	private ErrorPanel error = new ErrorPanel();
	
	private JPanel pnlSetGradeRange;
	private JPanel pnlGradeDistribution;
	private JPanel pnlStudentsPerGrade;
	private JPanel pnlSetPercentile;
	private JPanel pnlGivePercent;
	
	private JLabel lblGradeDistributionA;
	private JLabel lblGradeDistributionB;
	private JLabel lblGradeDistributionC;
	private JLabel lblGradeDistributionD;
	private JLabel lblGradeDistributionE;
	
	private JLabel lblStuPerGradeA;
	private JLabel lblStuPerGradeB;
	private JLabel lblStuPerGradeC;
	private JLabel lblStuPerGradeD;
	private JLabel lblStuPerGradeE;
	
	private JLabel lblDispScoAbove_Score;
	private JLabel lblDispScoBelow_Score;
	private JLabel lblDispStuAbove_Value;
	private JLabel lblDispStuBelow_Value;
	
	private JTextField txtSetGradeA;
	private JTextField txtSetGradeB;
	private JTextField txtSetGradeC;
	private JTextField txtSetGradeD;
	private JTextField txtSetTop_Value;
	private JTextField txtSetBottom_Value;
	
	private int percentA;
	private int percentB;
	private int percentC;
	private int percentD;
	private int percentE;
	
	private float gradeDistributA;
	private float gradeDistributB;
	private float gradeDistributC;
	private float gradeDistributD;
	private float gradeDistributE;
	
	private int topPercent;
	private int botPercent;
	
	private int stuCountArray[] = new int[5];
	private int stuCount;
	private JTextField textField;
	private JTextField textField_1;
	
	/**
	 * GUI for the Percentile Panel
	 */
	public PercentilePanel(Calculations calculationsIn) {
		
		calculations = calculationsIn;
		
		// Main panel
		GridBagLayout percentilePanel = new GridBagLayout();
		percentilePanel.columnWidths = new int[] {450, 0};
		percentilePanel.rowHeights = new int[] {20, 20, 30, 20, 20, 20, 20, 20, 30, 40, 37, 0};
		percentilePanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		percentilePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(percentilePanel);
		
		
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
		gbl_pnlSetGradeRangeLabel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_pnlSetGradeRangeLabel.rowHeights = new int[]{14, 0};
		gbl_pnlSetGradeRangeLabel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlSetGradeRangeLabel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlSetGradeRangeLabel.setLayout(gbl_pnlSetGradeRangeLabel);
		
		JLabel lblMaxScoreLabel = new JLabel("Max Score:");
		GridBagConstraints gbc_lblMaxScoreLabel = new GridBagConstraints();
		gbc_lblMaxScoreLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblMaxScoreLabel.gridx = 0;
		gbc_lblMaxScoreLabel.gridy = 0;
		pnlSetGradeRangeLabel.add(lblMaxScoreLabel, gbc_lblMaxScoreLabel);
		
		JLabel lblMaxScoreNumber = new JLabel("0");
		GridBagConstraints gbc_lblMaxScoreNumber = new GridBagConstraints();
		gbc_lblMaxScoreNumber.insets = new Insets(0, 0, 0, 5);
		gbc_lblMaxScoreNumber.gridx = 1;
		gbc_lblMaxScoreNumber.gridy = 0;
		pnlSetGradeRangeLabel.add(lblMaxScoreNumber, gbc_lblMaxScoreNumber);
		
		// Label for Set max section
		JLabel lblSetMaxBased = new JLabel("Set Max based on:");
		GridBagConstraints gbc_lblSetMaxBased = new GridBagConstraints();
		gbc_lblSetMaxBased.anchor = GridBagConstraints.WEST;
		gbc_lblSetMaxBased.insets = new Insets(0, 5, 0, 5);
		gbc_lblSetMaxBased.gridx = 3;
		gbc_lblSetMaxBased.gridy = 0;
		pnlSetGradeRangeLabel.add(lblSetMaxBased, gbc_lblSetMaxBased);
		
		// Max possible button
		JButton btnPossible = new JButton("Possible");
		GridBagConstraints gbc_btnPossible = new GridBagConstraints();
		gbc_btnPossible.insets = new Insets(0, 0, 0, 5);
		gbc_btnPossible.gridx = 4;
		gbc_btnPossible.gridy = 0;
		pnlSetGradeRangeLabel.add(btnPossible, gbc_btnPossible);
		btnPossible.addActionListener(new maxPossibleListener());
		
		// Max earned button
		JButton btnEarned = new JButton("Earned");
		GridBagConstraints gbc_btnEarned = new GridBagConstraints();
		gbc_btnEarned.gridx = 5;
		gbc_btnEarned.gridy = 0;
		pnlSetGradeRangeLabel.add(btnEarned, gbc_btnEarned);
		btnEarned.addActionListener(new maxEarnedListener());
		
		
		// Custom set grade range section
		pnlSetGradeRange = new JPanel();
		GridBagConstraints gbc_pnlSetGradeRange = new GridBagConstraints();
		gbc_pnlSetGradeRange.anchor = GridBagConstraints.NORTH;
		gbc_pnlSetGradeRange.insets = new Insets(0, 0, 5, 0);
		gbc_pnlSetGradeRange.gridx = 0;
		gbc_pnlSetGradeRange.gridy = 2;
		add(pnlSetGradeRange, gbc_pnlSetGradeRange);
		GridBagLayout gbl_pnlSetGradeRange = new GridBagLayout();
		gbl_pnlSetGradeRange.columnWidths = new int[] {0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlSetGradeRange.rowHeights = new int[] {40, 0};
		gbl_pnlSetGradeRange.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlSetGradeRange.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlSetGradeRange.setLayout(gbl_pnlSetGradeRange);
		
		// Custom set grade range section - A
		JLabel lblSetGradeA = new JLabel("Set A to:");
		GridBagConstraints gbc_lblSetGradeA = new GridBagConstraints();
		gbc_lblSetGradeA.ipadx = 5;
		gbc_lblSetGradeA.insets = new Insets(0, 5, 0, 5);
		gbc_lblSetGradeA.gridx = 0;
		gbc_lblSetGradeA.gridy = 0;
		pnlSetGradeRange.add(lblSetGradeA, gbc_lblSetGradeA);
		// Custom set grade range section - A text field
		txtSetGradeA = new JTextField();
		GridBagConstraints gbc_txtSetGradeA = new GridBagConstraints();
		gbc_txtSetGradeA.insets = new Insets(0, 0, 0, 5);
		gbc_txtSetGradeA.gridx = 1;
		gbc_txtSetGradeA.gridy = 0;
		pnlSetGradeRange.add(txtSetGradeA, gbc_txtSetGradeA);
		txtSetGradeA.setText("90");
		txtSetGradeA.setHorizontalAlignment(SwingConstants.CENTER);
		txtSetGradeA.setColumns(3);
		// Custom set grade range section - A %
		JLabel lblSetGradeAPercent = new JLabel("%");
		GridBagConstraints gbc_lblSetGradeAPercent = new GridBagConstraints();
		gbc_lblSetGradeAPercent.anchor = GridBagConstraints.EAST;
		gbc_lblSetGradeAPercent.insets = new Insets(0, 0, 0, 10);
		gbc_lblSetGradeAPercent.gridx = 2;
		gbc_lblSetGradeAPercent.gridy = 0;
		pnlSetGradeRange.add(lblSetGradeAPercent, gbc_lblSetGradeAPercent);
		
		// Custom set grade range section - B
		JLabel lblSetGradeB = new JLabel("Set B to:");
		GridBagConstraints gbc_lblSetGradeB = new GridBagConstraints();
		gbc_lblSetGradeB.anchor = GridBagConstraints.WEST;
		gbc_lblSetGradeB.insets = new Insets(0, 5, 0, 5);
		gbc_lblSetGradeB.gridx = 3;
		gbc_lblSetGradeB.gridy = 0;
		pnlSetGradeRange.add(lblSetGradeB, gbc_lblSetGradeB);
		// Custom set grade range section - B text field
		txtSetGradeB = new JTextField();
		txtSetGradeB.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_txtSetGradeB = new GridBagConstraints();
		gbc_txtSetGradeB.insets = new Insets(0, 0, 0, 5);
		gbc_txtSetGradeB.gridx = 4;
		gbc_txtSetGradeB.gridy = 0;
		pnlSetGradeRange.add(txtSetGradeB, gbc_txtSetGradeB);
		txtSetGradeB.setText("80");
		txtSetGradeB.setColumns(3);
		// Custom set grade range section - B %
		JLabel lblSetGradeBPercent = new JLabel("%");
		GridBagConstraints gbc_lblSetGradeBPercent = new GridBagConstraints();
		gbc_lblSetGradeBPercent.anchor = GridBagConstraints.EAST;
		gbc_lblSetGradeBPercent.insets = new Insets(0, 0, 0, 10);
		gbc_lblSetGradeBPercent.gridx = 5;
		gbc_lblSetGradeBPercent.gridy = 0;
		pnlSetGradeRange.add(lblSetGradeBPercent, gbc_lblSetGradeBPercent);
		
		// Custom set grade range section - C
		JLabel lblSetGradeC = new JLabel("Set C to:");
		GridBagConstraints gbc_lblSetGradeC = new GridBagConstraints();
		gbc_lblSetGradeC.anchor = GridBagConstraints.WEST;
		gbc_lblSetGradeC.insets = new Insets(0, 5, 0, 5);
		gbc_lblSetGradeC.gridx = 6;
		gbc_lblSetGradeC.gridy = 0;
		pnlSetGradeRange.add(lblSetGradeC, gbc_lblSetGradeC);
		// Custom set grade range section - C text field
		txtSetGradeC = new JTextField();
		txtSetGradeC.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_txtSetGradeC = new GridBagConstraints();
		gbc_txtSetGradeC.insets = new Insets(0, 0, 0, 5);
		gbc_txtSetGradeC.gridx = 7;
		gbc_txtSetGradeC.gridy = 0;
		pnlSetGradeRange.add(txtSetGradeC, gbc_txtSetGradeC);
		txtSetGradeC.setText("70");
		txtSetGradeC.setColumns(3);
		// Custom set grade range section - C %
		JLabel lblSetGradeCPercent = new JLabel("%");
		GridBagConstraints gbc_lblSetGradeCPercent = new GridBagConstraints();
		gbc_lblSetGradeCPercent.anchor = GridBagConstraints.EAST;
		gbc_lblSetGradeCPercent.insets = new Insets(0, 0, 0, 10);
		gbc_lblSetGradeCPercent.gridx = 8;
		gbc_lblSetGradeCPercent.gridy = 0;
		pnlSetGradeRange.add(lblSetGradeCPercent, gbc_lblSetGradeCPercent);
		
		// Custom set grade range section - D
		JLabel lblSetGradeD = new JLabel("Set D to:");
		GridBagConstraints gbc_lblSetGradeD = new GridBagConstraints();
		gbc_lblSetGradeD.anchor = GridBagConstraints.WEST;
		gbc_lblSetGradeD.insets = new Insets(0, 5, 0, 5);
		gbc_lblSetGradeD.gridx = 9;
		gbc_lblSetGradeD.gridy = 0;
		pnlSetGradeRange.add(lblSetGradeD, gbc_lblSetGradeD);
		// Custom set grade range section - D text field
		txtSetGradeD = new JTextField();
		txtSetGradeD.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_txtSetGradeD = new GridBagConstraints();
		gbc_txtSetGradeD.insets = new Insets(0, 0, 0, 5);
		gbc_txtSetGradeD.gridx = 10;
		gbc_txtSetGradeD.gridy = 0;
		pnlSetGradeRange.add(txtSetGradeD, gbc_txtSetGradeD);
		txtSetGradeD.setText("60");
		txtSetGradeD.setColumns(3);
		// Custom set grade range section - D %
		JLabel lblSetGradeDPercent = new JLabel("%");
		GridBagConstraints gbc_lblSetGradeDPercent = new GridBagConstraints();
		gbc_lblSetGradeDPercent.anchor = GridBagConstraints.EAST;
		gbc_lblSetGradeDPercent.insets = new Insets(0, 0, 0, 10);
		gbc_lblSetGradeDPercent.gridx = 11;
		gbc_lblSetGradeDPercent.gridy = 0;
		pnlSetGradeRange.add(lblSetGradeDPercent, gbc_lblSetGradeDPercent);
		
		// Custom set grade range section - E
		JLabel lblSetGradeE = new JLabel("Score below D is an E");
		GridBagConstraints gbc_lblSetGradeE = new GridBagConstraints();
		gbc_lblSetGradeE.anchor = GridBagConstraints.WEST;
		gbc_lblSetGradeE.insets = new Insets(0, 5, 0, 0);
		gbc_lblSetGradeE.gridx = 12;
		gbc_lblSetGradeE.gridy = 0;
		pnlSetGradeRange.add(lblSetGradeE, gbc_lblSetGradeE);
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
		pnlGradeDistribution = new JPanel();
		GridBagConstraints gbc_pnlGradeDistribution = new GridBagConstraints();
		gbc_pnlGradeDistribution.anchor = GridBagConstraints.NORTH;
		gbc_pnlGradeDistribution.insets = new Insets(0, 0, 5, 0);
		gbc_pnlGradeDistribution.gridx = 0;
		gbc_pnlGradeDistribution.gridy = 4;
		add(pnlGradeDistribution, gbc_pnlGradeDistribution);
		GridBagLayout gbl_pnlGradeDistribution = new GridBagLayout();
		gbl_pnlGradeDistribution.columnWidths = new int[] {75, 75, 75, 75, 75, 0};
		gbl_pnlGradeDistribution.rowHeights = new int[] {30, 0};
		gbl_pnlGradeDistribution.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlGradeDistribution.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlGradeDistribution.setLayout(gbl_pnlGradeDistribution);
		
		// Grade Distribution Results - A
		lblGradeDistributionA = new JLabel("A: 0%");
//		letterPercentLabel(lblGradeDistributionA, "A", 33);
		GridBagConstraints gbc_lblGradeDistributionA = new GridBagConstraints();
		gbc_lblGradeDistributionA.fill = GridBagConstraints.VERTICAL;
		gbc_lblGradeDistributionA.insets = new Insets(0, 0, 0, 5);
		gbc_lblGradeDistributionA.gridx = 0;
		gbc_lblGradeDistributionA.gridy = 0;
		pnlGradeDistribution.add(lblGradeDistributionA, gbc_lblGradeDistributionA);
		
		// Grade Distribution Results - B
		lblGradeDistributionB = new JLabel("B: 0%");
		GridBagConstraints gbc_lblGradeDistributionB = new GridBagConstraints();
		gbc_lblGradeDistributionB.fill = GridBagConstraints.VERTICAL;
		gbc_lblGradeDistributionB.insets = new Insets(0, 0, 0, 5);
		gbc_lblGradeDistributionB.gridx = 1;
		gbc_lblGradeDistributionB.gridy = 0;
		pnlGradeDistribution.add(lblGradeDistributionB, gbc_lblGradeDistributionB);
		
		// Grade Distribution Results - C
		lblGradeDistributionC = new JLabel("C: 0%");
		GridBagConstraints gbc_lblGradeDistributionC = new GridBagConstraints();
		gbc_lblGradeDistributionC.fill = GridBagConstraints.VERTICAL;
		gbc_lblGradeDistributionC.insets = new Insets(0, 0, 0, 5);
		gbc_lblGradeDistributionC.gridx = 2;
		gbc_lblGradeDistributionC.gridy = 0;
		pnlGradeDistribution.add(lblGradeDistributionC, gbc_lblGradeDistributionC);
		
		// Grade Distribution Results - D
		lblGradeDistributionD = new JLabel("D: 0%");
		GridBagConstraints gbc_lblGradeDistributionD = new GridBagConstraints();
		gbc_lblGradeDistributionD.fill = GridBagConstraints.VERTICAL;
		gbc_lblGradeDistributionD.insets = new Insets(0, 0, 0, 5);
		gbc_lblGradeDistributionD.gridx = 3;
		gbc_lblGradeDistributionD.gridy = 0;
		pnlGradeDistribution.add(lblGradeDistributionD, gbc_lblGradeDistributionD);
		
		// Grade Distribution Results - E
		lblGradeDistributionE = new JLabel("E: 0%");
		GridBagConstraints gbc_lblGradeDistributionE = new GridBagConstraints();
		gbc_lblGradeDistributionE.fill = GridBagConstraints.VERTICAL;
		gbc_lblGradeDistributionE.gridx = 4;
		gbc_lblGradeDistributionE.gridy = 0;
		pnlGradeDistribution.add(lblGradeDistributionE, gbc_lblGradeDistributionE);
		
		
		
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
		pnlStudentsPerGrade = new JPanel();
		GridBagConstraints gbc_pnlStudentsPerGrade = new GridBagConstraints();
		gbc_pnlStudentsPerGrade.anchor = GridBagConstraints.NORTH;
		gbc_pnlStudentsPerGrade.insets = new Insets(0, 0, 5, 0);
		gbc_pnlStudentsPerGrade.gridx = 0;
		gbc_pnlStudentsPerGrade.gridy = 6;
		add(pnlStudentsPerGrade, gbc_pnlStudentsPerGrade);
		GridBagLayout gbl_pnlStudentsPerGrade = new GridBagLayout();
		gbl_pnlStudentsPerGrade.columnWidths = new int[] {75, 75, 75, 75, 75, 0};
		gbl_pnlStudentsPerGrade.rowHeights = new int[] {30, 0};
		gbl_pnlStudentsPerGrade.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlStudentsPerGrade.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlStudentsPerGrade.setLayout(gbl_pnlStudentsPerGrade);
		
		// Displays Students in A
		lblStuPerGradeA = new JLabel("A: 0");
		GridBagConstraints gbc_lblStuPerGradeA = new GridBagConstraints();
		gbc_lblStuPerGradeA.insets = new Insets(0, 0, 0, 5);
		gbc_lblStuPerGradeA.gridx = 0;
		gbc_lblStuPerGradeA.gridy = 0;
		pnlStudentsPerGrade.add(lblStuPerGradeA, gbc_lblStuPerGradeA);
		
		// Displays Students in B
		lblStuPerGradeB = new JLabel("B: 0");
		GridBagConstraints gbc_lblStuPerGradeB = new GridBagConstraints();
		gbc_lblStuPerGradeB.insets = new Insets(0, 0, 0, 5);
		gbc_lblStuPerGradeB.gridx = 1;
		gbc_lblStuPerGradeB.gridy = 0;
		pnlStudentsPerGrade.add(lblStuPerGradeB, gbc_lblStuPerGradeB);
		
		// Displays Students in C
		lblStuPerGradeC = new JLabel("C: 0");
		GridBagConstraints gbc_lblStuPerGradeC = new GridBagConstraints();
		gbc_lblStuPerGradeC.insets = new Insets(0, 0, 0, 5);
		gbc_lblStuPerGradeC.gridx = 2;
		gbc_lblStuPerGradeC.gridy = 0;
		pnlStudentsPerGrade.add(lblStuPerGradeC, gbc_lblStuPerGradeC);
		
		// Displays Students in D
		lblStuPerGradeD = new JLabel("D: 0");
		GridBagConstraints gbc_lblStuPerGradeD = new GridBagConstraints();
		gbc_lblStuPerGradeD.insets = new Insets(0, 0, 0, 5);
		gbc_lblStuPerGradeD.gridx = 3;
		gbc_lblStuPerGradeD.gridy = 0;
		pnlStudentsPerGrade.add(lblStuPerGradeD, gbc_lblStuPerGradeD);
		
		// Displays Students in F
		lblStuPerGradeE = new JLabel("E: 0");
		GridBagConstraints gbc_lblStuPerGradeE = new GridBagConstraints();
		gbc_lblStuPerGradeE.gridx = 4;
		gbc_lblStuPerGradeE.gridy = 0;
		pnlStudentsPerGrade.add(lblStuPerGradeE, gbc_lblStuPerGradeE);
		// End Students in each percentile
		
		
		
		// Start "Students in Each Percentile"
		// Label for "Students in Each Percentile"
		JLabel lblPercent = new JLabel("Students in Each Percentile");
		lblPercent.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPercent.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblPercent = new GridBagConstraints();
		gbc_lblPercent.anchor = GridBagConstraints.SOUTH;
		gbc_lblPercent.insets = new Insets(0, 5, 5, 0);
		gbc_lblPercent.gridx = 0;
		gbc_lblPercent.gridy = 7;
		add(lblPercent, gbc_lblPercent);		
		
		
		// Start user input section
		// Percentile Input Panel
		pnlSetPercentile = new JPanel();
		GridBagConstraints gbc_pnlSetPercentile = new GridBagConstraints();
		gbc_pnlSetPercentile.anchor = GridBagConstraints.SOUTH;
		gbc_pnlSetPercentile.insets = new Insets(0, 0, 5, 0);
		gbc_pnlSetPercentile.gridx = 0;
		gbc_pnlSetPercentile.gridy = 8;
		add(pnlSetPercentile, gbc_pnlSetPercentile);
		GridBagLayout gbl_pnlSetPercentile = new GridBagLayout();
		gbl_pnlSetPercentile.columnWidths = new int[] {65, 30, 65, 25, 65, 30, 65, 0};
		gbl_pnlSetPercentile.rowHeights = new int[] {30, 0};
		gbl_pnlSetPercentile.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlSetPercentile.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlSetPercentile.setLayout(gbl_pnlSetPercentile);
		
		
		// Top Percentile Input - Top label
		JLabel lblSetTop_Top = new JLabel("In the Top");
		GridBagConstraints gbc_lblSetTop_Top = new GridBagConstraints();
		gbc_lblSetTop_Top.anchor = GridBagConstraints.EAST;
		gbc_lblSetTop_Top.insets = new Insets(0, 0, 0, 5);
		gbc_lblSetTop_Top.gridx = 0;
		gbc_lblSetTop_Top.gridy = 0;
		pnlSetPercentile.add(lblSetTop_Top, gbc_lblSetTop_Top);
		
		// Top Percentile Input - Top text field
		txtSetTop_Value = new JTextField();
		txtSetTop_Value.setHorizontalAlignment(SwingConstants.CENTER);
		txtSetTop_Value.setText("10");
		GridBagConstraints gbc_txtSetTop_Value = new GridBagConstraints();
		gbc_txtSetTop_Value.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSetTop_Value.insets = new Insets(0, 0, 0, 5);
		gbc_txtSetTop_Value.gridx = 1;
		gbc_txtSetTop_Value.gridy = 0;
		pnlSetPercentile.add(txtSetTop_Value, gbc_txtSetTop_Value);
		txtSetTop_Value.setColumns(3);
		
		// Top Percentile Input - Percentile label
		JLabel lblSetTop_Percentile = new JLabel("percent");
		GridBagConstraints gbc_lblSetTop_Percentile = new GridBagConstraints();
		gbc_lblSetTop_Percentile.anchor = GridBagConstraints.WEST;
		gbc_lblSetTop_Percentile.insets = new Insets(0, 0, 0, 5);
		gbc_lblSetTop_Percentile.gridx = 2;
		gbc_lblSetTop_Percentile.gridy = 0;
		pnlSetPercentile.add(lblSetTop_Percentile, gbc_lblSetTop_Percentile);
		
		
		// Bottom Percentile Input - Bottom label
		JLabel lblSetBottom_Bottom = new JLabel("In the Bottom");
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
		txtSetBottom_Value.setColumns(3);
		
		// Bottom Percentile Input - Percentile label
		JLabel lblSetBottom_Percentile = new JLabel("percent");
		GridBagConstraints gbc_lblSetBottom_Percentile = new GridBagConstraints();
		gbc_lblSetBottom_Percentile.anchor = GridBagConstraints.WEST;
		gbc_lblSetBottom_Percentile.gridx = 6;
		gbc_lblSetBottom_Percentile.gridy = 0;
		pnlSetPercentile.add(lblSetBottom_Percentile, gbc_lblSetBottom_Percentile);
		
		
		
		// Percentile Display - Panel
		pnlGivePercent = new JPanel();
		GridBagConstraints gbc_pnlGivePercent = new GridBagConstraints();
		gbc_pnlGivePercent.insets = new Insets(0, 0, 5, 0);
		gbc_pnlGivePercent.anchor = GridBagConstraints.NORTH;
		gbc_pnlGivePercent.gridx = 0;
		gbc_pnlGivePercent.gridy = 9;
		add(pnlGivePercent, gbc_pnlGivePercent);
		GridBagLayout gbl_pnlGivePercent = new GridBagLayout();
		gbl_pnlGivePercent.columnWidths = new int[] {90, 50, 55, 90, 50, 0};
		gbl_pnlGivePercent.rowHeights = new int[] {20, 20, 0};
		gbl_pnlGivePercent.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlGivePercent.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlGivePercent.setLayout(gbl_pnlGivePercent);
		
		// Percentile Display - Score above - "Score above" label
		JLabel lblDispScoAbove_Title = new JLabel("Score above ");
		GridBagConstraints gbc_lblDispScoAbove_Title = new GridBagConstraints();
		gbc_lblDispScoAbove_Title.anchor = GridBagConstraints.WEST;
		gbc_lblDispScoAbove_Title.insets = new Insets(0, 0, 5, 5);
		gbc_lblDispScoAbove_Title.gridx = 0;
		gbc_lblDispScoAbove_Title.gridy = 0;
		pnlGivePercent.add(lblDispScoAbove_Title, gbc_lblDispScoAbove_Title);
		
		// Percentile Display - Score above - Above score
		lblDispScoAbove_Score = new JLabel("0%");
		GridBagConstraints gbc_lblDispScoAbove_Score = new GridBagConstraints();
		gbc_lblDispScoAbove_Score.anchor = GridBagConstraints.WEST;
		gbc_lblDispScoAbove_Score.insets = new Insets(0, 0, 5, 5);
		gbc_lblDispScoAbove_Score.gridx = 1;
		gbc_lblDispScoAbove_Score.gridy = 0;
		pnlGivePercent.add(lblDispScoAbove_Score, gbc_lblDispScoAbove_Score);
		
		// Percentile Display - Score below - "Score below" label
		JLabel lblDispScoBelow_Title = new JLabel("Score below");
		GridBagConstraints gbc_lblDispScoBelow_Title = new GridBagConstraints();
		gbc_lblDispScoBelow_Title.anchor = GridBagConstraints.WEST;
		gbc_lblDispScoBelow_Title.insets = new Insets(0, 0, 5, 5);
		gbc_lblDispScoBelow_Title.gridx = 3;
		gbc_lblDispScoBelow_Title.gridy = 0;
		pnlGivePercent.add(lblDispScoBelow_Title, gbc_lblDispScoBelow_Title);
		
		// Percentile Display - Score below - Below score
		lblDispScoBelow_Score = new JLabel("0%");
		GridBagConstraints gbc_lblDispScoBelow_Score = new GridBagConstraints();
		gbc_lblDispScoBelow_Score.anchor = GridBagConstraints.WEST;
		gbc_lblDispScoBelow_Score.insets = new Insets(0, 0, 5, 0);
		gbc_lblDispScoBelow_Score.gridx = 4;
		gbc_lblDispScoBelow_Score.gridy = 0;
		pnlGivePercent.add(lblDispScoBelow_Score, gbc_lblDispScoBelow_Score);
		
		// Percentile Display - Students above - "Students above" label
		JLabel lblDispStuAbove_Title = new JLabel("Students");
		GridBagConstraints gbc_lblDispStuAbove_Title = new GridBagConstraints();
		gbc_lblDispStuAbove_Title.anchor = GridBagConstraints.WEST;
		gbc_lblDispStuAbove_Title.insets = new Insets(0, 0, 0, 5);
		gbc_lblDispStuAbove_Title.gridx = 0;
		gbc_lblDispStuAbove_Title.gridy = 1;
		pnlGivePercent.add(lblDispStuAbove_Title, gbc_lblDispStuAbove_Title);
		
		// Percentile Display - Students above - Number of students above
		lblDispStuAbove_Value = new JLabel("0");
		GridBagConstraints gbc_lblDispStuAbove_Value = new GridBagConstraints();
		gbc_lblDispStuAbove_Value.anchor = GridBagConstraints.WEST;
		gbc_lblDispStuAbove_Value.insets = new Insets(0, 0, 0, 5);
		gbc_lblDispStuAbove_Value.gridx = 1;
		gbc_lblDispStuAbove_Value.gridy = 1;
		pnlGivePercent.add(lblDispStuAbove_Value, gbc_lblDispStuAbove_Value);
		
		// Percentile Display - Students below - "Students below" label
		JLabel lblDispStuBelow_Title = new JLabel("Students");
		GridBagConstraints gbc_lblDispStuBelow_Title = new GridBagConstraints();
		gbc_lblDispStuBelow_Title.anchor = GridBagConstraints.WEST;
		gbc_lblDispStuBelow_Title.insets = new Insets(0, 0, 0, 5);
		gbc_lblDispStuBelow_Title.gridx = 3;
		gbc_lblDispStuBelow_Title.gridy = 1;
		pnlGivePercent.add(lblDispStuBelow_Title, gbc_lblDispStuBelow_Title);
		
		// Percentile Display - Students below - Number of students below
		lblDispStuBelow_Value = new JLabel("0");
		GridBagConstraints gbc_lblDispStuBelow_Value = new GridBagConstraints();
		gbc_lblDispStuBelow_Value.anchor = GridBagConstraints.WEST;
		gbc_lblDispStuBelow_Value.gridx = 4;
		gbc_lblDispStuBelow_Value.gridy = 1;
		pnlGivePercent.add(lblDispStuBelow_Value, gbc_lblDispStuBelow_Value);
		
		JPanel pnlPercentile = new JPanel();
		GridBagConstraints gbc_pnlPercentile = new GridBagConstraints();
		gbc_pnlPercentile.anchor = GridBagConstraints.SOUTH;
		gbc_pnlPercentile.insets = new Insets(0, 0, 5, 0);
		gbc_pnlPercentile.gridx = 0;
		gbc_pnlPercentile.gridy = 10;
		add(pnlPercentile, gbc_pnlPercentile);
		GridBagLayout gbl_pnlPercentile = new GridBagLayout();
		gbl_pnlPercentile.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_pnlPercentile.rowHeights = new int[] {30, 0};
		gbl_pnlPercentile.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlPercentile.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlPercentile.setLayout(gbl_pnlPercentile);
		
		JLabel lblThereAre = new JLabel("There are");
		GridBagConstraints gbc_lblThereAre = new GridBagConstraints();
		gbc_lblThereAre.insets = new Insets(0, 0, 0, 5);
		gbc_lblThereAre.anchor = GridBagConstraints.EAST;
		gbc_lblThereAre.gridx = 0;
		gbc_lblThereAre.gridy = 0;
		pnlPercentile.add(lblThereAre, gbc_lblThereAre);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("0");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		pnlPercentile.add(textField, gbc_textField);
		textField.setColumns(3);
		
		JLabel lblStudentsInThe = new JLabel("students in the");
		GridBagConstraints gbc_lblStudentsInThe = new GridBagConstraints();
		gbc_lblStudentsInThe.insets = new Insets(0, 0, 0, 5);
		gbc_lblStudentsInThe.anchor = GridBagConstraints.EAST;
		gbc_lblStudentsInThe.gridx = 2;
		gbc_lblStudentsInThe.gridy = 0;
		pnlPercentile.add(lblStudentsInThe, gbc_lblStudentsInThe);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("0");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 0;
		pnlPercentile.add(textField_1, gbc_textField_1);
		textField_1.setColumns(3);
		
		JLabel lblThPercentile = new JLabel("th percentile.");
		GridBagConstraints gbc_lblThPercentile = new GridBagConstraints();
		gbc_lblThPercentile.anchor = GridBagConstraints.WEST;
		gbc_lblThPercentile.gridx = 4;
		gbc_lblThPercentile.gridy = 0;
		pnlPercentile.add(lblThPercentile, gbc_lblThPercentile);
		
		
		
		// Update button - Updates all display fields in Percentile Panel
		JButton btnPercentileUpdate = new JButton("Update");
		btnPercentileUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnPercentileUpdate = new GridBagConstraints();
		gbc_btnPercentileUpdate.gridx = 0;
		gbc_btnPercentileUpdate.gridy = 11;
		add(btnPercentileUpdate, gbc_btnPercentileUpdate);
		btnPercentileUpdate.addActionListener(new updatePercentileButton());
		
		// End of Percentile Tab GUI
		
	}

	
	private class maxPossibleListener implements ActionListener {
		 @Override
		 public void actionPerformed(ActionEvent event) {
			 calculations.refreshRoundedArray();
			 calculations.setMaxInUseToPossible();
		 }
	}
	
	private class maxEarnedListener implements ActionListener {
		 @Override
		 public void actionPerformed(ActionEvent event) {
			 calculations.refreshRoundedArray();
			 calculations.setMaxInUseToEarned();
		 }
	}
	
	private class updatePercentileButton implements ActionListener {
		private boolean fail = false;
		
		@Override
		public void actionPerformed(ActionEvent event) {
			calculations.refreshRoundedArray();
			stuCount = calculations.studentCount();
			
			inputCustomGradeRanges();
			fail = calculations.checkPercentOrder();
			fail = calculations.checkGradesExist();
			
			if (fail == false) {
				stuCountArray = calculations.countStuPerGrade();
				
				calculations.setGradeDistResults();
				updateGradeDistribText();
				updateStuCountText();
				
				inputTopBottomPercent();
				updateScoreAboveText();
				updateScoreBelowText();
				
				refreshPanels();
			}
		}
		
		private void inputCustomGradeRanges() {
			try {
				percentA = Integer.parseInt(txtSetGradeA.getText());
				percentB = Integer.parseInt(txtSetGradeB.getText());
				percentC = Integer.parseInt(txtSetGradeC.getText());
				percentD = Integer.parseInt(txtSetGradeD.getText());
			}
			catch (NumberFormatException exception){
                // Input not a number.
                error.setString("Set custom grade range input is not an integer. \nPlease input only integers.");
                error.setVisible(true);
			}
			calculations.setGradePercent('A', percentA);
			calculations.setGradePercent('B', percentB);
			calculations.setGradePercent('C', percentC);
			calculations.setGradePercent('D', percentD);
		}
		
		private void updateGradeDistribText() {
			gradeDistributA = calculations.getGradeDistribution('A');
			gradeDistributB = calculations.getGradeDistribution('B');
			gradeDistributC = calculations.getGradeDistribution('C');
			gradeDistributD = calculations.getGradeDistribution('D');
			gradeDistributE = calculations.getGradeDistribution('E');
			
			changeGradeDistrLabel(lblGradeDistributionA, "A", gradeDistributA);
			changeGradeDistrLabel(lblGradeDistributionB, "B", gradeDistributB);
			changeGradeDistrLabel(lblGradeDistributionC, "C", gradeDistributC);
			changeGradeDistrLabel(lblGradeDistributionD, "D", gradeDistributD);
			changeGradeDistrLabel(lblGradeDistributionE, "E", gradeDistributE);
		}
		
		private void updateStuCountText() {
			changeStuCountLabel(lblStuPerGradeA, "A", stuCountArray[0]);
			changeStuCountLabel(lblStuPerGradeB, "B", stuCountArray[1]);
			changeStuCountLabel(lblStuPerGradeC, "C", stuCountArray[2]);
			changeStuCountLabel(lblStuPerGradeD, "D", stuCountArray[3]);
			changeStuCountLabel(lblStuPerGradeE, "E", stuCountArray[4]);
		}
		
		/**
		 * Formats text to be sent to label.setText for Grade Distribution 
		 * In the form of "A: 20%"
		 * 
		 * @param label		JLabel that will have text changed
		 * @param letter	Grade letter to be set into string
		 * @param percent	float Percent to be associated with letter
		 */
		private void changeGradeDistrLabel(JLabel label, String letter, float percent) {
			label.setText(letter + ": " + percent + "%");
		}
		
		private void changeStuCountLabel(JLabel label, String letter, int count) {
			label.setText(letter + ": " + count);
		}

		private void inputTopBottomPercent() {
			try {
				topPercent = Integer.parseInt(txtSetTop_Value.getText());
				botPercent = Integer.parseInt(txtSetBottom_Value.getText());
			}
			catch (NumberFormatException exception){
                // Input not a number.
                error.setString("Percentile input is not an integer. \nPlease input only integers.");
                error.setVisible(true);
			}
			calculations.setTopBotPercent(topPercent, 1);
			calculations.setTopBotPercent(botPercent, 0);
		}
		
		private void updateScoreAboveText() {
			int stuAbove = calculations.stuTopPercent();
			lblDispStuAbove_Value.setText("" + stuAbove);
			
			int topScore = calculations.scoreAboveTop();
			lblDispScoAbove_Score.setText(topScore + "%");
		}
		
		private void updateScoreBelowText() {
			int stuBelow = calculations.stuBotPercent();
			lblDispStuBelow_Value.setText("" + stuBelow);
			
			int botScore = calculations.scoreBelowBot();
			lblDispScoBelow_Score.setText(botScore + "%");
		}
		
		private void refreshPanels() {
			pnlSetGradeRange.revalidate();
			pnlSetGradeRange.repaint();
			pnlGradeDistribution.revalidate();
			pnlGradeDistribution.repaint();
			pnlStudentsPerGrade.revalidate();
			pnlStudentsPerGrade.repaint();
			pnlGivePercent.revalidate();
			pnlGivePercent.repaint();
		}
	}
}