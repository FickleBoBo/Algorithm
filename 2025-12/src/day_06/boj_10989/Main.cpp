#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 10000;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    int cntArr[1 + MAX] = {};
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        cntArr[num]++;
    }

    for (int i = 1; i <= MAX; i++) {
        for (int j = 1; j <= cntArr[i]; j++) {
            cout << i << '\n';
        }
    }
}
