import java.util.*;

public class Solution {
    Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        
        // Check if they have the same character frequencies
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (!Arrays.equals(arr1, arr2)) return false;
        
        String key = s1 + "#" + s2;
        if (memo.containsKey(key)) return memo.get(key);
        
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            // Case 1: No swap (left-left, right-right)
            boolean withoutSwap = isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                                  isScramble(s1.substring(i), s2.substring(i));

            // Case 2: Swap (left-right, right-left)
            boolean withSwap = isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                               isScramble(s1.substring(i), s2.substring(0, n - i));

            if (withoutSwap || withSwap) {
                memo.put(key, true);
                return true;
            }
        }
        
        memo.put(key, false);
        return false;
    }
}
