#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int wlen, slen;  // 단어 W의 길이, 문자열 S의 길이
    string w, s;
    cin >> wlen >> slen >> w >> s;

    vector<int> cnt_w(58);  // 단어 W에 등장한 알파벳을 세는 카운팅 배열
    for (char c : w) {
        cnt_w[c - 'A']++;
    }

    vector<int> cnt_s(58);  // 단어 S의 윈도우 내에 등장한 알파벳을 세는 카운팅 배열
    for (int i = 0; i < wlen; i++) {
        cnt_s[s[i] - 'A']++;
    }

    int cnt = 0;

    // 초기 윈도우에서 W를 만족하면 카운팅
    if (equal(cnt_w.begin(), cnt_w.end(), cnt_s.begin())) {
        cnt++;
    }

    // 윈도우를 이동하며 W를 만족하면 카운팅
    for (int i = 0; i < slen - wlen; i++) {
        cnt_s[s[i] - 'A']--;
        cnt_s[s[i + wlen] - 'A']++;

        if (equal(cnt_w.begin(), cnt_w.end(), cnt_s.begin())) {
            cnt++;
        }
    }

    cout << cnt;
}
