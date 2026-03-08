#include <bits/stdc++.h>
using namespace std;

int arr[1000000];
int res[1000000];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) cin >> arr[i];

    stack<int> st;
    for (int i = n - 1; i >= 0; i--) {
        int x = arr[i];

        while (!st.empty() && st.top() <= x) {
            st.pop();
        }

        res[i] = st.empty() ? -1 : st.top();
        st.push(x);
    }

    for (int i = 0; i < n; i++) {
        cout << res[i] << ' ';
    }
}
