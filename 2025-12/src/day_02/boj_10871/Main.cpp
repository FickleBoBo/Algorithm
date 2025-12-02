#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, X;
    cin >> N >> X;

    vector<int> v(N);
    for (auto& num : v) cin >> num;

    for (auto num : v) {
        if (num < X) {
            cout << num << ' ';
        }
    }
}
