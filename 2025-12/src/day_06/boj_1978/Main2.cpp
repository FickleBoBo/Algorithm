#include <bits/stdc++.h>
using namespace std;

vector<bool> sieve(int n) {
    vector<bool> isPrime(1 + n);
    fill(isPrime.begin() + 2, isPrime.end(), true);

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

    int n;
    cin >> n;

    vector<bool> isPrime = sieve(1000);
    int cnt = 0;

    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;

        if (isPrime[x]) cnt++;
    }

    cout << cnt;
}
