package com.tw.apistackbase.service;

import com.tw.apistackbase.model.MiniPackage;
import com.tw.apistackbase.repository.MiniPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MiniPackageService {

    @Autowired
    private MiniPackageRepository miniPackageRepository;

    public Iterable<MiniPackage> getPackageList(Integer page, Integer pageSize) {
        return miniPackageRepository.findAll(PageRequest.of(page, pageSize, Sort.by("bookingDateTime").ascending()));
    }

    public MiniPackage addMiniPackage(MiniPackage miniPackage) {
        return miniPackageRepository.save(miniPackage);
    }
}
