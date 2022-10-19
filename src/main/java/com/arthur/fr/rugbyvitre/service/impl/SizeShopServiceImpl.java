package com.arthur.fr.rugbyvitre.service.impl;

import com.arthur.fr.rugbyvitre.model.SizeShop;
import com.arthur.fr.rugbyvitre.repository.SizeRepository;
import com.arthur.fr.rugbyvitre.service.SizeShopService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeShopServiceImpl implements SizeShopService {

    private final SizeRepository sizeRepository;

    public SizeShopServiceImpl(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    @Override
    public List<SizeShop> getAll() {
        return sizeRepository.findAll();
    }

    @Override
    public SizeShop getById(Integer id) {
        return sizeRepository.getReferenceById(id);
    }

}
