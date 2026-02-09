#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    unordered_set<int> st;
    for (int i = 0; i < 10; i++) {
        int x;
        cin >> x;
        st.insert(x % 42);
    }

    cout << st.size();
}
