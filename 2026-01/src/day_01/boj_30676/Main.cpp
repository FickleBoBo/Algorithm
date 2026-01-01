#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int x;
    cin >> x;

    if (x >= 620) {
        cout << "Red\n";
    } else if (x >= 590) {
        cout << "Orange\n";
    } else if (x >= 570) {
        cout << "Yellow\n";
    } else if (x >= 495) {
        cout << "Green\n";
    } else if (x >= 450) {
        cout << "Blue\n";
    } else if (x >= 425) {
        cout << "Indigo\n";
    } else {
        cout << "Violet\n";
    }
}
