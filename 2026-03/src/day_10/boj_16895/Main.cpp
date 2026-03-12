#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    int nimsum = 0;

    vector<int> v(n);
    for (int& p : v) cin >> p;
    for (int p : v) nimsum ^= p;

    int cnt = 0;
    for (int p : v) {
        if ((p ^ nimsum) < p) cnt++;
    }

    cout << cnt;
}
