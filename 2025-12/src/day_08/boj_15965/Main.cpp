#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 7368787;

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

    int k;
    cin >> k;

    vector<bool> isPrime = sieve(MAX);
    int cnt = 0;

    for (int i = 2; i <= MAX; i++) {
        if (isPrime[i]) cnt++;

        if (cnt == k) {
            cout << i;
            break;
        }
    }
}
