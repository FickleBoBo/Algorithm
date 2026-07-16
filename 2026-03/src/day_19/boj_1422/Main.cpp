#include <bits/stdc++.h>
using namespace std;

struct cmp {
    bool operator()(auto& a, auto& b) {
        return a + b < b + a;
    }
};

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int k, n;
    cin >> k >> n;

    vector<string> v(k);
    for (string& s : v) cin >> s;

    priority_queue<string, vector<string>, cmp> pq;

    for (string& s : v) {
        pq.push(s);
    }

    sort(v.begin(), v.end(), [](auto& a, auto& b) {
        if (a.size() != b.size()) return b.size() < a.size();
        return b + a < a + b;
    });

    for (int i = 0; i < n - k; i++) {
        pq.push(v[0]);
    }

    while (!pq.empty()) {
        cout << pq.top();
        pq.pop();
    }
}
