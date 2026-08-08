#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> mp;
        for (int x : nums) {
            mp[x]++;
        }

        vector<vector<int>> bucket(1 + nums.size());
        for (auto [num, freq] : mp) {
            bucket[freq].push_back(num);
        }

        vector<int> ans;
        for (int i = bucket.size() - 1; i >= 1; i--) {
            for (int x : bucket[i]) {
                ans.push_back(x);
                if (ans.size() == k) return ans;
            }
        }

        return ans;
    }
};
