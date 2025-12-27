#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    vector<bool> visited(42);
    for (int i = 0; i < 10; i++) {
        int n;
        cin >> n;
        visited[n % 42] = true;
    }

    cout << count(visited.begin(), visited.end(), true);
}
