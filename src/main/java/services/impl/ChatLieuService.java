package services.impl;

import java.util.List;
import models.ChatLieu;
import repositories.ChatLieuRepository;
import services.IChatLieuService;

/**
 *
 * @author cvdoa
 */
public class ChatLieuService implements IChatLieuService {

    private ChatLieuRepository repo = new ChatLieuRepository();

    @Override
    public List<ChatLieu> getListSize() {
        return repo.getAll();
    }

    @Override
    public boolean save(ChatLieu cl) {
        return repo.save(cl);
    }

    @Override
    public boolean delete(ChatLieu cl) {
        return repo.delete(cl);
    }

    @Override
    public ChatLieu getObject(String ma) {
        return repo.getObj(ma);
    }

    @Override
    public List<ChatLieu> getSearch(String ten) {
        return repo.findByName(ten);
    }
    
    @Override
    public ChatLieu getObjById(int id) {
        return repo.getObjById(id);
    }

    @Override
    public List<ChatLieu> pagination( int pageNumber, int pageSize, String ten) {
        return repo.pagination( pageNumber, pageSize, ten);
    }

    
}
