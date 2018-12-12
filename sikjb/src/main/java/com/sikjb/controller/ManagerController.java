package com.sikjb.controller;

import com.sikjb.model.Manager;
import com.sikjb.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ManagerController {

    private ManagerService managerService;

    @Autowired
    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }

    @RequestMapping("/manager")
    public String showManagerList(Model model) {
        model.addAttribute("manager", managerService.listManager());
        return "list/manager";
    }

    @RequestMapping(value = "/manager/create", method = RequestMethod.GET)
    public String showFormManager(Model model) {
        model.addAttribute("manager", new Manager());
        return "form/formManager";
    }

    @RequestMapping(value = "/manager/create", method = RequestMethod.POST)
    public String saveFormManager(Model model, Manager manager) {
        model.addAttribute("manager", managerService.saveOrUpdate(manager));
        return "redirect:/manager";
    }

    @RequestMapping(value = "/manager/edit/{managerId}", method = RequestMethod.GET)
    public String showFormEditManager(Model model, @PathVariable Long managerId) {
        model.addAttribute("manager", managerService.getManagerById(managerId));
        return "form/formManager";
    }

    @RequestMapping(value = "/manager/delete/{managerId}", method = RequestMethod.GET)
    public String deleteOneManager(@PathVariable Long managerId) {
        managerService.deleteManagerById(managerId);
        return "redirect:/manager";
    }
}
