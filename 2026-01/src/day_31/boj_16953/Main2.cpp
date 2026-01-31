#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int a, b;
    cin >> a >> b;

    bool flag = false;
    int cnt = 1;
    while (true) {
        if (a == b) {
            flag = true;
            break;
        } else if (a > b) {
            break;
        }

        if (b % 2 == 0) {
            b /= 2;
        } else if (b % 10 == 1) {
            b /= 10;
        } else {
            break;
        }

        cnt++;
    }

    if (flag) {
        cout << cnt;
    } else {
        cout << -1;
    }
}
