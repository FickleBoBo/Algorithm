#include <bits/stdc++.h>
using namespace std;

int q[10000];
int front = 0;
int rear = 0;

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
            q[rear++] = x;
        } else if (command == "pop") {
            if (front == rear) {
                cout << -1 << '\n';
            } else {
                cout << q[front++] << '\n';
            }
        } else if (command == "size") {
            cout << rear - front << '\n';
        } else if (command == "empty") {
            cout << (front == rear) << '\n';
        } else if (command == "front") {
            if (front == rear) {
                cout << -1 << '\n';
            } else {
                cout << q[front] << '\n';
            }
        } else {
            if (front == rear) {
                cout << -1 << '\n';
            } else {
                cout << q[rear - 1] << '\n';
            }
        }
    }
}
