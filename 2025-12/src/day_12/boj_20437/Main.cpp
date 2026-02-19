#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    while (t--) {
        string s;
        int k;
        cin >> s >> k;

        vector<vector<int>> pos(26);
        for (int i = 0; i < s.size(); i++) {
            pos[s[i] - 'a'].push_back(i);
        }

        int mn = INT_MAX;
        int mx = 0;

        // 알파벳별 리스트에 대해 슬라이딩 윈도우 수행
        for (auto& v : pos) {
            for (int i = 0; i <= (int)v.size() - k; i++) {
                mn = min(mn, v[i + k - 1] - v[i] + 1);
                mx = max(mx, v[i + k - 1] - v[i] + 1);
            }
        }

        // min 값이 갱신되지 않은 경우로 판단
        if (mn == INT_MAX) {
            cout << -1 << '\n';
        } else {
            cout << mn << ' ' << mx << '\n';
        }
    }
}
