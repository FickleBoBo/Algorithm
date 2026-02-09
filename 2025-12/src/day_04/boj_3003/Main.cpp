#include <bits/stdc++.h>
using namespace std;

int arr[6] = {1, 1, 2, 2, 2, 8};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    for (int n : arr) {
        int x;
        cin >> x;
        cout << n - x << ' ';
    }
}
