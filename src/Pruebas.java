import matematicas.Varias;

public class Pruebas {
    public static void main(String[] args) throws Exception {
        
		System.out.printf("El %d%s es capicúa.%n", 464, Varias.esCapicua(464) ? "" : " no");
		System.out.printf("El %d%s es primo.%n", 29, Varias.esPrimo(29) ? "" : " no");
		System.out.printf("El siguiente primo mayor a %d es %d.%n", 23, Varias.siguientePrimo(23));
		System.out.printf("El siguiente primo mayor a %d es %d.%n", 100, Varias.siguientePrimo(100));
		System.out.printf("%d^%d = %1.f%n", 2, 10, Varias.potencia(2, 10));
		System.out.printf("%d^(%d) = %3.f%n", 5, -3, Varias.potencia(5, -3));
		System.out.printf("%d^(%d) = %1.f%n", 10, 6, Varias.potencia(10, 6));
		System.out.printf("El número %d tiene %d dígito%s.%n", 0, Varias.digitos(0), Varias.digitos(0) > 1 ? "s" : "");
		System.out.printf("El número %d tiene %d dígito%s.%n", 7, Varias.digitos(7), Varias.digitos(7) > 1 ? "s" : "");
		System.out.printf("El número %d tiene %d dígito%s.%n", 674893123, Varias.digitos(674893123), Varias.digitos(674893123) > 1 ? "s" : "");
		System.out.printf("El %d volteado es %d.%n", 5, Varias.voltea(5));
		System.out.printf("El %d volteado es %d.%n", 398004321, Varias.voltea(398004321));
		System.out.printf("El %d volteado es %d.%n", -75839, Varias.voltea(-75839));
		System.out.printf("En la posición %d del %d está el %d.%n", 0, 3452, Varias.digitoN(3452, 0));
		System.out.printf("En la posición %d del %d está el %d.%n", 6, 857964034, Varias.digitoN(857964034, 6));
		System.out.printf("En la posición %d del %d está el %d.%n", 4, 857964034, Varias.digitoN(857964034, 4));
		System.out.printf("En el %d, el dígito %d está en la posición %d.%n", 3452, 4, Varias.posicionDeDigito(3452, 4));
		System.out.printf("En el %d, el dígito %d está en la posición %d.%n", 78604321, 1, Varias.posicionDeDigito(78604321, 1));
		System.out.printf("En el %d, el dígito %d está en la posición %d.%n", 78604321, 7, Varias.posicionDeDigito(78604321, 7));
		System.out.printf("En el %d, el dígito %d está en la posición %d.%n", 78604321, 5, Varias.posicionDeDigito(78604321, 5));
		System.out.printf("Si al %d se le quitan por detrás %d dígito%s, se queda como %d.%n", 78604321, 4, Varias.quitaPorDetras(78604321, 4) > 1 ? "s" : "", Varias.quitaPorDetras(78604321, 4));
		System.out.printf("Si al %d se le quitan por detrás %d dígito%s, se queda como %d.%n", 1000, 1, Varias.quitaPorDetras(1000, 1) > 1 ? "s" : "", Varias.quitaPorDetras(1000, 1));
		System.out.printf("Si al %d se le quitan por delante %d dígito%s, se queda como %d.%n", 78604321, 4, Varias.quitaPorDelante(78604321, 4) > 1 ? "s" : "", Varias.quitaPorDelante(78604321, 4));
		System.out.printf("Si al %d se le quitan por delante %d dígito%s, se queda como %d.%n", 78604000, 2, Varias.quitaPorDelante(78604000, 2) > 1 ? "s" : "", Varias.quitaPorDelante(78604000, 2));
		System.out.printf("Si al %d se le pega por detrás el %d da el %d.%n", 567, 1, Varias.pegaPorDetras(567, 1));
		System.out.printf("Si al %d se le pega por detrás el %d da el %d.%n", 33, 0, Varias.pegaPorDetras(33, 0));
		System.out.printf("Si al %d se le pega por delante el %d da el %d.%n", 567, 1, Varias.pegaPorDelante(567, 1));
		System.out.printf("Si al %d se le pega por delante el %d da el %d.%n", 33, 0, Varias.pegaPorDelante(33, 0));
		System.out.printf("Al %d le cojo el trozo que va de la posición %d a la %d: %d.%n", 78604000, 0, 3, Varias.trozoDeNumero(78604000, 0, 3));
		System.out.printf("Al %d le cojo el trozo que va de la posición %d a la %d: %d.%n", 78604000, 4, 6, Varias.trozoDeNumero(78604000, 4, 6));
		System.out.printf("Al %d le cojo el trozo que va de la posición %d a la %d: %d.%n", 78604000, 2, 2, Varias.trozoDeNumero(78604000, 2, 2));
		System.out.printf("Juntando el %d y el %d da el %d.%n", 21, 40, Varias.juntaNumeros(21, 40));
		System.out.printf("Juntando el %d y el %d da el %d.%n", 789, 250, Varias.juntaNumeros(789, 250));
    }
}
