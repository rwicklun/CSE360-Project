package gradeAnalyzer;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class BaseGUI extends JFrame { 
	
	
	public BaseGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.BLACK);
		UIManager.put("TabbedPane.selected", Color.blue);
		GUIComponents();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        this.setSize(913, 497);// makes full screen, should be adjusted later.
        this.setResizable(false);
        this.setLocation((screenWidth - this.getSize().width) / 2,(screenHeight - this.getSize().height) / 2); 
        
	}

	
	public static void main(String[] args) {
		try {
			   // Set to cross-platform Windows Classic look and feel.
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			} catch (UnsupportedLookAndFeelException e) {
			   e.printStackTrace();
			} catch (ClassNotFoundException e) {
			   e.printStackTrace();
			} catch (InstantiationException e) {
			   e.printStackTrace();
			} catch (IllegalAccessException e) {
			   e.printStackTrace();
			}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new BaseGUI().setVisible(true);
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		
		
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
		
		
		//stats tab start
        statsPanel = new JPanel();
        statsPanel.setBackground(new Color(240, 240, 240));
        basePanel.addTab("Grade Statistics", null, statsPanel, null);
		//stats tab end
		
		//percentiles tab start
        percentilePanel= new PercentilePanel();
		basePanel.addTab("Grade Percentiles", percentilePanel);
		//percentiles tab end
		
		//user tab start
        userPanel= new JPanel();
        userPanel.setBackground(Color.WHITE);
        
        setMaxGrade = new JButton("Change maximum possible score.");
        setMaxGrade.setFont(new Font("Tahoma", Font.PLAIN, 18));
        setMaxGrade.setForeground(new Color(255, 255, 255));
        setMaxGrade.setBackground(Color.BLUE);

        setMinGrade = new JButton("Change minimum possible score.");
        setMinGrade.setFont(new Font("Tahoma", Font.PLAIN, 18));
        setMinGrade.setForeground(new Color(255, 255, 255));
        setMinGrade.setBackground(Color.BLUE);

    	deleteGrade = new JButton("Delete a Grade.");
    	deleteGrade.setFont(new Font("Tahoma", Font.PLAIN, 18));
        deleteGrade.setForeground(new Color(255, 255, 255));
        deleteGrade.setBackground(Color.BLUE);
        
    	addGrade = new JButton("Add a Grade.");
    	addGrade.setFont(new Font("Tahoma", Font.PLAIN, 18));
    	addGrade.setForeground(new Color(255, 255, 255));
    	addGrade.setBackground(Color.BLUE);
    	
    	replaceGrade = new JButton("Change a Grade.");
    	replaceGrade.setFont(new Font("Tahoma", Font.PLAIN, 18));
    	replaceGrade.setForeground(new Color(255, 255, 255));
    	replaceGrade.setBackground(Color.BLUE);
    	
    	userPanel.add(setMaxGrade);
    	userPanel.add(setMinGrade);
    	userPanel.add(addGrade);
    	userPanel.add(deleteGrade);
    	userPanel.add(replaceGrade);
    	
		basePanel.addTab("Change Grades", userPanel);
		//user tab end
		
		
        // end of base tabs and such 
        
        //bottom buttons and such
        bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 16, 5));
        bottomPanel.setBackground(new Color( 200, 200, 200));

        fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fileChooser.setFileFilter(filter);
        
        recordButton = new JButton("Create Record");
        recordButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        recordButton.setForeground(new Color(255, 255, 255));
        recordButton.setBackground(Color.BLUE);
        recordButton.addActionListener(new RecordListener());
        bottomPanel.add(recordButton);
        
        loadButton = new JButton("Load");
        loadButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        loadButton.setForeground(new Color(255, 255, 255));
        loadButton.setBackground(Color.BLUE);
        loadButton.addActionListener(new LoadSaveListener());
        bottomPanel.add(loadButton);
        
        saveButton = new JButton("Save");
        saveButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        saveButton.setForeground(new Color(255, 255, 255));
        saveButton.setBackground(Color.BLUE);
        saveButton.addActionListener(new LoadSaveListener());
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
	    public void actionPerformed(ActionEvent event) {
	    	int returnVal = fileChooser.showSaveDialog(BaseGUI.this);
	    	if (returnVal == JFileChooser.APPROVE_OPTION) {
                //File file = fileChooser.getSelectedFile();
	    	} else {
	    		
	    	}
	    }
	}
	private class LoadSaveListener implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent event) {
	    	if (event.getSource() == loadButton) {
		    	int returnVal = fileChooser.showOpenDialog(BaseGUI.this);
		    	if (returnVal == JFileChooser.APPROVE_OPTION) {
	                //File file = fileChooser.getSelectedFile();
		    	} else {
		    		
		    	}
	    	} else if (event.getSource() == saveButton) {
		    	int returnVal = fileChooser.showSaveDialog(BaseGUI.this);
		    	if (returnVal == JFileChooser.APPROVE_OPTION) {
	                //File file = fileChooser.getSelectedFile();
		    	} else {
		    		
		    	}
	    		
	    	}
	    }
	}
	private class CloseListener implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent event) {
	        //exits the program, closing the GUI.
	        System.exit(0);
	    }
	}
	
	private JTabbedPane basePanel;
	
	private JPanel mainPanel;
	private JTextArea mainDescription;
	private JPanel percentilePanel;
	
	private JPanel userPanel;
	private JButton deleteGrade;
	private JButton addGrade;
	private JButton replaceGrade;
	private JButton setMaxGrade;
	private JButton setMinGrade;
	
	private JPanel bottomPanel;
	private JButton closeButton;
	private JButton loadButton;
	private JButton saveButton;
	private JButton recordButton;
	private JFileChooser fileChooser;
	private JScrollPane scrollPane;
	private JPanel statsPanel;
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	

}