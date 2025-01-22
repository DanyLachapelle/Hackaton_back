package school.token.hackaton_groupe7.domain;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CategorieUser {

    private int id;
    private int idUser;
    private String name;
    private double budget;

    /*
    public void setName(String name)
        {if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name cannot be blank");
        if(name.length() > 60)
            throw new IllegalArgumentException("Name cannot be longer than 60 chars");
        this.name = name;
    }
    */
}
