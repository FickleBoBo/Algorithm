#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    vector<bool> visited(42);
    for (int i = 0; i < 10; i++) {
        int x;
        cin >> x;
        visited[x % 42] = true;
    }

    cout << count(visited.begin(), visited.end(), true);
}
