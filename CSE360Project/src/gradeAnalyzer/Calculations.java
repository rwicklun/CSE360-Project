package gradeAnalyzer;

import java.util.*;

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
			return Integer.toString(roundedArray[roundedArray.length - 1]);
		}
		else {
			return "";
		}
	}
	
	public String getMinEarned() {
		if (roundedList != null ) {
			return Integer.toString(roundedArray[0]);
		}
		else {
			return "";
		}
	}
	
	public String getAverage() {
		if (roundedList != null ) {
			int sum = 0;
			int count = 0;
			float average;
			
			for(int index = 0; index < roundedArray.length; index ++) {
				sum += roundedArray[index];
				count ++;
			}
			average = sum / (float)count;
			return Float.toString(average);
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

}