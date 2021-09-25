package com.construction;

public class FactoryClient {

	public static void main(String[] args) {
		AbstractJob userJob = new ConreteJobWorkerTypeA();
		userJob.performJob();
		
		AbstractJob adminJob = new ConcreteJobWorkerTypeB();
		adminJob.performJob();
	}
}

interface Job {
	public void defineJob();
}

class UserJob implements Job {

	@Override
	public void defineJob() {
		System.out.println("I am going to user job");
	}

}

class AdminJob implements Job {

	@Override
	public void defineJob() {
		System.out.println("I am going to do Admin job");
	}

}

interface JobInterface {
	public void performJob();
	public Job createJob();
}

abstract class AbstractJob implements JobInterface {

	@Override
	public void performJob() {
		Job job = this.createJob();
		System.out.println("Job is getting executed");
		job.defineJob();
	}
}

class ConcreteJobWorkerTypeB extends AbstractJob {

	@Override
	public Job createJob() {
		return new AdminJob();
	}
}

class ConreteJobWorkerTypeA extends AbstractJob {

	@Override
	public Job createJob() {
		return new UserJob();
	}
}
