#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(5);
    for (int& x : v) cin >> x;

    int cnt = 0;
    for (int x : v) {
        if (n == x) cnt++;
    }

    cout << cnt;
}
