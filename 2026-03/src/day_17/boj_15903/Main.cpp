#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    priority_queue<long long, vector<long long>, greater<>> pq;
    while (n--) {
        long long x;
        cin >> x;
        pq.push(x);
    }

    while (m--) {
        long long x = pq.top();
        pq.pop();

        long long y = pq.top();
        pq.pop();

        pq.push(x + y);
        pq.push(x + y);
    }

    long long sum = 0;
    while (!pq.empty()) {
        sum += pq.top();
        pq.pop();
    }

    cout << sum;
}
