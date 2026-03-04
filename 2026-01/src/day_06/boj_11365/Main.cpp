#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    while (true) {
        string line;
        getline(cin, line);

        if (line == "END") break;

        reverse(line.begin(), line.end());
        cout << line << '\n';
    }
}
