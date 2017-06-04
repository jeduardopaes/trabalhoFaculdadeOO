package br.com.joseeduardopaes.agenda.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ContatoDB {

	private List<Contato> listaDosContatos;
	private HashMap<String, Contato> listaHashMap;

	public ContatoDB() {
		listaDosContatos = new ArrayList<Contato>();
		listaHashMap = new HashMap();
	}

	public ContatoDB(List<Contato> listaDosContatos) {
		this.listaDosContatos = listaDosContatos;
		this.organizaContatos();
	}

	public ContatoDB(HashMap listaHashMap) {
		this.listaHashMap = listaHashMap;
		this.organizaContatos();
	}

	public List<Contato> getListaDosContatos() {
		return listaDosContatos;
	}

	public void setListaDosContatos(List<Contato> listaDosContatos) {
		this.listaDosContatos = listaDosContatos;
		this.organizaContatos();
	}

	public Contato buscarPorNome(String nome) {

		for (Contato contato : listaDosContatos) {
			if (contato.getPrimeiroNome().equalsIgnoreCase(nome) || contato.getUltimoNome().equalsIgnoreCase(nome)) {
				return contato;
			}
		}

		return null;
	}
	
	public Contato buscarPorInicial(String iniciais){
		
		for(String key : listaHashMap.keySet()){
			if(key.equalsIgnoreCase(iniciais)){
				return listaHashMap.get(key);
			}
		}
		
		return null;
	}

	public void organizaContatos() {
		Collections.sort(listaDosContatos);
	}

	public void adicionarContatoHashMap(Contato contato) {
		char inicialNome = contato.getPrimeiroNome().toCharArray()[0];
		char inicialSobrenome = contato.getUltimoNome().toCharArray()[0];
		String iniciais = inicialNome + "" + inicialSobrenome;
		listaHashMap.put(iniciais, contato);
	}
	
	public void removerContatoHashMap(Contato contato){
		char inicialNome = contato.getPrimeiroNome().toCharArray()[0];
		char inicialSobrenome = contato.getUltimoNome().toCharArray()[0];
		String iniciais = inicialNome + "" + inicialSobrenome;
		listaHashMap.remove(iniciais);
	}

	public void adicionarContato(Contato contato) {

		listaDosContatos.add(contato);

	}

	public void removerContato(Contato contato) {
		listaDosContatos.remove(contato);
	}

	@Override
	public String toString() {
		String lista = "";

		for (Contato contato : listaDosContatos) {
			lista = lista + "\n|| " + contato.toString() + " ||";
		}

		return lista;
	}
	
	public String mostrarContatoHashMap() {
		String lista = "";

		for (String key : listaHashMap.keySet()) {
		    lista += "\nIniciais: "+key+" Contato: "+listaHashMap.get(key).toString();
		}

		return lista;
	}

	public int numeroDeContatos() {
		return listaDosContatos.size();
	}
	
	public int numeroDeContatosDoHashMap() {
		return listaHashMap.size();
	}

}
