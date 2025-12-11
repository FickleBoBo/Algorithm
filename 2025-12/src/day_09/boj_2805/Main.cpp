#include <bits/stdc++.h>
using namespace std;

int upper_bound_param(const vector<int>& v, int key) {
    int left = 0;
    int right = 1000000001;  // 나무의 길이가 최대 10^9까지라서 right의 상한을 10^9+1로 설정

    while (left < right) {
        int mid = (left + right) / 2;

        long long sum = 0;
        for (int n : v) {
            sum += max(n - mid, 0);
        }

        if (sum >= key) {
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
    for (int& x : v) cin >> x;

    cout << upper_bound_param(v, m) - 1;
}
