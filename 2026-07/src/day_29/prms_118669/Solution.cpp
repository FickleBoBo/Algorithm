#include <bits/stdc++.h>
using namespace std;

const int INF = 10'000'001;
const int MAXN = 50'000;

bool isGate[1 + MAXN];
bool isSummit[1 + MAXN];

vector<pair<int, int>> adj[1 + MAXN];
bool vis[1 + MAXN];

vector<int> dijkstra(vector<int>& gates) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;
    for (int gate : gates) {
        pq.push({0, gate});
    }

    vector<int> ans = {0, INF};

    while (!pq.empty()) {
        auto [cur_w, cur_v] = pq.top();
        pq.pop();

        if (isSummit[cur_v]) {
            if (cur_w < ans[1] || cur_w == ans[1] && cur_v < ans[0]) {
                ans[0] = cur_v;
                ans[1] = cur_w;
            }
            continue;
        }

        if (vis[cur_v]) continue;
        vis[cur_v] = true;

        for (auto [nxt_w, nxt_v] : adj[cur_v]) {
            if (isGate[nxt_v] || vis[nxt_v]) continue;
            pq.push({max(cur_w, nxt_w), nxt_v});
        }
    }

    return ans;
}

vector<int> solution(int n, vector<vector<int>> paths, vector<int> gates, vector<int> summits) {
    for (auto& p : paths) {
        adj[p[0]].push_back({p[2], p[1]});
        adj[p[1]].push_back({p[2], p[0]});
    }

    for (int g : gates) {
        isGate[g] = true;
    }
    for (int s : summits) {
        isSummit[s] = true;
    }

    return dijkstra(gates);
}
