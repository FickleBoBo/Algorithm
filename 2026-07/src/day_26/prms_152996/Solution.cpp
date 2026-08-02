#include <unordered_map>
#include <vector>

using namespace std;

long long solution(vector<int> weights) {
    unordered_map<int, long long> mp;
    for (int w : weights) mp[w]++;

    long long ans = 0;
    for (auto [k, v] : mp) {
        ans += v * (v - 1) / 2;  // 같은 거리에 위치하는 경우

        auto it = mp.find(k * 2);
        if (it != mp.end()) ans += v * it->second;  // 4m, 2m에 위치하는 경우

        if (k % 2 == 0) {
            it = mp.find(k * 3 / 2);
            if (it != mp.end()) ans += v * it->second;  // 3m, 2m에 위치하는 경우
        }

        if (k % 3 == 0) {
            it = mp.find(k * 4 / 3);
            if (it != mp.end()) ans += v * it->second;  // 4m, 3m에 위치하는 경우
        }
    }

    return ans;
}
