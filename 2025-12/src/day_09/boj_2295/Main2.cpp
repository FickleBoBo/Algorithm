#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (auto& num : v) cin >> num;
    sort(v.begin(), v.end());  // 역순 조회로 d를 발견하면 종료하기 위해 정렬

    // a + b 미리 저장
    unordered_set<int> st;
    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            st.insert(v[i] + v[j]);
        }
    }

    // a + b + c = d -> a + b = d - c
    for (int i = n - 1; i >= 0; i--) {
        for (int j = 0; j < i; j++) {
            if (st.count(v[i] - v[j])) {
                cout << v[i];
                return 0;
            }
        }
    }
}
