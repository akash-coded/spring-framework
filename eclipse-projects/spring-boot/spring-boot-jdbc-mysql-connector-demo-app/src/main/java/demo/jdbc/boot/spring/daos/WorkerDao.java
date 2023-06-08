/**
 * 
 */
package demo.jdbc.boot.spring.daos;

import java.sql.SQLException;
import java.util.List;

import demo.jdbc.boot.spring.models.Worker;

/**
 * @author Akash
 *
 */
public interface WorkerDao {
	// Create Operation
	Integer createWorker(Worker worker) throws SQLException;
	
	// Read/Retrieve Operations
	Worker findWorkerById(Integer id) throws SQLException;
	List<Worker> findAllWorkers() throws SQLException;
	
	// Update Operations
	Integer updateWorker(Worker worker) throws SQLException;
	Integer updateSalaryByDepartment(String department, Integer bonusFactor) throws SQLException;
	
	// Delete Operations
	Integer deleteWorkerById(Integer id) throws SQLException;	
}
