#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int A, B;
    cin >> A >> B;
    cout << gcd(A, B) << '\n';
    cout << lcm(A, B) << '\n';
}
