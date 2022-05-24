package javaOOP;

import lombok.Getter;
import lombok.Setter;

public class Topic_06_Getter_Setter {
	// Kiểm tra/ validate dữ liệu được
	private String personName;
	private int personAge;
	private int personPhone;

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		if (personName == null || personName.isEmpty()) {
			throw new IllegalArgumentException("Tên nhập vào không đc bỏ trống !!");
		} else {
			this.personName = personName;
		}
	}

	public int getPersonAge() {
		return personAge;
	}

	public void setPersonAge(int personAge) {
		if (personAge > 15 && personAge < 60) {
			throw new IllegalArgumentException("Nhập tuổi ko đúng!!");
		} else {
			this.personAge = personAge;
		}
	}

	public int getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(int personPhone) {
		if(!String.valueOf(personPhone).startsWith("0")) {
			throw new IllegalArgumentException("Số điện thoại ko đúng !!");
		}else {
			this.personPhone = personPhone;
		}
	}

}
