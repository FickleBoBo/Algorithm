#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int solution(vector<int> citations) {
    sort(citations.begin(), citations.end());

    for (int i = citations.back(); i >= 0; i--) {
        int cnt = citations.end() - lower_bound(citations.begin(), citations.end(), i);
        if (cnt >= i) return i;
    }

    return -1;
}
