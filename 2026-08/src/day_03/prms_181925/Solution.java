package day_03.prms_181925;

class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < numLog.length; i++) {
            if (numLog[i] == numLog[i - 1] + 1) {
                sb.append("w");
            } else if (numLog[i] == numLog[i - 1] - 1) {
                sb.append("s");
            } else if (numLog[i] == numLog[i - 1] + 10) {
                sb.append("d");
            } else {
                sb.append("a");
            }
        }

        return sb.toString();
    }
}
