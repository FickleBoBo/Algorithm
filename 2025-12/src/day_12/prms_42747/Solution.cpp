#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int solution(vector<int> citations) {
    sort(citations.begin(), citations.end());

    int mx = 0;
    for (int i = 0; i < citations.size(); i++) {
        mx = max(mx, min(citations[i], (int)citations.size() - i));
    }

    return mx;
}
