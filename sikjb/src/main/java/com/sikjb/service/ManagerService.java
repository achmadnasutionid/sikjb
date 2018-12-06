package com.sikjb.service;

import com.sikjb.model.Manager;

import java.util.List;

public interface ManagerService {

    List<Manager> listManager();

    Manager saveOrUpdate(Manager manager);

    Manager getManagerById(Long managerId);

    void deleteManager(Long managerId);

}
