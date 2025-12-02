#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    vector<int> v(N);
    for (auto& num : v) cin >> num;

    int X;
    cin >> X;

    cout << count(v.begin(), v.end(), X);
}
