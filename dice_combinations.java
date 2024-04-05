import java.util.ArrayList;

public class dice_combinations {
    public static void main(String args[]){
       //2.finding all combinations of dice
      ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
      
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                
               ArrayList<Integer> sub=new ArrayList<>();
               sub.add(i);
               sub.add(j);
               matrix.add(sub);

            }
            
        }
       
        System.out.println(matrix);
        //1.finding total combinations
        int totalCombinations = matrix.size();
        System.out.println(totalCombinations);
        
       
        
    }
}
