package matematicas;

public interface Varias {

	/**
	 * Comprueba si un número pasado como parámetro es capicúa.
	 * <p>
	 * Devuelve verdadero si el número que se pasa 
	 * como parámetro es capicúa y falso en caso contrario.
	 * 
	 * @param num un número entero.
	 * @return true si {@code num} es capicúa o false si no lo es.
	 */
	public static boolean esCapicua(long num) {
		// throw new UnsupportedOperationException("Operación no implementada");
		return num == voltea(num);
	}

	/**
	 * Versión sobrecargada de {@link #esCapicua(long)} que
	 * admite un {@code int} como parámetro.
	 * 
	 * @param num un número entero.
	 * @return true si {@code num} es capicúa o false si no no es.
	 */
	public static boolean esCapicua(int num) {
		return esCapicua((long) num);
	}

	/**
	 * Devuelve el menor primo que es mayor al número que 
	 * se pasa como parámetro.
	 * 
	 * @param num un número entero.
	 * @return el siguiente número primo mayor a {@code num}.
	 */
	public static int siguientePrimo(int num) {
		while (!esPrimo(++num)) {}
		return num;
	}

	/**
	 * Comprueba si un número pasado como parámetro es primo.
	 * <p>
	 * Devuelve verdadero si el número que se pasa como parámetro 
	 * es primo y falso de lo contrario.
	 * 
	 * @param num un número entero.
	 * @return true si {@code num} es primo y false si no lo es.
	 */
	public static boolean esPrimo(long num) {
		if (num < 2)
			return false;
		for (long i = 2; i <= num / 2; i++)
			if (num % i == 0)
				return false;
		return true;
	}

	/**
	 * Versión sobrecargada de {@link #esPrimo(num)} que 
	 * admite un {@code int}.
	 * 
	 * @param num un número entero.
	 * @return true si {@code num} es primo y false si no lo es.
	 */
	public static boolean esPrimo(int num) {
		return esPrimo((long) num);
	}

	/**
	 * 
	 * @param base el número entero.
	 * @param exp el exponente al que se quiere elevar el número.
	 * @return el número {@code num} multiplicado por si mismo 
	 * 		{@code exp} veces.
	 */
	private static double _potencia(int base, int exp) {
		double res = 1;
		for (int i = 0; i < exp; i++)
			res *= base;
		return res;
	}

	/**
	 * Dada una base y un exponente devuelve la potencia.
	 * 
	 * @param base un número entero.
	 * @param exp el exponente al que queremos elevar el número.
	 * @return el número {@code num} multiplicado por si mismo 
	 * 		{@code exp} veces.
	 */
	public static double potencia(int base, int exp) {

		return (exp < 0) ? (double) 1 / _potencia(base, Math.abs(exp)) : _potencia(base, exp);
	}
	
	/**
	 * Versión sobrecargada de {@link #digitos(double)} que 
	 * admite un {@code int}.
	 * @param num un número entero.
	 * @return el número de dígitos de {@code num}.
	 */
	public static int digitos(int num) {
		return digitos((long) num);
	}

	/**
	 * Cuenta el número de dígitos de un número entero 
	 * pasado por parámetro.
	 * 
	 * @param num un número entero.
	 * @return el número de dígitos de {@code num}.
	 */
	public static int digitos(long num) {
		if (num == 0)
			return 1;
		if (num < 1)
			num = -num;
		int n = 0;
		while (num > 0){
			num /= 10;
			n++;
		}
		return n;
	}

	/**
	 * Versión sobrecargada de {@link #voltea(long)} que
	 * admite un {@code int}.
	 * 
	 * @param num un número entero.
	 * @return el número {@code num} invertido.
	 */
	public static int voltea(int num) {
		return (int) voltea((long) num);
	}

	/**
	 * Le da la vuelta a un número entero pasado por parámetro.
	 * 
	 * @param num un número entero.
	 * @return el número {@code num} invertido.
	 */
	public static long voltea(long num) {
		if (num < 0)
			return -voltea(-num);
		long volteado = 0;
		while (num > 0) {
			volteado = volteado * 10 + num % 10;
			num /= 10;
		}
		return volteado;
	}

	/**
	 * Devuelve el dígito que está en la posición n de un número 
	 * entero. 
	 * <p>
	 * Se empieza contando por el 0 de izquierda a derecha.
	 * 
	 * @param num un número entero.
	 * @param pos la posición en la que se busca el dígito.
	 * @return el dígito que se encuentra en la posición {@code pos}
	 * 		dentro del número {@code num}.
	 */
	public static int digitoN(long num, int pos) {
		return (int) trozoDeNumero(num, pos, pos);
	}

	/**
	 * Versión sobrecargada de {@link #digitoN(long, pos)} que
	 * admite un {@cod int}.
	 * 
	 * @param num un número entero.
	 * @param pos la posición en la que se busca el dígito.
	 * @return el dígito que se encuentra en la posición {@code pos}
	 * 		dentro del número {@code num}.
	 */
	public static int digitoN(int num, int dig) {
		return digitoN((long) num, dig);
	}

	/**
	 * Versión sobrecargada de {@link #posicionDeDigito(long, dig)}
	 * que admite un {@code int}.
	 * 
	 * @param num un número entero.
	 * @param dig el dígito que se busca.
	 * @return la posición de {@code dig} dentro de {@code num} o
	 * 		-1 si no se encuentra.
	 */
	public static int posicionDeDigito(int num, int pos) {
		return posicionDeDigito((long) num, pos);
	}

	/**
	 * Da la posición de la primera ocurrencia de un dígito dentro
	 * de un número entero. Si no lo encuentra, devuelve -1.
	 * 
	 * @param num un número entero.
	 * @param dig el dígito que se busca.
	 * @return la posición de {@code dig} dentro de {@code num} o
	 * 		-1 si no se encuentra.
	 */
	public static int posicionDeDigito(long num, int dig) {
		int pos;
		for (pos = 0; pos < digitos(num) && digitoN(num, pos) != dig; pos++) {}
		if (pos == digitos(num)) 
			return -1;
		else return 
			pos;
	}

	/**
	 * Versión sobrecargada de {@link #quitaPorDetras(long, int)} 
	 * que admite un {@code int}.
	 * 
	 * @param num un número entero.
	 * @param n el número de dígitos a eliminar.
	 * @return el número {@code num} sin los {@code n} dígitos de 
	 * su derecha.
	 */
	public static int quitaPorDetras(int num, int n) {
		return (int) quitaPorDetras((long) num, n);
	}

	/**
	 * Le quita a un número entero n dígitos por detrás (por la derecha).
	 * 
	 * @param num un número entero.
	 * @param n el número de dígitos a eliminar.
	 * @return el número {@code num} sin los {@code n} dígitos de 
	 * su derecha.
	 */
	public static long quitaPorDetras(long num, int n) {
		return num / (long) potencia(10, n);
	}

	/**
	 * Versión sobrecargada de {@link #quitaPorDelante(long, int)} 
	 * que admite un {@code int}.
	 * 
	 * @param num un número entero.
	 * @param n el número de dígitos a eliminar.
	 * @return el número {@code num} sin los {@code n} dígitos de 
	 * su izquierda.
	 */
	public static int quitaPorDelante(int num, int n) {
		return (int) quitaPorDelante((long) num, n);
	}

	/**
	 * Le quita a un número entero n dígitos por delante (por la izquierda).
	 * 
	 * @param num un número entero.
	 * @param n el número de dígitos a eliminar.
	 * @return el número {@code num} sin los {@code n} dígitos de 
	 * su izquierda.
	 */
	public static long quitaPorDelante(long num, int n) {
		if (n > digitos(num))
			return 0;
		return num % (long) potencia(10, digitos(num) - n);
	}

	/**
	 * Versión sobrecargada de {@link #pegaPorDetras(long, int)} 
	 * que admite un {@code int}.
	 * 
	 * @param num un número entero.
	 * @param dig el dígito a añadir.
	 * @return el número {@code num} con el {@code dig} dígito añadido
	 * por su derecha.
	 */
	public static int pegaPorDetras(int num, int dig) {
		return (int) pegaPorDetras((long) num, dig);
	}

	/**
	 * Añade un dígito a un número entero por detrás (por la derecha).
	 * 
	 * @param num un número entero.
	 * @param dig el dígito a añadir.
	 * @return el número {@code num} con el {@code dig} dígito añadido 
	 * por su derecha.
	 */
	public static long pegaPorDetras(long num, int dig) {
		return juntaNumeros(num, dig);
	}

	/**
	 * Versión sobrecargada de {@link #pegaPorDelante(long, int)} 
	 * que admite un {@code int}.
	 * 
	 * @param num un número entero.
	 * @param dig el dígito a añadir.
	 * @return el número {@code num} con el {@code dig} dígito añadido
	 * por su izquierda.
	 */
	public static int pegaPorDelante(int num, int dig) {
		return (int) pegaPorDelante((long) num, dig);
	}

	/**
	 * Añade un dígito a un número entero por delante (por la izquierda).
	 * 
	 * @param num un número entero.
	 * @param dig el dígito a añadir.
	 * @return el número {@code num} con el {@code dig} dígito añadido 
	 * por su izquierda.
	 */
	public static long pegaPorDelante(long num, int dig) {
		return juntaNumeros(dig, num);
	}
	
	/**
	 * Versión sobrecargada de {@link #trozoDeNumero(long, int, int)}
	 * que admite un int.
	 * 
	 * @param num un número entero.
	 * @param posInic la posición incial.
	 * @param posFin la posicióin final.
	 * @return la porción del número {@code num} que se encuentra entre
	 * la posición {@code posInic} y la posición {@code posFin} incluidos
	 * ambos y comenzando en 0.
	 */
	public static int trozoDeNumero(int num, int posInic, int posFin) {
		return (int) trozoDeNumero((long) num, posInic, posFin);
	}

	/**
	 * Toma como parámetros las posiciones incial y final dentro de un
	 * número entero y devuelve el trozo correspondiente.
	 * 
	 * @param num un número entero.
	 * @param posInic la posición incial.
	 * @param posFin la posicióin final.
	 * @return la porción del número {@code num} que se encuentra entre
	 * la posición {@code posInic} y la posición {@code posFin} incluidos
	 * ambos y comenzando en 0.
	 */
	public static long trozoDeNumero(long num, int posInic, int posFin) {
		int len = digitos(num);
		if (posInic <= posFin) {
			num = quitaPorDelante(num, posInic);
			num = quitaPorDetras(num, len - posFin - 1);
		}
		return num;
	}

	/**
	 * Versión sobrecargada de {@link #juntaNumeros(double, double)}
	 * que admite dos {@code int}.
	 * 
	 * @param num1 el número que se pegará por la izquierda.
	 * @param num2 el número que se pegará por la derecha.
	 * @return el número resultante de pegar {@code num1} y {@code num2}.
	 */
	public static int juntaNumeros(int num1, int num2) {
		return (int) juntaNumeros((long) num1, (long) num2);
	}

	/**
	 * Pega dos números enteros para formar uno.
	 * 
	 * @param num1 el número que se pegará por la izquierda.
	 * @param num2 el número que se pegará por la derecha.
	 * @return el número resultante de pegar {@code num1} y {@code num2}.
	 */
	public static long juntaNumeros(long num1, long num2) {
		return num1 * (long) potencia(10, digitos(num2)) + num2;
	}
}
