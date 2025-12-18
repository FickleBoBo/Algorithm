#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    unordered_set<int> a;
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        a.insert(x);
    }

    unordered_set<int> b;
    for (int i = 0; i < m; i++) {
        int x;
        cin >> x;
        b.insert(x);
    }

    int cnt = 0;
    for (int x : a) {
        if (b.count(x)) cnt++;
    }

    cout << n + m - 2 * cnt;
}
