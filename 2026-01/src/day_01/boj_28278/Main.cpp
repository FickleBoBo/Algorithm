#include <bits/stdc++.h>
using namespace std;

int st[1000000];
int top = -1;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    while (n--) {
        int command;
        cin >> command;

        if (command == 1) {
            int x;
            cin >> x;
            st[++top] = x;
        } else if (command == 2) {
            if (top == -1) {
                cout << -1 << '\n';
            } else {
                cout << st[top--] << '\n';
            }
        } else if (command == 3) {
            cout << top + 1 << '\n';
        } else if (command == 4) {
            cout << (top == -1) << '\n';
        } else {
            if (top == -1) {
                cout << -1 << '\n';
            } else {
                cout << st[top] << '\n';
            }
        }
    }
}
