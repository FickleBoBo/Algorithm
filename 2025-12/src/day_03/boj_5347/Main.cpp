#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    for (int tc = 1; tc <= n; tc++) {
        long long a, b;
        cin >> a >> b;
        cout << lcm(a, b) << '\n';
    }
}
