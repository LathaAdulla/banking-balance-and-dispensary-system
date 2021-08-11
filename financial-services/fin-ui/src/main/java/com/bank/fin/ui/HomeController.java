package com.bank.fin.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

//    @Autowired
//    private ClientRepository clientRepository;

    /*This will display home screen with all available services and list clients
    * Note: Providing option to select client as the client id receiving from ATM is out of scope */
    @RequestMapping(value = {"/home", "/"})
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("services", ServiceType.values());
//        mv.addObject("clients", clientRepository.findAll());
        return mv;
    }

}
