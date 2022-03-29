package bebeShare.domain.code;

import bebeShare.web.dto.CodeResponseDto;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.query.Param;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Rollback(false)
public class CodeRepositoryTest {
    @Autowired
    CodeRepository codeRepository;

    @Test
    public void find_code(){
        //given
        String testCode = "100";
        
        codeRepository.save( Code.builder()
                .id(123L)
                .code(testCode)
                .codeName("전자기기")
                .useYn("Y")
                .build()
        );


        //when
        List<CodeResponseDto> code = codeRepository.lookup(testCode);

        //then
        assertThat(code.get(0).getCode()).isEqualTo("100");
    }

}
