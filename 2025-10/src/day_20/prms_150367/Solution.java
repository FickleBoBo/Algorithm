package day_20.prms_150367;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            answer[i] = isValid(numbers[i]) ? 1 : 0;
        }

        return answer;
    }

    private static boolean isValid(long number) {
        char[] binaryNumberArr = toBinaryArr(number);

        return dfs(binaryNumberArr, 0, binaryNumberArr.length - 1);
    }

    // 각 서브트리를 재귀적으로 탐색
    private static boolean dfs(char[] arr, int left, int right) {
        // 리프 노드면 true로 넘어감
        if (left == right) return true;

        int mid = (left + right) / 2;

        // 서브트리의 루트가 1이면 루트의 자식 노드를 루트로 갖는 서브트리 탐색
        // 서브트리의 루트가 0이면 루트의 자식 노드는 1이 되면 안됨
        if (arr[mid] == '1') {
            return dfs(arr, left, mid - 1) && dfs(arr, mid + 1, right);
        } else {
            if (arr[(left + mid - 1) / 2] == '1' || arr[(mid + 1 + right) / 2] == '1') {
                return false;
            } else {
                return dfs(arr, left, mid - 1) && dfs(arr, mid + 1, right);
            }
        }
    }

    // long 타입 숫자를 이진수의 각 비트를 원소로 갖는 배열로 반환
    private static char[] toBinaryArr(long number) {
        String binaryNumber = Long.toBinaryString(number);
        int len = binaryNumber.length();

        int n = 1;
        while (len > (1 << n) - 1) {
            n++;
        }

        return ("0".repeat((1 << n) - 1 - len) + binaryNumber).toCharArray();
    }
}
