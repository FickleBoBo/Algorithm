#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int a, p;
    cin >> a >> p;

    unordered_map<int, int> mp;
    int idx = 1;
    int cur = a;

    while (true) {
        mp[cur] = idx;

        int next = 0;
        while (cur > 0) {
            int r = cur % 10;
            int tmp = 1;
            for (int i = 0; i < p; i++) {
                tmp *= r;
            }

            next += tmp;
            cur /= 10;
        }

        auto it = mp.find(next);
        if (it != mp.end()) {
            cout << it->second - 1;
            return 0;
        }

        idx++;
        cur = next;
    }
}
