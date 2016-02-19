package cn.wang.validators;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class StrongPasswordValidator extends FieldValidatorSupport {
	private boolean trim = true;

	public boolean isTrim() {
		return trim;
	}

	public void setTrim(boolean trim) {
		this.trim = trim;
	}

	@Override
	public void validate(Object object) throws ValidationException {
		String fieldName = getFieldName();
		Object value = this.getFieldValue(fieldName, object);

		if (!(value instanceof String)) {
			addFieldError(fieldName, object);
		} else {
			String s = (String) value;

			if (trim) {
				s = s.trim();
			}

			if (!passwordIsStrong(s)) {
				addFieldError(fieldName, object);
			}
		}
	}

//	private static final String GROUP1 = "abcdefghijklmnopqrstuvwxyz";
//	private static final String GROUP2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//	private static final String GROUP3 = "0123456789";

	private boolean passwordIsStrong(String password) {
		boolean ok1 = false;
		boolean ok2 = false;
		boolean ok3 = false;
		for (char c : password.toCharArray()) {
			if (Character.isLowerCase(c)) {
				ok1 = true;
				continue;
			}
			if (Character.isUpperCase(c)) {
				ok2 = true;
				continue;
			}
			if (Character.isDigit(c)) {
				ok3 = true;
				continue;
			}
		}
		return ok1 && ok2 && ok3;
	}
}
