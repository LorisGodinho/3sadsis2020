package aula20200327.Carro;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestesEmCarro {

	double valorTeste = 35.00;

	@Test
	void testarConsumo() {
		Carro audi = new Carro(0.00);
		double qtdEmLitrosTanqueAntes = audi.getCombustivelNoTanqueEmLitros();

		assertTrue(audi.isDesligado());

		double qtdEmLitros = valorTeste;
		qtdEmLitrosTanqueAntes = audi.getCombustivelNoTanqueEmLitros();
		audi.abastecer(valorTeste);

		assertEquals(qtdEmLitrosTanqueAntes + qtdEmLitros, audi.getCombustivelNoTanqueEmLitros());
		// resetar o verificador
		qtdEmLitrosTanqueAntes = audi.getCombustivelNoTanqueEmLitros();

		// testar ignicao
		if (audi.getCombustivelNoTanqueEmLitros() >= 0.250) {
			audi.ligar();
			assertEquals(qtdEmLitrosTanqueAntes - 0.250, audi.getCombustivelNoTanqueEmLitros());
			assertEquals(true, audi.isLigado());
		} else {
			System.out.println("Carro sem combustível !..");
		}
		// resetar o verificador
		qtdEmLitrosTanqueAntes = audi.getCombustivelNoTanqueEmLitros();

		if (audi.getCombustivelNoTanqueEmLitros() >= 0.250 && audi.isLigado() == true) {
			audi.acelerar();
			assertEquals(qtdEmLitrosTanqueAntes - 0.250, audi.getCombustivelNoTanqueEmLitros());
		} else {
			System.out.println("Carro desligado ou sem combustível !..");
		}

	}

	@Test
	// 2. O Carro se desligue automaticamente sempre que o combustível no tanque
	// seja insuficiente para seu funcionamento.
	void testarDesligarAutomatico() {
		Carro audi = new Carro(1.00);
		audi.ligar();
		do {
			audi.acelerar();
		} while (audi.getCombustivelNoTanqueEmLitros() >= 0.250);
		audi.desligar();
		assertFalse(audi.isLigado());
		assertTrue(audi.isDesligado());
	}

	@Test
	// 3. O Casso possa ser reabastecido.
	void testarReabastecimento() {
		Carro audi = new Carro(0.00);
		audi.abastecer(1.00);
		assertEquals(1.00, audi.getCombustivelNoTanqueEmLitros());

		for (int i = 0; i < 2; i++) {
			audi.acelerar();
		}

		assertEquals(0.250, audi.getCombustivelNoTanqueEmLitros());

		audi.abastecer(2.00);

		assertEquals(2.250, audi.getCombustivelNoTanqueEmLitros());
	}

	@Test
	// 4. O Carro possa ser criado com uma quantidade determinada de combustível
	// (via construtor).
	void testarSetDeCombustivelViaConstrutor() {
		Carro corsa = new Carro(20.00);

		assertEquals(20.00, corsa.getCombustivelNoTanqueEmLitros());
	}

}
