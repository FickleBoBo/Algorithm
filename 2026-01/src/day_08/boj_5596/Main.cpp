#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int sum1 = 0;
    for (int i = 0; i < 4; i++) {
        int x;
        cin >> x;
        sum1 += x;
    }

    int sum2 = 0;
    for (int i = 0; i < 4; i++) {
        int x;
        cin >> x;
        sum2 += x;
    }
    cout << max(sum1, sum2);
}
