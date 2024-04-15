import java.util.Arrays;

public class CombinedDiceProbability {

    // Function to calculate the sum combinations of two dice
    public static int[][] sumCombinations(int[] dieA, int[] dieB) {
        int[][] sums = new int[dieA.length][dieB.length];
        
        for (int i = 0; i < dieA.length; i++) {
            for (int j = 0; j < dieB.length; j++) {
                sums[i][j] = dieA[i] + dieB[j];
            }
        }
        return sums;
    }

    // Function to calculate probabilities for each sum
    public static double[] getAllProbabilities(int[] dieA, int[] dieB) {
        int totalCombinations = dieA.length * dieB.length;
        double[] probabilities = new double[13];
        for (int i = 0; i < dieA.length; i++) {
            for (int j = 0; j < dieB.length; j++) {
                int sum = dieA[i] + dieB[j];
                probabilities[sum] += 1.0;
            }
        }
        for (int i = 2; i <= 12; i++) {
            probabilities[i] /= totalCombinations;
        }
        return probabilities;
    }
 // Function to print matrix combinations
 public static void matrixCombinations(int[][] sums) {
    for (int[] row : sums) {
        for (int sum : row) {
            System.out.print(sum + " ");
        }
        System.out.println();
    }
}
public static void main(String[] args) {
        // Original dice sets
        int[] originalDieA = {1, 2, 3, 4, 5, 6};
        int[] originalDieB = {1, 2, 3, 4, 5, 6};

        System.out.println("Original die A: " + Arrays.toString(originalDieA));
        System.out.println("Original die B: " + Arrays.toString(originalDieB));

        System.out.println("\nOriginal Probabilities for each sum:");
        double[] originalProbabilities = getAllProbabilities(originalDieA, originalDieB);
        for (int i = 2; i <= 12; i++) {
            System.out.println("Sum: " + i + ", Probability: " + originalProbabilities[i]);
        }

        // New dice sets
        int[] newDieA = {1, 2, 2, 3, 3, 4};
        int[] newDieB = {1, 3, 4, 5, 6, 8};

        System.out.println("\nNew die A: " + Arrays.toString(newDieA));
        System.out.println("New die B: " + Arrays.toString(newDieB));
        System.out.println("Total combinations");
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                System.out.print("("+i+","+j+") ");

            }
            System.out.println();
        }
        System.out.println("\nSum combinations for new dice sets:");
        int[][] sums = sumCombinations(newDieA, newDieB);
        matrixCombinations(sums);

        System.out.println("\nProbabilities for each sum for new dice sets:");
        double[] probabilities = getAllProbabilities(newDieA, newDieB);
        for (int i = 2; i <= 12; i++) {
            System.out.println("Sum: " + i + ", Probability: " + probabilities[i]);
        }
    }
}
