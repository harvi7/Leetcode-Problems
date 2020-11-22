// https://www.youtube.com/watch?v=sn6r0ZV_2y4

class Solution {
    public String largestTimeFromDigits(int[] arr) {
        String result = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (i == j || j == k || k == i) continue;
                    String hh = arr[i] + "" + arr[j];
                    String mm = arr[k] + "" + arr[6-i-j-k];
                    String _time = hh + ":" + mm;
                    if (hh.compareTo("24") < 0 && mm.compareTo("60") < 0 && _time.compareTo(result) > 0) result = _time;
                }
            }
        }
        return result;
    }
}