#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int nimsum = 0;
    int cnt = 0;

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int p;
        cin >> p;
        nimsum ^= p;
        if (p == 1) cnt++;
    }

    if ((cnt < n && nimsum != 0) || (cnt == n && cnt % 2 == 0)) {
        cout << "koosaga";
    } else {
        cout << "cubelover";
    }
}
