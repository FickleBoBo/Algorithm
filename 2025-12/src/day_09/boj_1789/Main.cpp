#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    long long s;
    cin >> s;

    long long n = 1;
    while (n * (n + 1) / 2 <= s) {
        n++;
    }

    cout << n - 1;
}
