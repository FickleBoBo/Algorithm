#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int zero = 0;
    int one = 0;

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;

        if (x == 0) {
            zero++;
        } else {
            one++;
        }
    }

    if (zero > one) {
        cout << "Junhee is not cute!";
    } else {
        cout << "Junhee is cute!";
    }
}
