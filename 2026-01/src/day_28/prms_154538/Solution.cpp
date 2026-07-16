#include <queue>
#include <vector>

using namespace std;

int solution(int x, int y, int n) {
    queue<int> q;
    q.push(x);

    vector<bool> vis(y * 3);
    vis[x] = true;

    int dist = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            int cur = q.front();
            q.pop();

            if (cur == y) return dist;

            if (cur + n <= y && !vis[cur + n]) {
                q.push(cur + n);
                vis[cur + n] = true;
            }

            if (cur * 2 <= y && !vis[cur * 2]) {
                q.push(cur * 2);
                vis[cur * 2] = true;
            }

            if (cur * 3 <= y && !vis[cur * 3]) {
                q.push(cur * 3);
                vis[cur * 3] = true;
            }
        }

        dist++;
    }

    return -1;
}
