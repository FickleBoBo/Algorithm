#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 100000;
bool visited[1 + MAX];
int prv[1 + MAX];

void traceback(int dist, int k) {
    vector<int> v;

    int pos = k;
    while (pos != -1) {
        v.push_back(pos);
        pos = prv[pos];
    }

    reverse(v.begin(), v.end());

    cout << dist << '\n';

    for (int x : v) {
        cout << x << ' ';
    }
}

void bfs(int n, int k) {
    queue<int> q;
    q.push(n);

    visited[n] = true;

    memset(prv, -1, sizeof(prv));

    int dist = 0;

    while (!q.empty()) {
        int size = q.size();

        while (size-- > 0) {
            int node = q.front();
            q.pop();

            if (node == k) {
                traceback(dist, k);
                return;
            }

            int next1 = node - 1;
            if (next1 >= 0 && !visited[next1]) {
                q.push(next1);
                visited[next1] = true;
                prv[next1] = node;
            }

            int next2 = node + 1;
            if (next2 <= MAX && !visited[next2]) {
                q.push(next2);
                visited[next2] = true;
                prv[next2] = node;
            }

            int next3 = node * 2;
            if (next3 <= MAX && !visited[next3]) {
                q.push(next3);
                visited[next3] = true;
                prv[next3] = node;
            }
        }

        dist++;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    bfs(n, k);
}
