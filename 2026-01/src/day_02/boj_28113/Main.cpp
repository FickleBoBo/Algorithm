#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, a, b;
    cin >> n >> a >> b;

    if (a < max(n, b)) {
        cout << "Bus";
    } else if (a > max(b, n)) {
        cout << "Subway";
    } else {
        cout << "Anything";
    }
}
