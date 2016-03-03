package cn.wang.utils;


public class DaoFactory {
	private DaoFactory() {
	}

	private static final DaoFactory instance = new DaoFactory();

	public static DaoFactory getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	public <T> T createDao(String className,Class<T> clazz) {
		try {
			return (T)Class.forName(className).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	// public DepartmentDao createDepartmentDao(String className) {
	// try {
	// return (DepartmentDao) Class.forName(className).newInstance();
	// } catch (Exception e) {
	// throw new RuntimeException(e);
	// }
	// }
	// public TeacherDao createTeacherDao(String className) {
	// try {
	// return (TeacherDao) Class.forName(className).newInstance();
	// } catch (Exception e) {
	// throw new RuntimeException(e);
	// }
	// }
	// public PersonDao createPersonDao(String className) {
	// try {
	// return (PersonDao) Class.forName(className).newInstance();
	// } catch (Exception e) {
	// throw new RuntimeException(e);
	// }
	// }
}
