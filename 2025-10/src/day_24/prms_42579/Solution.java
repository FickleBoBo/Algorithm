package day_24.prms_42579;

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
