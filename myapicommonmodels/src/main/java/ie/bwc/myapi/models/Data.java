package ie.bwc.myapi.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.base.MoreObjects;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @author Kieran
 *
 */
@JsonRootName(value = "outer")
@JsonIgnoreProperties({ "id" })
@JsonInclude(Include.NON_NULL)
public class Data {
	
	private Integer id;
	private String something;
	private LocalDateTime timestamp;
	
	public Data() {}
	
	/**
	 * 
	 * @param id
	 * @param something
	 * @param timestamp
	 */
	public Data(Integer id, String something, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.something = something;
		this.timestamp = timestamp;
	}
	
	/**
	 * 
	 * @param builder
	 */
	private Data(Builder builder) {
		this.id = builder.id;
		this.something = builder.something;
		this.timestamp = builder.timestamp;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * @return
	 */
	public String getSomething() {
		return something;
	}

	/**
	 * 
	 * @return
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).toString();
	}

	/**
	 * Creates builder to build {@link Data}.
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link Data}.
	 */
	public static final class Builder {
		private Integer id;
		private String something;
		private LocalDateTime timestamp;

		/**
		 * 
		 */
		private Builder() {
		}

		/**
		 * 
		 * @param id
		 * @return
		 */
		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}

		/**
		 * 
		 * @param something
		 * @return
		 */
		public Builder withSomething(String something) {
			this.something = something;
			return this;
		}

		/**
		 * 
		 * @param timestamp
		 * @return
		 */
		public Builder withTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		/**
		 * 
		 * @return
		 */
		public Data build() {
			return new Data(this);
		}
	}
	
}