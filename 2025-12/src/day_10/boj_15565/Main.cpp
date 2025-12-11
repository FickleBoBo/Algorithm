#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    // 라이언 인형의 인덱스를 저장하는 벡터
    vector<int> v;
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;

        if (x == 1) v.push_back(i);
    }

    // 리스트의 크기가 K보다 작으면 라이언 인형이 K개 미만이라 -1을 출력하고 리턴
    if (v.size() < k) {
        cout << -1;
        return 0;
    }

    // 슬라이딩 윈도우 수행
    int mn = INT_MAX;
    for (int i = 0; i <= v.size() - k; i++) {
        mn = min(mn, v[i + k - 1] - v[i] + 1);
    }

    cout << mn;
}
