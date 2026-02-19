#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 500000;
bool visited[1 + MAX][2];

int bfs(int n, int k) {
    queue<int> q;
    q.push(n);

    visited[n][0] = true;

    int time = 0;

    while (!q.empty()) {
        int bro = k + time * (time + 1) / 2;
        if (bro > MAX) return -1;

        if (visited[bro][time % 2]) return time;

        int nextParity = (time + 1) % 2;
        int size = q.size();
        while (size-- > 0) {
            int node = q.front();
            q.pop();

            int next1 = node - 1;
            if (next1 >= 0 && !visited[next1][nextParity]) {
                q.push(next1);
                visited[next1][nextParity] = true;
            }

            int next2 = node + 1;
            if (next2 <= MAX && !visited[next2][nextParity]) {
                q.push(next2);
                visited[next2][nextParity] = true;
            }

            int next3 = node * 2;
            if (next3 <= MAX && !visited[next3][nextParity]) {
                q.push(next3);
                visited[next3][nextParity] = true;
            }
        }

        time++;
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;
    cout << bfs(n, k);
}
