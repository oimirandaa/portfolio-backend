package dev.oscarmiranda.portfolio.backend.mapper;

import dev.oscarmiranda.portfolio.backend.dto.ContactDTO;
import dev.oscarmiranda.portfolio.backend.entity.Contact;

public class ContactMapper {
    public static ContactDTO contactToContactDTO(Contact contact) {
        return new ContactDTO(
                contact.getId(),
                contact.getName(),
                contact.getEmail(),
                contact.getMessage()
        );
    }

    public static Contact contactDTOToContact(ContactDTO contactDTO) {
        return new Contact(
                contactDTO.id(),
                contactDTO.name(),
                contactDTO.email(),
                contactDTO.message()
        );
    }
}
