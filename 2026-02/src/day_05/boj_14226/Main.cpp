#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 1000;
bool visited[1 + MAX][1 + MAX];

int bfs(int s) {
    queue<pair<int, int>> q;
    q.push({1, 0});

    visited[1][0] = true;

    int dist = 0;

    while (!q.empty()) {
        int size = q.size();

        while (size-- > 0) {
            auto [a, b] = q.front();
            q.pop();

            if (a == s) return dist;

            if (!visited[a][a]) {
                q.push({a, a});
                visited[a][a] = true;
            }

            if (a + b <= MAX && !visited[a + b][b]) {
                q.push({a + b, b});
                visited[a + b][b] = true;
            }

            if (a > 0 && !visited[a - 1][b]) {
                q.push({a - 1, b});
                visited[a - 1][b] = true;
            }
        }

        dist++;
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int s;
    cin >> s;
    cout << bfs(s);
}
