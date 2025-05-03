package service;

import dao2.ClubDao;
import entities.Club;
import java.util.List;

public class ClubService {

    private final ClubDao clubDao;

    public ClubService() {
        this.clubDao = new ClubDao();
    }

    public List<Club> findAll() {
        return clubDao.findAll();
    }

    public void create(Club club) {
        clubDao.create(club);
    }

    public void update(Club club) {
        clubDao.update(club);
    }

    public void delete(Club club) {
        clubDao.delete(club);
    }

    public Club findById(int id) {
        return clubDao.findById(id);
    }
}
