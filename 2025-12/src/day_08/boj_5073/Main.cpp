#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    while (true) {
        vector<int> v(3);
        for (int& x : v) cin >> x;
        sort(v.begin(), v.end());

        if (v[0] == 0) break;

        if (v[0] + v[1] <= v[2]) {
            cout << "Invalid\n";
        } else {
            if (v[0] == v[1] && v[1] == v[2]) {
                cout << "Equilateral\n";
            } else if (v[0] == v[1] || v[1] == v[2] || v[2] == v[0]) {
                cout << "Isosceles\n";
            } else {
                cout << "Scalene\n";
            }
        }
    }
}
