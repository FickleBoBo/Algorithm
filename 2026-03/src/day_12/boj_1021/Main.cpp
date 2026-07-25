#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    deque<int> dq(n);
    iota(dq.begin(), dq.end(), 1);

    int cnt = 0;
    while (m--) {
        int x;
        cin >> x;

        int pos = find(dq.begin(), dq.end(), x) - dq.begin();

        if (pos <= n / 2) {
            cnt += pos;
            for (int i = 0; i < pos; i++) {
                dq.push_back(dq.front());
                dq.pop_front();
            }
            dq.pop_front();
        } else {
            cnt += n - pos;
            for (int i = 0; i < n - pos; i++) {
                dq.push_front(dq.back());
                dq.pop_back();
            }
            dq.pop_front();
        }
        n--;
    }

    cout << cnt;
}
