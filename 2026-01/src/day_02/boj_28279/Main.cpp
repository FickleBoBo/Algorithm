#include <bits/stdc++.h>
using namespace std;

const int MX = 2000000;
int dq[MX];
int s = MX / 2, e = MX / 2;

void push_front(int x) {
    dq[--s] = x;
}

void push_back(int x) {
    dq[e++] = x;
}

void pop_front() {
    s++;
}

void pop_back() {
    e--;
}

int size() {
    return e - s;
}

bool empty() {
    return s == e;
}

int front() {
    return dq[s];
}

int back() {
    return dq[e - 1];
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    while (n--) {
        int c;
        cin >> c;

        if (c == 1) {
            int x;
            cin >> x;
            push_front(x);
        } else if (c == 2) {
            int x;
            cin >> x;
            push_back(x);
        } else if (c == 3) {
            if (empty()) {
                cout << -1 << '\n';
            } else {
                cout << front() << '\n';
                pop_front();
            }
        } else if (c == 4) {
            if (empty()) {
                cout << -1 << '\n';
            } else {
                cout << back() << '\n';
                pop_back();
            }
        } else if (c == 5) {
            cout << size() << '\n';
        } else if (c == 6) {
            cout << empty() << '\n';
        } else if (c == 7) {
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
