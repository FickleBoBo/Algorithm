#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> array) {
    int mx = -1;
    int idx = -1;

    for (int i = 0; i < array.size(); i++) {
        if (array[i] > mx) {
            mx = array[i];
            idx = i;
        }
    }

    return {mx, idx};
}
