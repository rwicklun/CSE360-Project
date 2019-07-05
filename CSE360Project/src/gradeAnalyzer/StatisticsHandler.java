package gradeAnalyzer;

import java.util.*;


public class StatisticsHandler {
	protected LinkedList<Float> floatList;
	protected LinkedList<Integer> roundedList;
	//default maximum set to 100
	private int maximumPossibleGrade = 100;
	//default minimum set to 0
	private int minimumPossibleGrade = 0;
	public StatisticsHandler() {
		
	}
	public void setLinkedLists (LinkedList<Float> floater, LinkedList<Integer> rounder) {
		floatList = floater;
		roundedList = rounder;
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
			int max = roundedList.get(count - 1);
			while(count > 0) {
				int newNumber = roundedList.get(count - 1);
				count--;
				if (max < newNumber && newNumber < maximumPossibleGrade) {
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
			int min = roundedList.get(count - 1);
			while(count > 0) {
				int newNumber = roundedList.get(count - 1);
				count--;
				if (min > newNumber && newNumber > minimumPossibleGrade) {
					min = newNumber;
				}
			}
			return "" + min;
		} else {
			return "";
		}
	}
}
