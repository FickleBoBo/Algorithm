#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    cin >> N >> M;

    vector<int> v(1 + N);
    iota(v.begin(), v.end(), 0);

    for (int i = 0; i < M; i++) {
        int s, e;
        cin >> s >> e;

        swap(v[s], v[e]);
    }

    for (int i = 1; i <= N; i++) {
        cout << v[i] << ' ';
    }
}
