#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    cin >> s;

    int sum = 0;
    for (char c : s) {
        int x = c - '0';
        sum += x * x * x * x * x;
    }

    cout << sum;
}
