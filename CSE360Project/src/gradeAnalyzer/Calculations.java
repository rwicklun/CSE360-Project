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
	private int stuAbovePercentile;
	private int botPercentileScore = 0;
	private int stuBelowPercentile;

	
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
	
	public int[] countStuPerGrade(int percentA, int percentB, int percentC, int percentD, int percentE) {
		int countA = 0;
		int countB = 0;
		int countC = 0;
		int countD = 0;
		int countE = 0;
		int countArray[] = new int[5];
		
		int scoreA = maxInUse * percentA / 100;
		int scoreB = maxInUse * percentB / 100;
		int scoreC = maxInUse * percentC / 100;
		int scoreD = maxInUse * percentD / 100;
		
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
		countArray = new int[] {countA, countB, countC, countD, countE};
		return countArray;		
	}
	
	public int scoreAboveTop(int percentileIn) {
		topPercentileScore = maxInUse * percentileIn / 100;
		return topPercentileScore;
	}
	
	public int stuAboveTop() {
		stuAbovePercentile = 0;
		int index = roundedArray.length - 1;
		while (roundedArray[index] >= topPercentileScore && index > 0) {
			stuAbovePercentile ++;
			index --;
		}
		return stuAbovePercentile;
	}
	
	public int scoreBelowBot(int percentileIn) {
		botPercentileScore = maxInUse * percentileIn / 100;
		return botPercentileScore;
	}
	
	public int stuBelowBot() {
		stuBelowPercentile = 0;
		int index = 0;
		while (roundedArray[index] <= botPercentileScore && index < maxInUse) {
			stuBelowPercentile ++;
			index ++;
		}
		return stuBelowPercentile;
	}
	
// End Percentile only ----------------------------------------------------------------------------
}