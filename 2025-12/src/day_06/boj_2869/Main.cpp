#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int a, b, v;
    cin >> a >> b >> v;
    cout << (v - b - 1) / (a - b) + 1;
}
