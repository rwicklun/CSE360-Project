package gradeAnalyzer;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

/**
 * <h1> Grade Analyzer </h1>
 * This is the Grade Analyzer program, it takes a text file of grades, 
 * and finds the average, minimum, median, and other statistical functions.
 * It allows the user to save the current state of the program, the current grades 
 * in the program, adjust the visible ranges of the grades, and add, delete or replace grades.
 * <p>
 * This is the main panel for the grade analyzer program. 
 * This is where the base of the GUI is built and where the program is run from.
 * @author Richard Wicklund
 * @author Steven Situ
 * @author Abdullah Almuhanna
 *
 */
@SuppressWarnings("serial")
public class BaseGUI extends JFrame { 
	/**
	 * This is the constructor of the grade analyzer program, it sets the user interface location,
	 * size and color, as well as its exit behavior.
	 */
	public BaseGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.BLACK);
		UIManager.put("TabbedPane.selected", Color.blue);
		GUIComponents();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        this.setSize(screenWidth/2, screenHeight/2);// DO NOT MAKE A STAGNANT NUMBER IT SCREWS EVERYTHING UP
        this.setResizable(false);
        this.setLocation((screenWidth - this.getSize().width) / 2,(screenHeight - this.getSize().height) / 2); 
        
	}
	/**
	 * This is the executable portion of the program, it runs the code.
	 * 
	 */
	public static void main(String[] args) {
		try {
			   // Set to cross-platform Windows Classic look and feel.
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			} catch (UnsupportedLookAndFeelException exception) {
				exception.printStackTrace();
			} catch (ClassNotFoundException exception) {
				exception.printStackTrace();
			} catch (InstantiationException exception) {
				exception.printStackTrace();
			} catch (IllegalAccessException exception) {
				exception.printStackTrace();
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
	/**
	 * The GUIComponents method creates the GUI components and sets them into their proper locations.
	 * It also creates the Load Save and Create Report buttons
	 */
	private void GUIComponents() {
		getContentPane().setLayout(new BorderLayout());
		getContentPane().setBackground(new Color(110, 110, 110));//left side bar color
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
        	mainDescription.setText("The Home Tab: \nThis tab contains a description of the components of the Grade Analyzer program."
        			+ "\n\nThe Grade Statistics Tab:"
        			+ "\nThis tab contains the means of setting the highest and lowest possible scores, adding, deleting and "
        			+ "replacing a grade, displaying the average, the median, and the highest and lowest score of the grades."
        			+ "\n\nThe Grade Percentiles Tab:"
        			+ "\nThis tab contains the distrubtion of A's, B's, C's etc. the count of students in a user set percentile, "
        			+ "and the count of students in each percentage range."
        			+ "\n\nThe Create Report Button:"
        			+ "\nThis button will generate a document that lists out all the data given by Grade Analyzer, with nothing loaded it will only "
        			+ "write out the categories."
        			+ "\n\n The Load Button:"
        			+ "\nThis button will load a .txt file composed of individual floating point numbers on each line, anything else will error."
        			+ "\n\nThe Save Button:"
        			+ "\nThis button will save all changes made to the grades, including the set maximum and minimum and statistics.");
        	mainDescription.setCaretPosition(0);
        // end of text for home description
        scrollPane = new JScrollPane(mainDescription);
        mainPanel.add(scrollPane);
        mainPanel.setBackground(Color.white);
        basePanel.addTab("Home", mainPanel);
        basePanel.setForegroundAt(0, Color.WHITE);
		//home page tab end
		
		
		//stats tab start
        statsPanel = new StatisticsPanel(calculations);
        statsPanel.setBackground(new Color(110, 110, 110));
        basePanel.addTab("Grade Statistics", null, statsPanel, null);
		//stats tab end
		
		//percentiles tab start
        percentilePanel= new PercentilePanel(calculations);
        percentilePanel.setBackground(new Color(110, 110, 110));
        //percentilePanel.setBackground(Color.lightGray);
		basePanel.addTab("Grade Percentiles", percentilePanel);
		//percentiles tab end
		
		
		
        // end of base tabs and such 
        
        //bottom buttons and such
        bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 16, 5));
        bottomPanel.setBackground(new Color(110, 110, 110));

        fileChooser = new JFileChooser();
		fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fileChooser.setFileFilter(filter);
        
        recordButton = new JButton("Create Report");
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
	
	
	
	
	//This is the RecordListener that makes the create record button works 
	/**
	 * The RecordListener Class implements the function of the Create Report
	 * button when it is clicked.
	 *
	 */
		private class RecordListener implements ActionListener {
			/**
			 * The actionPerformed method saves the current state of the Grade Analyzer to a
			 * text file, this does not include the input, or current grades in the program.
			 * @param event - this is the event that happens when the Create Report button is pushed.
			 */
			@Override
		    public void actionPerformed(ActionEvent event) {
				  
			    int correctFile = fileChooser.showOpenDialog(BaseGUI.this);
			        
			    if(correctFile == JFileChooser.APPROVE_OPTION)
			    {
			    	try
			    	{    			
			    		FileWriter recordWriter = new FileWriter(fileChooser.getSelectedFile());
			    		recordWriter.write("Record: The Current State of Grade Analyzer." );
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write("Maximum Possible Grade: " + calculations.getMaxPossible());
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write("Minimum Possible Grade: " + calculations.getMinPossible());
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write("Maximum Grade recieved: " + calculations.getMaxEarned());
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write("Minimum Grade recieved: " + calculations.getMinEarned());
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write("Average Grade recieved: " + calculations.getAverage());
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write("Median Grade: " + calculations.getMedian());
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		// start of A range
			    		recordWriter.write("A Range is: 100" + " to: " + calculations.getGradePercent('A'));
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write("Percent of students in A range: " + calculations.getGradeDistribution('A') + "%.");
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write("Number of students in A range: " + calculations.getStuPerGrade('A'));
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		//start of B range
			    		recordWriter.write("B Range is: " + calculations.getGradePercent('A') + " to: " + calculations.getGradePercent('B'));
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write("Percent of students in B range: " + calculations.getGradeDistribution('B') + "%.");
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write("Number of students in B range: " + calculations.getStuPerGrade('B'));
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		//Start of C range
			    		recordWriter.write("C Range is: "+ calculations.getGradePercent('B') + " to: " + calculations.getGradePercent('C'));
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write("Percent of students in C range: " + calculations.getGradeDistribution('C') + "%.");
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write("Number of students in C range: " + calculations.getStuPerGrade('C'));
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		//Start of D range
			    		recordWriter.write("D Range is: "+ calculations.getGradePercent('C') + " to: " + calculations.getGradePercent('D'));
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write("Percent of students in D range: " + calculations.getGradeDistribution('D') + "%.");
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write("Number of students in D range: " + calculations.getStuPerGrade('D'));
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		//Start of E range
			    		recordWriter.write("E Range is: " + calculations.getGradePercent('D') + " to: 0");
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write("Percent of students in E range: " + calculations.getGradeDistribution('E') + "%.");
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write("Number of students in E range: " + calculations.getStuPerGrade('E'));
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		recordWriter.write(System.getProperty( "line.separator" ));
			    		
			    		
			    		recordWriter.close();
			    	}
			    	catch(IOException ex)
			    	{
			    		ex.printStackTrace();
			    	}
			    }

			}
		} 
		
	// end of the RecordListener
	
	
	private float inputNumbers;
	private int roundedNumbers;
	private String extension;
	private Scanner scan;
	protected LinkedList<Float> floatList;
	protected LinkedList<Integer> roundedList;
	private int inputOutOfBounds = 0;
	/**
	 * The getFileExtension program takes in a File input and returns its extension type.
	 * <p>
	 * @param file - This File is the file the program finds the extension of.
	 * @return - Returns a string that contains a null string or the extension of the file.
	 */
	private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }
	/**
	 * The LoadSaveListener class implements both the Load button and the Save Button. 
	 * @author Richard Wicklund
	 *
	 */
	private class LoadSaveListener implements ActionListener {
		/**
	     * The actionPerformed method saves the current grades in the system when the save 
	     * button is pushed, and loads a text file of grades into the system.
	     * @param event - This is the event that is triggered when the Save or Load button is pushed, 
	     * and dictates which action happens.
	     */
	    @Override
	    public void actionPerformed(ActionEvent event) {
	    	if (event.getSource() == loadButton) {
		    	int returnVal = fileChooser.showOpenDialog(BaseGUI.this);
		    	if (returnVal == JFileChooser.APPROVE_OPTION) {
	                File file = fileChooser.getSelectedFile();
	                extension = getFileExtension(file);
		                try {
							scan = new Scanner(file);
			                if (extension.compareTo("txt") == 0) {
			                	try {
			                		//attempts to create the Linked Lists for both floating point and integer numbers
			                		floatList = new LinkedList<Float>();
			                		roundedList = new LinkedList<Integer>();
									while(scan.hasNextFloat()) {
										inputNumbers = scan.nextFloat();
										if (inputNumbers <= calculations.getMaxPossible() && inputNumbers >= calculations.getMinPossible()) {
											floatList.addLast(inputNumbers);
											roundedNumbers = Math.round(inputNumbers);
											roundedList.addLast(roundedNumbers);
										} else {
											inputOutOfBounds++;
										}
									}
									if (inputOutOfBounds > 0) {
										floatList = new LinkedList<Float>();
										roundedList = new LinkedList<Integer>();
										// Input Out of Bounds Exception
						                error.setString("Input Out of Bounds: \n" + "There are " + inputOutOfBounds + " inputs of out bounds.\n"
						                		+ "Please change the Highest and Lowest Possible scores in the Grade Statistics Tab, or load a different file.");
						                error.setVisible(true);
										inputOutOfBounds = 0;
									}
									//gives the Calculations the LinkedLists
									calculations.setLinkedLists(floatList, roundedList);
									//System.out.println("Float list: " + floatList); 
									//System.out.println("Rounded list: " + roundedList); 

			                	} catch (InputMismatchException e) {
			                		// Wrong input type exception
					                error.setString("Incorrect Format Error: \nPlease load a file containing floating point numbers on each line.");
					                error.setVisible(true);
								}
			                } else {
				                // Wrong file type exception
				                error.setString("File Type Error: \nPlease load a \".txt\" file");
				                error.setVisible(true);
			                }
						} catch (FileNotFoundException exception) {
			                // File not found/ does not exist exception
			                error.setString("File Not Found: \nPlease load an existing file");
			                error.setVisible(true);
						} finally {
							if (scan != null) {
								scan.close();
							}
						}
		    	} else {
		    		//this is when the load box is closed or cancelled nothing needs to be done here.
		    	}
	    	} else if (event.getSource() == saveButton) {	
			        
			    int saveing = fileChooser.showSaveDialog(BaseGUI.this);
			        
			    if(saveing == JFileChooser.APPROVE_OPTION)
			    {
			    	File saveFile = fileChooser.getSelectedFile();
			    	if (getFileExtension(saveFile).compareTo("txt") != 0) {
			    		String path = saveFile.getAbsolutePath();
			    		path = path + ".txt";
			    		saveFile = new File(path);
			    	}
			    	try
			    	{    			
			    		FileWriter writer = new FileWriter(saveFile);
			    		floatList = calculations.getFloatList();
			    		int Create = 0;
				    	if (floatList != null) {
				    		while(Create < floatList.size())
				    		{
				    			writer.write(floatList.get(Create) + "\n");
				    			Create++;
				    		}
			    		}
			    			
			    		writer.close();
			    	}
			    	catch(IOException ex)
			    	{
			    		ex.printStackTrace();
			    	}
			    }
	    	}
	    }
	}
	/**
	 * The CloseListener class implements the close button.
	 * @author Richard Wicklund
	 */
	private class CloseListener implements ActionListener {
	    /**
	     * The Action performed method closes the program when the close button is pushed.
	     * @param event - This is the event that is triggered when the Close button is pushed.
	     */
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

	private JPanel bottomPanel;
	private JButton closeButton;
	private JButton loadButton;
	private JButton saveButton;
	private JButton recordButton;
	private JFileChooser fileChooser;
	private JScrollPane scrollPane;
	private JPanel statsPanel;
	private Calculations calculations = new Calculations();
	private ErrorPanel error = new ErrorPanel();
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	

}