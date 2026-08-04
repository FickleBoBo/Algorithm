#include <bits/stdc++.h>
using namespace std;

vector<int> solution(int numer1, int denom1, int numer2, int denom2) {
    int g = gcd(numer1 * denom2 + numer2 * denom1, denom1 * denom2);
    return {(numer1 * denom2 + numer2 * denom1) / g, (denom1 * denom2) / g};
}
