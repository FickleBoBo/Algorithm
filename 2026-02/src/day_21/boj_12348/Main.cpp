#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;
    cin >> s;

    int len = s.size();

    long long n = stoll(s);
    for (long long i = n - 9 * len; i <= n; i++) {
        long long x = i;
        long long sum = x;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }

        if (sum == n) {
            cout << i;
            return 0;
        }
    }

    cout << 0;
}
