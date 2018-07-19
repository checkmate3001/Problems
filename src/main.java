import java.util.Random;

public class main extends Problems{

    public static void main(String[] args){
        Random rand = new Random();
        int pivot = 1000000; // Our base size for arrays, values for random numbers and target numbers
        int randNum = rand.nextInt(pivot + 1); // Random array size
        int[] randArray = new int[randNum];
        //System.out.print("Array size: ");
        //System.out.println(randNum);

        //System.out.print("{");
        for (int i = 0; i < randNum; i++){
            randArray[i] = rand.nextInt(pivot) - (pivot/2); // Random values
            //System.out.print(randArray[i]);

            if (i < randNum - 1) {
                //System.out.print(", ");
            }
        }
        //System.out.println("}");

        randNum = rand.nextInt(pivot + (pivot/2)); // Random target
//        if (existsPairWithSumStepping(randArray, randNum)){
//            System.out.println("Match found!");
//        } else {
//            System.out.println("No match found.");
//        }

        existsPairWithSumNested(randArray, randNum);
        existsPairWithSumSortNested(randArray, randNum);
        existsPairWithSumSortWalking(randArray, randNum);
        existsPairWithSumBinarySearch(randArray, randNum);
    }
}
