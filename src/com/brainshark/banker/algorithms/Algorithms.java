package com.brainshark.banker.algorithms;

import com.brainshark.banker.entity.ProcessResource;
import com.brainshark.banker.entity.Resources;

public class Algorithms {

	/**
	 * @author hudaofan
	 * 
	 */
	public static void algorithms(int num) {
		ProcessResource prResource[] = new ProcessResource[5];
		Resources resources = new Resources(1, 5, 2, 0);
		int last_i = 0;
		// 根据题意，已知Process,Allocation,MaxNeed
		prResource[0] = new ProcessResource("P0", 0, 0, 1, 2, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		prResource[1] = new ProcessResource("P1", 1, 0, 0, 0, 1, 7, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		prResource[2] = new ProcessResource("P2", 1, 3, 5, 4, 2, 3, 5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		prResource[3] = new ProcessResource("P3", 0, 6, 3, 2, 0, 6, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		prResource[4] = new ProcessResource("P4", 0, 0, 1, 4, 0, 6, 5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		if (num == 2) {
			System.out.println("P1请求(0,4,2,0)个资源后");
			resources.setA(resources.getA()-0);
			resources.setB(resources.getB()-4);
			resources.setC(resources.getC()-2);
			resources.setD(resources.getD()-0);
			prResource[1].allocation.setA(prResource[1].allocation.getA()+0);
			prResource[1].allocation.setB(prResource[1].allocation.getB()+4);
			prResource[1].allocation.setC(prResource[1].allocation.getC()+2);
			prResource[1].allocation.setD(prResource[1].allocation.getD()+0);
		}
		for (int i = 0; i < prResource.length; i++) {
			prResource[i].need.setA(prResource[i].maxNeed.getA() - prResource[i].allocation.getA());
			prResource[i].need.setB(prResource[i].maxNeed.getB() - prResource[i].allocation.getB());
			prResource[i].need.setC(prResource[i].maxNeed.getC() - prResource[i].allocation.getC());
			prResource[i].need.setD(prResource[i].maxNeed.getD() - prResource[i].allocation.getD());
			prResource[i].work.setA(resources.getA());
			prResource[i].work.setB(resources.getB());
			prResource[i].work.setC(resources.getC());
			prResource[i].work.setD(resources.getD());
		}
		System.out.println("-------------------------------------------------");
		System.out.println("系统资源还剩:" + resources.toResources());
		System.out.println("进程" + "\t已分配资源" + "\t最大需求数" + "\t还需要资源");
		System.out.println("\t" + resources.abcd() + "\t\t" + resources.abcd() + "\t\t" + resources.abcd());
		for (int i = 0; i < prResource.length; i++) {
			System.out.println(prResource[i].showProcess());
		}
		System.out.println(
				"----------------------------------------------------------------------------------------------");
		if (num == 1) {
			System.out.println("(1):");
		} else if (num == 2) {
			System.out.println("(2):");
		} else {
			System.out.println("输入有误！！！");
		}
		System.out.println("剩余资源:" + resources.toString());
		for (int length = 0; length < prResource.length; length++) {
			System.out.println("-----" + "第" + (length + 1) + "次分配" + "-----");
			System.out.print("满足还需要分配资源的有：");
			for (int i = 0; i < prResource.length; i++) {
				if (length == 0) {
					if (prResource[last_i].work.getA() >= prResource[i].need.getA()
							&& prResource[last_i].work.getB() >= prResource[i].need.getB()
							&& prResource[last_i].work.getC() >= prResource[i].need.getC()
							&& prResource[last_i].work.getD() >= prResource[i].need.getD()
							&& !prResource[i].isFinish()) {
						System.out.print(prResource[i].getProcess() + "(" + prResource[i].showNeed() + ")" + "\t");
					}
				} else {
					if (prResource[last_i].workAndAllocation.getA() >= prResource[i].need.getA()
							&& prResource[last_i].workAndAllocation.getB() >= prResource[i].need.getB()
							&& prResource[last_i].workAndAllocation.getC() >= prResource[i].need.getC()
							&& prResource[last_i].workAndAllocation.getD() >= prResource[i].need.getD()
							&& !prResource[i].isFinish()) {
						System.out.print(prResource[i].getProcess() + "(" + prResource[i].showNeed() + ")  ");
					}
				}

			}
			System.out.print("\n先分配资源给：");
			for (int i = 0; i < prResource.length; i++) {
				if (prResource[last_i].workAndAllocation.getA() >= prResource[i].need.getA()
						&& prResource[last_i].workAndAllocation.getB() >= prResource[i].need.getB()
						&& prResource[last_i].workAndAllocation.getC() >= prResource[i].need.getC()
						&& prResource[last_i].workAndAllocation.getD() >= prResource[i].need.getD()
						&& !prResource[i].isFinish()) {
					System.out.print(prResource[i].getProcess() + "(" + prResource[i].showNeed() + ")" + "\t");
					if (i == 0) {
						prResource[i].work.setA(resources.getA());
						prResource[i].work.setB(resources.getB());
						prResource[i].work.setC(resources.getC());
						prResource[i].work.setD(resources.getD());
					} else {
						prResource[i].work.setA(prResource[last_i].workAndAllocation.getA());
						prResource[i].work.setB(prResource[last_i].workAndAllocation.getB());
						prResource[i].work.setC(prResource[last_i].workAndAllocation.getC());
						prResource[i].work.setD(prResource[last_i].workAndAllocation.getD());
					}
					System.out.println("\n剩余资源:" + prResource[i].showWork());
					prResource[i].workAndAllocation.setA(prResource[i].work.getA() + prResource[i].allocation.getA());
					prResource[i].workAndAllocation.setB(prResource[i].work.getB() + prResource[i].allocation.getB());
					prResource[i].workAndAllocation.setC(prResource[i].work.getC() + prResource[i].allocation.getC());
					prResource[i].workAndAllocation.setD(prResource[i].work.getD() + prResource[i].allocation.getD());
					System.out.println("剩余+回收资源:" + prResource[i].showWorkAndAllocation());
					prResource[i].setFinish(true);
					last_i = i;
					break;
				}
			}
			System.out.println("进程" + "\t已分配资源" + "\t最大需求数" + "\t还需要资源" + "\t剩余资源" + "\t\t剩余+回收资源" + "\t状态");
			System.out.println("\t" + resources.abcd() + "\t\t" + resources.abcd() + "\t\t" + resources.abcd() + "\t\t"
					+ resources.abcd() + "\t\t" + resources.abcd());
			System.out.println(prResource[last_i].toString());
		}
	}

}
