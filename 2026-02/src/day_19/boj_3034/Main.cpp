#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, w, h;
    cin >> n >> w >> h;

    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;

        if (x * x <= w * w + h * h) {
            cout << "DA\n";
        } else {
            cout << "NE\n";
        }
    }
}
