#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    while (true) {
        string name;
        int age, weight;

        cin >> name >> age >> weight;

        if (name == "#" && age == 0 && weight == 0) break;

        if (age > 17 || weight >= 80) {
            cout << name << " Senior\n";
        } else {
            cout << name << " Junior\n";
        }
    }
}
