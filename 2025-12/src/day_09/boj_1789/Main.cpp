#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    long long s;
    cin >> s;

    long long n = 1;
    while (n * (n + 1) / 2 <= s) {
        n++;
    }

    cout << n - 1;
}
