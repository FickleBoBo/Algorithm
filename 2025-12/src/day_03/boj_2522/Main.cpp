#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    int pivot = N;
    for (int i = 1; i <= 2 * N - 1; i++) {
        for (int j = 1; j < pivot; j++) {
            cout << ' ';
        }
        for (int j = pivot; j <= N; j++) {
            cout << '*';
        }
        cout << '\n';

        if (i < N) {
            pivot--;
        } else {
            pivot++;
        }
    }
}
