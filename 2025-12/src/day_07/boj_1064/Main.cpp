#include <bits/stdc++.h>
using namespace std;

double dist(int x1, int y1, int x2, int y2) { return sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2)); }

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int xa, ya, xb, yb, xc, yc;
    cin >> xa >> ya >> xb >> yb >> xc >> yc;

    if ((yb - ya) * (xc - xa) == (yc - ya) * (xb - xa)) {
        cout << -1;
    } else {
        vector<double> v = {dist(xa, ya, xb, yb), dist(xb, yb, xc, yc), dist(xc, yc, xa, ya)};
        sort(v.begin(), v.end());

        cout << fixed << setprecision(9) << 2 * (v[2] - v[0]);
    }
}
