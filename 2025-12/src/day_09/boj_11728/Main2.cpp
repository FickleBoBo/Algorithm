#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<int> v1(n);
    for (int& x : v1) cin >> x;
    sort(v1.begin(), v1.end());

    vector<int> v2(m);
    for (int& x : v2) cin >> x;
    sort(v2.begin(), v2.end());

    vector<int> ans;
    int p1 = 0;  // v1 포인터
    int p2 = 0;  // v2 포인터

    while (p1 < n && p2 < m) {
        if (v1[p1] <= v2[p2]) {
            ans.push_back(v1[p1++]);
        } else {
            ans.push_back(v2[p2++]);
        }
    }

    ans.insert(ans.end(), v1.begin() + p1, v1.end());  // 남은 수 처리
    ans.insert(ans.end(), v2.begin() + p2, v2.end());  // 남은 수 처리

    for (int x : ans) {
        cout << x << ' ';
    }
}
