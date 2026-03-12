#include <bits/stdc++.h>
using namespace std;

const int MX = 100000;
bool vis[1 + MX];

int bfs(int n, int k) {
    queue<int> q;
    q.push(n);

    vis[n] = true;

    int dist = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            int cur = q.front();
            q.pop();

            if (cur == k) return dist;

            for (int nxt : {cur - 1, cur + 1, cur * 2}) {
                if (0 <= nxt && nxt <= MX && !vis[nxt]) {
                    q.push(nxt);
                    vis[nxt] = true;
                }
            }
        }

        dist++;
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, k;
    cin >> n >> k;
    cout << bfs(n, k);
}
