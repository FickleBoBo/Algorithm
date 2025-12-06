#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 10000000;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> cntArr(MAX + 1 + MAX);
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;

        cntArr[num + MAX]++;
    }

    int m;
    cin >> m;

    for (int i = 0; i < m; i++) {
        int num;
        cin >> num;
        cout << cntArr[num + MAX] << ' ';
    }
}
