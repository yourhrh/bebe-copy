package bebeShare.web.dto;

import bebeShare.domain.code.Code;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class CodeResponseDto {
    private Long codeId;
    private String code;
    private String codeName;
    private String useYn;
    private LocalDateTime insertDt;

    public CodeResponseDto(Code code) {
        this.codeId = code.getId();
        this.code = code.getCode();
        this.codeName = code.getCodeName();
        this.useYn = code.getUseYn();
        this.insertDt = code.getCreatedDate();
    }
}
