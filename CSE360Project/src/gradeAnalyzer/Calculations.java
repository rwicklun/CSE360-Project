package gradeAnalyzer;

import java.util.*;

/**
 * 
 * @author Richard Wicklund
 * @author Steven Situ
 *
 */
public class Calculations {
	
	private LinkedList<Float> floatList;
	private LinkedList<Integer> roundedList;
	private Integer roundedArray[];
	//default maximum set to 100
	private int maxPossible = 100;
	//default minimum set to 0
	private int minPossible = 0;
	private int maxEarned;
	private int maxInUse;

	
	public void setLinkedLists (LinkedList<Float> floatListIn, LinkedList<Integer> roundedListIn) {
		floatList = floatListIn;
		roundedList = roundedListIn;
		roundedArray = roundedList.toArray(new Integer[roundedList.size()]);
		Arrays.sort(roundedArray);
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
	}
	public String getMinEarned() {
		if (roundedList != null ) {
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
	}
	
	public int studentCount() {
		return roundedArray.length;
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
				return "" + average;
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
				median = (float)roundedArray[middleLocation + 1];
			}
			return "" + median;
		} else {
			return "";
		}
	}
	public String addGrade(float newGrade) {
		if (newGrade <= maxPossible && newGrade >= minPossible) {
			floatList.add(newGrade);
			roundedList.add(Math.round(newGrade));
			roundedArray = roundedList.toArray(new Integer[roundedList.size()]);
			Arrays.sort(roundedArray);
			return "Adding " + newGrade + " was successful.";
		} else {
			ErrorPanel error = new ErrorPanel();
			error.setString("Grade Out Of Bounds: \nPlease input a grade between " + maxPossible + " and " + minPossible + ".");
			error.setVisible(true);
			return "";
		}
	}
	public String deleteGrade(float oldGrade) {
		if (floatList != null) {
			int floatFound = floatList.lastIndexOf(oldGrade);
			if (floatFound != -1) {
				floatList.remove(floatFound);
				roundedList.remove(floatFound);
				roundedArray = roundedList.toArray(new Integer[roundedList.size()]);
				Arrays.sort(roundedArray);
				return "Deleting " + oldGrade + " was successful.";
			} else if (oldGrade % 1 == 0) {
				int roundedFound = roundedList.lastIndexOf((int) oldGrade);
				if (roundedFound != -1) {
					floatList.remove(roundedFound);
					roundedList.remove(roundedFound);
					roundedArray = roundedList.toArray(new Integer[roundedList.size()]);
					Arrays.sort(roundedArray);
					return "Deleting " + oldGrade + " was successful.";
				} else {
					ErrorPanel error = new ErrorPanel();
					error.setString("Grade Not Found: \nPlease enter one of the following grades:\n"
							+ floatList.toString() + ", or " + roundedList.toString());
					error.setVisible(true);
					return "";
				}
			} else {
				ErrorPanel error = new ErrorPanel();
				error.setString("Grade Not Found: \nPlease enter one of the following grades:\n"
						+ floatList.toString() + ", or " + roundedList.toString());
				error.setVisible(true);
				return "";
			}
		}
		return "";
	}
	
// End Statistics only ----------------------------------------------------------------------------
	
// Start Percentile only --------------------------------------------------------------------------
	
	public void setMaxInUseToPossible() {
		maxInUse = maxPossible;
	}
	
	public void setMaxInUseToEarned() {
		maxInUse = maxEarned;
	}
	
	public int[] countStuPerGrade(int gradeA, int gradeB, int gradeC, int gradeD, int gradeF) {
		int countA = 0;
		int countB = 0;
		int countC = 0;
		int countD = 0;
		int countF = 0;
		int countArray[];
		
		for(int index = 0; index < roundedArray.length; index ++) {
			if (roundedArray[index] <= gradeF) {
				countF ++;
			}
			else if (roundedArray[index] <= gradeD) {
				countD ++;
			}
			else if (roundedArray[index] <= gradeC) {
				countC ++;
			}
			else if (roundedArray[index] <= gradeB) {
				countB ++;
			}
			else if (roundedArray[index] <= gradeA) {
				countA ++;
			}
		}
		countArray = new int[] {countA, countB, countC, countD, countF};
		return countArray;
	}
	
// End Percentile only ----------------------------------------------------------------------------
}