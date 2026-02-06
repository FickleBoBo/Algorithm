#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int deque[20000];
    int front = 10000;
    int back = 10000;

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        string command;
        cin >> command;

        if (command == "push_front") {
            int x;
            cin >> x;
            deque[--front] = x;
        } else if (command == "push_back") {
            int x;
            cin >> x;
            deque[back++] = x;
        } else if (command == "pop_front") {
            if (front == back) {
                cout << -1 << '\n';
            } else {
                cout << deque[front++] << '\n';
            }
        } else if (command == "pop_back") {
            if (front == back) {
                cout << -1 << '\n';
            } else {
                cout << deque[--back] << '\n';
            }
        } else if (command == "size") {
            cout << back - front << '\n';
        } else if (command == "empty") {
            cout << (front == back) << '\n';
        } else if (command == "front") {
            if (front == back) {
                cout << -1 << '\n';
            } else {
                cout << deque[front] << '\n';
            }
        } else {
            if (front == back) {
                cout << -1 << '\n';
            } else {
                cout << deque[back - 1] << '\n';
            }
        }
    }
}
