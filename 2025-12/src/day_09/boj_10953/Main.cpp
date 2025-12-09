#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    scanf("%d", &t);

    for (int tc = 1; tc <= t; tc++) {
        int a, b;
        scanf("%d,%d", &a, &b);
        cout << a + b << '\n';
    }
}
