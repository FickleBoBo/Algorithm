#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> isQueue(n);
    for (int& x : isQueue) cin >> x;

    deque<int> dq;
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        if (isQueue[i] == 0) dq.push_back(x);
    }

    int m;
    cin >> m;

    for (int i = 0; i < m; i++) {
        int x;
        cin >> x;

        dq.push_front(x);
        cout << dq.back() << ' ';
        dq.pop_back();
    }
}
