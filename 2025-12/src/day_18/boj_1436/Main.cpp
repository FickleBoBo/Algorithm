#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    int x = 666;
    while (true) {
        if (to_string(x).find("666") != string::npos) {
            n--;

            if (n == 0) break;
        }
        x++;
    }

    cout << x;
}
