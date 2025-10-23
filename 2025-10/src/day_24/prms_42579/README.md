# [Programmers 42579 - 베스트앨범](https://school.programmers.co.kr/learn/courses/30/lessons/42579)

## 문제 설명

스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

## 제한 사항

- genres[i]는 고유번호가 i인 노래의 장르입니다.
- plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
- genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
- 장르 종류는 100개 미만입니다.
- 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
- 모든 장르는 재생된 횟수가 다릅니다.

## 입출력 예

| genres                                          | plays                      | return       |
| ----------------------------------------------- | -------------------------- | ------------ |
| ["classic", "pop", "classic", "classic", "pop"] | [500, 600, 150, 800, 2500] | [4, 1, 3, 0] |

## 입출력 예 설명

classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.

- 고유 번호 3: 800회 재생
- 고유 번호 0: 500회 재생
- 고유 번호 2: 150회 재생

pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.

- 고유 번호 4: 2,500회 재생
- 고유 번호 1: 600회 재생

따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.

- 장르 별로 가장 많이 재생된 노래를 최대 두 개까지 모아 베스트 앨범을 출시하므로 2번 노래는 수록되지 않습니다.

---

## 문제 정보

| 난이도 | Lv.3 |
| ------ | ---- |
| 정답률 | 56%  |

## 풀이 정보

| 풀이 시간 | 46 min     |
| --------- | ---------- |
| 알고리즘  | 구현, 해시 |

| 정확성 테스트                      |
| ---------------------------------- |
| 테스트 1 〉 통과 (1.21ms, 82.1MB)  |
| 테스트 2 〉 통과 (1.67ms, 85.6MB)  |
| 테스트 3 〉 통과 (1.08ms, 85.4MB)  |
| 테스트 4 〉 통과 (1.06ms, 76.8MB)  |
| 테스트 5 〉 통과 (1.32ms, 83.2MB)  |
| 테스트 6 〉 통과 (1.44ms, 85.9MB)  |
| 테스트 7 〉 통과 (1.20ms, 86.2MB)  |
| 테스트 8 〉 통과 (1.16ms, 80.1MB)  |
| 테스트 9 〉 통과 (1.14ms, 77MB)    |
| 테스트 10 〉 통과 (1.28ms, 86.4MB) |
| 테스트 11 〉 통과 (1.20ms, 86.3MB) |
| 테스트 12 〉 통과 (1.15ms, 82.2MB) |
| 테스트 13 〉 통과 (1.33ms, 80.6MB) |
| 테스트 14 〉 통과 (1.21ms, 71.3MB) |
| 테스트 15 〉 통과 (1.03ms, 84.6MB) |

## 코드

```java
import java.util.*;

class Solution {

    private static class Genre implements Comparable<Genre> {
        String name;
        int play;

        public Genre(String name, int play) {
            this.name = name;
            this.play = play;
        }

        @Override
        public int compareTo(Genre o) {
            return Integer.compare(o.play, this.play);
        }
    }

    private static class Music implements Comparable<Music> {
        int no;
        int play;

        public Music(int no, int play) {
            this.no = no;
            this.play = play;
        }

        @Override
        public int compareTo(Music o) {
            if (this.play == o.play) return Integer.compare(this.no, o.no);
            return Integer.compare(o.play, this.play);
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCntMap = getGenreCntMap(genres, plays);
        Map<String, PriorityQueue<Music>> musicPqMap = getMusicPqMap(genres, plays);

        List<Genre> genreList = mapToList(genreCntMap);
        genreList.sort(Comparator.naturalOrder());

        List<Integer> answer = new ArrayList<>();

        for (Genre genre : genreList) {
            PriorityQueue<Music> pq = musicPqMap.get(genre.name);
            int cnt = 0;

            while (!pq.isEmpty() && cnt < 2) {
                answer.add(pq.poll().no);
                cnt++;
            }
        }

        return listToArr(answer);
    }

    private static Map<String, Integer> getGenreCntMap(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        return map;
    }

    private static Map<String, PriorityQueue<Music>> getMusicPqMap(String[] genres, int[] plays) {
        Map<String, PriorityQueue<Music>> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (!map.containsKey(genres[i])) {
                map.put(genres[i], new PriorityQueue<>());
            }

            map.get(genres[i]).offer(new Music(i, plays[i]));
        }

        return map;
    }

    private static List<Genre> mapToList(Map<String, Integer> map) {
        List<Genre> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Genre(entry.getKey(), entry.getValue()));
        }

        return list;
    }

    private static int[] listToArr(List<Integer> list) {
        int[] arr = new int[list.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
```

## 해설

컬렉션 프레임워크와 해시를 활용해서 복합적으로 해결했다.

구현에 필요한 정보는 재생된 횟수를 기준으로 장르를 찾아야하고 해당 장르에서 다시 노래를 재생 횟수 또는 고유 번호 순서로 찾아야 한다. 이를 위해 카운팅 맵을 통해 장르별 재생 횟수를 찾았고 이를 리스트를 통해 정렬해 재생 횟수에 대한 내림차순으로 장르를 찾았다. 노래의 경우 장르별로 정렬해서 담아야해서 `Map<String, PriorityQueue<Music>>` 형태로 키에 장르 이름, 값에 노래 우선순위 큐를 두어 노래 정보를 관리했다. 기존에 재생 횟수에 대한 내림차순으로 장르를 찾았으므로 이 장르를 순서대로 돌며 노래를 최대 2곡까지 뽑아서 담으면 된다.

## 리뷰

컬렉션 프레임워크에 대한 숙련도가 중요한 것 같았다.

---
