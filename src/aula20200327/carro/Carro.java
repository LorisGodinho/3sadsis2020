package aula20200327.Carro;

public class Carro {

	private double combustivelNoTanqueEmLitros = 0.00;
	private boolean ligado = false;

	public Carro(double combustivelNoTanque) {
		combustivelNoTanqueEmLitros = combustivelNoTanque;
		ligado = false;
	}


	public void ligar() {
		if (combustivelNoTanqueEmLitros - 0.250 >= 0.250) {
			combustivelNoTanqueEmLitros -= 0.250;
			ligado = true;
		} else
			System.out.println("Carro sem combustível !..");
	}

	public void abastecer(double volumeEmLitros) {
		combustivelNoTanqueEmLitros += volumeEmLitros;
	}

	public void acelerar() {
		if (combustivelNoTanqueEmLitros - 0.250 >= 0.250) {
			combustivelNoTanqueEmLitros -= 0.250;
		} else
			System.out.println("Carro desligado ou sem combustível !..");
	}

	public void desligar() {
		ligado = false;
	}
	
	//retorna a quantida de combustivel no tannque em litros
	public double getCombustivelNoTanqueEmLitros() {
		return combustivelNoTanqueEmLitros;
	}

	public boolean isLigado() {
		return ligado;
	}
	
	public boolean isDesligado() {
		return !isLigado();
	}
}
