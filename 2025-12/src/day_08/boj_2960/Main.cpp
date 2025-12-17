#include <bits/stdc++.h>
using namespace std;

int sieve(int n, int k) {
    vector<bool> isPrime(1 + n, true);
    isPrime[0] = isPrime[1] = false;
    int cnt = 0;

    for (int i = 2; i <= n; i++) {
        if (isPrime[i]) {
            cnt++;
            if (cnt == k) return i;

            for (int j = i * i; j <= n; j += i) {
                if (isPrime[j]) {
                    isPrime[j] = false;

                    cnt++;
                    if (cnt == k) return j;
                }
            }
        }
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;
    cout << sieve(n, k);
}
