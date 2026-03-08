#include <bits/stdc++.h>
using namespace std;

const int MX = 10000;
int st[MX];
int pos = 0;

void push(int x) {
    st[pos++] = x;
}

void pop() {
    pos--;
}

int size() {
    return pos;
}

bool empty() {
    return pos == 0;
}

int top() {
    return st[pos - 1];
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    while (n--) {
        string c;
        cin >> c;

        if (c == "push") {
            int x;
            cin >> x;
            push(x);
        } else if (c == "pop") {
            if (empty()) {
                cout << -1 << '\n';
            } else {
                cout << top() << '\n';
                pop();
            }
        } else if (c == "size") {
            cout << size() << '\n';
        } else if (c == "empty") {
            cout << empty() << '\n';
        } else {
            if (empty()) {
                cout << -1 << '\n';
            } else {
                cout << top() << '\n';
            }
        }
    }
}
