package kg.megacom.apiadminservice.models;

import lombok.Data;

@Data
public class Role {

    private Long id;
    private String name;
    private boolean is_active;
}
