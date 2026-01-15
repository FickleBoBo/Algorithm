#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    long long a, b;
    cin >> a >> b;

    if (a > b) swap(a, b);

    cout << (a + b) * (b - a + 1) / 2;
}
