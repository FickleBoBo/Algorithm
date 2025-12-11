#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;

    vector<int> v1(n);
    for (int& x : v1) cin >> x;

    // 연속한 네 마리 소들의 품질 점수의 곱 벡터
    vector<int> v2(n);
    v2[0] = v1[0] * v1[1] * v1[2] * v1[3];
    for (int i = 1; i < n; i++) {
        v2[i] = v2[i - 1] * v1[(i + 3) % n] / v1[i - 1];
    }

    int sum = 0;
    for (int x : v2) {
        sum += x;
    }

    for (int i = 0; i < q; i++) {
        int x;
        cin >> x;

        int idx1 = (x - 4 + n) % n;
        int idx2 = (x - 3 + n) % n;
        int idx3 = (x - 2 + n) % n;
        int idx4 = x - 1;

        v2[idx1] *= -1;
        v2[idx2] *= -1;
        v2[idx3] *= -1;
        v2[idx4] *= -1;

        sum += 2 * v2[idx1];
        sum += 2 * v2[idx2];
        sum += 2 * v2[idx3];
        sum += 2 * v2[idx4];

        cout << sum << '\n';
    }
}
