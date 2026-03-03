#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int x, y, w, h;
    cin >> x >> y >> w >> h;
    cout << min({x, w - x, y, h - y});
}
