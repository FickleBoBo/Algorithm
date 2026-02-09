#include <bits/stdc++.h>
using namespace std;

constexpr int MOD = 1000000007;
long long fact[4000001] = {1};  // 팩토리얼 배열
long long invFact[4000001];     // 역팩토리얼 배열

long long modpow(long a, int b) {
    long long res = 1;

    while (b > 0) {
        if (b & 1) res = res * a % MOD;
        a = a * a % MOD;
        b >>= 1;
    }

    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    for (int i = 1; i <= n; i++) {
        fact[i] = fact[i - 1] * i % MOD;
    }

    invFact[n] = modpow(fact[n], MOD - 2);
    for (int i = n - 1; i >= 0; i--) {
        invFact[i] = invFact[i + 1] * (i + 1) % MOD;
    }

    cout << fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
}
