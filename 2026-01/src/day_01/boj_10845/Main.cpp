#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int queue[10000];
    int front = 0;
    int rear = 0;

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        string command;
        cin >> command;

        if (command == "push") {
            int x;
            cin >> x;
            queue[rear++] = x;
        } else if (command == "pop") {
            if (front == rear) {
                cout << -1 << '\n';
            } else {
                cout << queue[front++] << '\n';
            }
        } else if (command == "size") {
            cout << rear - front << '\n';
        } else if (command == "empty") {
            cout << (front == rear) << '\n';
        } else if (command == "front") {
            if (front == rear) {
                cout << -1 << '\n';
            } else {
                cout << queue[front] << '\n';
            }
        } else {
            if (front == rear) {
                cout << -1 << '\n';
            } else {
                cout << queue[rear - 1] << '\n';
            }
        }
    }
}
