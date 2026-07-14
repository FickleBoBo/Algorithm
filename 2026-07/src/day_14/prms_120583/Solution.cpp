#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int solution(vector<int> array, int n) {
    return count(array.begin(), array.end(), n);
}
