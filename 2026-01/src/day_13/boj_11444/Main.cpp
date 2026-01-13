#include <bits/stdc++.h>
using namespace std;

using Matrix = vector<vector<long long>>;

constexpr int MOD = 1000000007;

Matrix identity() {
    return {{1, 0}, {0, 1}};
}

Matrix base_matrix() {
    return {{1, 1}, {1, 0}};
}

Matrix multiply(const Matrix& m1, const Matrix& m2) {
    return {{(m1[0][0] * m2[0][0] + m1[0][1] * m2[1][0]) % MOD, (m1[0][0] * m2[0][1] + m1[0][1] * m2[1][1]) % MOD},
            {(m1[1][0] * m2[0][0] + m1[1][1] * m2[1][0]) % MOD, (m1[1][0] * m2[0][1] + m1[1][1] * m2[1][1]) % MOD}};
}

Matrix binpow(Matrix mat, long long n) {
    Matrix res = identity();

    while (n > 0) {
        if (n & 1) res = multiply(res, mat);
        mat = multiply(mat, mat);
        n >>= 1;
    }

    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    long long n;
    cin >> n;

    if (n == 0) {
        cout << 0;
        return 0;
    }

    Matrix res = binpow(base_matrix(), n - 1);
    cout << res[0][0];
}
