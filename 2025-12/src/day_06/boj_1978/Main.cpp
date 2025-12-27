#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    int cnt = 0;
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;

        bool flag = true;
        if (x == 1) flag = false;

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                flag = false;
                break;
            }
        }

        if (flag) cnt++;
    }

    cout << cnt;
}
