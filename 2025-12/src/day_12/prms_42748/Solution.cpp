#include <algorithm>
#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> ans;

    for (int i = 0; i < commands.size(); i++) {
        int s = commands[i][0];
        int e = commands[i][1];
        int k = commands[i][2];

        vector<int> tmp(array.begin() + s - 1, array.begin() + e);  // 범위 생성자 활용
        sort(tmp.begin(), tmp.end());
        ans.push_back(tmp[k - 1]);
    }

    return ans;
}
