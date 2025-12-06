#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    double totalSum = 0;
    double creditSum = 0;
    for (int i = 0; i < 20; i++) {
        string s, grade;
        double credit;
        cin >> s >> credit >> grade;

        if (grade == "P") continue;

        if (grade == "A+") {
            totalSum += credit * 4.5;
        } else if (grade == "A0") {
            totalSum += credit * 4.0;
        } else if (grade == "B+") {
            totalSum += credit * 3.5;
        } else if (grade == "B0") {
            totalSum += credit * 3.0;
        } else if (grade == "C+") {
            totalSum += credit * 2.5;
        } else if (grade == "C0") {
            totalSum += credit * 2.0;
        } else if (grade == "D+") {
            totalSum += credit * 1.5;
        } else if (grade == "D0") {
            totalSum += credit;
        }
        creditSum += credit;
    }

    cout << totalSum / creditSum;
}
