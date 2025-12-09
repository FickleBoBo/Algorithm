#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    cin >> s;

    int len = count(s.begin(), s.end(), 'a');          // 윈도우 크기
    int cnt = count(s.begin(), s.begin() + len, 'a');  // 초기 윈도우 내 a의 개수

    int mx = cnt;  // 윈도우 내 a의 개수가 가장 많은 경우
    for (int i = 0; i < s.size(); i++) {
        if (s[i] == 'a') cnt--;
        if (s[(i + len) % s.size()] == 'a') cnt++;

        mx = max(mx, cnt);
    }

    // 윈도우 내 a의 개수가 가장 많을 때 윈도우 내 b와 윈도우 밖 a를 교환하면 a로 연속되게 교환 가능
    cout << len - mx;
}
