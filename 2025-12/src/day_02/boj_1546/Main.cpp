#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (auto& num : v) cin >> num;
    int mx = *max_element(v.begin(), v.end());

    double sum = 0;
    for (auto num : v) {
        sum += (double)num / mx * 100;
    }

    cout << sum / n;
}
