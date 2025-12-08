#include <bits/stdc++.h>
using namespace std;

int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
    int cross = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
    return (cross > 0) - (cross < 0);
}

double dist(int x1, int y1, int x2, int y2) { return sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2)); }

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int xa, ya, xb, yb, xc, yc;
    cin >> xa >> ya >> xb >> yb >> xc >> yc;

    if (ccw(xa, ya, xb, yb, xc, yc) == 0) {
        cout << -1;
    } else {
        vector<double> v = {dist(xa, ya, xb, yb), dist(xb, yb, xc, yc), dist(xc, yc, xa, ya)};
        sort(v.begin(), v.end());

        cout << fixed << setprecision(9) << 2 * (v[2] - v[0]);
    }
}
