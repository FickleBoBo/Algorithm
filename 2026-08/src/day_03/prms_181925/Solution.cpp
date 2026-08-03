#include <string>
#include <vector>

using namespace std;

string solution(vector<int> numLog) {
    string ans;
    for (int i = 1; i < numLog.size(); i++) {
        if (numLog[i] == numLog[i - 1] + 1) {
            ans += "w";
        } else if (numLog[i] == numLog[i - 1] - 1) {
            ans += "s";
        } else if (numLog[i] == numLog[i - 1] + 10) {
            ans += "d";
        } else {
            ans += "a";
        }
    }

    return ans;
}
