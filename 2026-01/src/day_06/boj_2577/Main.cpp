#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int a, b, c;
    cin >> a >> b >> c;

    int res = a * b * c;
    vector<int> cnt(10);

    while (res > 0) {
        cnt[res % 10]++;
        res /= 10;
    }

    for (int x : cnt) {
        cout << x << '\n';
    }
}
