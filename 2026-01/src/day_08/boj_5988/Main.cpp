#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        string k;
        cin >> k;

        if ((k.back() - '0') % 2 == 0) {
            cout << "even\n";
        } else {
            cout << "odd\n";
        }
    }
}
