#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int stack[1000000];
    int peek = -1;

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int command;
        cin >> command;

        if (command == 1) {
            int x;
            cin >> x;
            stack[++peek] = x;
        } else if (command == 2) {
            if (peek == -1) {
                cout << -1 << '\n';
            } else {
                cout << stack[peek--] << '\n';
            }
        } else if (command == 3) {
            cout << peek + 1 << '\n';
        } else if (command == 4) {
            if (peek == -1) {
                cout << 1 << '\n';
            } else {
                cout << 0 << '\n';
            }
        } else {
            if (peek == -1) {
                cout << -1 << '\n';
            } else {
                cout << stack[peek] << '\n';
            }
        }
    }
}
