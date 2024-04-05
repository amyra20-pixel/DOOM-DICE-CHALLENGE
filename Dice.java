import java.util.HashMap;
import java.util.Map;

public class Dice {

  public static void main(String[] args) {
    int[] dieA = {1, 2, 3, 4, 5, 6};
    int[] dieB = dieA;

    int[][] newDice = undoomDice(dieA, dieB);
    System.out.println("Original Die A: " + java.util.Arrays.toString(dieA));
    System.out.println("Original Die B: " + java.util.Arrays.toString(dieB));
    System.out.println("New Die A: " + java.util.Arrays.toString(newDice[0]));
    System.out.println("New Die B: " + java.util.Arrays.toString(newDice[1]));
  }

  public static int[][] undoomDice(int[] dieA, int[] dieB) {
    
    int totalSpotsA = 0;
    int[] newDieA = new int[dieA.length]; 
    for (int i = 0; i < dieA.length; i++) {
      totalSpotsA += dieA[i];
      newDieA[i] = Math.min(dieA[i], 4); 
    }

    // Calculate original and new sum counts in a single loop
    Map<Integer, Integer> sumCounts = new HashMap<>();
    for (int a : dieA) {
      for (int b = 1; b <= 6; b++) {
        int sum = a + b;
        sumCounts.put(sum, sumCounts.getOrDefault(sum, 0) + 1);
        sumCounts.put(sum, sumCounts.get(sum) - (a <= 4 ? a : 4)); // Adjust for newDieA
      }
    }

    
    int additionalSpotsB = 0;
    for (Map.Entry<Integer, Integer> entry : sumCounts.entrySet()) {
      additionalSpotsB += Math.max(0, entry.getValue());
    }

    
    int[] newDieB = new int[6];
    for (int i = 5; i >= 0; i--) {
      newDieB[i] = Math.min(additionalSpotsB, 6);
      additionalSpotsB -= Math.min(additionalSpotsB, 6);
    }

    return new int[][]{newDieA, newDieB};
  }
}
