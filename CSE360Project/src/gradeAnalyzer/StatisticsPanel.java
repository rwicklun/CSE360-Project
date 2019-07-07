package gradeAnalyzer;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * 
 * @author Richard Wicklund
 *
 */
@SuppressWarnings("serial")
public class StatisticsPanel extends JPanel{
	private JButton btnSetLowest;
	private JTextField lowestTextField;
	
	private JButton btnSetHighest;
	private JTextField highestTextField;
	
	private JTextField maximumTextField;
	private JTextField minimumTextField;
	private JTextField averageTextField;
	private JTextField medianTextField;
	
	private JTextField addGradeTextField;
	private JButton btnAddGrade;
	
	private JTextField deleteGradeTextField;
	private JButton btnDeleteGrade;
	
	private JTextField replaceOldGrade;
	private JTextField replaceNewGrade;
	private JButton btnReplaceGrade;
	
	private JButton btnReset;
	private JButton btnRefresh;
	
	//private StatisticsHandler stats = new StatisticsHandler();
	private Calculations stats = new Calculations();
	
	private ErrorPanel error = new ErrorPanel();
	
	/**
	 * 
	 * @param insertCalc
	 */
	public StatisticsPanel(Calculations insertCalc) {
		stats = insertCalc;
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
		
		highestTextField = new JTextField();
		String highest = "" + stats.getMaxPossible();
		highestTextField.setText(highest);
		GridBagConstraints gbc_highestTextField = new GridBagConstraints();
		gbc_highestTextField.insets = new Insets(0, 0, 5, 5);
		gbc_highestTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_highestTextField.gridx = 1;
		gbc_highestTextField.gridy = 0;
		add(highestTextField, gbc_highestTextField);
		highestTextField.setColumns(10);
		
		JLabel lblLowestScore = new JLabel("Lowest Possible Score: ");
		GridBagConstraints gbc_lblLowestScore = new GridBagConstraints();
		gbc_lblLowestScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblLowestScore.anchor = GridBagConstraints.EAST;
		gbc_lblLowestScore.gridx = 2;
		gbc_lblLowestScore.gridy = 0;
		add(lblLowestScore, gbc_lblLowestScore);
		
		lowestTextField = new JTextField();
		String lowest = "" + stats.getMinPossible();
		lowestTextField.setText(lowest);
		GridBagConstraints gbc_lowestTextField = new GridBagConstraints();
		gbc_lowestTextField.insets = new Insets(0, 0, 5, 0);
		gbc_lowestTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_lowestTextField.gridx = 3;
		gbc_lowestTextField.gridy = 0;
		add(lowestTextField, gbc_lowestTextField);
		lowestTextField.setColumns(10);
		
		btnSetHighest = new JButton("Set Highest");
		GridBagConstraints gbc_btnSetHighest = new GridBagConstraints();
		gbc_btnSetHighest.insets = new Insets(0, 0, 5, 5);
		gbc_btnSetHighest.gridx = 0;
		gbc_btnSetHighest.gridy = 1;
		btnSetHighest.addActionListener(new ButtonListener());
		add(btnSetHighest, gbc_btnSetHighest);
		
		btnSetLowest = new JButton("Set Lowest");
		GridBagConstraints gbc_btnSetLowest = new GridBagConstraints();
		gbc_btnSetLowest.insets = new Insets(0, 0, 5, 5);
		gbc_btnSetLowest.gridx = 2;
		gbc_btnSetLowest.gridy = 1;
		btnSetLowest.addActionListener(new ButtonListener());
		add(btnSetLowest, gbc_btnSetLowest);
		
		JLabel lblMaximum = new JLabel("Maximum Score: ");
		GridBagConstraints gbc_lblMaximum = new GridBagConstraints();
		gbc_lblMaximum.anchor = GridBagConstraints.EAST;
		gbc_lblMaximum.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaximum.gridx = 0;
		gbc_lblMaximum.gridy = 2;
		add(lblMaximum, gbc_lblMaximum);
		
		maximumTextField = new JTextField();
		maximumTextField.setText(stats.getMaxEarned());
		GridBagConstraints gbc_maximumTextField = new GridBagConstraints();
		gbc_maximumTextField.insets = new Insets(0, 0, 5, 5);
		gbc_maximumTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_maximumTextField.gridx = 1;
		gbc_maximumTextField.gridy = 2;
		add(maximumTextField, gbc_maximumTextField);
		maximumTextField.setColumns(10);
		
		JLabel lblMinimum = new JLabel("Minimum Score: ");
		GridBagConstraints gbc_lblMinimum = new GridBagConstraints();
		gbc_lblMinimum.anchor = GridBagConstraints.EAST;
		gbc_lblMinimum.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinimum.gridx = 2;
		gbc_lblMinimum.gridy = 2;
		add(lblMinimum, gbc_lblMinimum);
		
		minimumTextField = new JTextField();
		minimumTextField.setText(stats.getMinEarned());
		GridBagConstraints gbc_minimumTextField = new GridBagConstraints();
		gbc_minimumTextField.insets = new Insets(0, 0, 5, 0);
		gbc_minimumTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_minimumTextField.gridx = 3;
		gbc_minimumTextField.gridy = 2;
		add(minimumTextField, gbc_minimumTextField);
		minimumTextField.setColumns(10);
		
		JLabel lblAverageScore = new JLabel("Average Score: ");
		GridBagConstraints gbc_lblAverageScore = new GridBagConstraints();
		gbc_lblAverageScore.anchor = GridBagConstraints.EAST;
		gbc_lblAverageScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblAverageScore.gridx = 0;
		gbc_lblAverageScore.gridy = 3;
		add(lblAverageScore, gbc_lblAverageScore);
		
		averageTextField = new JTextField();
		averageTextField.setText(stats.getAverage());
		GridBagConstraints gbc_averageTextField = new GridBagConstraints();
		gbc_averageTextField.insets = new Insets(0, 0, 5, 5);
		gbc_averageTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_averageTextField.gridx = 1;
		gbc_averageTextField.gridy = 3;
		add(averageTextField, gbc_averageTextField);
		averageTextField.setColumns(10);
		
		JLabel lblMedianScore = new JLabel("Median Score:");
		GridBagConstraints gbc_lblMedianScore = new GridBagConstraints();
		gbc_lblMedianScore.anchor = GridBagConstraints.EAST;
		gbc_lblMedianScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedianScore.gridx = 2;
		gbc_lblMedianScore.gridy = 3;
		add(lblMedianScore, gbc_lblMedianScore);
		
		medianTextField = new JTextField();
		medianTextField.setText(stats.getMedian());
		GridBagConstraints gbc_medianTextField = new GridBagConstraints();
		gbc_medianTextField.insets = new Insets(0, 0, 5, 0);
		gbc_medianTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_medianTextField.gridx = 3;
		gbc_medianTextField.gridy = 3;
		add(medianTextField, gbc_medianTextField);
		medianTextField.setColumns(10);
		
		btnAddGrade = new JButton("Add Grade:");
		GridBagConstraints gbc_btnAddGrade = new GridBagConstraints();
		gbc_btnAddGrade.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddGrade.gridx = 0;
		gbc_btnAddGrade.gridy = 4;
		add(btnAddGrade, gbc_btnAddGrade);
		
		addGradeTextField = new JTextField();
		addGradeTextField.setText("51");
		GridBagConstraints gbc_addGradeTextField = new GridBagConstraints();
		gbc_addGradeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addGradeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addGradeTextField.gridx = 1;
		gbc_addGradeTextField.gridy = 4;
		add(addGradeTextField, gbc_addGradeTextField);
		addGradeTextField.setColumns(10);
		
		btnDeleteGrade = new JButton("Delete Grade:");
		GridBagConstraints gbc_btnDeleteGrade = new GridBagConstraints();
		gbc_btnDeleteGrade.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteGrade.gridx = 2;
		gbc_btnDeleteGrade.gridy = 4;
		add(btnDeleteGrade, gbc_btnDeleteGrade);
		
		deleteGradeTextField = new JTextField();
		deleteGradeTextField.setText("50");
		GridBagConstraints gbc_deleteGradeTextField = new GridBagConstraints();
		gbc_deleteGradeTextField.insets = new Insets(0, 0, 5, 0);
		gbc_deleteGradeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_deleteGradeTextField.gridx = 3;
		gbc_deleteGradeTextField.gridy = 4;
		add(deleteGradeTextField, gbc_deleteGradeTextField);
		deleteGradeTextField.setColumns(10);
		
		btnReplaceGrade = new JButton("Replace Grade:");
		GridBagConstraints gbc_btnReplaceGrade = new GridBagConstraints();
		gbc_btnReplaceGrade.insets = new Insets(0, 0, 5, 5);
		gbc_btnReplaceGrade.gridx = 0;
		gbc_btnReplaceGrade.gridy = 5;
		add(btnReplaceGrade, gbc_btnReplaceGrade);
		
		replaceOldGrade = new JTextField();
		replaceOldGrade.setText("14");
		GridBagConstraints gbc_replaceOldGrade = new GridBagConstraints();
		gbc_replaceOldGrade.insets = new Insets(0, 0, 5, 5);
		gbc_replaceOldGrade.fill = GridBagConstraints.HORIZONTAL;
		gbc_replaceOldGrade.gridx = 1;
		gbc_replaceOldGrade.gridy = 5;
		add(replaceOldGrade, gbc_replaceOldGrade);
		replaceOldGrade.setColumns(10);
		
		JLabel lblWith = new JLabel("With:");
		GridBagConstraints gbc_lblWith = new GridBagConstraints();
		gbc_lblWith.anchor = GridBagConstraints.EAST;
		gbc_lblWith.insets = new Insets(0, 0, 5, 5);
		gbc_lblWith.gridx = 2;
		gbc_lblWith.gridy = 5;
		add(lblWith, gbc_lblWith);
		
		replaceNewGrade = new JTextField();
		replaceNewGrade.setText("92");
		GridBagConstraints gbc_replaceNewGrade = new GridBagConstraints();
		gbc_replaceNewGrade.insets = new Insets(0, 0, 5, 0);
		gbc_replaceNewGrade.fill = GridBagConstraints.HORIZONTAL;
		gbc_replaceNewGrade.gridx = 3;
		gbc_replaceNewGrade.gridy = 5;
		add(replaceNewGrade, gbc_replaceNewGrade);
		replaceNewGrade.setColumns(10);
		
		btnReset = new JButton("Reset");
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.insets = new Insets(0, 0, 0, 5);
		gbc_btnReset.gridx = 0;
		gbc_btnReset.gridy = 7;
		btnReset.addActionListener(new ButtonListener());
		add(btnReset, gbc_btnReset);
		
		btnRefresh = new JButton("Refresh");
		GridBagConstraints gbc_btnRefresh = new GridBagConstraints();
		gbc_btnRefresh.insets = new Insets(0, 0, 0, 5);
		gbc_btnRefresh.gridx = 2;
		gbc_btnRefresh.gridy = 7;
		btnRefresh.addActionListener(new ButtonListener());
		add(btnRefresh, gbc_btnRefresh);
	}
	/**
	 * 
	 */
	private void refresh() {
		maximumTextField.setText(stats.getMaxEarned());
		minimumTextField.setText(stats.getMinEarned());
		averageTextField.setText(stats.getAverage());
		medianTextField.setText(stats.getMedian());
	}
	private int maxPossible;
	private int minPossible;
	/**
	 * 
	 * @author Richard Wicklund
	 *
	 */
	private class ButtonListener implements ActionListener {
		/**
		 * 
		 */
	    @Override
	    public void actionPerformed(ActionEvent event) {
	    	if (event.getSource() == btnSetHighest) {
	    		String highest = highestTextField.getText();
	    		try {
	    		maxPossible = Integer.parseInt(highest);
	    		} catch (NumberFormatException exception) {
	    			stats.setMaxPossible(stats.getMaxPossible());
	    			highest = "" + stats.getMaxPossible();
	                // Input not a number.
	                error.setString("Input Not A Number: \nPlease input only numbers");
	                error.setVisible(true);
	    		}
	    		if (maxPossible > stats.getMinPossible()) {
	    			stats.setMaxPossible(maxPossible);
	    		} else {
	    			stats.setMaxPossible(stats.getMaxPossible());
	    			highest = "" + stats.getMaxPossible();
	                // Input lower than min possible score
	                error.setString("Input Smaller Than Min: \nPlease input a number greater than the "
	                		+ "Lowest Possible Score");
	                error.setVisible(true);
	    		}
	    		highestTextField.setText(highest);
	    		refresh();
	    	} else if (event.getSource() == btnSetLowest) {
	    		String lowest = lowestTextField.getText();
	    		try {
	    		minPossible = Integer.parseInt(lowest);
	    		} catch (NumberFormatException exception) {
	    			stats.setMinPossible(stats.getMinPossible());
	    			lowest = "" + stats.getMinPossible();
	                // Input not a number.
	                error.setString("Input Not A Number: \nPlease input only numbers");
	                error.setVisible(true);
	    		}
	    		if (minPossible < stats.getMaxPossible()) {
	    			stats.setMinPossible(minPossible);
	    		} else {
	    			stats.setMinPossible(stats.getMinPossible());
	    			lowest = "" + stats.getMinPossible();
	                // Input greater than max possible score
	                error.setString("Input Greater Than Max: \nPlease input a number less than the "
	                		+ "Highest Possible Score");
	                error.setVisible(true);
	    		}
	    		lowestTextField.setText(lowest);
	    		refresh();
	    	} else if (event.getSource() == btnReset) {
    			stats.setMaxPossible(stats.getDefaultMaxPossible());
	    		highestTextField.setText("" + stats.getMaxPossible());
    			stats.setMinPossible(stats.getDefaultMinPossible());
    			lowestTextField.setText("" + stats.getMinPossible());
    			refresh();
	    	}else if (event.getSource() == btnRefresh) {
	    		refresh();
	    	}
	    }
	}
}
