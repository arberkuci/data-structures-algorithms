package algos.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumbers {

    public long fibonacciNaive(long n) {
        long result;
        if (n <= 2)
            result = 1;
        else
            result = fibonacciNaive(n - 1) + fibonacciNaive(n - 2);
        return result;
    }

    Map<Long, Long> memo = new HashMap<>();

    public long fibonacciMemo(long n) {
        if (memo.containsKey(n)) return memo.get(n);
        long result;
        if (n <= 2)
            result = 1;
        else
            result = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
        memo.put(n, result);
        return result;
    }

}
