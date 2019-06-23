package GradeAnalyzer;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.event.*;
import java.io.File;

@SuppressWarnings("serial")
public class BaseGUI extends JFrame { 
	
	
	public BaseGUI() {
		try {
			   // Set to cross-platform Windows Classic look and feel.
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
			} catch (UnsupportedLookAndFeelException e) {
			   e.printStackTrace();
			} catch (ClassNotFoundException e) {
			   e.printStackTrace();
			} catch (InstantiationException e) {
			   e.printStackTrace();
			} catch (IllegalAccessException e) {
			   e.printStackTrace();
			}
		setBackground(Color.BLACK);
		UIManager.put("TabbedPane.selected", Color.blue);
		GUIComponents();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        this.setSize(screenWidth/2, screenHeight/2);
        this.setResizable(false);
        this.setLocation((screenWidth - this.getSize().width) / 2,(screenHeight - this.getSize().height) / 2); 
        
	}

	public static void main(String[] args) {
		new BaseGUI().setVisible(true);
		
	}
	private void GUIComponents() {
		getContentPane().setLayout(new BorderLayout());
		getContentPane().setBackground(new Color( 200, 200, 200));//left side bar color
        setTitle("Grade Analyzer");
		//base tabs and such
		basePanel = new JTabbedPane();
		basePanel.setFont(new Font("Tahoma", Font.PLAIN, 18));//tab font and size
        basePanel.setTabPlacement(JTabbedPane.LEFT);//set tab location left side
        basePanel.setBackground(Color.BLACK);//tab background color
        basePanel.setForeground(Color.WHITE);//tab text color
        getContentPane().add(basePanel, BorderLayout.CENTER);
        
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
		
		/*load tab start
        loadButton = new JButton("Load Tab");
        loadButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		basePanel.addTab("Load a File", loadButton);
		*///load tab end
		
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
        
        //bottom buttons and such
        bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 16, 5));
        bottomPanel.setBackground(new Color( 200, 200, 200));
        
        recordButton = new JButton("Create Record");
        recordButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        recordButton.setForeground(new Color(255, 255, 255));
        recordButton.setBackground(Color.BLUE);
        recordButton.addActionListener(new RecordListener());
        bottomPanel.add(recordButton);
        
        loadButton = new JButton("Load");
        fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fileChooser.setFileFilter(filter);
        loadButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        loadButton.setForeground(new Color(255, 255, 255));
        loadButton.setBackground(Color.BLUE);
        loadButton.addActionListener(new LoadListener());
        bottomPanel.add(loadButton);
        
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
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        //end of bottom buttons and such
        
        
        
		
	}
	private class RecordListener implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        //DOES NOTHING
	    }
	}
	private class SaveListener implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        //DOES NOTHING
	    }
	}
	private class LoadListener implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	int returnVal = fileChooser.showOpenDialog(BaseGUI.this);
	    	if (returnVal == JFileChooser.APPROVE_OPTION) {
                //File file = fileChooser.getSelectedFile();
	    	} else {
	    		
	    	}
	    }
	}
	private class CloseListener implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        //exits the program, closing the GUI.
	        System.exit(0);
	    }
	}
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
	private JFileChooser fileChooser;
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JScrollPane scrollPane;

}