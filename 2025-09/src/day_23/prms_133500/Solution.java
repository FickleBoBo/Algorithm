package day_23.prms_133500;

import java.util.*;

class Solution {

    // 메모이제이션
    private static final Map<Integer, Integer> memoOn = new HashMap<>();
    private static final Map<Integer, Integer> memoOff = new HashMap<>();

    public int solution(int n, int[][] lighthouse) {
        // lighthouse로 양방향 인접리스트 생성
        List<Integer>[] adj = new ArrayList[1 + n];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : lighthouse) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        // 방문 체크 배열
        boolean[] visited = new boolean[1 + n];

        // 1번 등대를 키는 경우와 끄는 경우 중 최솟값 반환(등대 번호는 무관)
        return Math.min(dfs(1, true, adj, visited), dfs(1, false, adj, visited));
    }

    private static int dfs(int node, boolean isOn, List<Integer>[] adj, boolean[] visited) {
        // 메모이제이션한 값이 있으면 해당 값을 반환해서 가지치기
        if (isOn && memoOn.containsKey(node)) {
            return memoOn.get(node);
        } else if (!isOn && memoOff.containsKey(node)) {
            return memoOff.get(node);
        }

        int cnt = isOn ? 1 : 0;
        visited[node] = true;

        for (int next : adj[node]) {
            if (visited[next]) continue;

            // 해당 등대를 켰을 경우 인접 등대를 켜는 경우와 끄는 경우 두 가지를 모두 탐색
            // 해당 등대를 껐을 경우 인접 등대는 모두 켜야 함
            if (isOn) {
                cnt += Math.min(dfs(next, true, adj, visited), dfs(next, false, adj, visited));
            } else {
                cnt += dfs(next, true, adj, visited);
            }
        }
        visited[node] = false;

        // 메모이제이션
        if (isOn) {
            memoOn.put(node, cnt);
        } else {
            memoOff.put(node, cnt);
        }

        return cnt;
    }
}
