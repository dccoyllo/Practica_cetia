package udaff.edu.pe.entities;
// Generated 02-nov-2020 23:35:36 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * LoginId generated by hbm2java
 */
@Embeddable
public class LoginId implements java.io.Serializable {

	private int userId;
	private String userCuenta;
	private String userClave;
	private int userRol;

	public LoginId() {
	}

	public LoginId(int userId, String userCuenta, String userClave, int userRol) {
		this.userId = userId;
		this.userCuenta = userCuenta;
		this.userClave = userClave;
		this.userRol = userRol;
	}

	@Column(name = "user_id", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "user_cuenta", nullable = false, length = 50)
	public String getUserCuenta() {
		return this.userCuenta;
	}

	public void setUserCuenta(String userCuenta) {
		this.userCuenta = userCuenta;
	}

	@Column(name = "user_clave", nullable = false, length = 50)
	public String getUserClave() {
		return this.userClave;
	}

	public void setUserClave(String userClave) {
		this.userClave = userClave;
	}

	@Column(name = "user_rol", nullable = false)
	public int getUserRol() {
		return this.userRol;
	}

	public void setUserRol(int userRol) {
		this.userRol = userRol;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LoginId))
			return false;
		LoginId castOther = (LoginId) other;

		return (this.getUserId() == castOther.getUserId())
				&& ((this.getUserCuenta() == castOther.getUserCuenta()) || (this.getUserCuenta() != null
						&& castOther.getUserCuenta() != null && this.getUserCuenta().equals(castOther.getUserCuenta())))
				&& ((this.getUserClave() == castOther.getUserClave()) || (this.getUserClave() != null
						&& castOther.getUserClave() != null && this.getUserClave().equals(castOther.getUserClave())))
				&& (this.getUserRol() == castOther.getUserRol());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getUserId();
		result = 37 * result + (getUserCuenta() == null ? 0 : this.getUserCuenta().hashCode());
		result = 37 * result + (getUserClave() == null ? 0 : this.getUserClave().hashCode());
		result = 37 * result + this.getUserRol();
		return result;
	}

}
