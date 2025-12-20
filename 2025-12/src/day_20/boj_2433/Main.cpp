#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, l;
    cin >> n >> l;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    // 단조 덱
    deque<int> dq;
    for (int i = 0; i < n; i++) {
        // 구간에서 나가는 인덱스 처리
        if (!dq.empty() && dq.front() == (i - l)) {
            dq.pop_front();
        }

        // 구간으로 들어오는 인덱스 처리
        while (!dq.empty() && v[i] <= v[dq.back()]) {
            dq.pop_back();
        }

        dq.push_back(i);

        cout << v[dq.front()] << ' ';
    }
}
