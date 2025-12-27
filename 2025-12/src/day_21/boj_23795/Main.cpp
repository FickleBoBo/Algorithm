#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int sum = 0;

    while (true) {
        int n;
        cin >> n;

        if (n == -1) break;

        sum += n;
    }

    cout << sum;
}
