#include <bits/stdc++.h>
using namespace std;

const int MX = 10000;
int q[MX];
int s = 0, e = 0;

void push(int x) {
    q[e++] = x;
}

void pop() {
    s++;
}

int size() {
    return e - s;
}

bool empty() {
    return s == e;
}

int front() {
    return q[s];
}

int back() {
    return q[e - 1];
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
                cout << front() << '\n';
                pop();
            }
        } else if (c == "size") {
            cout << size() << '\n';
        } else if (c == "empty") {
            cout << empty() << '\n';
        } else if (c == "front") {
            if (empty()) {
                cout << -1 << '\n';
            } else {
                cout << front() << '\n';
            }
        } else {
            if (empty()) {
                cout << -1 << '\n';
            } else {
                cout << back() << '\n';
            }
        }
    }
}
