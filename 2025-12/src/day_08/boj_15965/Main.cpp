#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 7368787;
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
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int k;
    cin >> k;

    sieve();
    int cnt = 0;

    for (int i = 2; i <= MAX; i++) {
        if (isPrime[i]) cnt++;

        if (cnt == k) {
            cout << i;
            break;
        }
    }
}
