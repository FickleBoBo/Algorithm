#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int ys = 0;
    int ms = 0;

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;

        ys += (x / 30 + 1) * 10;
        ms += (x / 60 + 1) * 15;
    }

    if (ys < ms) {
        cout << "Y " << ys << '\n';
    } else if (ys > ms) {
        cout << "M " << ms << '\n';
    } else {
        cout << "Y M " << ys << '\n';
    }
}
