#include <bits/stdc++.h>
using namespace std;

double lower_bound_param(double x, double y, double c) {
    double left = 0;
    double right = min(x, y);

    while (right - left > 0.001) {
        double mid = (left + right) / 2;

        double h1 = sqrt(x * x - mid * mid);
        double h2 = sqrt(y * y - mid * mid);

        if (c < h1 * h2 / (h1 + h2)) {
            left = mid;
        } else {
            right = mid;
        }
    }

    return right;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    double x, y, c;
    cin >> x >> y >> c;
    cout << lower_bound_param(x, y, c);
}
