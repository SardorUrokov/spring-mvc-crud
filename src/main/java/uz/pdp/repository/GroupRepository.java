package uz.pdp.repository;

import uz.pdp.entity.Group;
import uz.pdp.entity.Student;

import java.util.List;

public interface GroupRepository {

    public int create(Group group);

    public List<Group> read();

    public Group findGroupById(int groupId);

    public int update(Group group);

    public int delete(int groupId);
}
