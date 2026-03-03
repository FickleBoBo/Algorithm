#include <bits/stdc++.h>
using namespace std;

bool visited[31];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

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
