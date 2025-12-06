#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (auto& num : v) cin >> num;
    sort(v.begin(), v.end());

    for (auto num : v) {
        cout << num << '\n';
    }
}
