package uz.pdp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import uz.pdp.repository.*;

@Configuration //bu class nimadr configlarni va qo'shimcha ichida bean ishlata oladi
@ComponentScan("uz.pdp")
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    //front uchun nastroyka web-inf papkadan   .jsp fayllarni qidir degandek
    @Bean
    InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    //baza uchun nastroyka
    @Bean
    DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("root123");
        return dataSource;
    }

    @Bean
    public StudentRepository getStudentDAO() {
        return new StudentRepositoryImpl(getDataSource());
    }

    @Bean
    public GroupRepository getGroupDAO (){
        return new GroupRepositoryImpl(getDataSource());
    }

    @Bean
    public SinfRepository getClassDAO (){
        return new SinfRepositoryImpl(getDataSource());
    }
}
