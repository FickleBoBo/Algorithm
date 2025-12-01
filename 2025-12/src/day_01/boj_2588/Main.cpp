#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int A, B;
    cin >> A >> B;
    cout << A * (B % 10) << '\n';
    cout << A * (B / 10 % 10) << '\n';
    cout << A * (B / 100) << '\n';
    cout << A * B << '\n';
}
