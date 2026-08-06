#include <bits/stdc++.h>
using namespace std;

vector<string> solution(vector<string> quiz) {
    vector<string> v(quiz.size());
    for (int i = 0; i < quiz.size(); i++) {
        stringstream ss(quiz[i]);
        int x, y, z;
        char op, eq;
        ss >> x >> op >> y >> eq >> z;

        if (op == '+') {
            v[i] = x + y == z ? "O" : "X";
        } else if (op == '-') {
            v[i] = x - y == z ? "O" : "X";
        }
    }

    return v;
}
