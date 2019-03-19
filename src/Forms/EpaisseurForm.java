package Forms;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import Dao.ContinueJumelleDao;
import Dao.ContinueSimpleDao;
import Dao.IsostatiqueJumelleDao;
import Dao.IsostatiqueSimpleDao;


public class EpaisseurForm {
	
	private static final String CHAMP_CHARGE  = "charge";
	private static final String CHAMP_PORTEE  = "portee";
	private static final String CHAMP_ERROR_PORTEE = "erreur_portee";

	private IsostatiqueSimpleDao      isostatiqueSimpleDao;
	private IsostatiqueJumelleDao      isostatiqueJumelleDao;
	private ContinueSimpleDao      continueSimpleDao;
	private ContinueJumelleDao      continueJumelleDao;
	private Map<String, String> erreurs      = new HashMap<String, String>();
	private ArrayList<ArrayList<ArrayList<Integer>>> resultat;

	public EpaisseurForm(IsostatiqueSimpleDao isostatiqueSimpleDao, IsostatiqueJumelleDao isostatiqueJumelleDao,
			ContinueSimpleDao continueSimpleDao, ContinueJumelleDao continueJumelleDao) {
		super();
		this.isostatiqueSimpleDao = isostatiqueSimpleDao;
		this.isostatiqueJumelleDao = isostatiqueJumelleDao;
		this.continueSimpleDao = continueSimpleDao;
		this.continueJumelleDao = continueJumelleDao;
		this.resultat = new ArrayList<ArrayList<ArrayList<Integer>>>();
	}
	
	
	public ArrayList<ArrayList<ArrayList<Integer>>> calculerEpaisseur(HttpServletRequest request){
		
		String charge = getValeurChamp( request, CHAMP_CHARGE );
    	
	    try {
	    	float portee = Float.parseFloat(getValeurChamp(request, CHAMP_PORTEE));
	    
		int numeroCharge = chargeColumn(charge);
		
		resultat.add(isostatiqueSimpleDao.calculerEpaisseur(portee, numeroCharge));
		resultat.add(isostatiqueJumelleDao.calculerEpaisseur(portee, numeroCharge));
		resultat.add(continueSimpleDao.calculerEpaisseur(portee, numeroCharge));
		resultat.add(continueJumelleDao.calculerEpaisseur(portee, numeroCharge));
		// Bunch of sql querys like isostatiquesimple(epaisseurx,epaisseury,numerocharge)
	    }
	    catch(NumberFormatException e) {
    		setErreur( CHAMP_ERROR_PORTEE, "Entrer un nombre valide" );
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
	

	
	private int chargeColumn(String charge) {
		switch (charge) {
    	case "150": return 0; 
    	case "250" : return 1; 
    	case "400" : return 2; 
    	case "500" :return 3; 
    	case "150/T" :return 4; 
    	case "100/T": return 5; 
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
