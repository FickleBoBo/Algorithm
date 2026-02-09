#include <bits/stdc++.h>
using namespace std;

bool isPrime[10001];

void sieve(int n) {
    fill(isPrime, isPrime + n + 1, true);
    isPrime[0] = isPrime[1] = false;

    for (int i = 2; i * i <= n; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int m, n;
    cin >> m >> n;

    int sum = 0;
    int mn = n;
    sieve(n);

    for (int i = m; i <= n; i++) {
        if (isPrime[i]) {
            sum += i;
            mn = min(mn, i);
        }
    }

    if (sum == 0) {
        cout << -1;
    } else {
        cout << sum << '\n';
        cout << mn << '\n';
    }
}
