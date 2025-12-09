#include <bits/stdc++.h>
using namespace std;

int upper_bound_param(const vector<int>& v, int m) {
    int left = 0;
    int right = 1000000001;  // 나무의 길이가 최대 10^9까지라서 right의 상한을 10^9+1로 설정

    while (left < right) {
        int mid = (left + right) / 2;

        long long sum = 0;
        for (int n : v) {
            sum += max(n - mid, 0);
        }

        if (sum >= m) {
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

    int n, m;
    cin >> n >> m;

    vector<int> v(n);
    for (auto& num : v) cin >> num;

    cout << upper_bound_param(v, m) - 1;
}
