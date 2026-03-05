#include <bits/stdc++.h>
using namespace std;

long long find(int x, int div) {
    long long cnt = 0;

    long long tmp = div;
    while (x >= tmp) {
        cnt += x / tmp;
        tmp *= div;
    }

    return cnt;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    int cnt2 = find(n, 2) - find(m, 2) - find(n - m, 2);
    int cnt5 = find(n, 5) - find(m, 5) - find(n - m, 5);
    cout << min(cnt2, cnt5);
}
