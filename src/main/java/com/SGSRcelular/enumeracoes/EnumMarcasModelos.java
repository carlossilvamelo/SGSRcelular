package com.SGSRcelular.enumeracoes;
import java.util.ArrayList;

public enum EnumMarcasModelos {

	
	LG(modelosLG()), MOTOROLA(modelosMotorola())
	, NOKIA(modelosNokia()), SAMSUNG(modelosSamsung());
	
	
	public ArrayList<String> modelos;
	
	EnumMarcasModelos(ArrayList<String> modelos){
		this.modelos = modelos;
	}
	
	//Listagem de modelos
	
	
	public static ArrayList<String> modelosLG(){
		ArrayList<String> modelos = new ArrayList<String>();
		modelos.add("Nexus 4");
		modelos.add("Nexus 5");
		modelos.add("A275");
		modelos.add("LG T375 Dual Chip");
		modelos.add("Optimus L1 II ");
		modelos.add("G PRO LITE D683");
		modelos.add("G2 D805");
		modelos.add("Optimus G");
		modelos.add("LG Fireweb");
		modelos.add("LG L70 Dual");
		return modelos;
	}
	public static ArrayList<String> modelosMotorola(){
		ArrayList<String> modelos = new ArrayList<String>();
		modelos.add("Moto X");
		modelos.add("Motorola RAZR HD");
		modelos.add("Moto E");
		modelos.add("Moto G");
		modelos.add("ATRIX TV");
		modelos.add("Inronrock");
		modelos.add("RAZR HD");
		modelos.add("Motorola XT621");
		modelos.add("RAZR D1");
		modelos.add("RAZR D3");
		return modelos;
	}
	
	public static ArrayList<String> modelosNokia(){
		ArrayList<String> modelos = new ArrayList<String>();
		modelos.add("220");
		modelos.add("Asha 302");
		modelos.add("LUMIA 1020");
		modelos.add("LUMIA 710");
		modelos.add("LUMIA 800");
		modelos.add("808 PureView");
		modelos.add("Asha 305");
		modelos.add("Asha 310 Dual Chip");
		modelos.add("LUMIA 920 - 4G");
		modelos.add("LUMIA 630 Dual Chip");
		return modelos;
	}
	
	public static ArrayList<String> modelosSamsung(){
		
		ArrayList<String> modelos = new ArrayList<String>();
		modelos.add("Galaxy S5");
		modelos.add("Galaxy X");
		modelos.add("Galaxy S4 Mini Duos");
		modelos.add("Omnia M");
		modelos.add("GALAXY W");
		modelos.add("GALAXY S III MINI");
		modelos.add("Galaxy S Duos 2");
		modelos.add("Galaxy Express");
		modelos.add("Galaxy Ace Plus");
		modelos.add("Galaxy Music Duos");
		return modelos;
	}
	
	//gets
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static EnumMarcasModelos getMarcaById(int id){
		
		for (EnumMarcasModelos marca : EnumMarcasModelos.values()) {
			if(EnumMarcasModelos.valueOf(marca.toString()).ordinal() == id){
				return EnumMarcasModelos.valueOf(marca.toString());
			}
		}

		return null;
	}
	
	public static ArrayList<String> listaMarcas(){
		ArrayList<String> lista = new ArrayList<String>();
		for (EnumMarcasModelos marca : EnumMarcasModelos.values()) {
			lista.add(marca.toString());
		}
		return lista;
	}
	
	public String getModeloById(int id){
		return this.modelos.get(id);
	}
	
}
