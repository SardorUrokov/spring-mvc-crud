package uz.pdp.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import uz.pdp.entity.Sinf;

import java.util.List;

public class SinfRepositoryImpl implements SinfRepository {
    //bazaga ulanish xosil qiladi
    JdbcTemplate jdbcTemplate;

    public SinfRepositoryImpl(DriverManagerDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int create(Sinf sinf) {
        try {
            return jdbcTemplate.update("insert into classes (name) values (?)",
                    sinf.getName());
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<Sinf> read() {
        return jdbcTemplate.query("select * from classes order by id",
                BeanPropertyRowMapper.newInstance(Sinf.class));
    }

    @Override
    public Sinf findSinfById(int sinfId) {
        return jdbcTemplate.queryForObject("select * from classes where id=?",
                BeanPropertyRowMapper.newInstance(Sinf.class), sinfId);
    }

    @Override
    public int update(Sinf sinf) {
        return jdbcTemplate.update("update classes set name=? where id=?",
                sinf.getName(),
                sinf.getId());
    }

    @Override
    public int delete(int sinfId) {
        return jdbcTemplate.update("DELETE FROM classes WHERE id=?", sinfId);
    }
}
