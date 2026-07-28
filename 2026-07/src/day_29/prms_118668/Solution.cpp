#include <algorithm>
#include <vector>

using namespace std;

const int INF = 1'000'000'000;
int dp[1 + 150 + 1][1 + 150 + 1];

int solution(int alp, int cop, vector<vector<int>> problems) {
    int alp_max = 0;
    int cop_max = 0;
    for (auto& p : problems) {
        alp_max = max(alp_max, p[0]);
        cop_max = max(cop_max, p[1]);
    }
    alp = min(alp, alp_max);
    cop = min(cop, cop_max);

    for (int i = 0; i <= alp_max; i++) {
        for (int j = 0; j <= cop_max; j++) {
            dp[i][j] = INF;
        }
    }
    dp[alp][cop] = 0;

    for (int i = alp; i <= alp_max; i++) {
        for (int j = cop; j <= cop_max; j++) {
            dp[i + 1][j] = min(dp[i + 1][j], dp[i][j] + 1);
            dp[i][j + 1] = min(dp[i][j + 1], dp[i][j] + 1);

            for (auto& p : problems) {
                if (i < p[0] || j < p[1]) continue;

                int ni = min(i + p[2], alp_max);
                int nj = min(j + p[3], cop_max);
                dp[ni][nj] = min(dp[ni][nj], dp[i][j] + p[4]);
            }
        }
    }

    return dp[alp_max][cop_max];
}
