#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    vector<bool> visited(1 + 30);
    for (int i = 0; i < 28; i++) {
        int n;
        cin >> n;

        visited[n] = true;
    }

    for (int i = 1; i <= 30; i++) {
        if (visited[i]) continue;

        cout << i << '\n';
    }
}
