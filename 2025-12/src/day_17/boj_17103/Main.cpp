#include <bits/stdc++.h>
using namespace std;

const int MAX = 1000000;
bool isPrime[1 + MAX];

void sieve() {
    fill(isPrime, isPrime + MAX + 1, true);
    isPrime[0] = isPrime[1] = false;

    for (int i = 2; i * i <= MAX; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j <= MAX; j += i) {
                isPrime[j] = false;
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    sieve();

    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;

        int cnt = 0;
        for (int i = 2; i <= n / 2; i++) {
            if (isPrime[i] && isPrime[n - i]) cnt++;
        }

        cout << cnt << '\n';
    }
}
