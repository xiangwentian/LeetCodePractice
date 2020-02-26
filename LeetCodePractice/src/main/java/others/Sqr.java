package others;

import java.text.DecimalFormat;

/**
 * @author liuzhuang 求算术平方根
 * https://www.cnblogs.com/hezhiyao/p/7544593.html
 */
public class Sqr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scanner scan = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.000000");
		// int sc = scan.nextInt();
		int sc = 16;
		System.out.println(df.format(SQR(sc)));
	}

	public static double SQR(int a) {
		double x1 = 1, x2;
		x2 = x1 / 2.0 + a / (2 * x1);
		while (Math.abs(x2 - x1) > 1e-4) {// abs求绝对值
			x1 = x2;
			x2 = x1 / 2.0 + a / (2 * x1);
		}
		return x2;
	}

}
