package gradeAnalyzer;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class ErrorPanel extends JFrame {
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public ErrorPanel() {
		setType(Type.POPUP);
		setTitle("Error:");

        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        setSize(334,331);
        setResizable(false);
        setLocation((screenWidth - this.getSize().width) / 2,(screenHeight - this.getSize().height) / 2); 
		
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{195, 42, 0};
		gbl_panel_1.rowHeights = new int[]{16, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblError = new JLabel("Error : ");
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.insets = new Insets(0, 0, 0, 5);
		gbc_lblError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblError.gridx = 0;
		gbc_lblError.gridy = 0;
		panel_1.add(lblError, gbc_lblError);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);
		panel_2.add(scrollPane);
		
		
	}
}
