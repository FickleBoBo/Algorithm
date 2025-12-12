#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int x;
    cin >> x;

    int cnt = 0;
    while (x > 0) {
        if (x % 2 == 1) cnt++;
        x /= 2;
    }

    cout << cnt;
}
