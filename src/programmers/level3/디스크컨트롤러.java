package programmers.level3;

import java.util.*;

class 힙 {
	public int solution(int[][] jobs){
		List<Job> jobList = new ArrayList<>();
		Arrays.stream(jobs).forEach(j -> {
			jobList.add(new Job(j[0], j[1]));
		});
		Collections.sort(jobList, (j1, j2) -> {
			if (j1.start == j2.start) return j1.duration - j2.duration;
			else return j1.start - j2.start;});

		PriorityQueue<Job> pq = new PriorityQueue<>();
		int idx = 0;
		int time = 0;
		int sum = 0;
		int count = 0;

		while (count < jobs.length) {
			while (idx < jobs.length && jobList.get(idx).getStart() <= time) {
				pq.add(jobList.get(idx));
				idx++;
			}
			if (!pq.isEmpty()) {
				Job now = pq.poll();
				sum += time + now.getDuration() - now.getStart();
				time += now.getDuration();
				count++;
			} else {
				time++;
			}
		}

		return sum / jobs.length;
	}
}

class Job implements Comparable<Job> {
	int start;
	int duration;

	public Job (int start, int duration) {
		this.start = start;
		this.duration = duration;
	}

	int getStart() {
		return this.start;
	}
	int getDuration() {
		return this.duration;
	}

	public int compareTo(Job job) {
		if (this.duration == job.duration) return this.start - job.start;
		else return this.duration - job.duration;
	}
}
