#include <bits/stdc++.h>
using namespace std;

int arr[10] = {0, 1, 2, 2, 2, 3, 3, 3, 3, 3};

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    long long n, k, x;
    cin >> n >> k >> x;
    cout << n - arr[x] - 3 * (k - 1) + 1;
}
