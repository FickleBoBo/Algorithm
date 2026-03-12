#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int nimsum = 0;

    int n;
    cin >> n;

    while (n--) {
        int x;
        cin >> x;
        nimsum ^= x - 2;
    }

    string s;
    cin >> s;
    bool is_white_king_name = s == "Whiteking";

    if (nimsum) {
        if (is_white_king_name) {
            cout << "Whiteking";
        } else {
            cout << "Blackking";
        }
    } else {
        if (is_white_king_name) {
            cout << "Blackking";
        } else {
            cout << "Whiteking";
        }
    }
}
