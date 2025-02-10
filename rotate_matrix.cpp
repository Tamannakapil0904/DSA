#include <iostream>
#include <vector>
using namespace std;

void rotateMatrix(vector<vector<int>>& matrix) {
  int n = matrix.size();

  for(int i = 0; i < n; i++) {
    for(int j = i; j < n; j++) {
      swap(matrix[i][j], matrix[j][i]);
      }
    }

  for(int i = 0; i < n; i++){
    reverse(matrix[i].begin(), matrix[i].end());
    }
  }

void printMatrix(const vector<vector<int>>& matrix) {
  for(const auto& row : matrix) {
    for(int elem : row) {
      cout<<elem<<" ";
      }
    cout<<endl;
    }
  }
int main(){
  vector<vector<int>>matrix = { 
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
    };
  cout<<"Original Matrix: \n";
  printMatrix(matrix);

  rotateMatrix(matrix);

  cout<<"\nRotated Matrix:\n";
  printMatrix(matrix);

  return 0;
}
