package gradeAnalyzer;

public class PercentileMath {
	
	private Float floatArray[];
	private int maxPossible;
	private float maxEarned;
	
	public PercentileMath(Float floatArrayIn[], int maxPossibleIn) {
		floatArray = floatArrayIn;
		maxPossible = maxPossibleIn;
		maxEarned = floatArray[floatArray.length - 1];
	}
	
	
}
