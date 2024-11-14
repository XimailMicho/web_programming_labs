package mk.ukim.finki.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private Long id;
    private String name;
    private String address;
    private String capacity;
    private String description;

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" - ").append(address).append(" - ").append(capacity);
        return sb.toString();
    }
}
