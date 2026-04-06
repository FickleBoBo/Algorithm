#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;

    int n;
    cin >> n;

    while (n--) {
        int sm, sd, em, ed;
        cin >> sm >> sd >> em >> ed;

        if (em < 3 || sm == 12) continue;
        pq.push({sm * 100 + sd, em * 100 + ed});
    }

    priority_queue<int> pq2;
    int last = 301;
    int cnt = 0;
    while (last < 1201) {
        bool flag = true;
        while (!pq.empty() && pq.top().first <= last) {
            pq2.push(pq.top().second);
            pq.pop();
            flag = false;
        }

        if (flag) {
            cout << 0;
            return 0;
        }

        last = pq2.top();
        pq2.pop();

        cnt++;
    }

    cout << cnt;
}
