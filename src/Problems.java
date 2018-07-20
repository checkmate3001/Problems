import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.floor;


public class Problems {
    /**
     * PROBLEM 1:
     *
     * We want to know whether any two integers within values can be added together to equal the target value.
     * Make it as fast as possible.
     *
     * What is the time complexity?
     * What is the space complexity?
     * Write test(s) for the solution
     * If relevant, what inputs are the best case for returning quickly?  What inputs are the worst?
     *
     * @return true if any two values within the values array sum to the provided target
     */

    /**
     * PROBLEM 1:
     *
     * We want to know whether any two integers within values can be added together to equal the target value.
     * Make it as fast as possible.
     *
     * What is the time complexity?
     * What is the space complexity?
     * Write test(s) for the solution
     * If relevant, what inputs are the best case for returning quickly?  What inputs are the worst?
     *
     * @param values an array of integers
     * @param target the target sum
     * @return true if any two values within the values array sum to the provided target
     */
    public static boolean existsPairWithSumNested(final int[] values, final int target) {
        /**
         * This Method utilizes an unsorted array and nested for-loops to iterate
         * through the array. The outer loop iterates from the beginning of the array,
         * while the inner loop iterates from the end of the array. Once they meet,
         * the inner loop ends and the outer loop increments.
         *
         * We are unable to make any guesses or determinations on the data we have not
         * seen as the array is unsorted.
         *
         * Worst-case scenario is n^2.
         */

        System.out.println("Unsorted Step Method");
        int[] ourValues = values.clone();
        int arrLength = ourValues.length;

        System.out.println("Target Sum: " + target);

        long tries = 0;
        for (int i = 0; i < arrLength; i++) {
            for (int j = arrLength - 1; j > i; j--) {
                tries ++;
                if (ourValues[i] + ourValues[j] == target) {
                    System.out.println("We found a sum: " + ourValues[i] + " + " + ourValues[j] + " = " + target);
                    System.out.println("It took " + tries + " tries out of " + arrLength + " numbers.");
                    System.out.println("");
                    return true;
                }

            }
        }
        System.out.println(tries + " tries attempted with no match out of " + arrLength + " numbers.");
        System.out.println("");
        return false;
    }
    public static boolean existsPairWithSumSortNested(final int[] values, final int target) {
        /**
         * This method sorts the array in ascending order,
         * then utilizes a nested for-loop to iterate through the numbers.
         * The outer loop ascends through the array while testing for a sum
         * against the inner loop which descends through the array.
         *
         * If at any time the sum of the outer and inner loops become LESS than the target,
         * we know the remaining untested numbers in the inner loop cannot possibly reach
         * the target number, so the inner loop breaks and increments the outer loop.
         *
         * In a case where it is mathematically impossible for any of the numbers to sum
         * together to equal a value equal to or greater than the target number, the maximum
         * number of attempts becomes n.
         *
         * A worse-case scenario is still n^2 unfortunately.
         */
        System.out.println("Sorted Step Method");
        int[] ourValues = values.clone();
        int arrLength = ourValues.length;
        Arrays.sort(ourValues);
        System.out.println("Target Sum: " + target);

        long tries = 0;                         //number of comparisons
        for (int i = 0; i < arrLength; i++) {   //outer for-loop index. Starts at beginning of array (small nums)
            innerloop:
            for (int j = arrLength - 1; j > i; j--) {   //inner for-loop index. Starts at end of array (big nums)
                tries ++;
                if (ourValues[i] + ourValues[j] == target) {
                    System.out.println("We found a sum: " + ourValues[i] + " + " + ourValues[j] + " = " + target);
                    System.out.println("It took " + tries + " tries out of " + arrLength + " numbers.");
                    System.out.println("");
                    return true;
                } else if (ourValues[i] + ourValues[j] < target) {
                    // if the two numbers are less than the target, we know every remaining number in the inner
                    // loop will also result in a value less than the target, so we give up.
                    // increment outer for-loop index (small numbers) and try again.
                    break innerloop;
                }

            }
        }
        System.out.println(tries + " tries attempted with no match out of " + arrLength + " numbers.");
        System.out.println("");
        return false;
    }
    public static boolean existsPairWithSumSortWalking(final int[] values, final int target) {
        /**
         * This method utilizes a sorted array and conditional testing with two index points.
         * One index point starts at the beginning of the array and will ascend through the array.
         * The second index point will start at the end of the array and will descend through the array.
         *
         * If the sum of the two values are GREATER than the target, we will decrement the upper bound index.
         *
         * If the sum of the two values are LOWER than the target, we will increment the lower bound index.
         *
         * Worst-case scenario is n^2.
         *
         * Algorithmically speaking, this method is nearly identical to the Sorted Nested For-loop method.
         * In all cases, both methods will find the same sums, but occasionally this method will find them
         * with just barely fewer steps. In most cases, they find the sums in the same number of steps.
         */

        System.out.println("Sorted Walk-in Method");
        int[] ourValues = values.clone();
        int arrLength = ourValues.length;
        Arrays.sort(ourValues);
        System.out.println("Target Sum: " + target);
        int i = 0;                          //lower bound index (smaller numbers)
        int j = arrLength - 1;              //upper bound index (large numbers)
        long tries = 0;                     //number of comparisons
        while (i < j) {                     //as long as our lower index hasn't passed our upper index

            if (ourValues[i] + ourValues[j] < target) {   //if we are smaller than target, increase lower index
                tries++;
                i++;
            } else if (ourValues[i] + ourValues[j] > target) {    //if we are larger than target, decrease upper index
                tries++;
                j--;
            } else if (ourValues[i] + ourValues[j] == target) {   //found a sum
                tries++;
                System.out.println("We found a sum: " + ourValues[i] + " + " + ourValues[j] + " = " + target);
                System.out.println("It took " + tries + " tries out of " + arrLength + " numbers.");
                System.out.println("");
                return true;
            }
        }
        System.out.println(tries + " tries attempted with no match out of " + arrLength + " numbers.");
        System.out.println("");
        return false;
    }
    public static boolean existsPairWithSumBinarySearch(final int[] values, final int target) {
        System.out.println("Sorted Binary Search Method");
        int[] ourValues = values.clone();
        int arrLength = ourValues.length;
        Arrays.sort(ourValues);
        System.out.println("Target Sum: " + target);
        int i;                                                  //index iteration variable
        int r;                                                  //upper bound index
        int l;                                                  //lower bound index
        int m;                                                  //middle index
        int binTarget;                                          //number we are bin-searching for
        long tries = 0;

        for (i = 0; i < arrLength - 1; i++) {                   //iterate through the array, bottom to top
            binTarget = target - ourValues[i];                  //looking for the number that sums with the value @ i to = target
            r = arrLength - 1;                                  //upper bound index
            l = i;                                              //lower bound index
            m = (l + r)/2;                                      //middle index
            while (l < r) {                                     //as long as we haven't met or crossed index bounds
                if (ourValues[m] > binTarget){
                    r = m - 1;                                  //upper bound index to 1 less than middle
                    m = (l + r)/2;                              //now calc the new middle
                    tries++;
                } else if (ourValues[m] < binTarget) {
                    l = m + 1;                                  //lower bound index to 1 more than middle
                    m = (l + r)/2;                              //now calc the new middle
                    tries++;
                } else if (ourValues[m] == binTarget) {
                    //found our number
                    tries++;
                    System.out.println("We found a sum: " + ourValues[i] + " + " + ourValues[m] + " = " + target);
                    System.out.println("It took " + tries + " tries out of " + arrLength + " numbers.");
                    System.out.println("");
                    return true;
                }
            }

        }
        System.out.println(tries + " tries attempted with no match out of " + arrLength + " numbers.");
        System.out.println("");
        return false;
    }

    public static boolean existsPairWithSumHashTable(final int[] values, final int target) {
        System.out.println("Hash Table Search Method");
        int[] ourValues = values.clone();
        int arrLength = ourValues.length;
        Arrays.sort(ourValues);
        System.out.println("Target Sum: " + target);

        return false;
    }


        /**
         * PROBLEM 2:
         *
         * Given an input list of list of elements return all combinations of innermost elements that can be constructed
         * by taking one element from each list.
         *
         * Example input: {{1, 2, 3}, {4}, {5, 5}, {6, 7}}
         * Example output: {{1, 4, 5, 6}, {1, 4, 5, 7}, {1, 4, 5, 6}, {1, 4, 5, 7}, {2, 4, 5, 6}, {2, 4, 5, 7} ...}
         *
         * Write test(s)
         * There are follow up questions/work for this as well
         */
        public static <T > Iterable < List < T >> getAllCombinations( final List<List<T>> inputLists){
            return Collections.emptyList();
        }
    }
