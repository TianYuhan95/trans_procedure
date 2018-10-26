package com.unicom.first_demo.controller;

import com.unicom.first_demo.entity.Information;
import com.unicom.first_demo.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InformationController {
    @Autowired
    private InformationService informationService;

    @RequestMapping(value = "/index")
    public String index(Model model){
        List<Information> list = informationService.findByAll();
        if(null != list){
            model.addAttribute("procedure",list);
        }
        return "index";
    }
    @RequestMapping(value = "/searchByState")
    public String searchByOwner(@RequestParam(value = "state") String state,Model model){
        List<Information> list = null;
        System.out.println(state);
        if (!("未完成".equals(state) || "进行中".equals(state) || "已完成".equals(state))) {
            /*list = informationService.findByAll();*/
            return "redirect:/index";
        } else {
            list = informationService.findInfoByState(state);
        }
        if(null != list){
            model.addAttribute("procedure",list);
            return  "index";
        }
        else return "redirect:/index";
    }

    @RequestMapping(value= "/updateState",method = RequestMethod.POST)
    public String updateState(@RequestParam(value = "upstate") String upstate, @RequestParam(value = "id") long id) {
        System.out.println("state:"+upstate);
        if (informationService.update_State(upstate, id+1)==1) {
            return "redirect:/index";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/updateInfo",method = RequestMethod.POST)
    public String updateInfo(@RequestParam(value = "comment") String upinfo,@RequestParam(value = "id_2") long id){
        System.out.println(id+":"+upinfo);
        if (informationService.update_Info(upinfo, id+1)==1) {
            return "redirect:/index";
        } else {
            return "error";
        }
    }
}
