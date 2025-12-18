#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    unordered_map<string, int> mp;

    for (string& s : participant) {
        mp[s]++;
    }

    for (string& c : completion) {
        mp[c]--;
    }

    string ans;
    for (auto& [key, value] : mp) {
        if (value == 1) {
            ans = key;
            break;
        }
    }

    return ans;
}
