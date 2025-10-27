
//problem link ->  https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/
class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        int n = bank.size();
        vector<int> v;
        for(int i=0;i<n;i++){
            int count =0;
            int s=bank[i].length();
            for(int j=0;j<s;j++){
                if(bank[i][j]=='1'){
                    count++;
                }
            }
            v.push_back(count);
        }
        int sum=0;
        for(int i=0,j=0;j<n && i<n;)
        {
            if(i>=j){
              j++;
            }
            else if(v[i]==0){
                i++;
            }
            else if(v[j]==0){
                j++;
            }
            else{
                sum = sum+(v[i]*v[j]);
                i=j;
                j++;
            }
        }
        return sum;
    }
};
