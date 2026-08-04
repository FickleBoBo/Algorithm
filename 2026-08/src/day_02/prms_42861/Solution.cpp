#include <bits/stdc++.h>
using namespace std;

int p[100];

void make(int n) {
    for (int i = 0; i < n; i++) {
        p[i] = i;
    }
}

int find(int x) {
    if (x == p[x]) return x;
    return p[x] = find(p[x]);
}

void unite(int x, int y) {
    p[find(y)] = find(x);
}

int solution(int n, vector<vector<int>> costs) {
    sort(costs.begin(), costs.end(), [](auto& o1, auto& o2) {
        return o1[2] < o2[2];
    });
    make(n);

    int sum = 0;
    int cnt = 0;
    for (auto& cost : costs) {
        int x = cost[0];
        int y = cost[1];
        int v = cost[2];

        if (find(x) == find(y)) continue;

        unite(x, y);
        sum += v;
        cnt++;

        if (cnt == n - 1) break;
    }

    return sum;
}
