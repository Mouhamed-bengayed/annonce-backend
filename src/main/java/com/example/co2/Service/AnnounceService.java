package com.example.co2.Service;

import com.example.co2.Dao.AnnounceRepository;
import com.example.co2.Entite.Announce;
import com.example.co2.Entite.Userco2;
import com.example.co2.Service.ServiceImpl.AnnounceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AnnounceService implements AnnounceServiceImpl {
    @Autowired
    AnnounceRepository messageRepository;
    @Autowired
    UserService userService;

    public Announce addMessage(Announce m1){
        Optional<Userco2> userco2=userService.getCurrentUser();
        if (userco2.isPresent()) {
            Announce m=new Announce();
            m.setUserco2(userco2.get());
           m.setAnnce(m1.getAnnce());
           messageRepository.save(m1);
            return m1;
        }
        else {
            return null;
        }
    }

    public List<Announce> gettAllMessage(){
      return   messageRepository.findAll();
    }

    public List<Announce> getMessageByUser(long id){
        return messageRepository.findAllByUserco2Id(id);
    }
}
