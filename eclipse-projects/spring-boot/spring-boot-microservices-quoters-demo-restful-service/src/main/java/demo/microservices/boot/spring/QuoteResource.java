/**
 * 
 */
package demo.microservices.boot.spring;

import java.util.Objects;

/**
 * @author Akash
 *
 */
public class QuoteResource {
	
	private String type;
	private Quote value;
	
	QuoteResource(Quote value, String type) {
		this.value = value;
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Quote getValue() {
		return value;
	}

	public void setValue(Quote value) {
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(type, value);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof QuoteResource))
			return false;
		QuoteResource that = (QuoteResource) o;
		return Objects.equals(type, that.type) && Objects.equals(value, that.value);
	}

	@Override
	public String toString() {
		return "QuoteResource{" + "type='" + type + '\'' + ", value=" + value + '}';
	}

}
