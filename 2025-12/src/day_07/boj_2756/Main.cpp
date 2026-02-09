#include <bits/stdc++.h>
using namespace std;

int point(double dist) {
    if (dist <= 3) return 100;
    if (dist <= 6) return 80;
    if (dist <= 9) return 60;
    if (dist <= 12) return 40;
    if (dist <= 15) return 20;
    return 0;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    while (t--) {
        int p1 = 0;
        int p2 = 0;

        double x, y;
        for (int i = 0; i < 3; i++) {
            cin >> x >> y;
            p1 += point(sqrt(x * x + y * y));
        }
        for (int i = 0; i < 3; i++) {
            cin >> x >> y;
            p2 += point(sqrt(x * x + y * y));
        }

        if (p1 > p2) {
            cout << "SCORE: " << p1 << " to " << p2 << ", PLAYER 1 WINS.\n";
        } else if (p1 < p2) {
            cout << "SCORE: " << p1 << " to " << p2 << ", PLAYER 2 WINS.\n";
        } else {
            cout << "SCORE: " << p1 << " to " << p2 << ", TIE.\n";
        }
    }
}
