package com.gmail.kutepov89.sergey;

public class Main {

	public static void main(String[] args) {
		
		Group group = new Group("First group");

		group.add(new Student("Vasya", "Vasiliev", "Davidovich", 21, true, 1));
		group.add(new Student("Alex", "Alexgov", "Alexsandrovich", 32, true, 2));
		group.add(new Student("Serg", "Williams", "Sergeevich", 23, true, 3));
		group.add(new Student("Ben", "Peters", "Petrovich", 24, true, 4));
		group.add(new Student("Tom", "Gibson", "Tomsovich", 19, true, 5));
		group.add(new Student("Andrey", "Martin", "Andreevich", 20, true, 6));
		group.add(new Student("Vitaliy", "Jordan", "Vitalievich", 26, true, 7));
		group.add(new Student("John", "Jackson", "Jonsovich", 31, true, 8));
		group.add(new Student("Oleg", "Grant", "Olegovich", 30, true, 9));
		group.add(new Student("Igor", "Davis", "Igorevich", 22, true, 10));

		System.out.println("Студент, которого удаляем:");
		System.out.println(group.del("Vasiliev"));
		System.out.println();
		
		System.out.println("Студент, которого искали:");
		System.out.println(group.searchByLastName("Williams"));
		System.out.println();

//		group.saveListStudentsToFile("students.txt");
//		group.readListStudentsFromFile("students.txt", group);

		System.out.println(group);

		System.out.println("Студент, которого искали:");
		System.out.println(group.searchByLastName("Gibson"));
		System.out.println();
	}

}