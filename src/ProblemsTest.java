import org.junit.Assert;

import java.util.Random;

import static org.junit.Assert.*;

public class ProblemsTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void existsPairWithSumNested() {
//        int arrSize = 500000;                   //desired array size
//        int[] randArray = new int[arrSize];
//        int randNumBound = 20000;               //bound for random number
//        int targetNum = 50000;                  //this is unreachable as it's setup
//
//        // we only want even numbers
//        // we're going to populate 1 odd
//        // number to give us our "sum"
//        for (int i = 0; i < arrSize; i++) {
//            boolean notEven = true;
//            Random randNum = new Random();
//            while (notEven) {
//                randArray[i] = randNum.nextInt(randNumBound) + 1;
//                if (randArray[i] % 2 != 1) {
//                    notEven = false;
//                }
//            }
//            //System.out.println(randArray[i]);
//        }
//        randArray[249999] = 1;
//        Problems.existsPairWithSumNested(randArray, targetNum);
    }

    @org.junit.Test
    public void existsPairWithSumSortNested() {
        int arrSize = 500000;                   //desired array size
        int[] randArray = new int[arrSize];
        int randNumBound = 20000;               //bound for random number
        int targetNum = -50000;                  //this is unreachable as it's setup

        // we only want even numbers
        // we're going to populate 1 odd
        // number to give us our "sum"
        for (int i = 0; i < arrSize; i++) {
            boolean notEven = true;
            Random randNum = new Random();
            while (notEven) {
                randArray[i] = randNum.nextInt(randNumBound) + 1;
                if (randArray[i] % 2 != 1) {
                    notEven = false;
                }
            }
            //System.out.println(randArray[i]);
        }
        //randArray[249999] = 1;
        Problems.existsPairWithSumSortNested(randArray, targetNum);
    }

    @org.junit.Test
    public void existsPairWithSumSortWalking() {
        int arrSize = 500000;                   //desired array size
        int[] randArray = new int[arrSize];
        int randNumBound = 20000;               //bound for random number
        int targetNum = -50000;                  //this is unreachable as it's setup

        // we only want even numbers
        // we're going to populate 1 odd
        // number to give us our "sum"
        for (int i = 0; i < arrSize; i++) {
            boolean notEven = true;
            Random randNum = new Random();
            while (notEven) {
                randArray[i] = randNum.nextInt(randNumBound) + 1;
                if (randArray[i] % 2 != 1) {
                    notEven = false;
                }
            }
            //System.out.println(randArray[i]);
        }
        //randArray[249999] = 1;

        Problems.existsPairWithSumSortWalking(randArray, targetNum);
    }
}