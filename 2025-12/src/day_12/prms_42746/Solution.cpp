#include <algorithm>
#include <string>
#include <vector>

using namespace std;

string solution(vector<int> numbers) {
    vector<string> v;
    for (int n : numbers) v.push_back(to_string(n));
    sort(v.begin(), v.end(), [](const string& a, const string& b) {
        return b + a < a + b;
    });

    string ans;
    for (string& s : v) {
        ans += s;
    }

    if (ans[0] == '0') {
        return "0";
    } else {
        return ans;
    }
}
