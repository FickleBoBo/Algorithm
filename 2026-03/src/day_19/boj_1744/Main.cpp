#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    priority_queue<int> pq;
    priority_queue<int, vector<int>, greater<>> pq2;

    int n;
    cin >> n;

    while (n--) {
        int x;
        cin >> x;

        if (x > 0) {
            pq.push(x);
        } else {
            pq2.push(x);
        }
    }

    int sum = 0;
    while (pq.size() > 1) {
        int a = pq.top();
        pq.pop();

        int b = pq.top();
        pq.pop();

        sum += max(a * b, a + b);
    }
    if (!pq.empty()) {
        sum += pq.top();
        pq.pop();
    }

    while (pq2.size() > 1) {
        int a = pq2.top();
        pq2.pop();

        int b = pq2.top();
        pq2.pop();

        sum += a * b;
    }
    if (!pq2.empty()) {
        sum += pq2.top();
        pq2.pop();
    }

    cout << sum;
}
