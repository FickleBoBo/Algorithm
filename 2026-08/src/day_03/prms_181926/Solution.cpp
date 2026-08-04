#include <bits/stdc++.h>
using namespace std;

int solution(int n, string control) {
    for (char c : control) {
        if (c == 'w') {
            n += 1;
        } else if (c == 's') {
            n -= 1;
        } else if (c == 'd') {
            n += 10;
        } else {
            n -= 10;
        }
    }

    return n;
}
