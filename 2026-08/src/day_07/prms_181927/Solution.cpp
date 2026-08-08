#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> num_list) {
    int a = num_list[num_list.size() - 2];
    int b = num_list[num_list.size() - 1];

    if (b > a) {
        num_list.push_back(b - a);
    } else {
        num_list.push_back(b * 2);
    }

    return num_list;
}
