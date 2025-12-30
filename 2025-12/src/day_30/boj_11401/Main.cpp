#include <bits/stdc++.h>
using namespace std;

constexpr int MOD = 1000000007;

long long modpow(long a, int b) {
    long long res = 1;

    while (b > 0) {
        if (b & 1) res = res * a % MOD;
        a = a * a % MOD;
        b >>= 1;
    }

    return res;
}

vector<long long> initFact(int n) {
    vector<long long> fact(1 + n);
    fact[0] = 1;

    for (int i = 1; i <= n; i++) {
        fact[i] = fact[i - 1] * i % MOD;
    }

    return fact;
}

vector<long long> initInvFact(int n, long a) {
    vector<long long> invFact(1 + n);
    invFact[n] = modpow(a, MOD - 2);  // 역팩토리얼의 초항(페르마의 소정리 활용)

    for (int i = n - 1; i >= 0; i--) {
        invFact[i] = invFact[i + 1] * (i + 1) % MOD;
    }

    return invFact;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    vector<long long> fact = initFact(n);                 // 팩토리얼 배열
    vector<long long> invFact = initInvFact(n, fact[n]);  // 역팩토리얼 배열

    cout << fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
}
