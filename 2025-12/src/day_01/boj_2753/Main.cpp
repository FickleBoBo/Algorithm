#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int y;
    cin >> y;
    cout << (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0));
}
