package com.brainshark.banker.entity;

public class ProcessResource {

	/**
	 * @author hudaofan
	 * 
	 */

	private String process;
	public Resources allocation;
	public Resources maxNeed;
	public Resources need;
	public Resources work;
	public Resources workAndAllocation;
	private Resources request;
	private boolean finish = false;

	public ProcessResource() {
	}

	public ProcessResource(String process, int a_a, int b_a, int c_a, int d_a, int a_m, int b_m, int c_m, int d_m) {
		super();
		this.process = process;
		this.allocation = new Resources(a_a, b_a, c_a, d_a);
		this.maxNeed = new Resources(a_m, b_m, c_m, d_m);
	}

	public ProcessResource(int a_n, int b_n, int c_n, int d_n, int a_w, int b_w, int c_w, int d_w, int a_wa, int b_wa,
			int c_wa, int d_wa) {
		super();
		this.need = new Resources(a_n, b_n, c_n, d_n);
		this.work = new Resources(a_w, b_w, c_w, d_w);
		this.workAndAllocation = new Resources(a_wa, b_wa, c_wa, d_wa);
	}

	public ProcessResource(String process, int a_a, int b_a, int c_a, int d_a, int a_m, int b_m, int c_m, int d_m,
			int a_n, int b_n, int c_n, int d_n, int a_w, int b_w, int c_w, int d_w, int a_wa, int b_wa, int c_wa,
			int d_wa) {
		super();
		this.process = process;
		this.allocation = new Resources(a_a, b_a, c_a, d_a);
		this.maxNeed = new Resources(a_m, b_m, c_m, d_m);
		this.need = new Resources(a_n, b_n, c_n, d_n);
		this.work = new Resources(a_w, b_w, c_w, d_w);
		this.workAndAllocation = new Resources(a_wa, b_wa, c_wa, d_wa);
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getRequest() {
		return request.toString();
	}

	public void setRequest(int a_r, int b_r, int c_r, int d_r) {
		this.request = new Resources(a_r, b_r, c_r, d_r);
	}

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	public String showProcess() {
		return process + "\t" + allocation + "\t\t" + maxNeed + "\t\t" + need;
	}

	public String showNeed() {
		return need.getA() + " " + need.getB() + " " + need.getC() + " " + need.getD();
	}

	public String showWork() {
		return work.getA() + " " + work.getB() + " " + work.getC() + " " + work.getD();
	}

	public String showWorkAndAllocation() {
		return workAndAllocation.getA() + " " + workAndAllocation.getB() + " " + workAndAllocation.getC() + " "
				+ workAndAllocation.getD();
	}

	@Override
	public String toString() {
		return process + "\t" + allocation + "\t\t" + maxNeed + "\t\t" + need + "\t\t" + work + "     \t"
				+ workAndAllocation + "     \t" + finish;
	}

}
