#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 100000;
bool visited[1 + MAX];

int bfs(int n, int k) {
    queue<int> q;
    q.push(n);

    visited[n] = true;

    int dist = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            int node = q.front();
            q.pop();

            if (node == k) return dist;

            int next1 = node - 1;
            if (next1 >= 0 && !visited[next1]) {
                q.push(next1);
                visited[next1] = true;
            }

            int next2 = node + 1;
            if (next2 <= MAX && !visited[next2]) {
                q.push(next2);
                visited[next2] = true;
            }

            int next3 = node * 2;
            if (next3 <= MAX && !visited[next3]) {
                q.push(next3);
                visited[next3] = true;
            }
        }

        dist++;
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
