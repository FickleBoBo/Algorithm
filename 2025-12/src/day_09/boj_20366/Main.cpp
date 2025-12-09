#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (auto& num : v) cin >> num;
    sort(v.begin(), v.end());

    int diff = INT_MAX;  // 두 눈사람의 키 차이

    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            int l = i + 1;
            int r = j - 1;
            int sum = v[i] + v[j];  // 한 쪽 눈사람의 키

            while (l < r) {
                if (v[l] + v[r] < sum) {
                    diff = min(diff, sum - v[l] - v[r]);
                    l++;
                } else {
                    if (v[l] + v[r] == sum) {
                        cout << 0;
                        return 0;
                    }

                    diff = min(diff, v[l] + v[r] - sum);
                    r--;
                }
            }
        }
    }

    cout << diff;
}
