package mk.ukim.finki.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private double popularityScore;
    @OneToOne
    private Location location;
    public Event(String name, String description, double popularityScore,Location location) {
        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.location = location;
    }

}
