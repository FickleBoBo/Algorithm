#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    bool isAnagram(string& s1, string& s2) {
        vector<int> cnt(26);
        for (char c : s1) {
            cnt[c - 'a']++;
        }
        for (char c : s2) {
            cnt[c - 'a']--;
        }

        for (int x : cnt) {
            if (x != 0) return false;
        }

        return true;
    }

    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> ans;

        for (string& str : strs) {
            bool flag = false;

            for (vector<string>& v : ans) {
                if (v[0].size() == str.size() && isAnagram(v[0], str)) {
                    v.push_back(str);
                    flag = true;
                    break;
                }
            }

            if (flag) continue;

            vector<string> v;
            v.push_back(str);
            ans.push_back(v);
        }

        return ans;
    }
};
