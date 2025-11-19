public class App {

	public static boolean esCapicua(int num) {
		return num == voltea(num);
	}

	public static boolean esPrimo(int num) {
		boolean esPrimo = true;
		if (num == 2)
			return esPrimo;
		int i = 3;
		while (i < num / 2 && esPrimo) {
			if (num % i == 0)
				return (!esPrimo);
			i++;
		}
		return esPrimo;
	}

	public static int siguientePrimo(int num) {
		int res = num + 1;
		while (!esPrimo(res))
			res++;
		return res;
	}

	public static int potencia(int base, int exp) {
		int res = base;
		for (int i = 1; i < exp; i++)
			res *= base;
		return res;
	}

	public static int digitos(long num) {
		int dig = 0;
		if (num == 0)
			return 1;
		while (num > 0) {
			num /= 10;
			dig++;
		}
		return dig;
	}

	public static long voltea(long num) {
		long res = 0;
		int signo = 1;
		if (num < 0)
			signo = -signo;
		num *= signo;
		while (num > 0) {
			res = res * 10 + num % 10;
			num /= 10;
		}
		return res * signo;
	}

	public static float digitoN(long num, int pos) { ///arreglar
		long aux = voltea(num);
		return aux % potencia(10, pos);
	}

	public static int posicionDeDigito(long num, int dig) {
		long aux = voltea(num);
		int pos = 0;
		while (aux > 0) {
			if (aux % 10 != dig)
				return (pos);
			aux /= 10;
			pos++;
		}
		return -1;
	}

	public static long quitaPorDetras(long num, int n) {
		return (long)(num / potencia(10, n));
	}

	public static long quitaPorDelante(long num, int n) {
		long aux = voltea(num);
		long res = quitaPorDetras(aux, n);
		return voltea(res);
	}

	public static long pegaPorDetras(long num, int dig) {
		return num * 10 + dig;
	}

	public static long pegaPorDelante(long num, int dig) {
		long aux = voltea(num);
		aux = aux * 10 + dig;
		return voltea(aux);
	}
	
	public static long trozoDeNumero(long num, int posInicial, int posFinal) { // terminar
		long aux = voltea(num);


		return aux;
	}

	public static long juntaNumeros(int num1, int num2) {
		num1 *= potencia(10, digitos(num2));
		return num1 += num2;
	}

    public static void main(String[] args) throws Exception {
        
		System.out.printf("El %d%s es capicúa.%n", 464, esCapicua(464) ? "" : " no");
		System.out.printf("El %d%s es primo.%n", 29, esPrimo(29) ? "" : " no");
		System.out.printf("El siguiente primo mayor a %d es %d.%n", 23, siguientePrimo(23));
		System.out.printf("El siguiente primo mayor a %d es %d.%n", 100, siguientePrimo(100));
		System.out.printf("%d^%d = %d%n", 2, 10, potencia(2, 10));
		System.out.printf("%d^(%d) = %d%n", 5, -3, potencia(5, -3));
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
		System.out.printf("Si al %d se le quitan por delante %d dígito%s, se queda como %d.%n", 78604321, 4, quitaPorDelante(78604321, 1) > 1 ? "s" : "", quitaPorDetras(78604321, 1));
		System.out.printf("Si al %d se le quitan por delante %d dígito%s, se queda como %d.%n", 78604000, 2, quitaPorDelante(78604000, 1) > 1 ? "s" : "", quitaPorDetras(78604000, 1));
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
