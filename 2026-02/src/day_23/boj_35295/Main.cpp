#include <bits/stdc++.h>
using namespace std;

const int MAX = 1000;
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

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;
    sort(v.begin(), v.end());

    sieve();

    int x = v[n - 2];
    int y = v[n - 1];
    if (x == 1 && isPrime[y]) {
        cout << "NO";
    } else {
        cout << "YES\n";
        cout << "2\n";
        cout << x << ' ' << y;
    }
}
