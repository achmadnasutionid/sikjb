package com.sikjb.services;

import com.sikjb.model.*;
import java.util.List;

public interface InventoryService {
		
		List<Inventory> listInventory();
		
		Inventory saveOrUpdate(Inventory inventory);
		
		Inventory getId(Integer id);
		void hapusInventory(Integer id);
		
	}


