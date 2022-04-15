package javaBasic;

public class Topic_05_Reference_Casting {
	protected String ten;
	
	public String getTen() {
		return ten;
	}
	
	public void setTen(String ten) {
		this.ten = ten;
	}
	
	public void xuatthongtin() {
		System.out.println("Nhan vien " + ten);
	}
	
	public static void main(String[] args) {
		Topic_05_Reference_Casting nhanVien1 = new Topic_05_Reference_Casting();
		Topic_05_Reference_Casting nhanVien2 = new Topic_05_Reference_Casting();
		
		nhanVien1.setTen("Ha Noi");
		nhanVien2.setTen("Sai Gon");
		
		nhanVien1.xuatthongtin();
		nhanVien2.xuatthongtin();
		
		// Ep kieu
		nhanVien1 = nhanVien2;
		
		nhanVien1.xuatthongtin();
		nhanVien2.xuatthongtin();
		
		nhanVien2.setTen("Da Nang");
		
		nhanVien1.xuatthongtin();
		nhanVien2.xuatthongtin();
	}
	
}
