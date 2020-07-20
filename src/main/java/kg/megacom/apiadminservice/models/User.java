package kg.megacom.apiadminservice.models;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String address;

    private Account account;

    private Role role;
}
