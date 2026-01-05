#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    deque<pair<int, int>> dq;
    for (int i = 1; i <= n; i++) {
        int x;
        cin >> x;
        dq.push_back({i, x});
    }

    while (true) {
        auto p = dq.front();
        dq.pop_front();

        cout << p.first << ' ';

        if (dq.empty()) break;

        if (p.second > 0) {
            for (int i = 1; i < p.second; i++) {
                dq.push_back(dq.front());
                dq.pop_front();
            }
        } else {
            for (int i = 1; i <= -p.second; i++) {
                dq.push_front(dq.back());
                dq.pop_back();
            }
        }
    }
}
