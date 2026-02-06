#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 10000;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> cnt(1 + MAX);
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        cnt[x]++;
    }

    for (int i = 1; i <= MAX; i++) {
        for (int j = 1; j <= cnt[i]; j++) {
            cout << i << '\n';
        }
    }
}
