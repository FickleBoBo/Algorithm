#include <bits/stdc++.h>
using namespace std;

long long tree[4 * 1000000];

void update(int node, int start, int end, int idx, int value) {
    if (start == end) {
        tree[node] += value;
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

    int n, q;
    cin >> n >> q;

    for (int i = 0; i < q; i++) {
        int t, a, b;
        cin >> t >> a >> b;

        if (t == 1) {
            update(1, 1, n, a, b);
        } else {
            cout << querySum(1, 1, n, a, b) << '\n';
        }
    }
}
