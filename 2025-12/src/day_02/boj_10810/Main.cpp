#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<int> v(n);
    for (int i = 0; i < m; i++) {
        int s, e, num;
        cin >> s >> e >> num;

        fill(v.begin() + s - 1, v.begin() + e, num);
    }

    for (auto num : v) {
        cout << num << ' ';
    }
}
