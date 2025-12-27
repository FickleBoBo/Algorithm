#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, l;
    cin >> n >> l;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    // 우선순위 큐
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;
    for (int i = 0; i < n; i++) {
        while (!pq.empty() && pq.top().second <= (i - l)) {
            pq.pop();
        }

        pq.push({v[i], i});

        cout << pq.top().first << ' ';
    }
}
