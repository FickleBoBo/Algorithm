#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> mp;

bool simul(long long hMax, long long hAtk) {
    long long hCur = hMax;

    for (auto row : mp) {
        int t = row[0];
        int a = row[1];
        int h = row[2];

        if (t == 1) {
            long long heroAtkCnt = (h + hAtk - 1) / hAtk;
            long long monsAtkCnt = (hCur + a - 1) / a;

            if (heroAtkCnt <= monsAtkCnt) {
                hCur -= a * (heroAtkCnt - 1);
            } else {
                return false;
            }
        } else {
            hAtk += a;
            hCur = min(hCur + h, hMax);
        }
    }

    return true;
}

long long lower_bound_param(int hAtk) {
    long long left = 1;
    long long right = LLONG_MAX - 1;

    while (left < right) {
        long long mid = left + (right - left) / 2;

        bool res = simul(mid, hAtk);
        if (!res) {
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

    int n, hAtk;
    cin >> n >> hAtk;

    mp.assign(n, vector<int>(3));
    for (auto& row : mp) cin >> row[0] >> row[1] >> row[2];

    cout << lower_bound_param(hAtk);
}
