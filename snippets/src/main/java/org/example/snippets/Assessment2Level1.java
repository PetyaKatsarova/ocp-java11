package org.example.snippets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.LongStream;

/*
1. Problem: Missing Integer
Description: Given an array A of N integers, find the smallest positive integer (greater than 0) that does not occur in the array.
Input:
An array A of N integers.
Example:
Input: A = [1, 3, 6, 4, 1, 2]
Output: 5
Explanation: 5 is the smallest positive integer that does not appear in the array.
2. Problem: Max Counters
Description: You are given N counters, all set to 0 initially, and you have two possible operations:

Increment the value of a specific counter.
Set all counters to the maximum of any counter.
Your task is to calculate the values of the counters after performing a sequence of operations.

Input:

Two integers, N (the number of counters) and M (the number of operations).
An array A of M integers representing the operations.
Example:

Input: N = 5, A = [3, 4, 4, 6, 1, 4, 4]
Output: [3, 2, 2, 4, 2]
Explanation: The counters go through the sequence of operations as described by the array.
3. Problem: Passing Cars
Description: A non-empty array A of integers (0s and 1s) represents cars on a road. A 0 represents a car traveling east, and a 1 represents a car traveling west. Your task is to count how many pairs of passing cars can be formed (i.e., a car traveling east passes a car traveling west).

Input:

An array A of N integers.
Example:

Input: A = [0, 1, 0, 1, 1]
Output: 5
Explanation: There are five pairs of passing cars in total.
* */
public class Assessment2Level1 {
    /*Description: Given an array A of N integers, find the smallest positive integer (greater than 0) that does not occur in the array.
     * */
    // todo: if in the array is Integer.MAX_VALUE?
    public static void main(String[] args) {
//        var stream = LongStream.of(1, 2, 3);
//        var opt = stream.map(n -> n * 10)
//           .filter(n -> n < 5).findFirst();


        System.out.println("Expected 5:  " + smallestInt(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println("Expected 2: " + smallestInt(new int[]{-55, 1, 500}));
        System.out.println("Expected 1: " + smallestInt(new int[]{-555555, -1, -500}));
        System.out.println("Expected 3: " + smallestInt(new int[]{-555555, -2, 500, 2, 42}));
    }

    private static int smallestInt(int[] arr) {
        HashSet<Integer> plusSet = new HashSet<Integer>();
        Integer smallestPositive = 1;
        Arrays.sort(arr);
        for (int i : arr)
            if ( i > 0 ) plusSet.add(i);
        System.out.println(plusSet);
        while (plusSet.contains(smallestPositive)) smallestPositive++;
        return smallestPositive;
    }
}
