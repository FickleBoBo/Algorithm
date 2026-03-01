#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    vector<int> v(5);
    int sum = 0;
    for (int i = 0; i < 5; i++) {
        cin >> v[i];
        sum += v[i];
    }
    sort(v.begin(), v.end());

    cout << sum / 5 << '\n';
    cout << v[2] << '\n';
}
