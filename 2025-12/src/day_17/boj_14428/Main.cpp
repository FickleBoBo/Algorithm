#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 1000000001;
int arr[100001];
pair<int, int> tree[4 * 100000];

pair<int, int> merge(pair<int, int> a, pair<int, int> b) {
    if (a.first <= b.first) return {a.first, a.second};
    return {b.first, b.second};
}

void init(int node, int start, int end) {
    if (start == end) {
        tree[node] = {arr[start], start};
        return;
    }

    int mid = (start + end) / 2;

    init(node * 2, start, mid);
    init(node * 2 + 1, mid + 1, end);
    tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
}

void update(int node, int start, int end, int idx, int value) {
    if (start == end) {
        tree[node] = {value, idx};
        return;
    }

    int mid = (start + end) / 2;

    if (idx <= mid) {
        update(node * 2, start, mid, idx, value);
    } else {
        update(node * 2 + 1, mid + 1, end, idx, value);
    }
    tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
}

pair<int, int> query(int node, int start, int end, int left, int right) {
    if (left > end || right < start) return {MAX, 0};
    if (left <= start && end <= right) return tree[node];

    int mid = (start + end) / 2;

    pair<int, int> leftRes = query(node * 2, start, mid, left, right);
    pair<int, int> rightRes = query(node * 2 + 1, mid + 1, end, left, right);
    return merge(leftRes, rightRes);
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
            cout << query(1, 1, n, a, b).second << '\n';
        }
    }
}
