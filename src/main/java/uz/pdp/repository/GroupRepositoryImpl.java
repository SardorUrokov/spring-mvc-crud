package uz.pdp.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import uz.pdp.entity.Group;
import uz.pdp.entity.Student;

import java.util.List;

public class GroupRepositoryImpl implements GroupRepository {
    //bazaga ulanish xosil qilib beradigan
    JdbcTemplate jdbcTemplate;

    public GroupRepositoryImpl(DriverManagerDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int create(Group group) {
        try {
            return jdbcTemplate.update("insert into groups (name,sinfId) values (?,?)",
                    group.getName(),
                    group.getSinfId());

        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<Group> read() {
        return jdbcTemplate.query("select * from groups order by id", BeanPropertyRowMapper.newInstance(Group.class));
    }

    @Override
    public Group findGroupById(int groupId) {
        return jdbcTemplate.queryForObject("SELECT * FROM groups WHERE id=?", BeanPropertyRowMapper.newInstance(Group.class), groupId);
    }

    @Override
    public int update(Group group) {
        return jdbcTemplate.update("UPDATE groups SET name=?, sinfId=? WHERE id=?",
                group.getName(),
                group.getSinfId(),
                group.getId());
    }

    @Override
    public int delete(int groupId) {
        return jdbcTemplate.update("DELETE FROM groups WHERE id=?", groupId);
    }
}
