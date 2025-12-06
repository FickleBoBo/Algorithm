#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= 2 * n; j++) {
            if ((i + j) % 2 == 0) {
                cout << '*';
            } else {
                cout << ' ';
            }
        }
        cout << '\n';
    }
}
