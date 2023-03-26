int subtractProductAndSum(int n){
    int sum=0;
    int prod=1;
    int dig;
    while(n>0)
    {
        dig=n%10;
        sum=sum+dig;
        prod=prod*dig;
        n=n/10;
    }
    
    return prod-sum;
}