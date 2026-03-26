#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    while (true) {
        string line;
        getline(cin, line);

        if (line == "#") break;

        int cnt = 0;
        for (char c : line) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') cnt++;
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') cnt++;
        }

        cout << cnt << '\n';
    }
}
