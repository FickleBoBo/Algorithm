#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    for (int tc = 1; tc <= t; tc++) {
        long long n;
        cin >> n;

        if (n <= 1) {
            cout << 2 << '\n';
            continue;
        }

        while (true) {
            bool isPrime = true;
            for (long long i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    isPrime = false;
                    n++;
                    break;
                }
            }

            if (isPrime) break;
        }

        cout << n << '\n';
    }
}
