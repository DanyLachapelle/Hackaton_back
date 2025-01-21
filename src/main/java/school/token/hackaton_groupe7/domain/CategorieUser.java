package school.token.hackaton_groupe7.domain;

import io.micrometer.common.util.StringUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class CategorieUser {

    private int idUser;
    private String name;
    private double budget;

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setName(String name)
        {if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name cannot be blank");
        if(name.length() > 60)
            throw new IllegalArgumentException("Name cannot be longer than 60 chars");
        this.name = name;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
