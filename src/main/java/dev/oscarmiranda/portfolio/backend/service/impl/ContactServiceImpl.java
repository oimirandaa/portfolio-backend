package dev.oscarmiranda.portfolio.backend.service.impl;

import dev.oscarmiranda.portfolio.backend.dto.ContactDTO;
import dev.oscarmiranda.portfolio.backend.entity.Contact;
import dev.oscarmiranda.portfolio.backend.mapper.ContactMapper;
import dev.oscarmiranda.portfolio.backend.repository.ContactRepository;
import dev.oscarmiranda.portfolio.backend.service.ContactService;


import java.util.List;
import java.util.stream.Collectors;

public class ContactServiceImpl implements ContactService {
    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public ContactDTO createContact(ContactDTO contactDTO) {
        Contact contact = ContactMapper.contactDTOToContact(contactDTO);
        Contact savedContact = contactRepository.save(contact);

        return ContactMapper.contactToContactDTO(savedContact);
    }

    @Override
    public ContactDTO getContactById(long id) {
        Contact contact = contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
        return ContactMapper.contactToContactDTO(contact);
    }

    @Override
    public List<ContactDTO> findAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream()
                .map(ContactMapper::contactToContactDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteContact(long id) {
        contactRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found"));

        contactRepository.deleteById(id);
    }
}
