#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    unordered_set<int> st;

    int n;
    cin >> n;

    while (n--) {
        int x;
        cin >> x;
        st.insert(x);
    }

    int m;
    cin >> m;

    while (m--) {
        int x;
        cin >> x;
        cout << st.count(x) << '\n';
    }
}
