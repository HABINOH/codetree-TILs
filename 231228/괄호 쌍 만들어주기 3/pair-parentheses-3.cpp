#include <iostream>
#include <string>

using namespace std;

int main() {
    string s;   cin >> s;

    int result=0;

    for(int i=0;i<s.length()-1;i++){
        if(s[i] == '('){
            for(int j=i+1; j<s.length(); j++){
                if(s[j] == ')'){result++;}
            }
        }
    }
    cout << result;

    return 0;
}