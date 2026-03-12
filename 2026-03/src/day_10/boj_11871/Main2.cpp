#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int nimsum = 0;

    int n;
    cin >> n;

    while (n--) {
        int p;
        cin >> p;

        if (p % 2 == 0) {
            nimsum ^= p / 2 - 1;
        } else {
            nimsum ^= (p + 1) / 2;
        }
    }

    if (nimsum) {
        cout << "koosaga";
    } else {
        cout << "cubelover";
    }
}
