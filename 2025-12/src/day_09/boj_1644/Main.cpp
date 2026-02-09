#include <bits/stdc++.h>
using namespace std;

bool isPrime[4000001];
vector<int> primes;

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

    for (int i = 2; i <= n; i++) {
        if (isPrime[i]) primes.push_back(i);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    if (n == 1) {
        cout << 0;
        return 0;
    }

    sieve(n);
    int l = 0;
    int r = 0;
    int sum = 0;
    int cnt = 0;

    while (true) {
        if (sum < n) {
            sum += primes[r++];
        } else {
            if (sum == n) cnt++;
            sum -= primes[l++];
        }

        if (r == primes.size() && sum < n) break;
    }

    cout << cnt;
}
