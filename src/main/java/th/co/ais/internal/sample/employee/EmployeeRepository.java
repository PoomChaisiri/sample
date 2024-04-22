package th.co.ais.internal.sample.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {


    @Query(value = "select e.emp_id ,e.emp_name ,min(t.timestamp) AS FIRST_TIMESTAMP, max(t.timestamp) AS LAST_TIMESTAMP  from test_employee e join test_timestamp t on e.EMP_ID = t.EMP_ID group by e.emp_id ,e.emp_name order by e.emp_id ", nativeQuery = true)
    List<Object> findEmployeeWithTimestamp();

}
