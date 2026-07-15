#include <cmath>
#include <string>
#include <vector>

using namespace std;

long long solution(int r1, int r2) {
    long long ans = 0;

    for (long long x = 1; x <= r2; x++) {
        long long mx = sqrt((long long)r2 * r2 - x * x);
        long long mn = ceil(sqrt((long long)r1 * r1 - x * x));
        ans += mx - mn + 1;
    }

    return ans * 4;
}
