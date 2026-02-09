#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 100000;
bool isPrime[1 + MAX];
vector<int> primes;

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

    for (int i = 2; i <= MAX; i++) {
        if (isPrime[i]) primes.push_back(i);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    sieve();

    int t;
    cin >> t;

    while (t--) {
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
