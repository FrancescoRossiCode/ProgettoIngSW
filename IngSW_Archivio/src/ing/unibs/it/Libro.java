package ing.unibs.it;

import java.io.Serializable;


import java.util.ArrayList;
import java.util.GregorianCalendar;
import util.Unibs.MyUtil;

public class Libro  extends Risorsa implements Serializable, Loanable {
	
	public static final int GIORNI_DURATA_PRESTITO = 30;
	/**
	 *  durata proroga del prestito di un Libro
	 */
	public static final int GIORNI_DURATA_PROROGA = 30;
	
	/**
	 *da che giorno e'possibile chiedere la proroga del prestito del Libro
	 */
	public static final int GIORNI_PRIMA_PER_PROROGA = -5;
	
	/**
	 * quanti Libri possono essere in prestito contemporaneamente dalla stessa persona
	 */
	public static final int PRESTITI_MAX = 3;
	
	private static final long serialVersionUID = -4579943601571388630L;
	private String nome;
	private int codiceUnivoco;
	private int numLicenze;
	private ArrayList<String>  autori;
	private int numPagine;
	private String casaEd;
	private String genere;
	private GregorianCalendar annoPub;
	private int giaInPrestito;
	
	 /** Costuttore 
	 
	  *@param nLicenze il numero di licenze disponibili
	  *@param nome il titolo del libro
	  *@param autori il array degli autori del libro
	  *@param numPagine il numero di pagine
	  *@param casaEd la casa editrice
	  *@param genere il genere del libro 
	  *@param annoPubblicazione l'anno di pubblicazione
	 
	 */
	public Libro(String nome,int codiceUnivoco, int numLicenze, ArrayList<String>  autori ,int numPagine,
				String casaEd,String genere,GregorianCalendar annoPub) {
		
		this.nome=nome;
		this.codiceUnivoco=codiceUnivoco;
		this.numLicenze=numLicenze;
		this.numPagine=numPagine;
		this.casaEd=casaEd;
		this.genere=genere;
		this.annoPub=annoPub;
		this.autori=autori;
		this.giaInPrestito=0;
	}

	
	@Override
	/**
	 * Stampa della "descrizione" del libro
	 */
	public void stampaDesc() {
		
		//System.out.println(Costanti.CATEGORIA_LIBRO);

		System.out.println(Costanti.TITOLO + getNome());
		System.out.println(Costanti.GENERE+ getGenere());
		System.out.println(Costanti.CODICE+ getCodiceUnivoco());
		System.out.print(Costanti.AUTORI);
		for(int i = 0; i < autori.size(); i++)
		{
			System.out.print(" " + autori.get(i));
			if(i < autori.size()-1)
			{ 
				System.out.print(",");
			}
			else System.out.println();
		}	
		System.out.println(Costanti.CASA_ED+ getCasaEd());
		System.out.println(Costanti.ANNO_PUB+ MyUtil.toStringData(getAnnoPub()));
		//System.out.println(Costanti.LINGUA+ getLingua());
		System.out.println(Costanti.NUM_PAG+ getNumPagine());
		System.out.println(Costanti.NUM_LIC+ getNumLicenze());
		System.out.println("In prestito: " + giaInPrestito);
		System.out.println("Copie disponibili " + (getNumLicenze() - getGiaInPrestito()));
	}
	
	
	//GETTERS & SETTERS
	
	
	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}
	
	
	public ArrayList<String> getAutori() {
		return autori;
	}

	public int getNumLicenze() {
		return numLicenze;
	}


	public void setNumLicenze(int numLicenze) {
		this.numLicenze = numLicenze;
	}


	public void setAutori(ArrayList<String> autori) {
		this.autori = autori;
	}

	public int getNumPagine() {
		return numPagine;
	}

	public void setNumPagine(int numPagine) {
		this.numPagine = numPagine;
	}

	public String getCasaEd() {
		return casaEd;
	}

	public void setCasaEd(String casaEd) {
		this.casaEd = casaEd;
	}

	/*public String getLingua() {
		return lingua;
	}*/

	/*public void setLingua(String lingua) {
		this.lingua = lingua;
	}*/

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public GregorianCalendar getAnnoPub() {
		return annoPub;
	}

	public void setAnnoPub(GregorianCalendar annoPub) {
		this.annoPub = annoPub;
	}


	public int getGiaInPrestito() {
		return giaInPrestito;
	}


	public void setGiaInPrestito(int giaInPrestito) {
		this.giaInPrestito = giaInPrestito;
	}

	
	/**
	 * precondizione: ci sono copie del Libro disponibili per il prestito
	 */
	public void mandaInPrestito() 
	{
		giaInPrestito++;
	}
	
	public void tornaDalPrestito()
	{
		giaInPrestito--;
	}

	@Override
	public int getGiorniDurataPrestito() 
	{
		return Libro.GIORNI_DURATA_PRESTITO;
	}

	@Override
	public int getGiorniDurataProroga() 
	{
		return Libro.GIORNI_DURATA_PROROGA;
	}

	@Override
	public int getGiorniPrimaPerProroga() 
	{
		return Libro.GIORNI_PRIMA_PER_PROROGA;
	}

	@Override
	public int getPrestitiMax() 
	{
		return Libro.PRESTITI_MAX;
	}


	@Override
	public int getCodiceUnivoco() {
		// TODO Auto-generated method stub
		return codiceUnivoco;
	}


	
}
