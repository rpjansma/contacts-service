package com.amdocs.contactservice.repository;

import com.amdocs.contactservice.entity.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, Long> {

    List<Contacts> findByUserId(Long userId);
}
