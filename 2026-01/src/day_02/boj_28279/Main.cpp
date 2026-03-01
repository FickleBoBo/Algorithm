#include <bits/stdc++.h>
using namespace std;

int dq[2000000];
int front = 1000000;
int back = 1000000;

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
            dq[--front] = x;
        } else if (command == 2) {
            int x;
            cin >> x;
            dq[back++] = x;
        } else if (command == 3) {
            if (front == back) {
                cout << -1 << '\n';
            } else {
                cout << dq[front++] << '\n';
            }
        } else if (command == 4) {
            if (front == back) {
                cout << -1 << '\n';
            } else {
                cout << dq[--back] << '\n';
            }
        } else if (command == 5) {
            cout << back - front << '\n';
        } else if (command == 6) {
            cout << (front == back) << '\n';
        } else if (command == 7) {
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
