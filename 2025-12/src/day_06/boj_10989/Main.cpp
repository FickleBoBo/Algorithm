#include <bits/stdc++.h>
using namespace std;

const int MX = 10000;
int cnt[1 + MX];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    while (n--) {
        int x;
        cin >> x;
        cnt[x]++;
    }

    for (int i = 1; i <= MX; i++) {
        for (int j = 1; j <= cnt[i]; j++) {
            cout << i << '\n';
        }
    }
}
