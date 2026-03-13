#include <bits/stdc++.h>
using namespace std;

int bfs(int a, int b) {
    queue<int> q;
    q.push(a);

    set<int> vis;
    vis.insert(a);

    int dist = 1;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            int cur = q.front();
            q.pop();

            if (cur == b) return dist;

            if (cur * 2LL <= b && !vis.count(cur * 2)) {
                q.push(cur * 2);
                vis.insert(cur * 2);
            }

            if (cur * 10LL + 1 <= b && !vis.count(cur * 10 + 1)) {
                q.push(cur * 10 + 1);
                vis.insert(cur * 10 + 1);
            }
        }

        dist++;
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int a, b;
    cin >> a >> b;
    cout << bfs(a, b);
}
