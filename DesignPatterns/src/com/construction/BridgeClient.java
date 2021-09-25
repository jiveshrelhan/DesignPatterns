package com.construction;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class BridgeClient {
	public static void main(String[] args) {
		StudentRepository repo = new StudentRepository(new FileStorage());
		repo.save(new Student());
		repo = new StudentRepository(new DataBaseStorage());
		repo.save(new Student());
		
		CourseRepository courseRepo = new CourseRepository(new FileStorage());
		courseRepo.save(new Course());
		courseRepo = new CourseRepository(new DataBaseStorage());
		courseRepo.save(new Course());
	}	
}

class Entity implements Serializable {
	private static final long serialVersionUID = -8886785021312618734L;
	public int id;
	public LocalDate creationDate;
}

class Student extends Entity {
	
	private static final long serialVersionUID = 239093900197332319L;
	
	public String name;
	public String section;
}

class Course extends Entity {
	private static final long serialVersionUID = 3030456075387849965L;
	public String courseName;
	public String specialization;
}

interface BaseRepository {
	public void save(Entity entity);
}

interface StorageRepository {
	public void store(Entity entity);
}

class FileStorage implements StorageRepository {

	public void store(Entity entity) {
		try {
			FileOutputStream fileOut = new FileOutputStream("file");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(entity);
			objectOut.close();
			System.out.println("Saved to file");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class DataBaseStorage implements StorageRepository {

	@Override
	public void store(Entity entity) {
		System.out.println("Saving to database");
	}
}

class StudentRepository implements BaseRepository {
	StorageRepository repo;

	StudentRepository(StorageRepository repo) {
		this.repo = repo;
	}

	@Override
	public void save(Entity entity) {
		repo.store(entity);
	}
}

class CourseRepository implements BaseRepository {
	StorageRepository repo;

	CourseRepository(StorageRepository repo) {
		this.repo = repo;
	}

	@Override
	public void save(Entity entity) {
		repo.store(entity);
	}
}
