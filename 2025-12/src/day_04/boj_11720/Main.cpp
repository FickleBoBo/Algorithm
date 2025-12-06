#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    string s;
    cin >> n >> s;

    int sum = 0;
    for (char c : s) {
        sum += c - '0';
    }

    cout << sum;
}
