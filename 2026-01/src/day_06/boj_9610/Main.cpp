#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int cntArr[5] = {};

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;

        if (x == 0 || y == 0) {
            cntArr[0]++;
            continue;
        }

        if (x > 0) {
            if (y > 0) {
                cntArr[1]++;
            } else {
                cntArr[4]++;
            }
        } else {
            if (y > 0) {
                cntArr[2]++;
            } else {
                cntArr[3]++;
            }
        }
    }

    cout << "Q1: " << cntArr[1] << '\n';
    cout << "Q2: " << cntArr[2] << '\n';
    cout << "Q3: " << cntArr[3] << '\n';
    cout << "Q4: " << cntArr[4] << '\n';
    cout << "AXIS: " << cntArr[0] << '\n';
}
