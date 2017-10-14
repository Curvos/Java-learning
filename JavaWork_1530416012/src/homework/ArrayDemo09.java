

//第1次作业
package homework;

public class ArrayDemo09 {

	public static void main(String[] args) {
		int score[][]={{67,61},{78,89,86},{99,100,98,66,95}};
		for( int i=0;i<score.length;i++){
			for(int j=-0;j<score[i].length;j++){
				System.out.print(score[i][j]+"\t");
			}
			System.out.println("");
		}

	}

}
