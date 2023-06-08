/**
 * 
 */
package demo.microservices.boot.spring;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Akash
 *
 */
public interface QuoteRepository extends JpaRepository<Quote, Long> {

}
