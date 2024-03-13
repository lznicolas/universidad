package com.universidad.universidadbackend;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

class UniversidadBackendApplicationTests {

	Calculadora calculadora = new Calculadora();

	@Test
	@DisplayName("suma de valor a y valor b")
	void sumaDeValores() {
		//given
		int valorA = 3;
		int valorB = 2;

		//when
		int expectativa = calculadora.suma(valorA, valorB);

		//Then
		int resultadoEsperado = 5;
		assertThat(expectativa).isEqualTo(resultadoEsperado);
	}

	@Test
	@DisplayName("Test deprecado")
	@Disabled("Test deprecado")
	void testDesactivado(){

	}

	class Calculadora{
		int suma (int valor_a, int valor_b){
			return valor_a + valor_b;
		}
	}

}
