/**
 * 
 */
package demo.jdbc.boot.spring.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.jdbc.boot.spring.daos.WorkerDao;
import demo.jdbc.boot.spring.models.Worker;

/**
 * @author Akash
 *
 */
@Service
public class WorkerService {
	private WorkerDao workerRepository;
	
	@Autowired
	WorkerService(WorkerDao workerRepository) {
		this.workerRepository = workerRepository;
	}
	
	public Boolean addWorker(Worker worker) throws SQLException {
		Integer recordsInserted = this.workerRepository.createWorker(worker);
		
		return recordsInserted > 0;
	}
	
	public Worker getWorker(Integer id) throws SQLException {
		return this.workerRepository.findWorkerById(id);
	}
	
	public List<Worker> getAllWorkers() throws SQLException {
		return this.workerRepository.findAllWorkers();
	}
	
	public Boolean updateWorker(Integer id, Worker updatedWorker) throws SQLException {
		Worker worker = this.workerRepository.findWorkerById(id);
		worker.setDepartment(updatedWorker.getDepartment());
		Integer recordsUpdated = this.workerRepository.updateWorker(worker);
		
		return recordsUpdated > 0;
	}
	
	public Boolean deleteWorker(Integer id) throws SQLException {
		Integer recordsDeleted = this.workerRepository.deleteWorkerById(id);
		
		return recordsDeleted > 0;
	}
}
