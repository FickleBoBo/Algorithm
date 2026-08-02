#include <algorithm>
#include <string>
#include <vector>

using namespace std;

vector<string> v;
string arr = "AEIOU";
string sel(5, ' ');

void dfs(int idx, int len) {
    if (idx == len) {
        v.push_back(sel.substr(0, len));
        return;
    }

    for (char c : arr) {
        sel[idx] = c;
        dfs(idx + 1, len);
    }
}

int solution(string word) {
    for (int i = 1; i <= 5; i++) {
        dfs(0, i);
    }
    sort(v.begin(), v.end());

    for (int i = 0; i < v.size(); i++) {
        if (v[i] == word) {
            return i + 1;
        }
    }

    return 0;
}
