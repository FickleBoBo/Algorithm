#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    vector<int> v(10);
    for (int& x : v) cin >> x;

    int sum = 0;
    for (int i = 0; i < 10; i++) {
        if (sum + v[i] <= 100) {
            sum += v[i];
            continue;
        }

        if ((100 - sum) >= (sum + v[i] - 100)) {
            sum += v[i];
            continue;
        }

        break;
    }

    cout << sum;
}
