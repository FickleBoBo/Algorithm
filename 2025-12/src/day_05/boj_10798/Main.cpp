#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    char grid[5][15] = {};
    for (int i = 0; i < 5; i++) {
        string s;
        cin >> s;

        for (int j = 0; j < s.size(); j++) {
            grid[i][j] = s[j];
        }
    }

    for (int j = 0; j < 15; j++) {
        for (int i = 0; i < 5; i++) {
            if (grid[i][j] != '\0') cout << grid[i][j];
        }
    }
}
