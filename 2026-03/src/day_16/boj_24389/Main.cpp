#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    int rev = (n ^ -1) + 1;
    int cnt = 0;

    for (int i = 0; i < 32; i++) {
        if ((n & (1 << i)) != (rev & (1 << i))) cnt++;
    }

    cout << cnt;
}
