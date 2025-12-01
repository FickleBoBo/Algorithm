#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int A, B, C;
    cin >> A >> B >> C;
    cout << (A + (B + C) / 60) % 24 << ' ' << (B + C) % 60;
}
