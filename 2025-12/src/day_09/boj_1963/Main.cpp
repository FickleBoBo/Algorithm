#include <bits/stdc++.h>
using namespace std;

const int MAX = 9999;
bool isPrime[1 + MAX];
bool vis[1 + MAX];

void sieve() {
    fill(isPrime, isPrime + MAX + 1, true);
    isPrime[0] = isPrime[1] = false;

    for (int i = 2; i * i <= MAX; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j <= MAX; j += i) {
                isPrime[j] = false;
            }
        }
    }
}

int bfs(int a, int b) {
    queue<int> q;
    q.push(a);

    vis[a] = true;

    int dist = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            int cur = q.front();
            q.pop();

            if (cur == b) return dist;

            for (int i = 0; i < 10; i++) {
                int n1 = cur / 10 * 10 + i;                        // 일의 자리 변경
                int n2 = cur / 100 * 100 + i * 10 + cur % 10;      // 십의 자리 변경
                int n3 = cur / 1000 * 1000 + i * 100 + cur % 100;  // 백의 자리 변경
                int n4 = i * 1000 + cur % 1000;                    // 천의 자리 변경

                if (isPrime[n1] && !vis[n1]) {
                    q.push(n1);
                    vis[n1] = true;
                }

                if (isPrime[n2] && !vis[n2]) {
                    q.push(n2);
                    vis[n2] = true;
                }

                if (isPrime[n3] && !vis[n3]) {
                    q.push(n3);
                    vis[n3] = true;
                }

                if (n4 >= 1000 && isPrime[n4] && !vis[n4]) {
                    q.push(n4);
                    vis[n4] = true;
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

    sieve();

    int t;
    cin >> t;

    while (t--) {
        int a, b;
        cin >> a >> b;

        memset(vis, 0, sizeof(vis));

        int dist = bfs(a, b);
        if (dist == -1) {
            cout << "Impossible\n";
        } else {
            cout << dist << '\n';
        }
    }
}
