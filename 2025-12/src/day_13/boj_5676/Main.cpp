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
    tree[node] = tree[node * 2] * tree[node * 2 + 1];
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
    tree[node] = tree[node * 2] * tree[node * 2 + 1];
}

int queryMul(int node, int start, int end, int left, int right) {
    if (left > end || right < start) return 1;
    if (left <= start && end <= right) return tree[node];

    int mid = (start + end) / 2;

    int leftMul = queryMul(node * 2, start, mid, left, right);
    int rightMul = queryMul(node * 2 + 1, mid + 1, end, left, right);
    return leftMul * rightMul;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    while (cin >> n >> k) {
        for (int i = 1; i <= n; i++) {
            int x;
            cin >> x;
            arr[i] = (x > 0) - (x < 0);
        }

        init(1, 1, n);

        for (int i = 0; i < k; i++) {
            string command;
            int a, b;
            cin >> command >> a >> b;

            if (command == "C") {
                update(1, 1, n, a, (b > 0) - (b < 0));
            } else {
                int res = queryMul(1, 1, n, a, b);

                if (res > 0) {
                    cout << '+';
                } else if (res < 0) {
                    cout << '-';
                } else {
                    cout << '0';
                }
            }
        }
        cout << '\n';
    }
}
