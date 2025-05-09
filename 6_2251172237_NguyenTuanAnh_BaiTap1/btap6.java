package vd;
interface IThanhToan {
    void thanhToan(double soTien);
    void hienThiThongBao(double soTien); // Giữ nguyên kiểu double
}


class ThanhToanTienMat implements IThanhToan {
    @Override
    public void thanhToan(double soTien) {
        System.out.println("Thanh toán tiền mặt: " + soTien + " VND");
    }
    @Override
    public void hienThiThongBao(double soTien) {
    	System.out.println("Đã thanh toán thành công " + soTien + " VND bằng tiền mặt");
    }
}


class ThanhToanTheTinDung implements IThanhToan {
    private String soThe;
    private String tenChuThe;
    private String ngayHetHan;

    public ThanhToanTheTinDung(String soThe, String tenChuThe, String ngayHetHan) {
        this.soThe = soThe;
        this.tenChuThe = tenChuThe;
        this.ngayHetHan = ngayHetHan;
    }

    @Override
    public void thanhToan(double soTien) {
        System.out.println("Số thẻ: " + soThe);
        System.out.println("Tên chủ thẻ: " + tenChuThe);
        System.out.println("Số tiền: " + soTien + " VND");
    }
    @Override
    public void hienThiThongBao(double soTien) {
    	System.out.println("Đã thanh toán thành công " + soTien + " VND bằng thẻ tín dụng");
    }
}


public class btap6 {
    public static void main(String[] args) {
        IThanhToan tienMat = new ThanhToanTienMat();
        double soTienMat = 1500000;
        tienMat.thanhToan(soTienMat);
        tienMat.hienThiThongBao(soTienMat); 
        IThanhToan theTinDung = new ThanhToanTheTinDung(
            "123-456-789",
            "NGUYEN TUAN ANH",
            "12/25"
        );
        double soTienThe = 1500000;
        theTinDung.thanhToan(soTienThe);
        theTinDung.hienThiThongBao(soTienThe); 
    }
}