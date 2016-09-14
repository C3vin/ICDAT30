package INQ;

public class amazonLocker {
	private static int[][] printMatrix(int cityWidth, int cityLength, int[] xCordinates, int[] yCordinates) {
		int[][] lockerDistances = new int[cityWidth][cityLength];
		for(int i=0; i<cityLength; i++) {
			for(int j=0; j<cityWidth; j++) {
				int lockDistance = findNearestLocker(i,j,xCordinates,yCordinates);
				lockerDistances[j][i] = lockDistance;
				//System.out.print(lockDistance + " ");
			}
			//System.out.println();
		}
		return lockerDistances;
	}

	private static int findNearestLocker(int i, int j, int[] xCordinates, int[] yCordinates) {
		int totalLocker = xCordinates.length;
		int distance = Integer.MAX_VALUE;

		for(int l=0; l<totalLocker; l++) {
			int x = xCordinates[l];
			int y = yCordinates[l];
			int tempDistance = Math.abs(x-j-1) + Math.abs(y-i-1);
			if(distance > tempDistance) {
				distance = tempDistance;
			}
		}
		return distance;
	}

	public static void main(String[] args) {
		int cityWidth = 5;
		int cityLength = 7;
		int[] xCordinates = {2, 4};
		int[] yCordinates = {3, 7};
		int[][] res = printMatrix(cityWidth,cityLength,xCordinates,yCordinates);
		for(int i=0; i<cityWidth; i++) {
			for(int j=0; j<cityLength; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
}
