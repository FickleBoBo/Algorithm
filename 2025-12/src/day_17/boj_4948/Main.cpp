#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 123456 * 2;

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

    while (true) {
        int n;
        cin >> n;

        if (n == 0) break;

        int cnt = 0;
        for (int i = n + 1; i <= 2 * n; i++) {
            if (isPrime[i]) cnt++;
        }

        cout << cnt << '\n';
    }
}
