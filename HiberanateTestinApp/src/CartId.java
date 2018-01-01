// default package
// Generated 29-Nov-2017 10:44:19 by Hibernate Tools 4.3.5.Final

/**
 * CartId generated by hbm2java
 */
public class CartId implements java.io.Serializable {

	private String code;
	private String name;
	private double qty;

	public CartId() {
	}

	public CartId(String code, String name, double qty) {
		this.code = code;
		this.name = name;
		this.qty = qty;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getQty() {
		return this.qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CartId))
			return false;
		CartId castOther = (CartId) other;

		return ((this.getCode() == castOther.getCode()) || (this.getCode() != null && castOther.getCode() != null
				&& this.getCode().equals(castOther.getCode())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null && castOther.getName() != null
						&& this.getName().equals(castOther.getName())))
				&& (this.getQty() == castOther.getQty());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCode() == null ? 0 : this.getCode().hashCode());
		result = 37 * result + (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result + (int) this.getQty();
		return result;
	}

}