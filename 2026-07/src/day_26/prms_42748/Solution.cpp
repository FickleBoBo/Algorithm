#include <algorithm>
#include <vector>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> ans;

    for (auto& c : commands) {
        int s = c[0] - 1;
        int e = c[1] - 1;
        int k = c[2] - 1;

        vector<int> tmp(array.begin() + s, array.begin() + e + 1);
        sort(tmp.begin(), tmp.end());
        ans.push_back(tmp[k]);
    }

    return ans;
}
