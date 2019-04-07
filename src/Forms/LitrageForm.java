package Forms;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import Dao.LitrageDao;




public class LitrageForm {
	
	
	//public static final String CHAMP_EPAISSEUR = "epaisseur";
	private static final String CHAMP_EPAISSEUR_X  = "epaisseurX";
	private static final String[] CHAMP_EPAISSEUR_Y  = {"epaisseurY12","epaisseurY16","epaisseurY20","epaisseurY25","epaisseurY30"};
	public static final String CHAMP_SUPERFICIE = "superficie";
	private static final String CHAMP_ERREUR = "erreur";
	private Map<String, String> erreurs      = new HashMap<String, String>();
	private ArrayList<Float> resultat = new ArrayList<Float>();
	
	private LitrageDao litrageDao;
	
	
	
	
	public LitrageForm(LitrageDao litrageDao) {
		super();
		this.litrageDao = litrageDao;
	}

	public ArrayList<Float> calculerLitrage(HttpServletRequest request){
	    try {
	    	int epaisseurX = Integer.parseInt(getValeurChamp( request, CHAMP_EPAISSEUR_X ));
	    	int epaisseurY = getEpaisseurY(epaisseurX,request);
	    	float superficie = Float.parseFloat(getValeurChamp(request, CHAMP_SUPERFICIE));
	    	float consommation = litrageDao.chercherConsommation(epaisseurX, epaisseurY);
	    	resultat.add(consommation * superficie);
	    	resultat.add((float)epaisseurX);
	    	resultat.add((float)epaisseurY);
	    	
	    }	
	    	catch(NumberFormatException e) {
    		setErreur( CHAMP_ERREUR, "Veuillez entrer des nombres valides" );
    	}
		return resultat;
	}
	
	private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
	    String valeur = request.getParameter( nomChamp );
	    if ( valeur == null || valeur.trim().length() == 0 ) {
	        return null;
	    } else {
	        return valeur.trim();
	    }
	}
	
	private int getEpaisseurY(int epaisseurX,HttpServletRequest request) {
		switch(epaisseurX) {
		case 12 : return Integer.parseInt(getValeurChamp(request,CHAMP_EPAISSEUR_Y[0]));
		case 16 : return Integer.parseInt(getValeurChamp(request,CHAMP_EPAISSEUR_Y[1]));
		case 20 : return Integer.parseInt(getValeurChamp(request,CHAMP_EPAISSEUR_Y[2]));
		case 25 : return Integer.parseInt(getValeurChamp(request,CHAMP_EPAISSEUR_Y[3]));
		case 30 : return Integer.parseInt(getValeurChamp(request,CHAMP_EPAISSEUR_Y[4]));
		}
		return 0;
	}
	
	private void setErreur( String champ, String message ) {
	    erreurs.put( champ, message );
	}
	public Map<String, String> getErreurs() {
	    return erreurs;
	}

}
