package zhy;

class toBinaryString{
	toBinaryString(int N){
	String s="";
	for (int n=N;n>0;n/=2)
		s=(n%2)+s;
	}
}