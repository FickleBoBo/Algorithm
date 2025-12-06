#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    while (true) {
        int n;
        cin >> n;

        if (n == -1) break;

        vector<int> v;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                v.push_back(i);
                sum += i;
            }
        }

        if (sum == n) {
            cout << n << " = ";
            for (int i = 0; i < v.size(); i++) {
                cout << v[i];
                if (i != v.size() - 1) cout << " + ";
            }
            cout << '\n';
        } else {
            cout << n << " is NOT perfect.\n";
        }
    }
}
