#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    while (true) {
        string line;
        getline(cin, line);

        if (line == "#") break;

        int cnt = 0;
        for (int i = 0; i < line.size(); i++) {
            char c = tolower(line[i]);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') cnt++;
        }

        cout << cnt << '\n';
    }
}
