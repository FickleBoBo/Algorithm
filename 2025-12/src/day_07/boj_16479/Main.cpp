#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int k, d1, d2;
    cin >> k >> d1 >> d2;
    cout << k * k - pow(d1 - d2, 2) / 4;
}
