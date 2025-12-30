#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    int fact = 1;
    for (int i = 1; i <= n; i++) {
        fact *= i;
    }

    cout << fact;
}
