#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    int left = 1;
    int right = 2 * N;
    for (int i = 1; i <= 2 * N - 1; i++) {
        for (int j = 1; j <= left; j++) {
            cout << '*';
        }
        for (int j = left + 1; j < right; j++) {
            cout << ' ';
        }
        for (int j = right; j <= 2 * N; j++) {
            cout << '*';
        }
        cout << '\n';

        if (i < N) {
            left++;
            right--;
        } else {
            left--;
            right++;
        }
    }
}
