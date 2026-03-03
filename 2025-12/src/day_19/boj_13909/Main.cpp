#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    int cnt = 1;
    while (cnt * cnt <= n) {
        cnt++;
    }

    cout << cnt - 1;
}
