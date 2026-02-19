#include <bits/stdc++.h>
using namespace std;

int arr[100001];
int tree[4 * 100000];

void init(int node, int start, int end) {
    if (start == end) {
        tree[node] = start;
        return;
    }

    int mid = (start + end) / 2;

    init(node * 2, start, mid);
    init(node * 2 + 1, mid + 1, end);

    if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
        tree[node] = tree[node * 2];
    } else {
        tree[node] = tree[node * 2 + 1];
    }
}

void update(int node, int start, int end, int idx, int value) {
    if (start == end) {
        tree[node] = idx;
        arr[idx] = value;
        return;
    }

    int mid = (start + end) / 2;

    if (idx <= mid) {
        update(node * 2, start, mid, idx, value);
    } else {
        update(node * 2 + 1, mid + 1, end, idx, value);
    }

    if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
        tree[node] = tree[node * 2];
    } else {
        tree[node] = tree[node * 2 + 1];
    }
}

int query(int node, int start, int end, int left, int right) {
    if (left > end || right < start) return -1;
    if (left <= start && end <= right) return tree[node];

    int mid = (start + end) / 2;

    int leftMin = query(node * 2, start, mid, left, right);
    int rightMin = query(node * 2 + 1, mid + 1, end, left, right);

    if (leftMin == -1) {
        return rightMin;
    } else if (rightMin == -1) {
        return leftMin;
    } else {
        if (arr[leftMin] <= arr[rightMin]) {
            return leftMin;
        } else {
            return rightMin;
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    for (int i = 1; i <= n; i++) {
        cin >> arr[i];
    }

    init(1, 1, n);

    int m;
    cin >> m;

    for (int i = 0; i < m; i++) {
        int t, a, b;
        cin >> t >> a >> b;

        if (t == 1) {
            update(1, 1, n, a, b);
        } else {
            cout << query(1, 1, n, a, b) << '\n';
        }
    }
}
