package dev.oscarmiranda.portfolio.backend.controller;

import dev.oscarmiranda.portfolio.backend.dto.ContactDTO;
import dev.oscarmiranda.portfolio.backend.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/contacts")
@RestController
public class ContactController {
    ContactService contactService;
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<ContactDTO> createContact(@RequestBody ContactDTO contactDTO) {
        return new ResponseEntity<>(contactService.createContact(contactDTO), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable long id){
        ContactDTO contactDTO = contactService.getContactById(id);

        return ResponseEntity.ok(contactDTO);
    }

    @GetMapping("/allContacts")
    public ResponseEntity<List<ContactDTO>> getAllContacts(){
        List<ContactDTO> contacts = contactService.findAllContacts();
        return ResponseEntity.ok(contacts);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContactById(@PathVariable long id){
        contactService.deleteContact(id);

        return ResponseEntity.ok("Contact Deleted Successfully");
    }
}
