#include <bits/stdc++.h>
using namespace std;

double PI = 3.141592;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int d1, d2;
    cin >> d1 >> d2;
    cout << fixed << setprecision(6) << d1 * 2 + 2 * d2 * PI;
}
