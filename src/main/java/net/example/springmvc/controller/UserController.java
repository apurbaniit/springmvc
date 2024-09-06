package net.example.springmvc.controller;

import net.example.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping(value ="/addUser" ,method = RequestMethod.POST)
    public String addUser(@ModelAttribute("SpringWeb") User user, ModelMap modelmap){
        modelmap.addAttribute("username",user.getUsername());
        modelmap.addAttribute("password",user.getPassword());
        modelmap.addAttribute("address",user.getAddress());
        modelmap.addAttribute("receivePaper",user.isReceivePaper());
        modelmap.addAttribute("favoriteFrameworks",user.getFavoriteFrameworks());
        modelmap.addAttribute("gender",user.getGender());
        modelmap.addAttribute("favoriteNumber",user.getFavoriteNumber());
        modelmap.addAttribute("country",user.getCountry());

        return "users";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView user() {
        User user = new User();
        user.setFavoriteFrameworks((new String []{"Spring MVC","Spring Boot"}));
        user.setGender("M");
        ModelAndView modelAndView = new ModelAndView("user", "command", user);
        return modelAndView;
    }

    @ModelAttribute("webFrameworkList")
    public Object[] getWebFrameworkList() {
        List<String> webFrameworkList = new ArrayList<String>();
        webFrameworkList.add("Spring MVC");
        webFrameworkList.add("Struts 1");
        webFrameworkList.add("Spring Boot");
        webFrameworkList.add("Apache Tomcat");
        return webFrameworkList.toArray();
    }

    @ModelAttribute("numbersList")
    public List<String> getNumbersList() {
        List<String> numbersList = new ArrayList<String>();
        numbersList.add("1");
        numbersList.add("2");
        numbersList.add("3");
        numbersList.add("4");
        return numbersList;
    }

    @ModelAttribute("countryList")
    public Map<String, String> getCountryList() {
        Map<String, String> countryList = new HashMap<String, String>();
        countryList.put("US", "United States");
        countryList.put("CH", "China");
        countryList.put("SG", "Singapore");
        countryList.put("MY", "Malaysia");
        return countryList;
    }

}
