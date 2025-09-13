# [Programmers 154538 - 숫자 변환하기](https://school.programmers.co.kr/learn/courses/30/lessons/154538)

## 문제 설명

자연수 `x`를 `y`로 변환하려고 합니다. 사용할 수 있는 연산은 다음과 같습니다.

- `x`에 `n`을 더합니다
- `x`에 2를 곱합니다.
- `x`에 3을 곱합니다.

자연수 `x`, `y`, `n`이 매개변수로 주어질 때, `x`를 `y`로 변환하기 위해 필요한 최소 연산 횟수를 return하도록 solution 함수를 완성해주세요. 이때 `x`를 `y`로 만들 수 없다면 -1을 return 해주세요.

## 제한 사항

- 1 ≤ `x` ≤ `y` ≤ 1,000,000
- 1 ≤ `n` < `y`

## 입출력 예

| x   | y   | n   | result |
| --- | --- | --- | ------ |
| 10  | 40  | 5   | 2      |
| 10  | 40  | 30  | 1      |
| 2   | 5   | 4   | -1     |

## 입출력 예 설명

입출력 예 #1

`x`에 2를 2번 곱하면 40이 되고 이때가 최소 횟수입니다.

입출력 예 #2

`x`에 `n`인 30을 1번 더하면 40이 되고 이때가 최소 횟수입니다.

입출력 예 #3

`x`를 `y`로 변환할 수 없기 때문에 -1을 return합니다.

---

## 문제 정보

| 난이도 | Lv.2 |
| ------ | ---- |
| 정답률 | 60%  |

## 풀이 정보

| 풀이 시간 | 7 min |
| --------- | ----- |
| 알고리즘  | BFS   |

| 정확성 테스트                       |
| ----------------------------------- |
| 테스트 1 〉 통과 (0.07ms, 75.9MB)   |
| 테스트 2 〉 통과 (0.08ms, 90.1MB)   |
| 테스트 3 〉 통과 (0.06ms, 72.4MB)   |
| 테스트 4 〉 통과 (0.11ms, 84.4MB)   |
| 테스트 5 〉 통과 (35.16ms, 103MB)   |
| 테스트 6 〉 통과 (0.09ms, 83.1MB)   |
| 테스트 7 〉 통과 (38.04ms, 102MB)   |
| 테스트 8 〉 통과 (0.05ms, 74.4MB)   |
| 테스트 9 〉 통과 (179.75ms, 166MB)  |
| 테스트 10 〉 통과 (169.67ms, 132MB) |
| 테스트 11 〉 통과 (99.32ms, 113MB)  |
| 테스트 12 〉 통과 (0.06ms, 85.8MB)  |
| 테스트 13 〉 통과 (0.06ms, 82.7MB)  |
| 테스트 14 〉 통과 (3.10ms, 87.5MB)  |
| 테스트 15 〉 통과 (0.93ms, 85.8MB)  |
| 테스트 16 〉 통과 (1.69ms, 89.2MB)  |

## 코드

```java
import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = bfs(x, y, n);
        return answer;
    }

    private static int bfs(int x, int y, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(x);

        Set<Integer> visited = new HashSet<>();
        visited.add(x);

        int dist = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int node = q.poll();
                if (node == y) return dist;

                if (node + n <= y && !visited.contains(node + n)) {
                    q.add(node + n);
                    visited.add(node + n);
                }

                if (node * 2 <= y && !visited.contains(node * 2)) {
                    q.add(node * 2);
                    visited.add(node * 2);
                }

                if (node * 3 <= y && !visited.contains(node * 3)) {
                    q.add(node * 3);
                    visited.add(node * 3);
                }
            }

            dist++;
        }

        return -1;
    }
}
```

## 해설

BFS 알고리즘을 활용하면 간단하게 해결할 수 있다. `x`에서 `y`로 변환하는 과정은 총 3가지 방법이 있는데 변환되는 과정의 숫자를 노드, 변환을 간선처럼 생각하면 최단거리 BFS로 접근이 가능하다. 변환 과정은 모두 숫자가 커지는 방향이므로 y보다 작거나 같은 경로만 추가하며 탐색을 진행했고 방문 체크의 경우 길이 100만의 배열을 만드는 대신 Set을 활용해서 처리했다.

## 리뷰

은근 빈출 유형이라 한번만 봐두면 금방 푸는 문제인듯

---
