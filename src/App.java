public class App {

	/**
	 * 
	 * @param num
	 * @return
	 */
	public static boolean esCapicua(long num) {
		return num == voltea(num);
	}

	/**
	 * 
	 * @param num
	 * @return
	 */
	public static boolean esCapicua(int num) {
		return esCapicua((long) num);
	}

	/**
	 * 
	 */
	public static boolean esPrimo(long num) {
		if (num < 2)
			return false;
		else {
			for (long i = num / 2; i >= 2; i--)
				if (num % i == 0)
					return false;
		}
		return true;
	}

	public static boolean esPrimo(int num) {
		return esPrimo((long) num);
	}

	public static int siguientePrimo(int num) {
		while (!esPrimo(++num)) {}
		return num;
	}

	public static double potencia(int base, int exp) {
		if (exp == 0)
			return 1;
		if (exp < 0)
			return 1 / potencia(base, -exp);
		int res = 1;
		for (int i = 0; i < Math.abs(exp); i++)
			res = res * base;
		return res;
	}

	public static int digitos(long num) {
		if (num < 0)
			num = -num;
		if (num == 0)
			return 1;
		else {
			int dig = 0;
			while (num > 0) {
				num /= 10;
				dig++;
			}
			return dig;
		}
	}

	public static int digitos(int num) {
		return digitos((long) num);
	}

	public static long voltea(long num) {
		long volteado = 0;
		if (num < 0)
			return -voltea(-num);
		while (num > 0) {
			volteado = volteado * 10 + num % 10;
			num /= 10;
		}
		return volteado;
	}

	public static int voltea(int num) {
		return (int) voltea((long) num);
	}

	public static int digitoN(long num, int pos) {
		num = voltea(num);
		while (pos-- > 0)
			num /= 10;
		return (int)(num % 10);
	}

	public static int digitoN(int num, int pos) {
		return digitoN((long) num, pos);
	}

	public static int posicionDeDigito(long num, int dig) {
		int pos;
		for (pos = 0; (pos < digitos(num)) && (digitoN(num, pos) != dig); pos++) {}
		if (pos == digitos(num))
			return -1;
		else
			return pos;
	}

	public static int posicionDeDigito(int num, int dig) {
		return posicionDeDigito((long) num, dig);
	}

	public static long quitaPorDetras(long num, int n) {
		return num / (long) potencia(10, n);
	}

	public static int quitaPorDetras(int num, int n) {
		return (int) quitaPorDetras((long) num, n);
	}

	public static long quitaPorDelante(long num, int n) {
		num = pegaPorDetras(num, 1);
		num = voltea(quitaPorDetras(voltea(num), n));
		num = quitaPorDetras(num, 1);
		return num;
	}

	public static long pegaPorDetras(long num, int dig) {
		return juntaNumeros(num, dig);
	}

	public static int pegaPorDetras(int num, int dig) {
		return (int) pegaPorDetras((long) num, dig);
	}

	public static long pegaPorDelante(long num, int dig) {
		return juntaNumeros(dig, num);
	}

	public static int pegaPorDelante(int num, int dig) {
		return (int) pegaPorDelante((long) num, dig);
	}
	
	public static long trozoDeNumero(long num, int posInicial, int posFinal) {
		int len = digitos(num);
		num = quitaPorDelante(num, posInicial);
		num = quitaPorDetras(num, len - posFinal - 1);
		return num;
	}

	public static int trozoDeNumero(int num, int posInicial, int posFinal) {
		return (int) trozoDeNumero((long) num, posInicial, posFinal);
	}

	public static long juntaNumeros(long num1, long num2) {
		return num1 * (long) potencia(10, digitos(num2)) + num2;
	}

	public static int juntaNumeros(int num1, int num2) {
		return (int) juntaNumeros((long) num1, (long) num2);
	}

	public static void main(String[] args) throws Exception {

		System.out.printf("El %d%s es capicúa.%n", 464, esCapicua(464) ? "" : " no");
		System.out.printf("El %d%s es primo.%n", 29, esPrimo(29) ? "" : " no");
		System.out.printf("El siguiente primo mayor a %d es %d.%n", 23, siguientePrimo(23));
		System.out.printf("El siguiente primo mayor a %d es %d.%n", 100, siguientePrimo(100));
		System.out.printf("%d^%d = %f%n", 2, 10, potencia(2, 10));
		System.out.printf("%d^(%d) = %f%n", 5, -3, potencia(5, -3));
		System.out.printf("El número %d tiene %d dígito%s.%n", 0, digitos(0), digitos(0) > 1 ? "s" : "");
		System.out.printf("El número %d tiene %d dígito%s.%n", 7, digitos(7), digitos(7) > 1 ? "s" : "");
		System.out.printf("El número %d tiene %d dígito%s.%n", 674893123, digitos(674893123), digitos(674893123) > 1 ? "s" : "");
		System.out.printf("El %d volteado es %d.%n", 5, voltea(5));
		System.out.printf("El %d volteado es %d.%n", 398004321, voltea(398004321));
		System.out.printf("El %d volteado es %d.%n", -75839, voltea(-75839));
		System.out.printf("En la posición %d del %d está el %d%n", 0, 3452, digitoN(3452, 0));
		System.out.printf("En la posición %d del %d está el %d%n", 6, 857964034, digitoN(857964034, 6));
		System.out.printf("En la posición %d del %d está el %d%n", 4, 857964034, digitoN(857964034, 4));
		System.out.printf("En el %d, el dígito %d está en la posición %d.%n", 3452, 4, posicionDeDigito(3452, 4));
		System.out.printf("En el %d, el dígito %d está en la posición %d.%n", 78604321, 1, posicionDeDigito(78604321, 1));
		System.out.printf("En el %d, el dígito %d está en la posición %d.%n", 78604321, 7, posicionDeDigito(78604321, 7));
		System.out.printf("En el %d, el dígito %d está en la posición %d.%n", 78604321, 5, posicionDeDigito(78604321, 5));
		System.out.printf("Si al %d se le quitan por detrás %d dígito%s, se queda como %d.%n", 78604321, 4, quitaPorDetras(78604321, 4) > 1 ? "s" : "", quitaPorDetras(78604321, 4));
		System.out.printf("Si al %d se le quitan por detrás %d dígito%s, se queda como %d.%n", 1000, 1, quitaPorDetras(1000, 1) > 1 ? "s" : "", quitaPorDetras(1000, 1));
		System.out.printf("Si al %d se le quitan por delante %d dígito%s, se queda como %d.%n", 78604321, 4, quitaPorDelante(78604321, 4) > 1 ? "s" : "", quitaPorDelante(78604321, 4));
		System.out.printf("Si al %d se le quitan por delante %d dígito%s, se queda como %d.%n", 78604000, 2, quitaPorDelante(78604000, 2) > 1 ? "s" : "", quitaPorDelante(78604000, 2));
		System.out.printf("Si al %d se le pega por detrás el %d da el %d.%n", 567, 1, pegaPorDetras(567, 1));
		System.out.printf("Si al %d se le pega por detrás el %d da el %d.%n", 33, 0, pegaPorDetras(33, 0));
		System.out.printf("Si al %d se le pega por delante el %d da el %d.%n", 567, 1, pegaPorDelante(567, 1));
		System.out.printf("Si al %d se le pega por delante el %d da el %d.%n", 33, 0, pegaPorDelante(33, 0));
		System.out.printf("Al %d le cojo el trozo que va de la posición %d a la %d: %d%n", 78604000, 0, 3, trozoDeNumero(78604000, 0, 3));
		System.out.printf("Al %d le cojo el trozo que va de la posición %d a la %d: %d%n", 78604000, 4, 6, trozoDeNumero(78604000, 4, 6));
		System.out.printf("Al %d le cojo el trozo que va de la posición %d a la %d: %d%n", 78604000, 2, 2, trozoDeNumero(78604000, 2, 2));
		System.out.printf("Juntando el %d y el %d da el %d%n", 21, 40, juntaNumeros(21, 40));
		System.out.printf("Juntando el %d y el %d da el %d%n", 789, 250, juntaNumeros(789, 250));
    }
}
