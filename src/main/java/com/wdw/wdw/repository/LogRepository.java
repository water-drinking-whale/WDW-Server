package com.wdw.wdw.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class LogRepository {

    private final EntityManager em;

}
