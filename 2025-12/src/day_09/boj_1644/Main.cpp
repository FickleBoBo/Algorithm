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

vector<int> prime_list(const vector<bool>& isPrime) {
    vector<int> v;

    for (int i = 2; i < isPrime.size(); i++) {
        if (isPrime[i]) v.push_back(i);
    }

    return v;
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

    vector<int> primes = prime_list(sieve(n));
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
