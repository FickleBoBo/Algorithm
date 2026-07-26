#include <bits/stdc++.h>
using namespace std;

int cnt[26];

class Solution {
   public:
    bool isAnagram(string s, string t) {
        memset(cnt, 0, sizeof(cnt));

        for (char c : s) cnt[c - 'a']++;
        for (char c : t) cnt[c - 'a']--;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) return false;
        }

        return true;
    }
};
