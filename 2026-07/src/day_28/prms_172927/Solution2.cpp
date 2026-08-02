#include <algorithm>
#include <string>
#include <tuple>
#include <vector>

using namespace std;

int solution(vector<int> picks, vector<string> minerals) {
    int pickCnt = picks[0] + picks[1] + picks[2];
    vector<tuple<int, int, int>> v(pickCnt);

    for (int i = 0; i < min((int)minerals.size(), pickCnt * 5); i++) {
        string mineral = minerals[i];
        auto& [di, ir, st] = v[i / 5];

        if (mineral == "diamond") {
            di++;
        } else if (mineral == "iron") {
            ir++;
        } else {
            st++;
        }
    }

    sort(v.rbegin(), v.rend());

    int ans = 0;
    for (auto [di, ir, st] : v) {
        if (picks[0] > 0) {
            ans += di + ir + st;
            picks[0]--;
        } else if (picks[1] > 0) {
            ans += di * 5 + ir + st;
            picks[1]--;
        } else if (picks[2] > 0) {
            ans += di * 25 + ir * 5 + st;
            picks[2]--;
        } else {
            break;
        }
    }

    return ans;
}
