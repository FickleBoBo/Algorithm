#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    long long mn, mx;
    cin >> mn >> mx;

    vector<char> check((int)(mx - mn + 1), true);

    for (long long i = 2; i * i <= mx; i++) {
        long long pow = i * i;
        long long q = mn % pow == 0 ? mn / pow : mn / pow + 1;

        for (long long j = pow * q; j <= mx; j += pow) {
            check[(int)(j - mn)] = false;
        }
    }

    cout << count(check.begin(), check.end(), true);
}
