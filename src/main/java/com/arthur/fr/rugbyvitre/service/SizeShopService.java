package com.arthur.fr.rugbyvitre.service;

import com.arthur.fr.rugbyvitre.model.SizeShop;

import java.util.List;

public interface SizeShopService {
    List<SizeShop> getAll();

    SizeShop getById(Integer id);


}
