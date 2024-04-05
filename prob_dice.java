import java.util.ArrayList;
import java.util.HashMap;
public class prob_dice {
public static void calculateDiceSumProbabilities() {
  
    ArrayList<ArrayList<Integer>> diceRolls = new ArrayList<>();
    for (int dieA = 1; dieA <= 6; dieA++) {
      for (int dieB = 1; dieB <= 6; dieB++) {
        ArrayList<Integer> roll = new ArrayList<>();
        roll.add(dieA);
        roll.add(dieB);
        diceRolls.add(roll);
      }
    }

    // HashMap to store sum and its count
    HashMap<Integer, Integer> sumCounts = new HashMap<>();

   
    for (ArrayList<Integer> roll : diceRolls) {
      int sum = roll.get(0) + roll.get(1);
      sumCounts.put(sum, sumCounts.getOrDefault(sum, 0) + 1);
    }

    // Total number of combinations
    int totalCombinations = 6 * 6;

    // Calculate and print probabilities
    double totalProbability = 0.0;
    for (int sumValue = 2; sumValue <= 12; sumValue++) {
      int count = sumCounts.getOrDefault(sumValue, 0); 
      float probability = (float) count / totalCombinations;
      totalProbability+=probability;
      System.out.println("P(Sum = " + sumValue + ") = " + String.format("%.5f",probability));
      
    }
    System.out.println("Total Probability: "+totalProbability);
  }

public static void main(String[] args) {
  calculateDiceSumProbabilities();
}

}
