#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    int cnt = 1;
    while (cnt * cnt <= n) {
        cnt++;
    }

    cout << cnt - 1;
}
