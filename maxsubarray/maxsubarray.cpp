#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int maxsubarray(vector<int> A){
    vector<int> S(A.size(), 0);
    S[0] = A[0];
    
    for (int i = 1; i < A.size(); i++){
        S[i] = max(A[i] + S[i-1], A[i]); 
    }

    return *(max_element(S.begin(), S.end()));
}

int main(int argc, char * argv[]){
    vector<int> A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    cout << "Maximum subarray sum: " << maxsubarray(A) << endl;
}





