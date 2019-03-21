package com.mohit.unbxd;

public class Combination {

	private int no1;
	private int no2;
	private int no3;
	private int no4;
	private int level;

	public Combination() {
		this(0, 0, 0, 0, -1);
	}

	public Combination(int n1, int n2, int n3, int n4, int level) {
		no1 = n1;
		no2 = n2;
		no3 = n3;
		no4 = n4;
		this.setLevel(level);
	}

	public int getNo1() {
		return no1;
	}

	public int getNo2() {
		return no2;
	}

	public int getNo3() {
		return no3;
	}

	public int getNo4() {
		return no4;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no1;
		result = prime * result + no2;
		result = prime * result + no3;
		result = prime * result + no4;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combination other = (Combination) obj;
		if (no1 != other.no1)
			return false;
		if (no2 != other.no2)
			return false;
		if (no3 != other.no3)
			return false;
		if (no4 != other.no4)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Combination [no1=" + no1 + ", no2=" + no2 + ", no3=" + no3 + ", no4=" + no4 + ", level=" + level + "]";
	}

}
