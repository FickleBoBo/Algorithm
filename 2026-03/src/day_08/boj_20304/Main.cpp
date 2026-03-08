#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    queue<int> q;
    vector<bool> vis(1 + n);

    while (m--) {
        int x;
        cin >> x;

        q.push(x);
        vis[x] = true;
    }

    int dist = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            int cur = q.front();
            q.pop();

            for (int i = 0; i < 20; i++) {
                int nxt = cur ^ (1 << i);
                if (nxt > n || vis[nxt]) continue;

                q.push(nxt);
                vis[nxt] = true;
            }
        }

        dist++;
    }

    cout << dist - 1;
}
