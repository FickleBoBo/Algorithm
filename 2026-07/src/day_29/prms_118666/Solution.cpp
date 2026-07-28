#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

string solution(vector<string> survey, vector<int> choices) {
    unordered_map<char, int> mp;

    for (int i = 0; i < survey.size(); i++) {
        char t1 = survey[i].front();
        char t2 = survey[i].back();
        int c = choices[i];

        if (c == 1) {
            mp[t1] += 3;
        } else if (c == 2) {
            mp[t1] += 2;
        } else if (c == 3) {
            mp[t1] += 1;
        } else if (c == 5) {
            mp[t2] += 1;
        } else if (c == 6) {
            mp[t2] += 2;
        } else if (c == 7) {
            mp[t2] += 3;
        }
    }

    string ans = "";
    if (mp['R'] >= mp['T']) {
        ans += "R";
    } else {
        ans += "T";
    }

    if (mp['C'] >= mp['F']) {
        ans += "C";
    } else {
        ans += "F";
    }

    if (mp['J'] >= mp['M']) {
        ans += "J";
    } else {
        ans += "M";
    }

    if (mp['A'] >= mp['N']) {
        ans += "A";
    } else {
        ans += "N";
    }

    return ans;
}
