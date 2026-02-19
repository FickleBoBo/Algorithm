#include <bits/stdc++.h>
using namespace std;

constexpr int MOD = 1000000007;
int arr[1000001];
long long tree[4 * 1000000];

void init(int node, int start, int end) {
    if (start == end) {
        tree[node] = arr[start];
        return;
    }

    int mid = (start + end) / 2;

    init(node * 2, start, mid);
    init(node * 2 + 1, mid + 1, end);
    tree[node] = tree[node * 2] * tree[node * 2 + 1] % MOD;
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
    tree[node] = tree[node * 2] * tree[node * 2 + 1] % MOD;
}

long long queryMul(int node, int start, int end, int left, int right) {
    if (left > end || right < start) return 1;
    if (left <= start && end <= right) return tree[node];

    int mid = (start + end) / 2;

    long long leftMul = queryMul(node * 2, start, mid, left, right);
    long long rightMul = queryMul(node * 2 + 1, mid + 1, end, left, right);
    return leftMul * rightMul % MOD;
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
        int a, b, c;
        cin >> a >> b >> c;

        if (a == 1) {
            update(1, 1, n, b, c);
        } else {
            cout << queryMul(1, 1, n, b, c) << '\n';
        }
    }
}
