#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

int solution(vector<vector<string>> clothes) {
    unordered_map<string, int> mp;
    for (auto& v : clothes) {
        mp[v[1]]++;
    }

    int ans = 1;
    for (auto& [key, value] : mp) {
        ans *= value + 1;
    }

    return ans - 1;
}
