package com.runningclub.web.service;

import com.runningclub.web.dto.ClubDto;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
}