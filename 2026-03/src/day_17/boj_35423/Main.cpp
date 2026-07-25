#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;
    cin >> s;

    int cnts = 0;
    int cntl = 0;

    for (char c : s) {
        if (c == 'S')
            cnts++;
        else if (c == 'L')
            cntl++;
    }

    while (cnts--) {
        cout << "SciCom";
    }

    while (cntl--) {
        cout << "Love";
    }
}
