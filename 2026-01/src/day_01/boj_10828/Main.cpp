#include <bits/stdc++.h>
using namespace std;

int st[10000];
int top = -1;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    while (n--) {
        string command;
        cin >> command;

        if (command == "push") {
            int x;
            cin >> x;
            st[++top] = x;
        } else if (command == "pop") {
            if (top == -1) {
                cout << -1 << '\n';
            } else {
                cout << st[top--] << '\n';
            }
        } else if (command == "size") {
            cout << top + 1 << '\n';
        } else if (command == "empty") {
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
