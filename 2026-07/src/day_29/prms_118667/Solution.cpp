#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> queue1, vector<int> queue2) {
    queue<int> q1;
    queue<int> q2;

    long long sum1 = 0;
    long long sum2 = 0;

    for (int x : queue1) {
        q1.push(x);
        sum1 += x;
    }
    for (int x : queue2) {
        q2.push(x);
        sum2 += x;
    }

    int cnt = 0;
    int mx = 2 * (q1.size() + q2.size());
    while (cnt <= mx) {
        if (sum1 > sum2) {
            sum2 += q1.front();
            sum1 -= q1.front();
            q2.push(q1.front());
            q1.pop();
            cnt++;
        } else if (sum1 < sum2) {
            sum1 += q2.front();
            sum2 -= q2.front();
            q1.push(q2.front());
            q2.pop();
            cnt++;
        } else {
            return cnt;
        }
    }

    return -1;
}
