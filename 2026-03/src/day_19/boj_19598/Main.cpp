#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<pair<int, int>> v(n);
    for (auto& [s, t] : v) cin >> s >> t;
    sort(v.begin(), v.end());

    priority_queue<int, vector<int>, greater<>> pq;
    pq.push(0);
    int mx = 0;
    for (auto [s, t] : v) {
        if (pq.top() <= s) pq.pop();
        pq.push(t);

        mx = max(mx, (int)pq.size());
    }

    cout << mx;
}
