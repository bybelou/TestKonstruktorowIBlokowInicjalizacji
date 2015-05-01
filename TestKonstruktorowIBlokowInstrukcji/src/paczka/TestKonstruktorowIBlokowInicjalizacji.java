package paczka;

import java.util.Random;

public class TestKonstruktorowIBlokowInicjalizacji {

	public static void main(String[] args) {
		Pracownik[] listaPracownikow = new Pracownik[3];
		
		listaPracownikow[0] = new Pracownik();
		listaPracownikow[1] = new Pracownik(4444);
		listaPracownikow[2] = new Pracownik("Kunowski", 5555);
		
		for (int i=0; i<listaPracownikow.length; i++){
			System.out.println(listaPracownikow[i].toString());
		}
	}
}

class Pracownik{
	//trzy przeladowane konstruktory
	Pracownik(){
		//nazwa="" - automatycznie
		//pensja=0 - automatycznie
	}
	
	//wywolanie konstruktora: Pracownik(String n, double p) 
	Pracownik(double p){
		this("Pracownik #" + Pracownik.nastepnyId, p);
		//this("Pracownik #" + nastepnyId, p);
	}
	
	Pracownik(String n, double p){
		this.nazwa = n;
		this.pensja = p;
	}
	
	//blok inicjalizacji obiektu
	{
		this.id = nastepnyId;
		nastepnyId++;
	}
	
	//statyczny blok inicjalizacji
	static
	{
		Random generator = new Random();
		Pracownik.nastepnyId = generator.nextInt(10000);
		//nastepnyId = generator.nextInt();
	}
	
	@Override
	public String toString(){
		return "ID: " + this.id
				+ " | Nazwa: " + this.nazwa
				+ " | Pensja: " + this.pensja;
	}
	
	String nazwa;
	double pensja;
	int id;
	static int nastepnyId;
}