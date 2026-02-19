#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 9999;
bool isPrime[1 + MAX];
bool visited[1 + MAX];

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

    visited[a] = true;

    int dist = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            int node = q.front();
            q.pop();

            if (node == b) return dist;

            for (int i = 0; i < 10; i++) {
                int n1 = node / 10 * 10 + i;                         // 일의 자리 변경
                int n2 = node / 100 * 100 + i * 10 + node % 10;      // 십의 자리 변경
                int n3 = node / 1000 * 1000 + i * 100 + node % 100;  // 백의 자리 변경
                int n4 = i * 1000 + node % 1000;                     // 천의 자리 변경

                if (isPrime[n1] && !visited[n1]) {
                    q.push(n1);
                    visited[n1] = true;
                }

                if (isPrime[n2] && !visited[n2]) {
                    q.push(n2);
                    visited[n2] = true;
                }

                if (isPrime[n3] && !visited[n3]) {
                    q.push(n3);
                    visited[n3] = true;
                }

                if (n4 >= 1000 && isPrime[n4] && !visited[n4]) {
                    q.push(n4);
                    visited[n4] = true;
                }
            }
        }

        dist++;
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    sieve();

    int t;
    cin >> t;

    while (t--) {
        int a, b;
        cin >> a >> b;

        memset(visited, 0, sizeof(visited));

        int dist = bfs(a, b);
        if (dist == -1) {
            cout << "Impossible\n";
        } else {
            cout << dist << '\n';
        }
    }
}
