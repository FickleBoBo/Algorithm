#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    vector<pair<int, int>> v(8);
    for (int i = 0; i < 8; i++) {
        cin >> v[i].first;
        v[i].second = i;
    }
    sort(v.begin(), v.end());

    int sum = 0;
    vector<bool> visited(8);
    for (int i = 3; i < 8; i++) {
        sum += v[i].first;
        visited[v[i].second] = true;
    }

    cout << sum << '\n';
    for (int i = 0; i < 8; i++) {
        if (visited[i]) {
            cout << i + 1 << ' ';
        }
    }
}
