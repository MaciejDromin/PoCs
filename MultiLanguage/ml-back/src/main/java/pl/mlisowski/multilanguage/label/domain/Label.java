package pl.mlisowski.multilanguage.label.domain;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "uuid")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    private String uuid = UUID.randomUUID().toString();

    @Column
    private String lang;

    @Column
    private String code;

    @Column
    private String content;

}
