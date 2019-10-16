package service.mapper;

import model.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionMapper extends Mapper<Position> {
    List<Position> getAll();
    Position get(Long id);
    void create(Position brand);
    void update(Position brand);
    int delete(Long id);
    List<Position> search(@Param("search") String search);
}
