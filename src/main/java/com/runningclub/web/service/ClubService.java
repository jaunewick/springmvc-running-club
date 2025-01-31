package com.runningclub.web.service;

import com.runningclub.web.dto.ClubDto;
import com.runningclub.web.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
    Club saveClub(Club club);

    ClubDto findClubById(long clubId);

    void updateClub(ClubDto club);
}
