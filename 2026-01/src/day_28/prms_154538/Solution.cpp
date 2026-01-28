#include <queue>
#include <string>
#include <vector>

using namespace std;

int solution(int x, int y, int n) {
    queue<int> q;
    q.push(x);

    vector<bool> visited(y * 3);
    visited[x] = true;

    int dist = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            int node = q.front();
            q.pop();

            if (node == y) return dist;

            if (node + n <= y && !visited[node + n]) {
                q.push(node + n);
                visited[node + n] = true;
            }

            if (node * 2 <= y && !visited[node * 2]) {
                q.push(node * 2);
                visited[node * 2] = true;
            }

            if (node * 3 <= y && !visited[node * 3]) {
                q.push(node * 3);
                visited[node * 3] = true;
            }
        }

        dist++;
    }

    return -1;
}
