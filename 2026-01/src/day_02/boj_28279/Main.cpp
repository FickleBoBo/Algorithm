#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int deque[2000000];
    int front = 1000000;
    int back = 1000000;

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int command;
        cin >> command;

        if (command == 1) {
            int x;
            cin >> x;
            deque[--front] = x;
        } else if (command == 2) {
            int x;
            cin >> x;
            deque[back++] = x;
        } else if (command == 3) {
            if (front == back) {
                cout << -1 << '\n';
            } else {
                cout << deque[front++] << '\n';
            }
        } else if (command == 4) {
            if (front == back) {
                cout << -1 << '\n';
            } else {
                cout << deque[--back] << '\n';
            }
        } else if (command == 5) {
            cout << back - front << '\n';
        } else if (command == 6) {
            if (front == back) {
                cout << 1 << '\n';
            } else {
                cout << 0 << '\n';
            }
        } else if (command == 7) {
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
