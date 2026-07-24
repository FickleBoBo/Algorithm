#include <vector>

using namespace std;

vector<int> solution(vector<int> numbers) {
    for (int& x : numbers) {
        x *= 2;
    }

    return numbers;
}
