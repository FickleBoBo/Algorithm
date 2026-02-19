#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 1000;
bool visited[MAX + 1 + MAX];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        visited[MAX + x] = true;
    }

    for (int i = 0; i < sizeof(visited); i++) {
        if (visited[i]) {
            cout << i - MAX << ' ';
        }
    }
}
