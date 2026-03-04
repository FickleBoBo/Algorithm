#include <bits/stdc++.h>
using namespace std;

const int MAX = 123456 * 2;
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
