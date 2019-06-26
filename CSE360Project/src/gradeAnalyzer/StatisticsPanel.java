package gradeAnalyzer;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class StatisticsPanel extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	public StatisticsPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 61, 106, 50, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblHighestScore = new JLabel("Highest Possible Score: ");
		GridBagConstraints gbc_lblHighestScore = new GridBagConstraints();
		gbc_lblHighestScore.anchor = GridBagConstraints.EAST;
		gbc_lblHighestScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighestScore.gridx = 0;
		gbc_lblHighestScore.gridy = 0;
		add(lblHighestScore, gbc_lblHighestScore);
		
		textField_1 = new JTextField();
		textField_1.setText("100");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLowestScore = new JLabel("Lowest Possible Score: ");
		GridBagConstraints gbc_lblLowestScore = new GridBagConstraints();
		gbc_lblLowestScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblLowestScore.anchor = GridBagConstraints.EAST;
		gbc_lblLowestScore.gridx = 2;
		gbc_lblLowestScore.gridy = 0;
		add(lblLowestScore, gbc_lblLowestScore);
		
		textField = new JTextField();
		textField.setText("0");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnSetHighest = new JButton("Set Highest");
		GridBagConstraints gbc_btnSetHighest = new GridBagConstraints();
		gbc_btnSetHighest.insets = new Insets(0, 0, 5, 5);
		gbc_btnSetHighest.gridx = 0;
		gbc_btnSetHighest.gridy = 1;
		add(btnSetHighest, gbc_btnSetHighest);
		
		JButton btnSetLowest = new JButton("Set Lowest");
		GridBagConstraints gbc_btnSetLowest = new GridBagConstraints();
		gbc_btnSetLowest.insets = new Insets(0, 0, 5, 5);
		gbc_btnSetLowest.gridx = 2;
		gbc_btnSetLowest.gridy = 1;
		add(btnSetLowest, gbc_btnSetLowest);
		
		JLabel lblMaximum = new JLabel("Maximum Score: ");
		GridBagConstraints gbc_lblMaximum = new GridBagConstraints();
		gbc_lblMaximum.anchor = GridBagConstraints.EAST;
		gbc_lblMaximum.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaximum.gridx = 0;
		gbc_lblMaximum.gridy = 2;
		add(lblMaximum, gbc_lblMaximum);
		
		textField_2 = new JTextField();
		textField_2.setText("95");
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblMinimum = new JLabel("Minimum Score: ");
		GridBagConstraints gbc_lblMinimum = new GridBagConstraints();
		gbc_lblMinimum.anchor = GridBagConstraints.EAST;
		gbc_lblMinimum.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinimum.gridx = 2;
		gbc_lblMinimum.gridy = 2;
		add(lblMinimum, gbc_lblMinimum);
		
		textField_3 = new JTextField();
		textField_3.setText("14");
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 2;
		add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAverageScore = new JLabel("Average Score: ");
		GridBagConstraints gbc_lblAverageScore = new GridBagConstraints();
		gbc_lblAverageScore.anchor = GridBagConstraints.EAST;
		gbc_lblAverageScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblAverageScore.gridx = 0;
		gbc_lblAverageScore.gridy = 3;
		add(lblAverageScore, gbc_lblAverageScore);
		
		textField_4 = new JTextField();
		textField_4.setText("72");
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 3;
		add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblMedianScore = new JLabel("Median Score:");
		GridBagConstraints gbc_lblMedianScore = new GridBagConstraints();
		gbc_lblMedianScore.anchor = GridBagConstraints.EAST;
		gbc_lblMedianScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedianScore.gridx = 2;
		gbc_lblMedianScore.gridy = 3;
		add(lblMedianScore, gbc_lblMedianScore);
		
		textField_5 = new JTextField();
		textField_5.setText("68");
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 3;
		add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.insets = new Insets(0, 0, 0, 5);
		gbc_btnReset.gridx = 0;
		gbc_btnReset.gridy = 7;
		add(btnReset, gbc_btnReset);
	}

}
