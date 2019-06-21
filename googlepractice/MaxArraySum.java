// https://www.hackerrank.com/challenges/max-array-sum

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
 * max @ position 0: value @ 0
 * max @ position 1: either:
    value @ 0
    value @ 1
 * from that point forward, the max of the next position is either:
    the current value at that position
    the max value found so far
    the max value from 2 positions back plus the current value
 */
public class MaxArraySum {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int[] acc = new int[arr.length];
        return maxSubsetSum(arr, acc);


    }

    static int maxSubsetSum(int[] arr, int[] acc) {
        acc[0] = arr[0];
        acc[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            acc[i] = getMax(arr[i], acc[i - 1], acc[i - 2] + arr[i]);
        }

        return acc[arr.length - 1];
    }

    static int getMax(int a, int b, int c) {
        if (a > b) {
            if (a > c) return a;
            else return c;
        } else {
            if (c > b) return c;
            else return b;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
