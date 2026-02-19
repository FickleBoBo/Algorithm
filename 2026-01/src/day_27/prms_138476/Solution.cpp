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

    vector<int> a;
    for (auto [k, v] : mp) {
        a.push_back(v);
    }
    sort(a.rbegin(), a.rend());

    int sum = 0;
    int ans = 0;
    for (int x : a) {
        sum += x;
        ans++;

        if (sum >= k) break;
    }

    return ans;
}
