#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<int> v(n + m);
    for (auto& num : v) cin >> num;
    sort(v.begin(), v.end());

    for (auto num : v) {
        cout << num << ' ';
    }
}
