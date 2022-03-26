package bebeShare.domain.like;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Dibs {

    @Id
    @GeneratedValue
    @Column(name = "likdId")
    private Long Id;

//    private Long productId;

//    private Long memberId;





}
