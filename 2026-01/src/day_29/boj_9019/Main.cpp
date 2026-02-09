#include <bits/stdc++.h>
using namespace std;

string bfs(int a, int b) {
    queue<int> q;
    q.push(a);

    vector<bool> visited(10000);
    visited[a] = true;

    vector<int> prev(10000, -1);
    vector<char> type(10000);

    while (!q.empty()) {
        int node = q.front();
        q.pop();

        if (node == b) {
            string res;

            while (prev[node] != -1) {
                res.push_back(type[node]);
                node = prev[node];
            }

            reverse(res.begin(), res.end());
            return res;
        }

        int d1 = node * 2 % 10000;
        if (!visited[d1]) {
            q.push(d1);
            visited[d1] = true;
            prev[d1] = node;
            type[d1] = 'D';
        }

        int d2 = (node - 1 + 10000) % 10000;
        if (!visited[d2]) {
            q.push(d2);
            visited[d2] = true;
            prev[d2] = node;
            type[d2] = 'S';
        }

        int d3 = node % 1000 * 10 + node / 1000;
        if (!visited[d3]) {
            q.push(d3);
            visited[d3] = true;
            prev[d3] = node;
            type[d3] = 'L';
        }

        int d4 = node % 10 * 1000 + node / 10;
        if (!visited[d4]) {
            q.push(d4);
            visited[d4] = true;
            prev[d4] = node;
            type[d4] = 'R';
        }
    }

    return "";
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    while (t--) {
        int a, b;
        cin >> a >> b;

        cout << bfs(a, b) << '\n';
    }
}
