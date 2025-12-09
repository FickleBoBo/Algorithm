#include <bits/stdc++.h>
using namespace std;

int upper_bound_param(const vector<int>& v, int m) {
    int left = 0;
    int right = 1000000001;  // 과자의 길이가 최대 10^9까지라서 right의 상한을 10^9+1로 설정

    while (left < right) {
        int mid = (left + right) / 2;
        if (mid == 0) return 1;  // mid가 0이면 과자를 나누어줄 수 없는 경우로 1 반환

        int cnt = 0;
        for (int n : v) {
            cnt += n / mid;
        }

        if (cnt >= m) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return right;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int m, n;
    cin >> m >> n;

    vector<int> v(n);
    for (auto& num : v) cin >> num;

    cout << upper_bound_param(v, m) - 1;
}
