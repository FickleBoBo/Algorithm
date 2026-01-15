#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    vector<int> v(5);
    for (int& x : v) cin >> x;

    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4 - i; j++) {
            if (v[j] > v[j + 1]) {
                swap(v[j], v[j + 1]);

                for (int x : v) {
                    cout << x << ' ';
                }
                cout << '\n';
            }
        }
    }
}
