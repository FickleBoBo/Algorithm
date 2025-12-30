#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string grade;
    cin >> grade;

    double ans = 0;

    if (grade.front() == 'A') {
        ans += 4;
    } else if (grade.front() == 'B') {
        ans += 3;
    } else if (grade.front() == 'C') {
        ans += 2;
    } else if (grade.front() == 'D') {
        ans += 1;
    } else {
        cout << fixed << setprecision(1) << ans;
        return 0;
    }

    if (grade.back() == '+') {
        ans += 0.3;
    } else if (grade.back() == '-') {
        ans -= 0.3;
    }

    cout << fixed << setprecision(1) << ans;
}
