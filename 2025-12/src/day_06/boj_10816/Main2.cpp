#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 10000000;
int cnt[20000001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        cnt[x + MAX]++;
    }

    int m;
    cin >> m;

    for (int i = 0; i < m; i++) {
        int x;
        cin >> x;
        cout << cnt[x + MAX] << ' ';
    }
}
