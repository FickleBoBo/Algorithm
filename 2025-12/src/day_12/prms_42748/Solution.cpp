#include <algorithm>
#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> ans;

    for (auto& c : commands) {
        int s = c[0];
        int e = c[1];
        int k = c[2];

        vector<int> tmp(array.begin() + s - 1, array.begin() + e);
        sort(tmp.begin(), tmp.end());
        ans.push_back(tmp[k - 1]);
    }

    return ans;
}
