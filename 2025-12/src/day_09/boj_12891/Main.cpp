#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int slen, plen;
    string s;
    cin >> slen >> plen >> s;

    vector<int> cnt(4);
    for (int& x : cnt) cin >> x;

    // 알파벳과 인덱스 매핑
    int mp[128];
    mp['A'] = 0;
    mp['C'] = 1;
    mp['G'] = 2;
    mp['T'] = 3;

    // 만들 수 있는 비밀번호의 종류의 수
    int result = 0;

    // 초기 윈도우에 대해 카운팅 배열 갱신
    for (int i = 0; i < plen; i++) {
        cnt[mp[s[i]]]--;
    }

    // 초기 윈도우로 만들 수 있는 비밀번호면 카운팅
    if (*max_element(cnt.begin(), cnt.end()) <= 0) {
        result++;
    }

    for (int i = 0; i < slen - plen; i++) {
        // 윈도우 이동
        cnt[mp[s[i]]]++;
        cnt[mp[s[i + plen]]]--;

        // 이동 후 만들 수 있는 비밀번호면 카운팅
        if (*max_element(cnt.begin(), cnt.end()) <= 0) {
            result++;
        }
    }

    cout << result;
}
