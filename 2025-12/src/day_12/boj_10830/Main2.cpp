#include <bits/stdc++.h>
using namespace std;

constexpr int MOD = 1000;

using Matrix = vector<vector<int>>;

Matrix identity(int len) {
    Matrix id(len, vector<int>(len));
    for (int i = 0; i < len; i++) {
        id[i][i] = 1;
    }
    return id;
}

Matrix multiply(const Matrix& a, const Matrix& b) {
    int len = a.size();
    Matrix res(len, vector<int>(len));

    for (int i = 0; i < len; i++) {
        for (int j = 0; j < len; j++) {
            for (int k = 0; k < len; k++) {
                res[i][j] += a[i][k] * b[k][j];
            }
            res[i][j] %= MOD;
        }
    }

    return res;
}

Matrix binpow(Matrix mat, long long n) {
    if (n == 0) return identity(mat.size());

    Matrix half = binpow(mat, n / 2);
    if (n % 2) {
        return multiply(multiply(half, half), mat);
    } else {
        return multiply(half, half);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    long long b;
    cin >> n >> b;

    Matrix mat(n, vector<int>(n));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int x;
            cin >> x;

            mat[i][j] = x;
        }
    }

    Matrix res = binpow(mat, b);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cout << res[i][j] << ' ';
        }
        cout << '\n';
    }
}
