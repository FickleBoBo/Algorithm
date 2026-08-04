#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> nums) {
    unordered_set<int> st(nums.begin(), nums.end());
    return min(st.size(), nums.size() / 2);
}
