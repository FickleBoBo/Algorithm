#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (auto& num : v) cin >> num;

    vector<int> psum(1 + n);
    for (int i = 1; i <= n; i++) {
        psum[i] = psum[i - 1] + v[i - 1];
    }

    int m;
    cin >> m;

    for (int i = 0; i < m; i++) {
        int s, e;
        cin >> s >> e;
        cout << psum[e] - psum[s - 1] << '\n';
    }
}
