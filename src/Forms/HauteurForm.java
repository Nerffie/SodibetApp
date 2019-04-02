package Forms;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;




public class HauteurForm {
	
	private static final String CHAMP_HSPB  = "hspb";
	private static final String CHAMP_FP  = "fp";
	private static final String CHAMP_GAINE = "gaine";
	private static final String CHAMP_ERREUR_TYPE = "erreur_type";
	private static final String CHAMP_ERREUR_CONDITION = "erreur_condition";
	
	
	
	private Map<String, String> erreurs      = new HashMap<String, String>();
	private float resultat;
	
	
	public float calculerHauteur(HttpServletRequest request){
	    try {
	    	float hspb = Float.parseFloat(getValeurChamp(request, CHAMP_HSPB));
	    	float gaine = Float.parseFloat(getValeurChamp(request, CHAMP_GAINE));
	    	float fp = Float.parseFloat(getValeurChamp(request, CHAMP_FP));
	    	if (!(fp>=gaine+5)) {
	    		setErreur( CHAMP_ERREUR_CONDITION, "Veuillez vérifier la condition FP>=G+5" );
	    	}
	    	else{
	    		resultat = hspb-fp;
	    	}
	    }	
	    	catch(NumberFormatException e) {
    		setErreur( CHAMP_ERREUR_TYPE, "Veuillez entrer des nombres valides" );
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
