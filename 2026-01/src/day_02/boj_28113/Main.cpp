#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, a, b;
    cin >> n >> a >> b;

    if (a < max(n, b)) {
        cout << "Bus";
    } else if (a > max(n, b)) {
        cout << "Subway";
    } else {
        cout << "Anything";
    }
}
