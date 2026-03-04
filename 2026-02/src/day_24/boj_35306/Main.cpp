#include <bits/stdc++.h>
using namespace std;

int arr[2000][2000];
bool check[2000];

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

    for (int i = 0; i < k; i++) {
        int mx = 0;
        int cnt = 0;
        int idx = 0;

        for (int j = 0; j < n; j++) {
            if (arr[j][i] > mx) {
                mx = arr[j][i];
                cnt = 1;
                idx = j;
            } else if (arr[j][i] == mx) {
                cnt++;
            }
        }

        if (cnt == 1) {
            check[idx] = true;
        }
    }

    int cnt = 0;
    for (int i = 0; i < n; i++) {
        if (check[i]) cnt++;
    }

    cout << cnt;
}
