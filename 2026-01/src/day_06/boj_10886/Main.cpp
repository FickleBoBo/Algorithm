#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    int cnt = 0;

    while (n--) {
        int x;
        cin >> x;

        if (x == 0) {
            cnt++;
        } else {
            cnt--;
        }
    }

    if (cnt > 0) {
        cout << "Junhee is not cute!";
    } else {
        cout << "Junhee is cute!";
    }
}
