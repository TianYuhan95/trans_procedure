package com.unicom.first_demo.service;

import com.unicom.first_demo.entity.Information;
import com.unicom.first_demo.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InformationService {
    @Autowired
    private InformationRepository informationRepository;

    public List<Information> findByAll(){
        List<Information> list = null;
        try {
            list = informationRepository.findByAll();
            if (null != list) {
                System.out.println("yes");
                }else System.out.println("null");
            }catch (Exception e){}
        return list;
    }

    public List<Information> findInfoByState(String state) {
        List<Information> list = null;
        try {
              list = informationRepository.findByState(state);
        } catch (Exception e) {
        }
        return list;
    }

    @Transactional
    public int update_State(String state,long id){
        try{
            System.out.println(state);
            informationRepository.update_State(state,id);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Update_State Service Had Exception");
        }
        return -1;
    }

    @Transactional
    public int update_Info(String info,long id){
        try{
            System.out.println(info);
            informationRepository.update_Info(info,id);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Update_Info Service Had Exception");
        }
        return -1;
    }
}
