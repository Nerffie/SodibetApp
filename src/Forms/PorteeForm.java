package Forms;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import Dao.ContinueJumelleDao;
import Dao.ContinueSimpleDao;
import Dao.IsostatiqueJumelleDao;
import Dao.IsostatiqueSimpleDao;


public class PorteeForm {
	
	private static final String CHAMP_CHARGE  = "charge";
	private static final String CHAMP_EPAISSEUR_X  = "epaisseurX";
	private static final String[] CHAMP_EPAISSEUR_Y  = {"epaisseurY12","epaisseurY16","epaisseurY20","epaisseurY25","epaisseurY30"};

	private IsostatiqueSimpleDao      isostatiqueSimpleDao;
	private IsostatiqueJumelleDao      isostatiqueJumelleDao;
	private ContinueSimpleDao      continueSimpleDao;
	private ContinueJumelleDao      continueJumelleDao;
	
	private ArrayList<Float> resultat;

	public PorteeForm(IsostatiqueSimpleDao isostatiqueSimpleDao, IsostatiqueJumelleDao isostatiqueJumelleDao,
			ContinueSimpleDao continueSimpleDao, ContinueJumelleDao continueJumelleDao) {
		super();
		this.isostatiqueSimpleDao = isostatiqueSimpleDao;
		this.isostatiqueJumelleDao = isostatiqueJumelleDao;
		this.continueSimpleDao = continueSimpleDao;
		this.continueJumelleDao = continueJumelleDao;
		this.resultat = new ArrayList<Float>();
	}
	
	
	public ArrayList<Float> calculerPortee(HttpServletRequest request){
		
		String charge = getValeurChamp( request, CHAMP_CHARGE );
	    int epaisseurX = Integer.parseInt(getValeurChamp( request, CHAMP_EPAISSEUR_X ));
	    int epaisseurY = getEpaisseurY(epaisseurX,request);
	    
		int numeroCharge = chargeColumn(charge);
		System.out.println("epaisseur X : "+epaisseurX+", epaisseur Y : "+epaisseurY+", charge "+numeroCharge);
	    
		resultat.add(isostatiqueSimpleDao.calculerPortee(epaisseurX, epaisseurY, numeroCharge));
		resultat.add(isostatiqueJumelleDao.calculerPortee(epaisseurX, epaisseurY, numeroCharge));
		resultat.add(continueSimpleDao.calculerPortee(epaisseurX, epaisseurY, numeroCharge));
		resultat.add(continueJumelleDao.calculerPortee(epaisseurX, epaisseurY, numeroCharge));
		System.out.println(isostatiqueSimpleDao.calculerPortee(epaisseurX, epaisseurY, numeroCharge));
		System.out.println(isostatiqueJumelleDao.calculerPortee(epaisseurX, epaisseurY, numeroCharge));
		System.out.println(continueSimpleDao.calculerPortee(epaisseurX, epaisseurY, numeroCharge));
		System.out.println(continueJumelleDao.calculerPortee(epaisseurX, epaisseurY, numeroCharge));
		
	
		// Bunch of sql querys like isostatiquesimple(epaisseurx,epaisseury,numerocharge)
		
		
		return resultat;
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

}
