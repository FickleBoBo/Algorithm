#include <algorithm>
#include <climits>
#include <string>
#include <tuple>
#include <vector>

using namespace std;

int ans = INT_MAX;

static void dfs(int idx, int maxLen, int sum, vector<int>& picks, vector<tuple<int, int, int>>& v) {
    if (idx == maxLen || idx == v.size()) {
        ans = min(ans, sum);
        return;
    }

    auto [di, ir, st] = v[idx];
    if (picks[0] > 0) {
        picks[0]--;
        dfs(idx + 1, maxLen, sum + di, picks, v);
        picks[0]++;
    }

    if (picks[1] > 0) {
        picks[1]--;
        dfs(idx + 1, maxLen, sum + ir, picks, v);
        picks[1]++;
    }

    if (picks[2] > 0) {
        picks[2]--;
        dfs(idx + 1, maxLen, sum + st, picks, v);
        picks[2]++;
    }
}

int solution(vector<int> picks, vector<string> minerals) {
    vector<tuple<int, int, int>> v((minerals.size() + 4) / 5);

    for (int i = 0; i < minerals.size(); i++) {
        string mineral = minerals[i];
        auto& [di, ir, st] = v[i / 5];

        if (mineral == "diamond") {
            di += 1;
            ir += 5;
            st += 25;
        } else if (mineral == "iron") {
            di += 1;
            ir += 1;
            st += 5;
        } else {
            di += 1;
            ir += 1;
            st += 1;
        }
    }

    dfs(0, picks[0] + picks[1] + picks[2], 0, picks, v);

    return ans;
}
