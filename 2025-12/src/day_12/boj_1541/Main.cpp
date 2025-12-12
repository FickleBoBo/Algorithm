#include <bits/stdc++.h>
using namespace std;

// 숫자와 +로만 이루어진 식의 합 리턴
int sum(const string& s) {
    vector<string> v;
    string cur;
    for (char c : s) {
        if (c == '+') {
            v.push_back(cur);
            cur.clear();
        } else {
            cur += c;
        }
    }
    v.push_back(cur);

    int res = 0;
    for (string x : v) {
        res += stoi(x);
    }

    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    cin >> s;

    vector<string> v;
    string cur;
    for (char c : s) {
        if (c == '-') {
            v.push_back(cur);
            cur.clear();
        } else {
            cur += c;
        }
    }
    v.push_back(cur);

    int ans = sum(v[0]);
    for (int i = 1; i < v.size(); i++) {
        ans -= sum(v[i]);
    }

    cout << ans;
}
