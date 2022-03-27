package bebeShare.domain.code;

import bebeShare.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Code extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "codeId")
    private Long id;

    private String code;

    private String codeName;

    private String useYn;
}
