// https://www.youtube.com/watch?v=on7MoPbgefk

// class Solution {
//     int[] costs;
//     int[] memo;
//     Set<Integer> dayset;
//     public int mincostTickets(int[] days, int[] costs) {
//         this.costs = costs;
//         memo = new int[days[days.length - 1]];
//         dayset = new HashSet<>();
//         for (int d: days) dayset.add(d);

//         return dp(days[days.length - 1]);
//     }
    
//     public int dp(int i) {
//         if (i <= 0)
//             return 0;
//         if (memo[i - 1] != 0)
//             return memo[i - 1];

//         int ans;
//         if (dayset.contains(i)) {
//             int one = dp(i-1) + costs[0];
//             int two = dp(i-7) + costs[1];
//             int thr = dp(i-30) + costs[2];
//             ans = Math.min(one, Math.min(two, thr));
//         } else {
//             ans = dp(i - 1);
//         }

//         memo[i - 1] = ans;
//         return ans;
//     }
// }

// https://www.youtube.com/watch?v=HyN5hdD1JU4

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n+1];
        for(int i = 0; i < n; ++i) dp[i] = 365*costs[0];
        
        for(int i = n-1; i >= 0; --i){
            int d7 = i, d30 = i;
            while(d7 < n && days[d7] < days[i] + 7) ++d7;
            while(d30 < n && days[d30] < days[i] + 30) ++d30;
            dp[i] = Math.min(costs[0] + dp[i+1], Math.min(costs[1] + dp[d7], costs[2] + dp[d30]));
        }
        return dp[0];
    }
}