// https://www.youtube.com/watch?v=sz1qaKt0KGQ

class Solution {
    public List<String> generateParenthesis(int n) {
        //int numPairs = n;
        List<String> result = new ArrayList<>();
        // directedGenerateBalancedParentheses(numPairs, numPairs, "", result); // kick off the recursion
        directedGenerateBalancedParentheses(0, 0, "", result, n);
        return result;
    }
    
//     private static void directedGenerateBalancedParentheses(int numLeftParensNeeded , int numRightParensNeeded,
//                                                         String parenStringInProgress, List<String> result) {
//       if (numLeftParensNeeded == 0 && numRightParensNeeded == 0) {
//         result.add(parenStringInProgress);
//         return;
//       }

//       if (numLeftParensNeeded > 0) {
//         directedGenerateBalancedParentheses(numLeftParensNeeded - 1, numRightParensNeeded,
//                                             parenStringInProgress + "(", result);
//       }

//       if (numLeftParensNeeded < numRightParensNeeded) {

//         directedGenerateBalancedParentheses(numLeftParensNeeded, numRightParensNeeded - 1,
//                                               parenStringInProgress + ")", result);
//       }
//     }
        private static void directedGenerateBalancedParentheses(int open , int close,
                                                        String parenStringInProgress, List<String> result, int max) {
          if (parenStringInProgress.length() == max * 2) {
            result.add(parenStringInProgress);
            return;
          }

          if (open < max) {
            directedGenerateBalancedParentheses(open + 1, close,
                                                parenStringInProgress + "(", result, max);
          }

          if (close < open) {

            directedGenerateBalancedParentheses(open, close + 1,
                                                  parenStringInProgress + ")", result, max);
          }
    }
}