#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int mx = 0;
    int idx = 0;

    for (int i = 1; i <= 9; i++) {
        int num;
        cin >> num;

        if (num > mx) {
            mx = num;
            idx = i;
        }
    }

    cout << mx << '\n';
    cout << idx << '\n';
}
