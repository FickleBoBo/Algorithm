#include <bits/stdc++.h>
using namespace std;

// 벡터를 p1, p2로 분할한 세 구간 중 key가 존재하는지 리턴
bool solve(const vector<int>& v, int p1, int p2, int key) {
    return binary_search(v.begin(), v.begin() + p1, key) || binary_search(v.begin() + p1 + 1, v.begin() + p2, key) ||
           binary_search(v.begin() + p2 + 1, v.end(), key);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;
    sort(v.begin(), v.end());

    int cnt = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i == j) continue;

            // 이분 탐색으로 찾으면 좋은 수
            if (solve(v, min(i, j), max(i, j), v[i] - v[j])) {
                cnt++;
                break;
            }
        }
    }

    cout << cnt;
}
