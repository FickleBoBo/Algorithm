#include <bits/stdc++.h>
using namespace std;

long long modpow(long long a, long long b, long long c) {
    if (b == 0) return 1;

    long long half = modpow(a, b / 2, c);
    if (b % 2) {
        return half * half % c * a % c;
    } else {
        return half * half % c;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int a, b, c;
    cin >> a >> b >> c;
    cout << modpow(a, b, c);
}
