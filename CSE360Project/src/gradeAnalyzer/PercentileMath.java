package gradeAnalyzer;

public class PercentileMath {
	
	private Float floatArray[];
	private int maxPossible;
	private float maxEarned;
	private float maxInUse;
	
	public PercentileMath() {
		floatArray = null;
		maxPossible = 100;
		maxEarned = 100;
		maxInUse = maxPossible;
	}
	
	public PercentileMath(Float floatArrayIn[], int maxPossibleIn) {
		floatArray = floatArrayIn;
		maxPossible = maxPossibleIn;
		maxEarned = floatArray[floatArray.length - 1];
		maxInUse = maxPossible;
	}
	
	public void setFloatArray(Float floatArrayIn[]) {
		floatArray = floatArrayIn;
		maxEarned = floatArray[floatArray.length - 1];
	}
	
	public void setMaxPossible(int maxPossibleIn) {
		maxPossible = maxPossibleIn;
	}
	
	public void setMaxToPossible() {
		maxInUse = maxPossible;
	}
	
	public void setMaxToEarned() {
		maxInUse = maxEarned;
	}
	
	
}
