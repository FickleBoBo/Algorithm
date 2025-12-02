#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    cin >> N >> M;

    vector<int> v(N);
    for (int i = 0; i < M; i++) {
        int s, e, n;
        cin >> s >> e >> n;

        fill(v.begin() + s - 1, v.begin() + e, n);
    }

    for (auto num : v) {
        cout << num << ' ';
    }
}
