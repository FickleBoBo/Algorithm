#include <bits/stdc++.h>
using namespace std;

const int MAX = 100000;
const int INF = 1000000000;
int arr[1 + MAX];
pair<int, int> tree[4 * MAX];

pair<int, int> merge(pair<int, int> a, pair<int, int> b) {
    return {min(a.first, b.first), max(a.second, b.second)};
}

void init(int node, int start, int end) {
    if (start == end) {
        tree[node] = {arr[start], arr[start]};
        return;
    }

    int mid = (start + end) / 2;

    init(node * 2, start, mid);
    init(node * 2 + 1, mid + 1, end);
    tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
}

pair<int, int> query(int node, int start, int end, int left, int right) {
    if (left > end || right < start) return {INF, -INF};
    if (left <= start && end <= right) return tree[node];

    int mid = (start + end) / 2;

    pair<int, int> leftRes = query(node * 2, start, mid, left, right);
    pair<int, int> rightRes = query(node * 2 + 1, mid + 1, end, left, right);
    return merge(leftRes, rightRes);
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    for (int i = 1; i <= n; i++) {
        cin >> arr[i];
    }

    init(1, 1, n);

    while (m--) {
        int a, b;
        cin >> a >> b;

        pair<int, int> res = query(1, 1, n, a, b);
        cout << res.first << ' ' << res.second << '\n';
    }
}
