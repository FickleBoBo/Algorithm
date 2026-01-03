#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    stack<int> st;
    int idx = 0;
    bool flag = true;

    for (int need = 1; need <= n; need++) {
        if (!st.empty() && st.top() == need) {
            st.pop();
        } else {
            while (idx < n && v[idx] != need) {
                st.push(v[idx++]);
            }

            if (idx == n) {
                flag = false;
                break;
            }
            idx++;
        }
    }

    if (flag) {
        cout << "Nice";
    } else {
        cout << "Sad";
    }
}
