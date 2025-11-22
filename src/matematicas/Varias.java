package matematicas;

/**
 * Funciones matemáticas de proósito general
 */
public class Varias {

	/**
	 * Devuelve verdadero si el número que se le pasa como parámetro 
	 * es capicúa y falso en caso contrario.
	 * <p>
	 * Un número capicúa es el que se lee igual de izquierda a derecha
	 * que de derecha a izquierda.
	 * 
	 * @param num número del que se quiere saber si es capicúa.
	 * @return verdadero si el número que se pasa como parámetro es
	 * 		capicúa y falso en caso contrario.
	 */
	public static boolean esCapicua(long num) {
		return num == voltea(num);
	}

	/**
	 * Versión sobrecargada de {@link #esCapicua(long)} que acepta un
	 * {@code int}.
	 * 
	 * @param num número del que se quiere saber si es capicúa.
	 * @return verdadero si el número que se pasa como parámetro es
	 * 		capicúa y falso en caso contrario.
	 */
	public static boolean esCapicua(int num) {
		return esCapicua((long) num);
	}

	/**
	 * Devuelve verdadero si el número que se pasa como parámetro 
	 * es primo y falso en caso contrario.
	 * <p>
	 * Un número primo es un número natural mayor que 1 y divisible
	 * únicamente entre el mismo y entre 1.
	 * 
	 * @param num número del que se quiere saber si es primo.
	 * @return verdadero si el número que se le pasa como parámetro es
	 * 		primo y falso en caso contrario.
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

	/**
	 * Versión sobrecargada de {@link #esPrimo(long)} que acepta un
	 * {@code int}.
	 * 
	 * @param num número del que se quiere saber si es primo.
	 * @return verdadero si el número que se pasa como parámetro es
	 * 		primo y falso en caso contrario.
	 */
	public static boolean esPrimo(int num) {
		return esPrimo((long) num);
	}

	/**
	 * Devuelve el menor primo que es mayor al número que se pasa como
	 * parámetro.
	 * 
	 * @param num un número entero.
	 * @return el menor primo que es mayor al número pasado como parámetro.
	 */
	public static int siguientePrimo(int num) {
		while (!esPrimo(++num)) {}
		return num;
	}

	/**
	 * Dada una base y un exponente, devuelve la potencia.
	 * 
	 * @param base base de la potencia.
	 * @param exp exponente de la potencia.
	 * @return número resultante de elevar la base a la potencia dada.
	 */
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

	/**
	 * Cuenta el número de dígitos de un número entero.
	 * 
	 * @param num número al que se le quieren contar los dígitos.
	 * @return número de dígitos del número que se pasa como parámetro.
	 */
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

	/**
	 * Versión sobrecargada de {@link #digitos(long)} que acepta un
	 * {@code int}.
	 * 
	 * @param num número al que se le quieren contar los dígitos.
	 * @return número de dígitos del número que se pasa como parámetro.
	 */
	public static int digitos(int num) {
		return digitos((long) num);
	}

	/**
	 * Le da la vuelta a un número.
	 * 
	 * @param num número al que se le quiere dar la vuelta.
	 * @return número volteado (al revés).
	 */
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

	/**
	 * Versión sobrecargada de {@link #voltea(long)} que acepta un
	 * {@code int}.
	 * 
	 * @param num número al que se le quiere dar la vuelta.
	 * @return número volteado (al revés).
	 */
	public static int voltea(int num) {
		return (int) voltea((long) num);
	}

	/**
	 * Devuelve el dígito que está en la posiciín n-ésima de un número.
	 * 
	 * @param num número entero.
	 * @param pos posición dentro del número {@code num}.
	 * @return dígito que está en la posicion {@code pos} del número
	 * 		{@code num} empezando a contar por la izquierda.
	 */
	public static int digitoN(long num, int pos) {
		num = voltea(num);
		while (pos-- > 0)
			num /= 10;
		return (int)(num % 10);
	}

	/**
	 * Versión sobrecargada del {@link #digitoN(long, int)} que acepta un
	 * {@code int}.
	 * 
	 * @param num número entero.
	 * @param pos posición dentro del número {@code num}.
	 * @return dígito que está en la posición {@code pos} del número
	 * 		{@code num} empezando a contar por la izquierda.
	 */
	public static int digitoN(int num, int pos) {
		return digitoN((long) num, pos);
	}

	/**
	 * Da la posición de la primera ocurrencia de un dígito dentro de un
	 * número entero. Si no se encuentra, devuelve -1.
	 * 
	 * @param num número entero.
	 * @param dig dígito a buscar dentro del número.
	 * @return posición de la primera ocurrencia del dígito dentro del
	 * 		número o -1 si no se encuentra.
	 */
	public static int posicionDeDigito(long num, int dig) {
		int pos;
		for (pos = 0; (pos < digitos(num)) && (digitoN(num, pos) != dig); pos++) {}
		if (pos == digitos(num))
			return -1;
		else
			return pos;
	}

	/**
	 * Versión sobrecargada de {@link #posicionDeDigito(long, int)} que
	 * acepta un {@code int}.
	 * 
	 * @param num número entero.
	 * @param dig dígito a buscar dentro del número.
	 * @return posición de la primera ocurrencia del dígito dentro del
	 * 		número o -1 si no se encuentra.
	 */
	public static int posicionDeDigito(int num, int dig) {
		return posicionDeDigito((long) num, dig);
	}

	/**
	 * Le quita a un número {@code n} dígitos por la derecha.
	 * 
	 * @param num número entero.
	 * @param n número de dígitos que se le van a quitar.
	 * @return número inicial {@code num} con {@code n} dígitos menos
	 * 		quitados de la derecha.
	 */
	public static long quitaPorDetras(long num, int n) {
		return num / (long) potencia(10, n);
	}

	/**
	 * Versión sobrecargada de {@link #quitaPorDetras(long, int)} que
	 * acepta un {@code int}.
	 * 
	 * @param num número entero.
	 * @param n número de dígitos que se le van a quitar.
	 * @return número inicial {@code num} con {@code n} dígitos menos
	 * 		quitados de la derecha.
	 */
	public static int quitaPorDetras(int num, int n) {
		return (int) quitaPorDetras((long) num, n);
	}

	/**
	 * Le quita a un número {@code n} dígitos por la derecha.
	 * 
	 * @param num número entero.
	 * @param n número de dígitos que se le van a quitar.
	 * @return número inicial {@code num} con {@code n} dígitos menos
	 * 		quitados de la izquierda.
	 */
	public static long quitaPorDelante(long num, int n) {
		num = pegaPorDetras(num, 1);
		num = voltea(quitaPorDetras(voltea(num), n));
		num = quitaPorDetras(num, 1);
		return num;
	}

	/**
	 * Versión sobrecargada de {@link #quitaPorDelante(long, int)} que
	 * acepta un {@cod int}.
	 * 
	 * @param num número entero.
	 * @param dig número de dígitos que se le van a quitar.
	 * @return número inicial {@code num} con {@code n} dígitos menos
	 */
	public static long quitaPorDelante(int num, int n) {
		return (int) quitaPorDelante((long) num, n);
	}

	/**
	 * Añade un dígito a un número por detrás (por la derecha).
	 * 
	 * @param num número entero.
	 * @param dig dígito que se le va a pegar por la derecha.
	 * @return número inicial {@code num} con el dígito {@code dig}
	 * 		pegado por la derecha.
	 */
	public static long pegaPorDetras(long num, int dig) {
		return juntaNumeros(num, dig);
	}

	/**
	 * Versión sobrecargada de pegaPorDetras(long, int) que
	 * acepta un {@code int}.
	 * 
	 * @param num número entero.
	 * @param dig dígito que se le va a pegar por la derecha.
	 * @return número inicial {@code num} con el dígito {@code dig}
	 * 		pegado por la derecha.
	 */
	public static int pegaPorDetras(int num, int dig) {
		return (int) pegaPorDetras((long) num, dig);
	}

	/**
	 * Añade un dítigo a un número por delante (por la izquierda).
	 * 
	 * @param num número entero.
	 * @param dig dígito que se le va a pegar por la izquierda.
	 * @return número inicial {@code num} con el dígito {@code dig}
	 * 		pegado por la izquierda.
	 */
	public static long pegaPorDelante(long num, int dig) {
		return juntaNumeros(dig, num);
	}

	/**
	 * Versión sobrecargada de {@link #pegaPorDelante(long, int)} que
	 * acepta un {@code int}.
	 * 
	 * @param num número entero.
	 * @param dig dígito que se le va a pegar por la izquierda.
	 * @return número inicial {@code num} con el dígito {@code dig}
	 * 		pegado por la izquierda.
	 */
	public static int pegaPorDelante(int num, int dig) {
		return (int) pegaPorDelante((long) num, dig);
	}
	
	/**
	 * Toma como parámetros las posiciones inicial y final dentro de un
	 * número y devuelve el trozo correspondiente.
	 * <p>
	 * Las posiciones se cuentan de izquierda a derecha comenzando por
	 * el cero.
	 * 
	 * @param num número entero.
	 * @param posInicial posición incial.
	 * @param posFinal posición final.
	 * @return trozo de número compuesto por los dígitos que van desde
	 * 		la posición inicial hasta la posición final incluyendo ambos.
	 */
	public static long trozoDeNumero(long num, int posInicial, int posFinal) {
		int len = digitos(num);
		num = quitaPorDelante(num, posInicial);
		num = quitaPorDetras(num, len - posFinal - 1);
		return num;
	}

	/**
	 * Versión sobrecargada de {@link #trozoDeNumero(long, int, int)} que
	 * acepta un {@code int}.
	 * 
	 * @param num número entero.
	 * @param posInicial posición incial.
	 * @param posFinal posición final.
	 * @return trozo de número compuesto por los dígitos que van desde
	 * 		la psoición inicial hasta la posición final incluyendo ambos.
	 */
	public static int trozoDeNumero(int num, int posInicial, int posFinal) {
		return (int) trozoDeNumero((long) num, posInicial, posFinal);
	}

	/**
	 * Pega dos números para formar uno solo.
	 * 
	 * @param num1 trozo que se pegará por la izquierda.
	 * @param num2 trozo que se pegará por la derecha.
	 * @return número compuesto de los trozos {@code num1} y {@code num2}.
	 */
	public static long juntaNumeros(long num1, long num2) {
		return num1 * (long) potencia(10, digitos(num2)) + num2;
	}

	/**
	 * Versión sobrecargada de {@link #juntanúmeros(long, long)} que
	 * acepta dos {@code int}.
	 * 
	 * @param num1 trozo que se pegará por la izquierda.
	 * @param num2 trozo que se pegará por la derecha.
	 * @return número compuesto de los trozos {@code num1} y {@code num2}.
	 */
	public static int juntaNumeros(int num1, int num2) {
		return (int) juntaNumeros((long) num1, (long) num2);
	}
}
