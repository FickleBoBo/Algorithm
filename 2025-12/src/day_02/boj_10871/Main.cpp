#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, x;
    cin >> n >> x;

    vector<int> v(n);
    for (auto& num : v) cin >> num;

    for (auto num : v) {
        if (num < x) {
            cout << num << ' ';
        }
    }
}
