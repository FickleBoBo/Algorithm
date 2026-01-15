#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    cin.ignore();

    for (int i = 1; i <= n; i++) {
        string line;
        getline(cin, line);
        cout << i << ". " << line << '\n';
    }
}
