#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    deque<int> q(n);
    iota(q.begin(), q.end(), 1);

    cout << '<';
    while (!q.empty()) {
        for (int i = 1; i < k; i++) {
            q.push_back(q.front());
            q.pop_front();
        }

        cout << q.front();
        q.pop_front();

        if (!q.empty()) cout << ", ";
    }
    cout << '>';
}
