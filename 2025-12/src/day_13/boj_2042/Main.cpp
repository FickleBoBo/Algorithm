#include <bits/stdc++.h>
using namespace std;

long long arr[1000001];
long long tree[4 * 1000000];

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

void update(int node, int start, int end, int idx, long long value) {
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

long long querySum(int node, int start, int end, int left, int right) {
    if (left > end || right < start) return 0;
    if (left <= start && end <= right) return tree[node];

    int mid = (start + end) / 2;

    long long leftSum = querySum(node * 2, start, mid, left, right);
    long long rightSum = querySum(node * 2 + 1, mid + 1, end, left, right);
    return leftSum + rightSum;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m, k;
    cin >> n >> m >> k;

    for (int i = 1; i <= n; i++) {
        cin >> arr[i];
    }

    init(1, 1, n);

    for (int i = 0; i < m + k; i++) {
        int a, b;
        long long c;
        cin >> a >> b >> c;

        if (a == 1) {
            update(1, 1, n, b, c);
        } else {
            cout << querySum(1, 1, n, b, (int)c) << '\n';
        }
    }
}
