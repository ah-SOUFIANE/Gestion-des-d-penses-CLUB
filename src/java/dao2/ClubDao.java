package dao2;

import entities.Club;

public class ClubDao extends AbstractDao<Club> {
    public ClubDao() {
        super(Club.class);
    }

    // 🔍 Méthode personnalisée possible :
    // public Club findByNom(String nom) { ... }

    
}
