#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int arr[6] = {1, 1, 2, 2, 2, 8};

    for (int n : arr) {
        int x;
        cin >> x;
        cout << n - x << ' ';
    }
}
