package day_15.prms_42892;

import java.util.*;

class Solution {

    // 이진 트리를 구성할 노드 클래스
    private static class Node {
        private int num;
        private int x;
        private int y;
        private Node left;
        private Node right;

        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    private static final List<Integer> preorderList = new ArrayList<>();  // 전위 순회 결과를 담을 리스트
    private static final List<Integer> postorderList = new ArrayList<>();  // 후위 순회 결과를 담을 리스트

    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];

        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        // y 좌표가 큰 순서로, y 좌표가 같으면 x 좌표가 작은 순서로 정렬
        Arrays.sort(nodes, (n1, n2) -> {
            if (n1.y != n2.y) return Integer.compare(n2.y, n1.y);
            return Integer.compare(n1.x, n2.x);
        });

        // 각 노드에 대해 참조 관계 설정
        for (int i = 1; i < nodes.length; i++) {
            init(nodes[0], nodes[i]);
        }

        preorder(nodes[0]);
        postorder(nodes[0]);

        return new int[][]{listToArray(preorderList), listToArray(postorderList)};
    }

    private static void init(Node parent, Node child) {
        // 부모보다 x 값이 작으면 왼쪽 자식 후보인데 왼쪽 자식이 없으면 채워주고 있으면 왼쪽 자식과 재귀 비교 (오른쪽도 마찬가지)
        if (parent.x > child.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                init(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                init(parent.right, child);
            }
        }
    }

    // 전위 순회
    private static void preorder(Node node) {
        if (node == null) return;

        preorderList.add(node.num);
        preorder(node.left);
        preorder(node.right);
    }

    // 후위 순회
    private static void postorder(Node node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        postorderList.add(node.num);
    }

    // 리스트를 배열로 변환
    private static int[] listToArray(List<Integer> list) {
        int[] arr = new int[list.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
