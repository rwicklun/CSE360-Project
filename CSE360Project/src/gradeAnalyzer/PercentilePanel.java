package gradeAnalyzer;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.ComponentOrientation;
import javax.swing.JLabel;

public class PercentilePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public PercentilePanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblGradeDistribution = new JLabel("Grade Distribution");
		add(lblGradeDistribution);
		
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel lblStudentsInEach = new JLabel("Students in Each Grade Range");
		add(lblStudentsInEach);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		
		JLabel lblStudentsInEach_1 = new JLabel("Students in Each Percentile");
		add(lblStudentsInEach_1);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);

	}

}
