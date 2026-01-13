#include <bits/stdc++.h>
using namespace std;

constexpr int MAX_PRICE = 1000000000;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> dist(n - 1);
    for (int& x : dist) cin >> x;

    vector<long long> price(n);
    for (long long& x : price) cin >> x;

    long long mn = MAX_PRICE;
    long long sum = 0;
    for (int i = 0; i < n - 1; i++) {
        mn = min(mn, price[i]);
        sum += mn * dist[i];
    }

    cout << sum;
}
