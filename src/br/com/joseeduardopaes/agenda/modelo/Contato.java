package br.com.joseeduardopaes.agenda.modelo;

public class Contato implements Comparable<Contato> {
	private String primeiroNome;
	private String ultimoNome;
	private String numeroDeTelefone;
	private String eMail;

	public Contato(String primeiroNome, String segundoNome, String numeroDeTelefone, String eMail) {
		this.primeiroNome = primeiroNome;
		this.ultimoNome = segundoNome;		
		this.numeroDeTelefone = numeroDeTelefone;
		this.eMail = eMail;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getNumeroDeTelefone() {
		return numeroDeTelefone;
	}

	public void setNumeroDeTelefone(String numeroDeTelefone) {
		this.numeroDeTelefone = numeroDeTelefone;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	@Override
	public String toString() {
		return "Nome: "+this.getPrimeiroNome()+" "+this.getUltimoNome()+" Telefone: "+this.getNumeroDeTelefone()+" E-mail: "+this.geteMail()+"";
	}

	@Override
	public int compareTo(Contato outroContato) {
		return this.primeiroNome.compareToIgnoreCase(outroContato.primeiroNome);
	}


	public boolean equals(Contato outroContato) {
		return this.getPrimeiroNome().equals(outroContato.getPrimeiroNome()) && this.getUltimoNome().equals(outroContato.getUltimoNome());
	}
}
