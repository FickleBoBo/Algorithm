#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    int div = 2;
    while (n > 1) {
        while (n % div == 0) {
            n /= div;
            cout << div << '\n';
        }

        div++;
    }
}
