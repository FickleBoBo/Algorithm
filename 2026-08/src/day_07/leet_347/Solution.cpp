#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> mp;
        for (int x : nums) {
            mp[x]++;
        }

        priority_queue<pair<int, int>> pq;
        for (auto& [num, freq] : mp) {
            pq.push({freq, num});
        }

        vector<int> res;
        while (k--) {
            res.push_back(pq.top().second);
            pq.pop();
        }

        return res;
    }
};
