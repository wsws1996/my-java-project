package org.wang.springmvc.student.pojo;

import java.util.List;

public class UserVo {
	private Student student;

	private List<StudentScore> scores;

	public List<StudentScore> getScores() {
		return scores;
	}

	public void setScores(List<StudentScore> scores) {
		this.scores = scores;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
