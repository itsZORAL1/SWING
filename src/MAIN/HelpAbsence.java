package MAIN;

public class HelpAbsence {
	public static  String combo;
	public static  int id_fich;
	public static  String radio;
	public static  String Email;
	public static  String Pass;
	public static String NomComplet;
	public static int CNEAB;
	public HelpAbsence()  {
		
	}
	public void setvalueCombo(String value) {
		this.combo=value;
	}
	public void setvaluePass(String value) {
		this.Pass=value;
	}
	public String getvaluePass() {
		return this.Pass;
	}
	public void setvalueCNE(int value) {
		this.CNEAB=value;
	}
	public int getvalueCNE() {
		return this.CNEAB;
	}
	public void setvalueNomC(String value) {
		this.NomComplet=value;
	}
	public String getvalueNomC() {
		return this.NomComplet;
	}
	public void setvalueId(int value) {
		this.id_fich=value;
	}
	public void setvalueEmail(String value) {
		this.Email=value;
	}
	public String getvalueEmail() {
		return this.Email;
	}
	public void setvalueRadio(String radio) {
		this.radio=radio;
	}
	public int getvalueId() {
		return this.id_fich;
	}
	public String getvalueCombo() {
		return this.combo;
	}
	public String getvalueRadio() {
		return this.radio;
	}
}
