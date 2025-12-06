#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    int cnt = 0;
    for (int i = 0; i < n; i++) {
        int n;
        cin >> n;

        bool flag = true;

        if (n == 1) flag = false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                flag = false;
                break;
            }
        }

        if (flag) cnt++;
    }

    cout << cnt;
}
