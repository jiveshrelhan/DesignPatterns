package com.structural;

public class Proxy {

	public static void main(String[] args) {
		DataBaseRepository originalRepo = new DataBaseRepository();
		ProxyDataBaseRepository proxy = new ProxyDataBaseRepository(originalRepo);
		ApplicationService service = new ApplicationService(proxy);
		service.saveUser();
		service.removeUser();
		service.updateUser();
	}

}

class ApplicationService {

	Repository repo;

	public ApplicationService(Repository repo) {
		this.repo = repo;
	}

	public void saveUser() {
		repo.create();
	}

	public void removeUser() {
		repo.delete();
	}

	public void updateUser() {
		repo.update();
	}
}

interface Repository {
	public void create();

	public void delete();

	public void update();
}

class DataBaseRepository implements Repository {

	@Override
	public void create() {
		System.out.println("Creating in actual DB");
	}

	@Override
	public void delete() {
		System.out.println("Deleting in actual DB");
	}

	@Override
	public void update() {
		System.out.println("Updating in actual DB");
	}

}

class ProxyDataBaseRepository implements Repository {

	Repository originalRepo;

	public ProxyDataBaseRepository(Repository originalRepo) {
		this.originalRepo = originalRepo;
	}

	@Override
	public void create() {
		System.out.println("Logged somebody call create");
		originalRepo.create();
	}

	@Override
	public void delete() {
		System.out.println("Logged somebody call delete");
		originalRepo.delete();
	}

	@Override
	public void update() {
		System.out.println("Logged somebody call update");
		originalRepo.update();
	}

}