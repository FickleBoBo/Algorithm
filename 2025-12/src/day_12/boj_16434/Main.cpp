#include <bits/stdc++.h>
using namespace std;

int n;
int arr[123456][3];

bool simul(long long hMax, long long hAtk) {
    long long hCur = hMax;

    for (int i = 0; i < n; i++) {
        int t = arr[i][0];
        int a = arr[i][1];
        int h = arr[i][2];

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
    ios::sync_with_stdio(0);
    cin.tie(0);

    int hAtk;
    cin >> n >> hAtk;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 3; j++) {
            cin >> arr[i][j];
        }
    }

    cout << lower_bound_param(hAtk);
}
