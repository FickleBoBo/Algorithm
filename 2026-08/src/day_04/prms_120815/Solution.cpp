#include <bits/stdc++.h>
using namespace std;

int solution(int n) {
    int cnt = 1;
    while (true) {
        if (6 * cnt % n == 0) return cnt;
        cnt++;
    }
}
