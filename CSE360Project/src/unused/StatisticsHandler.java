package unused;

import java.util.*;


public class StatisticsHandler {
	protected LinkedList<Float> floatList;
	protected LinkedList<Integer> roundedList;
	//default maximum set to 100
	private int maximumPossibleGrade = 100;
	//default minimum set to 0
	private int minimumPossibleGrade = 0;
	private Integer sortRounded[];
	public StatisticsHandler() {
		
	}
	public void setLinkedLists (LinkedList<Float> floater, LinkedList<Integer> rounder) {
		floatList = floater;
		roundedList = rounder;
		sortRounded = roundedList.toArray(new Integer[roundedList.size()]);
		Arrays.sort(sortRounded);
	}
	public void setMaxGrade(int max) {
		maximumPossibleGrade = max;
	}
	public void setMinGrade(int min) {
		minimumPossibleGrade = min;
	}
	public int getDefaultMaxGrade() {
		return 100;
	}
	public int getMaxGrade() {
		return maximumPossibleGrade;
	}
	public int getMinGrade() {
		return minimumPossibleGrade;
	}
	public int getDefaultMinGrade() {
		return 0;
	}
	public String getMaxAcheived() {
		if (roundedList != null ) {
			int count = roundedList.size();
			int max = minimumPossibleGrade;
			while(count > 0) {
				int newNumber = roundedList.get(count - 1);
				count--;
				if (max <= newNumber && newNumber <= maximumPossibleGrade) {
					max = newNumber;
				}
			}
			return "" + max;
		} else {
			return "";
		}
	}
	public String getMinAcheived() {
		if (roundedList != null ) {
			int count = roundedList.size();
			int min = maximumPossibleGrade;
			while(count > 0) {
				int newNumber = roundedList.get(count - 1);
				count--;
				if (min >= newNumber && newNumber >= minimumPossibleGrade) {
					min = newNumber;
				}
			}
			return "" + min;
		} else {
			return "";
		}
	}
	public String getAverage() {
		if (roundedList != null ) {
			int iterator = roundedList.size();
			int sum = 0;
			float average = 0;
			int count = 0;
			while(iterator > 0) {
				int input = roundedList.get(iterator - 1);
				if ((input >= minimumPossibleGrade) && (input <= maximumPossibleGrade)) {
					count++;
					sum = sum + input;
				}
				iterator--;
			}
			if (count >= 1) {
				average = (float)sum / (float)count;
				return "" + average;
			} else {
				return "";
			}
			
		} else {
			return "";
		}
		
	}
	public String getMedian() {
		if (sortRounded != null) {
		int lowerBound = 0;
		int upperBound = sortRounded.length;
			for (int iterator = 0; iterator < sortRounded.length; iterator++) {
				if (minimumPossibleGrade > sortRounded[iterator]) {
					lowerBound = iterator + 1;
				}
			}
			for (int iterator = sortRounded.length - 1; iterator >= 0; iterator--) {
				if (maximumPossibleGrade < sortRounded[iterator]) {
					upperBound = iterator;
				}
			}
			Integer subArray[] = Arrays.copyOfRange(sortRounded, lowerBound, upperBound);
			float median;
			int subRoundedLength = subArray.length;
			int middleLocation = subRoundedLength / 2;
			if (subRoundedLength % 2 == 0) {
				median = ((float) sortRounded[middleLocation - 1] + (float) sortRounded[middleLocation]) / (float) 2;
			} else {
				median = (float)sortRounded[middleLocation + 1];
			}
			return "" + median;
		} else {
			return "";
		}
	}
}
