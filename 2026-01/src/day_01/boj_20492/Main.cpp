#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    cout << (n / 100 * 78) << ' ' << (n / 100 * 80 + n / 100 * 78 * 20 / 100);
}
