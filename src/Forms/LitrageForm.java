package Forms;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;




public class LitrageForm {
	
	
	public static final String CHAMP_EPAISSEUR = "epaisseur";
	public static final String CHAMP_SUPERFICIE = "superficie";
	private static final String CHAMP_ERREUR = "erreur";
	private Map<String, String> erreurs      = new HashMap<String, String>();
	private float resultat;
	
	
	public float calculerLitrage(HttpServletRequest request){
	    try {
	    	float epaisseur = Float.parseFloat(getValeurChamp(request, CHAMP_EPAISSEUR));
	    	float superficie = Float.parseFloat(getValeurChamp(request, CHAMP_SUPERFICIE));
	    		resultat = (epaisseur/100)*superficie;
	    	
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
	
	
	private void setErreur( String champ, String message ) {
	    erreurs.put( champ, message );
	}
	public Map<String, String> getErreurs() {
	    return erreurs;
	}

}
