#include <bits/stdc++.h>
using namespace std;

int upper_bound_param(const vector<int>& v, int key) {
    int left = 1;
    int right = 1000000001;  // 과자의 길이가 최대 10^9까지라서 right의 상한을 10^9+1로 설정

    while (left < right) {
        int mid = (left + right) / 2;

        int cnt = 0;
        for (int n : v) {
            cnt += n / mid;
        }

        if (cnt >= key) {
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
    for (int& x : v) cin >> x;

    cout << upper_bound_param(v, m) - 1;
}
