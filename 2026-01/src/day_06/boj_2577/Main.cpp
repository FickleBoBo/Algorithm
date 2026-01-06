#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int a, b, c;
    cin >> a >> b >> c;

    int res = a * b * c;
    int cntArr[10] = {};

    while (res > 0) {
        cntArr[res % 10]++;
        res /= 10;
    }

    for (int cnt : cntArr) {
        cout << cnt << '\n';
    }
}
