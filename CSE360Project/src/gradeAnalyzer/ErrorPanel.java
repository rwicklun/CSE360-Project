package gradeAnalyzer;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class ErrorPanel extends JFrame {
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private String errorMessage;
	private JTextArea textArea;
	public ErrorPanel() {
		setType(Type.POPUP);
		setTitle("Error:");

        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        setSize(400,300);
        setResizable(false);
        setLocation((screenWidth - this.getSize().width) / 2,(screenHeight - this.getSize().height) / 2); 
		
		
		JPanel errorPanel = new JPanel();
		getContentPane().add(errorPanel, BorderLayout.NORTH);
		GridBagLayout errorPanelLayout = new GridBagLayout();
		errorPanelLayout.columnWidths = new int[]{195, 42, 0};
		errorPanelLayout.rowHeights = new int[]{16, 0};
		errorPanelLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		errorPanelLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		errorPanel.setLayout(errorPanelLayout);
		
		JLabel lblError = new JLabel("Error : ");
		lblError.setFont(new Font("Times New Roman", Font.BOLD, 18));// description text style
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.insets = new Insets(0, 0, 0, 5);
		gbc_lblError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblError.gridx = 0;
		gbc_lblError.gridy = 0;
		errorPanel.add(lblError, gbc_lblError);
		
		JPanel textPanel = new JPanel();
		getContentPane().add(textPanel, BorderLayout.CENTER);
		textPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));// description text style
		scrollPane.setViewportView(textArea);
		textPanel.add(scrollPane);
		
		
	}
	public void setString(String error) {
		errorMessage = error;
		textArea.setText(errorMessage);
		textArea.setEditable(false);
		
	}
}
