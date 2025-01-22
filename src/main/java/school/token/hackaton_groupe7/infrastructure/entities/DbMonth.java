package school.token.hackaton_groupe7.infrastructure.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "month")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DbMonth {
    @Id
    @Column(nullable = false,unique = true)
    public int month;
}
