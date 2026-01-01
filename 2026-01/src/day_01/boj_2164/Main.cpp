#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    deque<int> q(n);
    iota(q.begin(), q.end(), 1);

    while (q.size() > 1) {
        q.pop_front();
        q.push_back(q.front());
        q.pop_front();
    }
    cout << q.front();
}
