#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    deque<int> dq;

    vector<int> v(n);
    for (int& x : v) cin >> x;
    reverse(v.begin(), v.end());

    for (int i = 0; i < n; i++) {
        if (v[i] == 1) {
            dq.push_front(i + 1);
        } else if (v[i] == 2) {
            int tmp = dq.front();
            dq.pop_front();
            dq.push_front(i + 1);
            dq.push_front(tmp);
        } else {
            dq.push_back(i + 1);
        }
    }

    for (int x : dq) {
        cout << x << ' ';
    }
}
