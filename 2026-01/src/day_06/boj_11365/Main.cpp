#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    while (true) {
        string line;
        getline(cin, line);

        if (line == "END") break;

        reverse(line.begin(), line.end());
        cout << line << '\n';
    }
}
