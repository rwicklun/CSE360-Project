package gradeAnalyzer;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.ComponentOrientation;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class PercentilePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public PercentilePanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblGradeDistribution = new JLabel("Grade Distribution");
		lblGradeDistribution.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblGradeDistribution);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(25);
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel);
		JLabel label1 = new JLabel();
		LetterPercentLabel(label1, "A", 33);
		panel.add(label1);
		
		JLabel lblB = new JLabel("B:  20%");
		panel.add(lblB);
		
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

	public void LetterPercentLabel(JLabel label, String letter, float percent) {
		label.setText(letter + ":  " + percent + "%");
	}
}
