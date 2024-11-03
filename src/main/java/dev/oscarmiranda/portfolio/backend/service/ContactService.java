package dev.oscarmiranda.portfolio.backend.service;

import dev.oscarmiranda.portfolio.backend.dto.ContactDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {
    ContactDTO createContact(ContactDTO contactDTO);
    ContactDTO getContactById(long id);
    List<ContactDTO> findAllContacts();
    void deleteContact(long id);
}
