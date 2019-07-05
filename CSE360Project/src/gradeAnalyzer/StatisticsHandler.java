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
	public StatisticsHandler(LinkedList<Float> floater, LinkedList<Integer> rounder) {
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
}
