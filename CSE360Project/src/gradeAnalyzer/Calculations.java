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
	private int stuCountArray[] = new int[5];
	
	private int gradePercentA;
	private int gradePercentB;
	private int gradePercentC;
	private int gradePercentD;
	
	private int topPercent;
	private int botPercent;
	private int percentile;
	private int stuPercentile;
	
	public void setLinkedLists (LinkedList<Float> floatListIn, LinkedList<Integer> roundedListIn) {
		floatList = floatListIn;
		roundedList = roundedListIn;
		roundedArray = roundedList.toArray(new Integer[roundedList.size()]);
		Arrays.sort(roundedArray);
	}
	public LinkedList<Float> getFloatList(){
		return floatList;
	}
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
	public void printRoundedArray() {
		System.out.println("Rounded array " + Arrays.toString(roundedArray)); 
	}
	public void setMaxPossible(int max) {
		maxPossible = max;
		
	}
	public void setMinPossible(int min) {
		minPossible = min;
		
	}
	public int getDefaultMaxPossible() {
		return 100;
	}
	public int getMaxPossible() {
		return maxPossible;
	}
	public int getMinPossible() {
		return minPossible;
	}
	public int getDefaultMinPossible() {
		return 0;
	}
	
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
	
	public void setMaxInUseToPossible() {
		if (roundedArray != null) {
			maxInUse = maxPossible;
		}
		else {
			error.setString("No student grades have been entered.");
			error.setVisible(true);
		}
	}
	
	public void setMaxInUseToEarned() {
		if (roundedArray != null) {
			maxEarned = roundedArray[roundedArray.length - 1];
			maxInUse = maxEarned;
		}
		else {
			error.setString("No student grades have been entered.");
			error.setVisible(true);
		}
	}
	
	public int giveMaxInUse() {
		return maxInUse;
	}
	
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
	
	public void setGradeDistResults() {
		gradeDistributA = 100 * stuCountArray[0] / stuCount;
		gradeDistributB = 100 * stuCountArray[1] / stuCount;
		gradeDistributC = 100 * stuCountArray[2] / stuCount;
		gradeDistributD = 100 * stuCountArray[3] / stuCount;
		gradeDistributE = 100 * stuCountArray[4] / stuCount;
	}
	
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
	
	public boolean checkPercentOrder() {
		boolean fail = false;
		
		if (gradePercentA > 100 || gradePercentA < gradePercentB) {
			gradeOrderError('A');
			fail = true;
		}
		if (gradePercentB > gradePercentA || gradePercentB < gradePercentC) {
			gradeOrderError('B');
			fail = true;
		}
		if (gradePercentC > gradePercentB || gradePercentC < gradePercentD) {
			gradeOrderError('C');
			fail = true;
		}
		if (gradePercentD > gradePercentC) {
			gradeOrderError('D');
			fail = true;
		}
		return fail;
	}
	
	public void gradeOrderError(char gradeIn) {
		switch(gradeIn) {
		case 'A': 
			error.setString("Make sure the percent for A is less than 100 and greater than B");
			error.setVisible(true);
			break;
		case 'B':
			error.setString("Make sure the percent for B is less than A and greater than C");
			error.setVisible(true);
			break;
		case 'C':
			error.setString("Make sure the percent for C is less than B and greater than D");
			error.setVisible(true);
			break;
		case 'D':
			error.setString("Make sure the percent for D is less than C and greater than E");
			error.setVisible(true);
			break;
		case 'E':
			error.setString("Make sure the percent for E is less than D and greater than 0");
			error.setVisible(true);
			break;
		}
	}
	
	public boolean checkGradesExist() {
		boolean fail = false;
		if (stuCount <= 0) {
			fail = true;
			error.setString("No student grades have been entered.");
			error.setVisible(true);
		}
		return fail;
	}
	
	public void setTopBotPercent(int percentIn, int topBotIn) {
		// enter 1 for top and 0 for bottom
		switch (topBotIn) {
		case 1:
			topPercent = percentIn;
		case 0:
			botPercent = percentIn;
		}
	}
	
	// Number of students above input percent
	public int stuTopPercent() {
		double stuAbove = roundedArray.length * topPercent / 100.0;
		stuAbovePercent = (int)Math.ceil(stuAbove);
		return stuAbovePercent;
	}
	// score required to be in top percent given in stuAboveTop
	public int scoreAboveTop() {
		int inverseStuAbove = roundedArray.length - stuAbovePercent;
		for (int index = roundedArray.length - 1; index > inverseStuAbove - 1; index --) {
			topPercentileScore = roundedArray[index];
		}
		return topPercentileScore;
	}
	// number of students below input percent
	public int stuBotPercent() {
		double stuBelow = roundedArray.length * botPercent / 100.0;
		stuBelowPercent = (int)Math.ceil(stuBelow);
			return stuBelowPercent;
	}
	//score required to be in bottom percent given in stuBelowBot
	public int scoreBelowBot() {
		for (int index = 0; index < stuBelowPercent; index ++) {
			botPercentileScore = roundedArray[index];
		}
		return botPercentileScore;
	}

	public void setPercentile(int percentileIn) {
		percentile = percentileIn;
	}
	
	public int giveStuInPercentile() {
		int invPercentile = 100 - percentile;
		double stuPercentileDouble = roundedArray.length * invPercentile / 100.0;
		stuPercentile = (int)Math.ceil(stuPercentileDouble);
		return stuPercentile;
	}
	
// End Percentile only ----------------------------------------------------------------------------
}