#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;
    sort(v.rbegin(), v.rend());

    int time = 0;
    while (true) {
        if (v.back() < time) v.pop_back();
        if (v.empty()) break;
        time++;
    }

    cout << time;
}
