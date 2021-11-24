package com.gmail.kutepov89.sergey;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Group {
	private String name;
	private ArrayList<Student> students = new ArrayList<Student>();

	public Group(String name, ArrayList<Student> students) {
		super();
		this.name = name;
		this.students = students;
	}

	public Group(String name) {
		super();
		this.name = name;
	}

	public Group() {
		super();
	}

	public void add(Student student) {
		for (int i = 0;; i += 1) {
			try {
				if (students.size() > 9) {
					throw new FullGroupException();
				}
				students.add(student);
				break;
			} catch (FullGroupException e) {
				System.err.println(e.getMessage());
				break;
			}
		}
	}

	public String del(String lastName) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i) != null && students.get(i).getLastName().equalsIgnoreCase(lastName)) {
				String st = students.get(i).getLastName();
				students.remove(i);
				return "студент " + st + " удален";
			}
		}
		return "Такого студента нет в списке";
	}

	public Student searchByLastName(String lastName) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i) != null && students.get(i).getLastName().equalsIgnoreCase(lastName)) {
				return students.get(i);
			}
		}
		return null;
	}

	public void saveListStudentsToFile(String fileName) {
		String res = "";
		StringBuilder stringBuilder = new StringBuilder();
		Collections.sort(students, new StudentLastNameComparator());

		for (Student s : students) {
			if (s != null) {
				stringBuilder
						.append(s.getLastName() + " " + s.getFirstName() + " " + s.getPatronymic() + " " + s.getAge())
						.append("\n");
			}
		}
		res = stringBuilder.toString();

		try (PrintWriter a = new PrintWriter(fileName)) {
			a.println(res);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR FILE WRITE");
		}
	}

	public void readListStudentsFromFile(String fileName, Group group) {
		try (BufferedReader f = new BufferedReader(new FileReader(fileName))) {
			String str = "";
			for (; (str = f.readLine()) != null;) {
				if (!str.isEmpty()) {
					String[] student = str.split(" ");
					Student st = new Student(student[0], student[1], student[2], Integer.parseInt(student[3]), true, 1);
					group.add(st);
				}
			}
		} catch (IOException e) {
			System.out.println("ERROR");
		}
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		Collections.sort(students, new StudentLastNameComparator());

		stringBuilder.append("\n");
		stringBuilder.append("Group name: " + name);
		stringBuilder.append("\n");
		for (Student s : students) {
			if (s != null) {
				stringBuilder.append(s.getLastName() + " " + s.getFirstName() + " (age: " + s.getAge() + ")")
						.append("\n");
			}
		}
		stringBuilder.append("\n");

		return stringBuilder.toString();
	}

}