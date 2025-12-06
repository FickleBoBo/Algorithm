#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    unordered_set<int> st;
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;

        st.insert(num);
    }

    int m;
    cin >> m;

    for (int i = 0; i < m; i++) {
        int num;
        cin >> num;

        if (st.find(num) != st.end()) {
            cout << "1 ";
        } else {
            cout << "0 ";
        }
    }
}
