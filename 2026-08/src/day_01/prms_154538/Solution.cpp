#include <queue>
#include <vector>

using namespace std;

int solution(int x, int y, int n) {
    queue<int> q;
    q.push(x);

    vector<int> dist(1 + y, -1);
    dist[x] = 0;

    while (!q.empty()) {
        int cur = q.front();
        q.pop();

        if (cur == y) return dist[cur];

        if (cur + n <= y && dist[cur + n] == -1) {
            q.push(cur + n);
            dist[cur + n] = dist[cur] + 1;
        }

        if (cur * 2 <= y && dist[cur * 2] == -1) {
            q.push(cur * 2);
            dist[cur * 2] = dist[cur] + 1;
        }

        if (cur * 3 <= y && dist[cur * 3] == -1) {
            q.push(cur * 3);
            dist[cur * 3] = dist[cur] + 1;
        }
    }

    return -1;
}
