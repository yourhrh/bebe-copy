package bebeShare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource MS = new ResourceBundleMessageSource();
        MS.setDefaultEncoding("utf-8");
        // 메시지를 관리할 파일 이름 지정
        // messages라고 지정하면 src/main/resources/messages.properties 로 설정
        MS.setBasenames("messages");
        return MS;
    }

}
