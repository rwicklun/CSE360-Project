package experimental;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TestTabs {

	private JFrame frame;
	private JTabbedPane basePanel;
	private JPanel mainPanel;
	private JTextArea mainDescription;
	private JButton loadButton;
	private JButton percentilesButton;
	private JButton userButton;
	private JButton statsButton;
	private JPanel bottomPanel;
	private JButton closeButton;
	private JButton saveButton;
	private JButton recordButton;
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestTabs window = new TestTabs();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestTabs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setBackground(Color.BLACK);
		UIManager.put("TabbedPane.selected", Color.blue);
		
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().setBackground(new Color( 200, 200, 200));//left side bar color
        frame.setTitle("Grade Analyzer");
		
		basePanel = new JTabbedPane();
		basePanel.setFont(new Font("Tahoma", Font.PLAIN, 18));//tab font and size
        basePanel.setTabPlacement(JTabbedPane.LEFT);
        frame.getContentPane().add(basePanel);
		
        basePanel.setBackground(Color.BLACK);//tab background color
        basePanel.setForeground(Color.WHITE);//tab text color
        frame.getContentPane().add(basePanel, BorderLayout.CENTER);
        
        //Home page tab start
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setForeground(Color.BLACK);
        mainPanel.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));// Home page border color/size
        
        mainDescription = new JTextArea();
        mainDescription.setLineWrap(true);
        mainDescription.setWrapStyleWord(true);
        mainDescription.setFont(new Font("Times New Roman", Font.PLAIN, 18));// description text style
        mainDescription.setEditable(false);
        mainDescription.setBackground(Color.white);// the text background is white
        // start of text for home description
        	mainDescription.setText("Change to description of the project.");
        // end of text for home description
        scrollPane = new JScrollPane(mainDescription);
        mainPanel.add(scrollPane);
        mainPanel.setBackground(Color.white);
        basePanel.addTab("Home", mainPanel);
        basePanel.setForegroundAt(0, Color.WHITE);
		//home page tab end
		
		//load tab start
        loadButton = new JButton("Load Tab");
        loadButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		basePanel.addTab("Load a File", loadButton);
		//load tab end
		
		//stats tab start
        statsButton = new JButton("Stats Tab");
		basePanel.addTab("Grade Statistics", statsButton);
		//stats tab end
		
		//percentiles tab start
        percentilesButton = new JButton("Percentiles Tab");
		basePanel.addTab("Grade Percentiles", percentilesButton);
		//percentiles tab end
		
		//user tab start
        userButton = new JButton("User Tab");
		basePanel.addTab("Change Grades", userButton);
		//user tab end
		
        // end of base tabs and such 
        
    	final class RecordListener implements ActionListener {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        //DOES NOTHING
    	    }
    	}
    	final class SaveListener implements ActionListener {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        //DOES NOTHING
    	    }
    	}
    	final class CloseListener implements ActionListener {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        //exits the program, closing the GUI.
    	        System.exit(0);
    	    }
    	}
		
        //bottom buttons and such
        bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 16, 5));
        bottomPanel.setBackground(new Color( 200, 200, 200));
        
        recordButton = new JButton("Create Record");
        recordButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        recordButton.setForeground(new Color(255, 255, 255));
        recordButton.setBackground(Color.BLUE);
        recordButton.addActionListener(new RecordListener());
        bottomPanel.add(recordButton);
        
        saveButton = new JButton("Save");
        saveButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        saveButton.setForeground(new Color(255, 255, 255));
        saveButton.setBackground(Color.BLUE);
        saveButton.addActionListener(new SaveListener());
        bottomPanel.add(saveButton);
        
        closeButton = new JButton("Close");
        closeButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        closeButton.setForeground(new Color(255, 255, 255));
        closeButton.setBackground(Color.BLUE);
        closeButton.addActionListener(new CloseListener());
        bottomPanel.add(closeButton);
        frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        //end of bottom buttons and such
        

        

	}

}
