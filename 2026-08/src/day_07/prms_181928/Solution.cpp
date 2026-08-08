#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> num_list) {
    string odd = "";
    string even = "";

    for (int x : num_list) {
        if (x % 2) {
            odd += to_string(x);
        } else {
            even += to_string(x);
        }
    }

    return stoi(odd) + stoi(even);
}
