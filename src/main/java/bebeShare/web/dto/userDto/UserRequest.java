package bebeShare.web.dto.userDto;

import bebeShare.domain.common.PageEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UserRequest extends PageEntity {

    private Long memberId;
    private String productStatus;

}
