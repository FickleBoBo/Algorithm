#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string line;
    cin >> line;
    cout << count(line.begin(), line.end(), ',') + 1;
}
