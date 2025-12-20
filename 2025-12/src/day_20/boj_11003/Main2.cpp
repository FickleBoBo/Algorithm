#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m, c;
    cin >> n >> m >> c;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> minPq;  // 최소힙
    priority_queue<pair<int, int>> maxPq;                                     // 최대힙
    bool hasSilence = false;

    for (int i = 0; i < n; i++) {
        while (!minPq.empty() && minPq.top().second <= (i - m)) {
            minPq.pop();
        }
        minPq.push({v[i], i});

        while (!maxPq.empty() && maxPq.top().second <= (i - m)) {
            maxPq.pop();
        }
        maxPq.push({v[i], i});

        // 윈도우 크기가 확보됐을 때부터 비교
        if ((i > m - 2) && (maxPq.top().first - minPq.top().first <= c)) {
            cout << i - m + 2 << '\n';
            hasSilence = true;
        }
    }

    if (!hasSilence) {
        cout << "NONE";
    }
}
