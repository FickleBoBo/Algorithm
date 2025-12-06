#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    int left = n;
    int right = n;
    for (int i = 1; i <= 2 * n - 1; i++) {
        for (int j = 1; j < left; j++) {
            cout << ' ';
        }
        for (int j = left; j <= right; j++) {
            cout << '*';
        }
        cout << '\n';

        if (i < n) {
            left--;
            right++;
        } else {
            left++;
            right--;
        }
    }
}
