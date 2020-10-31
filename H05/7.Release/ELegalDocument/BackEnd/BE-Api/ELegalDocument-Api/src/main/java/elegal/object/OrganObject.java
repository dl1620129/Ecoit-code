package elegal.object;

public class OrganObject {
	long id;
	String name;
	String organ;
	String description;
	int position;
	boolean status;
	long parentId;

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrgan() {
		return organ;
	}

	public void setOrgan(String organ) {
		this.organ = organ;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public OrganObject(long id, String name, String organ, String description, int position, boolean status,
			long parentId) {
		super();
		this.id = id;
		this.name = name;
		this.organ = organ;
		this.description = description;
		this.position = position;
		this.status = status;
		this.parentId = parentId;
	}

	public OrganObject() {
		super();
		// TODO Auto-generated constructor stub
	}

}
