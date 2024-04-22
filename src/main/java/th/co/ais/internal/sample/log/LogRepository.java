package th.co.ais.internal.sample.log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository  extends JpaRepository<Log, Long> {

    @Query(value = "SELECT * FROM (SELECT lt.*, ROWNUM r FROM NBL_DAT_QUERY_LOG_LW lt WHERE ROWNUM <= 20) WHERE r > 1", nativeQuery = true)
    List<Log> findAllWithPagination();

}
