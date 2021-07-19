package test;

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int i=0;
        while(i<nums.length){
            if(nums[i]==1){
                int temp=i+1;
                int count=0;
                while(temp<nums.length){
                    if(nums[temp]==0){
                        count++;
                        temp++;
                    }
                }
                if(count>=k || temp==nums.length){
                    i=temp;
                }
                else{
                    return false;
                }
            }else{
                i++;
            }
        }
        return true;
    }
}

