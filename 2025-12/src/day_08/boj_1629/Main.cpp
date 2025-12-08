#include <bits/stdc++.h>
using namespace std;

long long modpow(long long a, long long b, long long c) {
    long long res = 1;

    while (b > 0) {
        if (b & 1) res = res * a % c;
        a = a * a % c;
        b >>= 1;
    }

    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int a, b, c;
    cin >> a >> b >> c;
    cout << modpow(a, b, c);
}
