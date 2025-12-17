#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 100000;

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

    vector<int> primes = prime_list(sieve(MAX));

    int t;
    cin >> t;

    for (int tc = 1; tc <= t; tc++) {
        int n;
        cin >> n;

        for (int p : primes) {
            if (p * p > n) break;  // p의 제곱보다 작으면 탐색 종료

            int cnt = 0;
            while (n % p == 0) {
                n /= p;
                cnt++;
            }

            if (cnt > 0) {
                cout << p << ' ' << cnt << '\n';
            }
        }

        if (n > 1) {
            cout << n << ' ' << 1 << '\n';  // n이 처음부터 소수인 경우와 합성수를 소인수분해한 후 소수가 남은 경우
        }
    }
}
