#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, S;
    cin >> N >> S;

    vector<int> v(N);
    for (auto& num : v) cin >> num;

    int g = abs(S - v[0]);
    for (int i = 1; i < N; i++) {
        g = gcd(g, abs(S - v[i]));
    }

    cout << g;
}
