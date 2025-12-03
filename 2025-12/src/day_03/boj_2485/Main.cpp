#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    vector<int> v(N);
    for (auto& num : v) cin >> num;

    int g = gcd(v[1] - v[0], v[2] - v[1]);
    for (int i = 3; i < N; i++) {
        g = gcd(g, v[i] - v[i - 1]);
    }

    cout << (v[N - 1] - v[0]) / g + 1 - N;
}
