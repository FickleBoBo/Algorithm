#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 1000000;

vector<bool> sieve(int n) {
    vector<bool> isPrime(1 + n, true);
    isPrime[0] = isPrime[1] = false;

    for (int i = 2; i * i <= n; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
    }

    return isPrime;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    vector<bool> isPrime = sieve(MAX);

    int t;
    cin >> t;

    for (int tc = 1; tc <= t; tc++) {
        int n;
        cin >> n;

        int cnt = 0;
        for (int i = 2; i <= n / 2; i++) {
            if (isPrime[i] && isPrime[n - i]) cnt++;
        }

        cout << cnt << '\n';
    }
}
