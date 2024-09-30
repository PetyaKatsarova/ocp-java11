package org.example.snippets;

import java.util.Arrays;
import java.util.List;

public class Assessment1 {
    public static void main(String[] args) {
        int[] arr = {42, -42, 1, 2};
        easyOne(arr);
        System.out.println(isPolindrome("A 2man, a plan, a canal: Panam2a"));
        System.out.println(isPolindrome("bla3%3ALB")); // TODO
        System.out.println(isPolindrome("bla3%abl"));
        System.out.println(isPolindrome(""));
        // chek "" etc ... TODO
    }

    // check if a str is a valid pol., ignore spaces and special chars:
    // aka: use only nums, capitals, lowercase letters
    public static boolean isPolindrome(String pol) {
        String clean = pol.replaceAll("[^a-zA-z0-9]", "").toLowerCase();
        System.out.println("clean - " + clean);
        if (clean.isEmpty())
            return true;
        for (int i = 0; i < clean.length() / 2; i++) {
            if (clean.charAt(i) != clean.charAt(clean.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static int easyOne(int[] arr) {
        if (arr.length == 1) {
            System.out.println(arr[0]);
            return arr[0];
        }
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                maxProduct = Math.max(maxProduct, arr[i] * arr[j]);
            }
        }
        System.out.println(maxProduct);
        return maxProduct;
    }
}
