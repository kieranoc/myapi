package ie.bwc.myapi.models;

/**
 * 
 * @author Kieran
 *
 */
public class SocketPayload {
	
	private String content;

	/**
	 * 
	 */
	public SocketPayload() {
	}

	/**
	 * 
	 * @param content
	 */
	public SocketPayload(String content) {
		super();
		this.content = content;
	}

	/**
	 * 
	 * @return
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

}