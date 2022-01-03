package buoi7.hashcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Xe {
	private String idXe;
	private String idLaiXe;
	private int viTriHienTai;
	private int giaCuoc;
	private int saoDanhGia;

	public String getIdXe() {
		return idXe;
	}

	public void setIdXe(String idXe) {
		this.idXe = idXe;
	}

	public String getIdLaiXe() {
		return idLaiXe;
	}

	public void setIdLaiXe(String idLaiXe) {
		this.idLaiXe = idLaiXe;
	}

	public int getViTriHienTai() {
		return viTriHienTai;
	}

	public void setViTriHienTai(int viTriHienTai) {
		this.viTriHienTai = viTriHienTai;
	}

	public int getGiaCuoc() {
		return giaCuoc;
	}

	public void setGiaCuoc(int giaCuoc) {
		if (giaCuoc < 1) {
			throw new ArithmeticException("nhap gia cuoc khong hop le(n > 1)");
		}

		this.giaCuoc = giaCuoc;
	}

	public int getSaoDanhGia() {
		return saoDanhGia;
	}

	public void setSaoDanhGia(int saoDanhGia) {
//		try {
//			if (saoDanhGia > 5 || saoDanhGia < 0) {
//				throw new ArithmeticException("not valid");
//			}
//
//			this.saoDanhGia = saoDanhGia;
//		} catch (ArithmeticException ex) {
//			System.out.println(ex.getMessage());
//
//		}
		if (saoDanhGia > 5 || saoDanhGia < 0) {
			throw new ArithmeticException("nhap sao danh gia khong hop le(0-5)");
		}

		this.saoDanhGia = saoDanhGia;
	}

	public Xe(String idXe, String idLaiXe, int viTriHienTai, int giaCuoc, int saoDanhGia) {

		this.idXe = idXe;
		this.idLaiXe = idLaiXe;
		this.viTriHienTai = viTriHienTai;
		this.giaCuoc = giaCuoc;
		this.saoDanhGia = saoDanhGia;
	}

	public Xe() {
	}

	public boolean equals(Object obj) {
		if (obj instanceof Xe) {
			Xe another = (Xe) obj;
			if (this.idXe.equals(another.idXe) && this.idLaiXe.equals(another.idLaiXe)) {
				return true;
			}
		}
		return false;
	}

	public int hashCode() {
		return idXe.hashCode();
	}

	public String toString() {
		String studentInfo = "idXe " + idXe;
		studentInfo += ":  " + idLaiXe;
		studentInfo += " - " + viTriHienTai;
		studentInfo += " - " + giaCuoc;
		studentInfo += " - " + saoDanhGia;
		return studentInfo;
	}

	class idlaiXeComparator implements Comparator<Xe> {
		public int compare(Xe x1, Xe x2) {
			return x1.idLaiXe.compareTo(x2.idLaiXe);
		}
	}

	class idXeComparator implements Comparator<Xe> {
		public int compare(Xe x1, Xe x2) {
			return x1.idXe.compareTo(x2.idXe);
		}
	}

	class saodanhgiaComparator implements Comparator<Xe> {
		public int compare(Xe s1, Xe s2) {
			if (s1.saoDanhGia == s2.saoDanhGia)
				return 0;
			else if (s1.saoDanhGia < s2.saoDanhGia)
				return 1;
			else
				return -1;
		}
	}

	public static void main(String[] args) {
//		Xe xe1=new Xe("789", null, 20, 30,3);
//		Xe xe2=new Xe("235", null, 20, 30,3);
//		Xe xe3=new Xe("789", null, 20, 30,3);
//		System.out.println(xe1.equals(xe3));
//		System.out.println(xe1.equals(xe2));

		Set<Xe> listSet = new HashSet<Xe>();

		listSet.add(new Xe("123", "X111", 5, 20000, 4));
		listSet.add(new Xe("123", "X111", 5, 20000, 4));
		listSet.add(new Xe("124", "X116", 6, 20000, 5));
		listSet.add(new Xe("125", "X117", 2, 25000, 3));
		listSet.add(new Xe("129", "X119", 3, 15000, 1));
		listSet.add(new Xe("130", "X118", 8, 20000, 5));
		listSet.add(new Xe("131", "X113", 9, 20000, 4));
		listSet.add(new Xe("132", "X112", 1, 20000, 3));
		listSet.add(new Xe("126", "X114", 7, 15000, 2));
		listSet.add(new Xe("127", "X110", 3, 20000, 5));
		listSet.add(new Xe("128", "X102", 4, 15000, 4));
		listSet.add(new Xe("128", "X102", 4, 15000, 4));
		System.out.println("Distinct danh sách Xe theo idXe + idLaiXe");
		for (Xe xe : listSet) {
			System.out.println(xe);
		}

		ArrayList<Xe> list = new ArrayList<Xe>(listSet);
		System.out.println("Sắp xếp Danh sách xe theo sao đánh giá sao từ lớn về bé");

		Collections.sort(list, new Xe().new saodanhgiaComparator());
		for (Xe st2 : list) {
			System.out.println(st2);
		}
		Collections.sort(list, new Comparator<Xe>() {

			@Override
			public int compare(Xe o1, Xe o2) {
				if (o1.saoDanhGia != o2.saoDanhGia) {
					return o2.saoDanhGia - o1.saoDanhGia;
				} else if (o1.viTriHienTai != o2.viTriHienTai) {
					return o1.viTriHienTai - o2.viTriHienTai;
				} else if (o1.giaCuoc != o2.giaCuoc) {
					return o1.giaCuoc - o2.giaCuoc;
				}
				return 0;
			}
		});
		System.out.println("Tìm danh sách Xe theo tiêu chí giá sao đánh giá tốt nhất -> gần nhất -> giá cước tốt nhất");
		for (Xe xe : list) {
			System.out.println(xe);
		}

	}

}
