#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    long long r, c, n;
    cin >> r >> c >> n;
    cout << ((r + n - 1) / n) * ((c + n - 1) / n);
}
