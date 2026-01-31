#include <bits/stdc++.h>
using namespace std;

int bfs(int a, int b) {
    queue<int> q;
    q.push(a);

    set<int> visited;
    visited.insert(a);

    int dist = 1;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            int node = q.front();
            q.pop();

            if (node == b) return dist;

            if (node * 2LL <= b && !visited.count(node * 2)) {
                q.push(node * 2);
                visited.insert(node * 2);
            }

            if (node * 10LL + 1 <= b && !visited.count(node * 10 + 1)) {
                q.push(node * 10 + 1);
                visited.insert(node * 10 + 1);
            }
        }

        dist++;
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int a, b;
    cin >> a >> b;

    int res = bfs(a, b);
    cout << res;
}
