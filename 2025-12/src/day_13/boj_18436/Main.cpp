#include <bits/stdc++.h>
using namespace std;

int arr[100001];
int tree[4 * 100000];

void init(int node, int start, int end) {
    if (start == end) {
        tree[node] = arr[start];
        return;
    }

    int mid = (start + end) / 2;

    init(node * 2, start, mid);
    init(node * 2 + 1, mid + 1, end);
    tree[node] = tree[node * 2] + tree[node * 2 + 1];
}

void update(int node, int start, int end, int idx, int value) {
    if (start == end) {
        tree[node] = value;
        return;
    }

    int mid = (start + end) / 2;

    if (idx <= mid) {
        update(node * 2, start, mid, idx, value);
    } else {
        update(node * 2 + 1, mid + 1, end, idx, value);
    }
    tree[node] = tree[node * 2] + tree[node * 2 + 1];
}

int querySum(int node, int start, int end, int left, int right) {
    if (left > end || right < start) return 0;
    if (left <= start && end <= right) return tree[node];

    int mid = (start + end) / 2;

    int leftSum = querySum(node * 2, start, mid, left, right);
    int rightSum = querySum(node * 2 + 1, mid + 1, end, left, right);
    return leftSum + rightSum;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    for (int i = 1; i <= n; i++) {
        int x;
        cin >> x;
        arr[i] = x % 2;
    }

    init(1, 1, n);

    int m;
    cin >> m;

    for (int i = 0; i < m; i++) {
        int t, a, b;
        cin >> t >> a >> b;

        if (t == 1) {
            update(1, 1, n, a, b % 2);
        } else if (t == 2) {
            cout << (b - a + 1) - querySum(1, 1, n, a, b) << '\n';
        } else {
            cout << querySum(1, 1, n, a, b) << '\n';
        }
    }
}
