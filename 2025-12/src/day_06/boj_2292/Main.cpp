#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    int x = 1;
    while ((3 * x * (x - 1) + 1) < n) {
        x++;
    }

    cout << x;
}
