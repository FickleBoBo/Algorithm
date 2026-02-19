#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 1000000;
int tree[4 * MAX];

void update(int node, int start, int end, int idx, int delta) {
    if (start == end) {
        tree[node] += delta;
        return;
    }

    int mid = (start + end) / 2;

    if (idx <= mid) {
        update(node * 2, start, mid, idx, delta);
    } else {
        update(node * 2 + 1, mid + 1, end, idx, delta);
    }
    tree[node] = tree[node * 2] + tree[node * 2 + 1];
}

int queryKth(int node, int start, int end, int k) {
    if (start == end) return start;

    int mid = (start + end) / 2;

    if (k <= tree[node * 2]) {
        return queryKth(node * 2, start, mid, k);
    } else {
        return queryKth(node * 2 + 1, mid + 1, end, k - tree[node * 2]);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int a, b;
        cin >> a >> b;

        if (a == 1) {
            int k = queryKth(1, 1, MAX, b);
            update(1, 1, MAX, k, -1);
            cout << k << '\n';
        } else {
            int c;
            cin >> c;
            update(1, 1, MAX, b, c);
        }
    }
}
