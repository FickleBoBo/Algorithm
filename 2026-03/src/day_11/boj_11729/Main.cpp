#include <bits/stdc++.h>
using namespace std;

string ans;
int cnt = 0;

void dfs(int n, int from, int by, int to) {
    if (n == 0) return;

    dfs(n - 1, from, to, by);

    ans += to_string(from) + " " + to_string(to) + '\n';
    cnt++;

    dfs(n - 1, by, from, to);
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    dfs(n, 1, 2, 3);

    cout << cnt << '\n';
    cout << ans << '\n';
}
