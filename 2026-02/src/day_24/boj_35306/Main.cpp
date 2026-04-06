#include <bits/stdc++.h>
using namespace std;

const int MAX = 2000;
int arr[MAX][MAX];
bool chk[MAX];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, k;
    cin >> n >> k;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < k; j++) {
            cin >> arr[i][j];
        }
    }

    for (int j = 0; j < k; j++) {
        int mx = 0;
        int cnt = 0;
        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i][j] > mx) {
                mx = arr[i][j];
                cnt = 1;
                idx = i;
            } else if (arr[i][j] == mx) {
                cnt++;
            }
        }

        if (cnt == 1) {
            chk[idx] = true;
        }
    }

    int cnt = 0;
    for (int i = 0; i < n; i++) {
        if (chk[i]) cnt++;
    }

    cout << cnt;
}
