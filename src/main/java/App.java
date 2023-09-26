import org.jetbrains.annotations.NotNull;

import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.List;

public class App {
    //Fibonacci
    public static int fib(int n) {
        return fib(n, new HashMap<>());
    }

    public static int fib(int n, HashMap<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return n;
        }

        if(memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = fib(n - 1, memo) + fib(n - 2, memo);
        memo.put(n, result);

        return result;
    }

    //Tribonacci
    public static int tribonacci(int n) {
        return tribonacci(n, new HashMap<>());
    }

    public static int tribonacci(int n, HashMap<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        if(memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = tribonacci(n - 1, memo) + tribonacci(n - 2, memo) + tribonacci(n - 3, memo);
        memo.put(n, result);
        return result;
    }

    //Sum possible
    public static boolean sumPossible(int amount, List<Integer> numbers) {
        return sumPossible(amount, numbers, new HashMap<>());
    }

    public static boolean sumPossible(int amount, List<Integer> numbers, HashMap<Integer, Boolean> memo) {
        if (amount == 0) {
            return true;
        }

        if (amount < 0) {
            return false;
        }

        if(memo.containsKey(amount)) {
            return memo.get(amount);
        }

        for (int num : numbers) {
            int subAmount = amount - num;
            if (sumPossible(subAmount, numbers, memo)) {
                memo.put(amount, true);
                return true;
            }
        }

        memo.put(amount, false);
        return false;
    }

    //Min change
    public static int minChange(int amount, List<Integer> coins) {
        return minChange(amount, coins, new HashMap<>());
    }

    public static int minChange(int amount, List<Integer> coins, HashMap<Integer, Integer> memo) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int minCoins = -1;

        for (int coin : coins) {
            int subAmount = amount - coin;
            int subCoins = minChange(subAmount, coins, memo);

            if (subCoins != -1) {
                int numCoins = subCoins + 1;

                if (numCoins < minCoins || minCoins == -1) {
                    minCoins = numCoins;
                }
            }
        }

        memo.put(amount, minCoins);
        return minCoins;
    }

    //Count paths
    public static int countPaths(List<List<String>> grid) {
        return countPaths(0, 0, grid, new HashMap<>());
    }

    public static int countPaths(int r, int c, @NotNull List<List<String>> grid, HashMap<List<Integer>, Integer> memo) {
        if (r == grid.size() || c == grid.get(0).size()) {
            return 0;
        }

        if (grid.get(r).get(c) == "X") {
            return 0;
        }

        if (r == grid.size() - 1 && c == grid.get(0).size() - 1) {
            return 1;
        }

        List<Integer> pos = List.of(r, c);

        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }

        int result = countPaths(r + 1, c, grid, memo) + countPaths(r, c + 1, grid, memo);
        memo.put(pos, result);
        return result;
    }

    //Max path sum
    public static int maxPathSum(List<List<Integer>> grid) {
        return (int) maxPathSum(0, 0, grid, new HashMap<>());
    }

    public static double maxPathSum(int r, int c, @NotNull List<List<Integer>> grid, HashMap<List<Integer>, Double> memo) {
        if (r == grid.size() || c == grid.get(0).size()) {
            return Double.NEGATIVE_INFINITY;
        }

        List<Integer> pos = List.of(r, c);

        if(memo.containsKey(pos)) {
            return memo.get(pos);
        }

        double result = grid.get(r).get(c) + Math.max(
                maxPathSum(r + 1, c, grid, memo),
                maxPathSum(r, c + 1, grid, memo)
        );

        memo.put(pos, result);
        return result;
    }

    //Non adjacent sum
    public static int nonAdjacentSum(List<Integer> nums) {
        return nonAdjacentSum(nums, 0, new HashMap<>());
    }

    public static int nonAdjacentSum(List<Integer> nums, int i, HashMap<Integer, Integer> memo) {
        if (i >= nums.size()) {
            return 0;
        }

        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        int result = Math.max(
                nums.get(i) + nonAdjacentSum(nums, i + 2, memo),
                nonAdjacentSum(nums, i + 1, memo)
        );

        memo.put(i, result);
        return result;
    }

    //Summing squares
    public static int summingSquares(int n) {
        return (int) summingSquares(n, new HashMap<>());
    }

    public static double summingSquares(int n, HashMap<Integer, Double> memo) {
        if (n == 0) {
            return 0;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        double minSquares = Double.POSITIVE_INFINITY;

        for (int i = 1; i <= Math.sqrt(n); i += 1) {
            int square = i * i;
            double numSquares = 1 + summingSquares(n - square, memo);

            if (numSquares < minSquares) {
                minSquares =  numSquares;
            }
        }

        double result = minSquares;
        memo.put(n, result);
        return result;
    }

    //Counting change
    public static int countingChange(int amount, List<Integer> coins) {
        return countingChange(amount, 0, coins, new HashMap<>());
    }

    public static int countingChange(int amount, int coinIdx, List<Integer> coins, HashMap<List<Integer>, Integer> memo) {
        if (amount == 0) {
            return 1;
        }

        if (coinIdx >= coins.size()) {
            return 0;
        }

        List<Integer> key = List.of(amount, coinIdx);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int totalWays = 0;
        int value = coins.get(coinIdx);

         for (int qty = 0; qty * value <= amount; qty += 1) {
             int subAmount = amount - (qty * value);
             totalWays += countingChange(subAmount, coinIdx + 1, coins, memo);
         }

         memo.put(key, totalWays);
         return totalWays;
    }
}