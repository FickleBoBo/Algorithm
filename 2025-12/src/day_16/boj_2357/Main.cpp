#include <bits/stdc++.h>
using namespace std;

constexpr int MIN = 1;
constexpr int MAX = 1000000000;
int arr[100001];
pair<int, int> tree[4 * 100000];

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
    if (left > end || right < start) return {MAX, MIN};
    if (left <= start && end <= right) return tree[node];

    int mid = (start + end) / 2;

    pair<int, int> leftRes = query(node * 2, start, mid, left, right);
    pair<int, int> rightRes = query(node * 2 + 1, mid + 1, end, left, right);
    return merge(leftRes, rightRes);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    for (int i = 1; i <= n; i++) {
        cin >> arr[i];
    }

    init(1, 1, n);

    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;

        pair<int, int> res = query(1, 1, n, a, b);
        cout << res.first << ' ' << res.second << '\n';
    }
}
