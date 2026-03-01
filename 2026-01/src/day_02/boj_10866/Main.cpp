#include <bits/stdc++.h>
using namespace std;

int dq[20000];
int front = 10000;
int back = 10000;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    while (n--) {
        string command;
        cin >> command;

        if (command == "push_front") {
            int x;
            cin >> x;
            dq[--front] = x;
        } else if (command == "push_back") {
            int x;
            cin >> x;
            dq[back++] = x;
        } else if (command == "pop_front") {
            if (front == back) {
                cout << -1 << '\n';
            } else {
                cout << dq[front++] << '\n';
            }
        } else if (command == "pop_back") {
            if (front == back) {
                cout << -1 << '\n';
            } else {
                cout << dq[--back] << '\n';
            }
        } else if (command == "size") {
            cout << back - front << '\n';
        } else if (command == "empty") {
            cout << (front == back) << '\n';
        } else if (command == "front") {
            if (front == back) {
                cout << -1 << '\n';
            } else {
                cout << dq[front] << '\n';
            }
        } else {
            if (front == back) {
                cout << -1 << '\n';
            } else {
                cout << dq[back - 1] << '\n';
            }
        }
    }
}
