#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int stack[10000];
    int top = -1;

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        string command;
        cin >> command;

        if (command == "push") {
            int x;
            cin >> x;
            stack[++top] = x;
        } else if (command == "pop") {
            if (top == -1) {
                cout << -1 << '\n';
            } else {
                cout << stack[top--] << '\n';
            }
        } else if (command == "size") {
            cout << top + 1 << '\n';
        } else if (command == "empty") {
            if (top == -1) {
                cout << 1 << '\n';
            } else {
                cout << 0 << '\n';
            }
        } else {
            if (top == -1) {
                cout << -1 << '\n';
            } else {
                cout << stack[top] << '\n';
            }
        }
    }
}
