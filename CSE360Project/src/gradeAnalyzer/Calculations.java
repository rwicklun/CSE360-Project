package gradeAnalyzer;

import java.text.DecimalFormat;
import java.util.*;

/**
 * 
 * @author Richard Wicklund
 * @author Steven Situ
 *
 */
public class Calculations {
	
	private ErrorPanel error = new ErrorPanel();
	
	private LinkedList<Float> floatList;
	private LinkedList<Integer> roundedList;
	private Integer roundedArray[];
	
	//default maximum set to 100
	private int maxPossible = 100;
	//default minimum set to 0
	private int minPossible = 0;
	private int maxEarned;
	
	private int maxInUse = maxPossible;
	private int topPercentileScore = 90;
	private int stuAbovePercent;
	private int botPercentileScore = 0;
	private int stuBelowPercent;
	
	private float gradeDistributA;
	private float gradeDistributB;
	private float gradeDistributC;
	private float gradeDistributD;
	private float gradeDistributE;
	
	private int stuCount;
	private int stuCountArray[] = new int[] {0, 0, 0, 0, 0};
	
	private int gradePercentA = 90;
	private int gradePercentB = 80;
	private int gradePercentC = 70;
	private int gradePercentD = 60;
	
	private int topPercent;
	private int botPercent;
	private int percentile = 90;
	private int stuPercentile = 0;
	
	/**
	 * Initializes floatList and roundedList with lists created in BaseGUI
	 * uses roundedList to initialize rounded array
	 * Sorts roundedArray
	 * 
	 * @param floatListIn	LinkedList of float numbers from BaseGUI
	 * @param roundedListIn	LinkedList of rounded numbers from floatList and BaseGUI
	 */
	public void setLinkedLists (LinkedList<Float> floatListIn, LinkedList<Integer> roundedListIn) {
		floatList = floatListIn;
		roundedList = roundedListIn;
		roundedArray = roundedList.toArray(new Integer[roundedList.size()]);
		Arrays.sort(roundedArray);
	}
	
	/**
	 * Returns the float LinkedList
	 * 
	 * @return float LinkedList
	 */
	public LinkedList<Float> getFloatList(){
		return floatList;
	}
	
	/**
	 * Refresh roundedArray by making new array from current roundedList
	 * Sorts new roundedArray
	 * Sets the count of students into stuCount
	 */
	public void refreshRoundedArray() {
		if (roundedList != null) {
			roundedArray = roundedList.toArray(new Integer[roundedList.size()]);
			Arrays.sort(roundedArray);
			stuCount = roundedArray.length;
		}
		else {
			roundedArray = null;
		}
	}
	/**
	 * Sets new maxPossible with max from statisticsPanel input
	 * 
	 * @param int max possible from statisticsPanel input
	 */
	public void setMaxPossible(int max) {
		maxPossible = max;
		
	}
	/**
	 * Sets new minPossible with min from statisticsPanel input
	 * 
	 * @param int min possible from statisticsPanel input
	 */
	public void setMinPossible(int min) {
		minPossible = min;
		
	}
	/**
	 * Returns default max possible of 100
	 * @return 100
	 */
	public int getDefaultMaxPossible() {
		return 100;
	}
	/**
	 * Returns current max possible
	 * @return current max possible
	 */
	public int getMaxPossible() {
		return maxPossible;
	}
	/**
	 * Returns current min possible
	 * @return current min possible
	 */
	public int getMinPossible() {
		return minPossible;
	}
	/**
	 * Returns default min possible
	 * @return 0
	 */
	public int getDefaultMinPossible() {
		return 0;
	}
	
	/**
	 * Scans through roundedList and returns largest value as a string
	 * 
	 * @return String of integer largest value in roundedList
	 * 			returns empty string if array empty
	 */
	public String getMaxEarned() {
		if (roundedList != null ) {
			if (roundedArray.length != 0) {
				int max = minPossible;
				for (int count = roundedList.size(); count > 0; count--) {
					int newNumber = roundedList.get(count - 1);
					if (max <= newNumber && newNumber <= maxPossible) {
						max = newNumber;
					}
				}
				return "" + max;
			} else {
				return "";
			}
		} else {
			return "";
		}
	}
	/**
	 * Scans through roundedList and returns smallest value as a string
	 * 
	 * @return String of integer smallest value in roundedList
	 * 			returns empty string if array empty
	 */
	public String getMinEarned() {
		if (roundedList != null ) {
			if (roundedArray.length != 0) {
				int min = maxPossible;
				for (int count = 0; count < roundedList.size(); count++) {
					int newNumber = roundedList.get(count);
					if (min >= newNumber && newNumber >= minPossible) {
						min = newNumber;
					}
				}
				return "" + min;
			} else {
				return "";
			}
		} else {
			return "";
		}
	}
	
	/**
	 * Returns the length of roundedArray 
	 * 
	 * @return int length of roundedArray or 0 if roundedArray null
	 */
	public int studentCount() {
		if (roundedArray != null)
			return roundedArray.length;
		else
			return 0;
	}
	
// Start Statistics only --------------------------------------------------------------------------
	public String getAverage() {
		if (roundedList != null ) {
			int sum = 0;
			int count = 0;
			double average;
			
			for (int iterator = 0; iterator < roundedList.size(); iterator++) {
				int input = roundedList.get(iterator);
				if ((input >= minPossible) && (input <= maxPossible)) {
					count++;
					sum = sum + input;
				}
			}
			if (count >= 1) {
				average = sum / (double) count;
				DecimalFormat decimalForm = new DecimalFormat("0.00");
				return "" + decimalForm.format(average);
			} else {
				return "";
			}
		}
		else {
			return "";
		}
	}
	
	public String getMedian() {
		if (roundedArray != null) {
			if (roundedArray.length != 0) {
				int lowerBound = 0;
				int upperBound = roundedArray.length;
				for (int iterator = 0; iterator < roundedArray.length; iterator++) {
					if (minPossible > roundedArray[iterator]) {
						lowerBound = iterator + 1;
					}
				}
				for (int iterator = roundedArray.length - 1; iterator >= 0; iterator--) {
					if (maxPossible < roundedArray[iterator]) {
						upperBound = iterator;
					}
				}
				Integer subArray[] = Arrays.copyOfRange(roundedArray, lowerBound, upperBound);
				float median;
				int subRoundedLength = subArray.length;
				int middleLocation = subRoundedLength / 2;
				if (subRoundedLength % 2 == 0) {
					median = ((float) roundedArray[middleLocation - 1] + (float) roundedArray[middleLocation]) / (float) 2;
				} else {
					median = (float)roundedArray[middleLocation];
				}
				DecimalFormat decimalForm = new DecimalFormat("0.00");
				return "" + decimalForm.format(median);
			} else {
				return "";
			}
		} else {
			return "";
		}
	}
	public void addGrade(float newGrade) {
		if (floatList == null) {
			floatList = new LinkedList<Float>();
    		roundedList = new LinkedList<Integer>();
		}
		if (newGrade <= maxPossible && newGrade >= minPossible) {
			floatList.add(newGrade);
			roundedList.add(Math.round(newGrade));
			roundedArray = roundedList.toArray(new Integer[roundedList.size()]);
			Arrays.sort(roundedArray);
		} else {
			ErrorPanel error = new ErrorPanel();
			error.setString("Grade Out Of Bounds: \nPlease input a grade between " + maxPossible + " and " + minPossible + ".");
			error.setVisible(true);
		}
	}
	public void deleteGrade(float oldGrade) {
		if (floatList != null) {
			int floatFound = floatList.lastIndexOf(oldGrade);
			if (floatFound != -1) {
				floatList.remove(floatFound);
				roundedList.remove(floatFound);
				roundedArray = roundedList.toArray(new Integer[roundedList.size()]);
				Arrays.sort(roundedArray);
			} else if (oldGrade % 1 == 0) {
				int roundedFound = roundedList.lastIndexOf((int) oldGrade);
				if (roundedFound != -1) {
					floatList.remove(roundedFound);
					roundedList.remove(roundedFound);
					roundedArray = roundedList.toArray(new Integer[roundedList.size()]);
					Arrays.sort(roundedArray);
				} else {
					ErrorPanel error = new ErrorPanel();
					error.setString("Grade Not Found: \nPlease enter one of the following grades:\n"
							+ floatList.toString() + ", or " + roundedList.toString());
					error.setVisible(true);
				}
			} else {
				ErrorPanel error = new ErrorPanel();
				error.setString("Grade Not Found: \nPlease enter one of the following grades:\n"
						+ floatList.toString() + ", or " + roundedList.toString());
				error.setVisible(true);
			}
		}
	}
	public void replaceGrade(float oldGrade, float newGrade) {
		if (floatList != null) {
			int floatFound = floatList.lastIndexOf(oldGrade);
			if (floatFound != -1) {
				if (newGrade <= maxPossible && newGrade >= minPossible) {
					floatList.set(floatFound, newGrade);
					roundedList.set(floatFound, Math.round(newGrade));
					roundedArray = roundedList.toArray(new Integer[roundedList.size()]);
					Arrays.sort(roundedArray);
				} else {
					ErrorPanel error = new ErrorPanel();
					error.setString("Grade Out Of Bounds: \nPlease input a grade between " + maxPossible + " and " + minPossible + ".");
					error.setVisible(true);
				}
			} else if (oldGrade % 1 == 0) {
				int roundedFound = roundedList.lastIndexOf((int) oldGrade);
				if (roundedFound != -1) {
					if (newGrade <= maxPossible && newGrade >= minPossible) {
						floatList.remove(roundedFound);
						roundedList.remove(roundedFound);
						roundedArray = roundedList.toArray(new Integer[roundedList.size()]);
						Arrays.sort(roundedArray);
					} else {
						ErrorPanel error = new ErrorPanel();
						error.setString("Grade Out Of Bounds: \nPlease input a grade between " + maxPossible + " and " + minPossible + ".");
						error.setVisible(true);
					}
				} else {
					ErrorPanel error = new ErrorPanel();
					error.setString("Grade Not Found: \nPlease enter one of the following grades:\n"
							+ floatList.toString() + ", or " + roundedList.toString());
					error.setVisible(true);
				}
			} else {
				ErrorPanel error = new ErrorPanel();
				error.setString("Grade Not Found: \nPlease enter one of the following grades:\n"
						+ floatList.toString() + ", or " + roundedList.toString());
				error.setVisible(true);
			}
		}
	}
	
// End Statistics only ----------------------------------------------------------------------------
	
// Start Percentile only --------------------------------------------------------------------------
	
	/**
	 * Sets max used for percentile calculations to max possible
	 */
	public void setMaxInUseToPossible() {
		if (roundedArray != null) {
			maxInUse = maxPossible;
		}
		else {
			error.setString("No student grades have been entered.");
			error.setVisible(true);
		}
	}
	
	/**
	 * Sets max used for percentile calculations to max possible
	 */
	public void setMaxInUseToEarned() {
		if (roundedArray.length > 0) {
			maxEarned = roundedArray[roundedArray.length - 1];
			maxInUse = maxEarned;
		}
		else {
			error.setString("No student grades have been entered.");
			error.setVisible(true);
		}
	}
	
	/**
	 * Returns the max currently used for calculations
	 * 
	 * @return maxInUse
	 */
	public int getMaxInUse() {
		return maxInUse;
	}
	
	/**
	 * Takes in letter and grade percent and sets each letter variable to the correct value
	 * 
	 * @param letterIn	A,B,C, or D to be used to set variable value
	 * @param gradeIn	int percent 
	 */
	public void setGradePercent(char letterIn, int gradeIn) {
		switch (letterIn) {
		case 'A':
			gradePercentA = gradeIn;
			break;
		case 'B':
			gradePercentB = gradeIn;
			break;
		case 'C':
			gradePercentC = gradeIn;
			break;
		case 'D':
			gradePercentD = gradeIn;
			break;
		}
	}
	
	public int getGradePercent(char letterIn) {
		int output = 0;
		switch (letterIn) {
		case 'A':
			output = gradePercentA;
			break;
		case 'B':
			output = gradePercentB;
			break;
		case 'C':
			output = gradePercentC;
			break;
		case 'D':
			output = gradePercentD;
			break;
		}
		return output;
	}
	
	/**
	 * Counts the amount of students in each grade range and returns as int[]
	 * 
	 * @return int[] of the amount of students in each grade [0]=A, [1]=B, [2]=C, [3]=D, [4]=E
	 */
	public int[] countStuPerGrade() {
		int countA = 0;
		int countB = 0;
		int countC = 0;
		int countD = 0;
		int countE = 0;

		int scoreA = maxInUse * gradePercentA / 100;
		int scoreB = maxInUse * gradePercentB / 100;
		int scoreC = maxInUse * gradePercentC / 100;
		int scoreD = maxInUse * gradePercentD / 100;
		
		for(int index = 0; index < roundedArray.length; index ++) {
			if (roundedArray[index] <= scoreD) {
				countE ++;
			}
			else if (roundedArray[index] <= scoreC) {
				countD ++;
			}
			else if (roundedArray[index] <= scoreB) {
				countC ++;
			}
			else if (roundedArray[index] <= scoreA) {
				countB ++;
			}
			else if (roundedArray[index] <= maxInUse) {
				countA ++;
			}
			else {
				error.setString("Count failed.");
				error.setVisible(true);
			}
		}
		stuCountArray = new int[] {countA, countB, countC, countD, countE};
		return stuCountArray;		
	}
	
	/**
	 * Outputs the students per grade when entering a grade
	 * @param letterIn Input char of grade
	 * @return returns students count
	 */
	public int getStuPerGrade(char letterIn) {
		int output = 0;
		switch (letterIn) {
		case 'A':
			output = stuCountArray[0];
			break;
		case 'B':
			output = stuCountArray[1];
			break;
		case 'C':
			output = stuCountArray[2];
			break;
		case 'D':
			output = stuCountArray[3];
			break;
		case 'E':
			output = stuCountArray[4];
			break;
		}
		return output;
	}
	
	/**
	 * Calculates the grade distribution based on how many students 
	 * earned each letter grade and the total amount of students
	 */
	public void setGradeDistResults() {
		gradeDistributA = 100 * stuCountArray[0] / stuCount;
		gradeDistributB = 100 * stuCountArray[1] / stuCount;
		gradeDistributC = 100 * stuCountArray[2] / stuCount;
		gradeDistributD = 100 * stuCountArray[3] / stuCount;
		gradeDistributE = 100 * stuCountArray[4] / stuCount;
	}
	
	/**
	 * Returns the grade distributions percent based on the letter grade put in as a parameter
	 * 
	 * @param letterIn	Tells what letter grade want results returned for
	 * @return	float of grade distribution percent based on parameter
	 */
	public int getGradeDistribution(char letterIn) {
		float output = 0;
		switch (letterIn) {
		case 'A':
			output = gradeDistributA;
			break;
		case 'B':
			output = gradeDistributB;
			break;
		case 'C':
			output = gradeDistributC;
			break;
		case 'D':
			output = gradeDistributD;
			break;
		case 'E':
			output = gradeDistributE;
			break;
		}
		return Math.round(output);
	}
	
	/**
	 * Checks to see if there are any grades entered and will produce error message if no list
	 * 
	 * @return	Boolean of true->grades exist false->no grades entered
	 */
	public boolean checkGradesExist() {
		boolean fail = false;
		if (stuCount <= 0) {
			fail = true;
			error.setString("No student grades have been entered.");
			error.setVisible(true);
		}
		return fail;
	}
	
	/**
	 * Set variables with the values of topPercent and botPercent
	 * Set based on parameter input values user entered
	 * 
	 * @param percentIn	The value of the percent being stored in calculations
	 * @param topBotIn	1=store in topPercent, 0=store in botPercent
	 */
	public void setTopBotPercent(int percentIn, int topBotIn) {
		// enter 1 for top and 0 for bottom
		switch (topBotIn) {
		case 1:
			topPercent = percentIn;
		case 0:
			botPercent = percentIn;
		}
	}
	
	/**
	 * Returns the top or bot percent entered by user
	 * @param letterIn	T or B for if you want top or bottom
	 * @return	int percent of top or bottom
	 */
	private int getTopBotPercent(char letterIn) {
		int output = 0;
		switch (letterIn) {
		case 'T':
			output = topPercent;
		case 'B':
			output = botPercent;
		}
		return output;
	}
	
	/**
	 * Calculates the number of students above input percent
	 * 
	 * @return int Amount of students in top __ percent
	 */
	public int stuTopPercent() {
		double stuAbove = roundedArray.length * topPercent / 100.0;
		stuAbovePercent = (int)Math.ceil(stuAbove);
		return stuAbovePercent;
	}

	/**
	 * 	Finds score required to be in top __ percent given in stuTopPercent
	 * 
	 * @return	int the score required to be in top ___ percent
	 */
	public int scoreAboveTop() {
		int inverseStuAbove = roundedArray.length - stuAbovePercent;
		for (int index = roundedArray.length - 1; index > inverseStuAbove - 1; index --) {
			topPercentileScore = roundedArray[index];
		}
		return topPercentileScore;
	}
	
	/**
	 * Calculates the number of students below input percent
	 * 
	 * @return int Amount of students in bottom __ percent
	 */
	public int stuBotPercent() {
		double stuBelow = roundedArray.length * botPercent / 100.0;
		stuBelowPercent = (int)Math.ceil(stuBelow);
			return stuBelowPercent;
	}
	
	/**
	 * 	Finds score required to be in bottom __ percent given in stuBotPercent
	 * 
	 * @return	int the score required to be in top ___ percent
	 */
	public int scoreBelowBot() {
		for (int index = 0; index < stuBelowPercent; index ++) {
			botPercentileScore = roundedArray[index];
		}
		return botPercentileScore;
	}

	/**
	 * Sets and stores the percentile from user input
	 * 
	 * @param percentileIn	int value from user
	 */
	public void setPercentile(int percentileIn) {
		percentile = percentileIn;
	}
	
	/**
	 * Calculates amount of students in the percentile provided by user
	 * 
	 * @return int number of students in selected percentile
	 */
	public int giveStuInPercentile() {
		if (floatList != null) {
			int invPercentile = 100 - percentile;
			double stuPercentileDouble = roundedArray.length * invPercentile / 100.0;
			stuPercentile = (int)Math.ceil(stuPercentileDouble);
			return stuPercentile;
		} else {
			return stuPercentile;
		}
	}
	public int getPercentile() {
		return percentile;
	}
// End Percentile only ----------------------------------------------------------------------------
}