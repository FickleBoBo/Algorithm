#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int burger = 2000;
    int beverage = 2000;

    for (int i = 0; i < 3; i++) {
        int x;
        cin >> x;
        burger = min(burger, x);
    }

    for (int i = 0; i < 2; i++) {
        int x;
        cin >> x;
        beverage = min(beverage, x);
    }

    cout << burger + beverage - 50;
}
