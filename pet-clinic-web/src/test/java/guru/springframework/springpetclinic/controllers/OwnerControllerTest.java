package guru.springframework.springpetclinic.controllers;

import guru.springframework.springpetclinic.model.Owner;
import guru.springframework.springpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController ownerController

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        Owner owner = new Owner();
        owner.setId(1l);
        owners.add(owner);
        // for each test method it will setup a mock environment for your controller
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void listOwners() {
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(get("/"));

    }

    @Test
    void findOwners() {
    }
}