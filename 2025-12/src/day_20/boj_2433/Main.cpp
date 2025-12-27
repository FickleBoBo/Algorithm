#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m, c;
    cin >> n >> m >> c;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    deque<int> minDq;  // 단조 증가 큐
    deque<int> maxDq;  // 단조 감소 큐
    bool hasSilence = false;

    for (int i = 0; i < n; i++) {
        // 구간에서 나가는 인덱스 처리
        if (!minDq.empty() && minDq.front() == (i - m)) {
            minDq.pop_front();
        }

        // 구간으로 들어오는 인덱스 처리
        while (!minDq.empty() && v[i] <= v[minDq.back()]) {
            minDq.pop_back();
        }
        minDq.push_back(i);

        // 구간에서 나가는 인덱스 처리
        if (!maxDq.empty() && maxDq.front() == (i - m)) {
            maxDq.pop_front();
        }

        // 구간으로 들어오는 인덱스 처리
        while (!maxDq.empty() && v[i] >= v[maxDq.back()]) {
            maxDq.pop_back();
        }
        maxDq.push_back(i);

        // 윈도우 크기가 확보됐을 때부터 비교
        if ((i > m - 2) && (v[maxDq.front()] - v[minDq.front()] <= c)) {
            cout << i - m + 2 << '\n';
            hasSilence = true;
        }
    }

    if (!hasSilence) {
        cout << "NONE";
    }
}
