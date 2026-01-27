#include <algorithm>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

int solution(int k, vector<int> tangerine) {
    unordered_map<int, int> mp;
    for (int t : tangerine) {
        mp[t]++;
    }

    vector<int> v;
    for (auto& [key, value] : mp) {
        v.push_back(value);
    }
    sort(v.rbegin(), v.rend());

    int sum = 0;
    int ans = 0;
    for (int x : v) {
        sum += x;
        ans++;

        if (sum >= k) break;
    }

    return ans;
}
