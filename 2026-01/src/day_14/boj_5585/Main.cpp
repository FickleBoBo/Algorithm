#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    n = 1000 - n;
    int cnt = 0;

    cnt += n / 500;
    n %= 500;

    cnt += n / 100;
    n %= 100;

    cnt += n / 50;
    n %= 50;

    cnt += n / 10;
    n %= 10;

    cnt += n / 5;
    n %= 5;

    cnt += n;

    cout << cnt;
}
