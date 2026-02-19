#include <bits/stdc++.h>
using namespace std;

bool dp[80][80][80][80];

struct Node {
    int a, b, c, d;
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    int sum = 0;
    for (int x : v) sum += x;

    int half = sum / 2;  // 전체 막대 길이의 절반
    dp[0][0][0][0] = true;

    for (int x : v) {
        vector<Node> tmp;

        // b, d는 항상 a, c보다 길게 저장하여 탐색 범위 축소
        for (int a = 0; a < half; a++) {
            for (int b = a; b < half; b++) {
                for (int c = 0; c < half; c++) {
                    for (int d = c; d < half; d++) {
                        if (!dp[a][b][c][d]) continue;  // 현재 불가능한 케이스면 넘김

                        // a에 막대를 붙이려고 할 경우 a + n이 b보다 작으면 붙이고 크면 붙이되 순서를 뒤바꿔서 항상 b가
                        // 더 크게 저장
                        if (max(a + x, b) < half) tmp.push_back({min(a + x, b), max(a + x, b), c, d});

                        // b에 막대를 붙이려고 할 경우 half 보다 작으면서 인접한 변과의 합도 half 이하여야 함
                        if (b + x < half && b + x + d <= half) tmp.push_back({a, b + x, c, d});

                        // c에 막대를 붙이려고 할 경우 c + n이 d보다 작으면 붙이고 크면 붙이되 순서를 뒤바꿔서 항상 d가
                        // 더 크게 저장
                        if (max(c + x, d) < half) tmp.push_back({a, b, min(c + x, d), max(c + x, d)});

                        // d에 막대를 붙이려고 할 경우 half 보다 작으면서 인접한 변과의 합도 half 이하여야 함
                        if (d + x < half && d + x + b <= half) tmp.push_back({a, b, c, d + x});
                    }
                }
            }
        }

        // 가능한 후보들로 dp 갱신
        for (auto [a, b, c, d] : tmp) {
            dp[a][b][c][d] = true;
        }
    }

    int mx = -1;
    for (int h = 1; h < half; h++) {
        for (int w = 1; w < half; w++) {
            if (dp[h][h][w][w]) {
                mx = max(mx, h * w);
            }
        }
    }

    cout << mx;
}
