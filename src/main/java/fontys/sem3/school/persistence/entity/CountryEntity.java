package fontys.sem3.school.persistence.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CountryEntity {
    private Long id;

    private String name;

    private String code;
}
