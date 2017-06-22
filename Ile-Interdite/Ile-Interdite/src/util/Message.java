package util;

import java.io.Serializable;

/**
 *
 * @author IUT2-Dept Info
 */
public class Message implements Serializable {
    private final Utils.Commandes commande ;
    private final String idAventurier ;
    private final String idCarte ;
    private final  Utils.Tresor tresor ;
    private final Integer idTuile ;
    private int nbJoueurs;
    private int difficulte;
    private String nomCarte;
    
    public Message(Utils.Commandes commande, String idAventurier, String idCarte,  Utils.Tresor tresor, Integer idTuile) {
        this.commande = commande ;
        this.idAventurier = idAventurier ;
        this.idCarte = idCarte ;
        this.tresor = tresor ;
        this.idTuile = idTuile ;
    }
    
    public Message(Utils.Commandes commande, String idAventurier, String idCarte,  Utils.Tresor tresor, Integer idTuile, int nbJoueurs, int difficulte) {
        this.commande = commande ;
        this.idAventurier = idAventurier ;
        this.idCarte = idCarte ;
        this.tresor = tresor ;
        this.idTuile = idTuile ;
        this.nbJoueurs = nbJoueurs;
        this.difficulte=difficulte;
    }
    
    public Message(Utils.Commandes commande, String nomCarte){
        this.commande = commande;
        this.nomCarte = nomCarte;
        this.tresor = null;
        this.idAventurier = null;
        this.idCarte = null;
        this.idTuile = null;
    }
    

    /**
     * @return the commande
     */
    public Boolean hasCommande() {
        return commande != null ;
    }
    public Utils.Commandes getCommande() {
        return commande;
    }

    /**
     * @return the idAventurier`
     */
    public Boolean hasIdAventurier() {
        return idAventurier != null ;
    }
    public String getIdAventurier() {
        return idAventurier;
    }

    /**
     * @return the idCarte
     */
    public Boolean hasIdCarte() {
        return idCarte != null ;
    }
    public String getIdCarte() {
        return idCarte;
    }

    /**
     * @return the tresor
     */
    public Boolean hasTresor() {
        return tresor != null ;
    }
    public  Utils.Tresor getTresor() {
        return tresor;
    }

    /**
     * @return the idTuile
     */
    public Boolean hasIdTuile() {
        return idTuile != null;
    }
    public Integer getIdTuile() {
        return idTuile;
    }
    
    @Override
    public String toString() {
        String txt = "" ;
        txt += commande.toString() + " " ;
        if (hasIdAventurier()) {
            txt += " aventurier=" + idAventurier ;
        }
        if (hasIdCarte()) {
            txt += " carte=" + idCarte ;
        }
        if (hasIdTuile()) {
            txt += " tuile=" + idTuile ;
        }
        if (hasTresor()) {
            txt += " tresor=" + tresor.toString() ;
        }
        return txt ;
    }

    public int getNbJoueurs() {
        return nbJoueurs;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public String getNomCarte() {
        return nomCarte;
    }
    
    
}
