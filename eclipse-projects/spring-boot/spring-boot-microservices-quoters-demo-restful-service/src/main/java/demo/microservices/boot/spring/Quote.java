/**
 * 
 */
package demo.microservices.boot.spring;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Akash
 *
 */
@Entity
public class Quote {

	@Id
	@GeneratedValue
	private Long id;
	private String quote;

	protected Quote() {
	}

	Quote(String quote) {
		this.quote = quote;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, quote);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Quote))
			return false;
		Quote quote1 = (Quote) o;
		return Objects.equals(id, quote1.id) && Objects.equals(quote, quote1.quote);
	}

	@Override
	public String toString() {
		return "Quote{" + "id=" + id + ", quote='" + quote + '\'' + '}';
	}
}
