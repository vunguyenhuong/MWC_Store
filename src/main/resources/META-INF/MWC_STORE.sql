CREATE DATABASE MWC_STORE
GO
USE MWC_STORE
GO

-- Dép
CREATE TABLE DEP (
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(50),
	HinhAnh NVARCHAR(50),
	NgayThem DATE,
	NgaySuaCuoi DATE,
	TrangThai INT
)

-- Loại dép
CREATE TABLE LOAIDEP (
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(50),
	NgayThem DATE,
	NgaySuaCuoi DATE,
	TrangThai INT
)

-- Màu sắc
CREATE TABLE MAUSAC (
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(50),
	NgayThem DATE,
	NgaySuaCuoi DATE,
	TrangThai INT
)

-- Chất liệu
CREATE TABLE CHATLIEU (
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(50),
	NgayThem DATE,
	NgaySuaCuoi DATE,
	TrangThai INT
)

-- Nhà sản xuất
CREATE TABLE NSX (
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(50),
	NgayThem DATE,
	NgaySuaCuoi DATE,
	TrangThai INT
)

-- Size
CREATE TABLE SIZE (
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20) UNIQUE,
	KichCo FLOAT,
	NgayThem DATE,
	NgaySuaCuoi DATE,
	TrangThai INT
)

-- Chi tiết dép
CREATE TABLE CHITIETDEP (
	Id INT PRIMARY KEY IDENTITY(1,1),
	IdDep INT,
	IdLoaiDep INT,
	IdMauSac INT,
	IdChatLieu INT,
	IdNsx INT,
	IdSize INT,
	MoTa NVARCHAR(50),
	SoLuong INT,
	SoLuongBanRa INT,
	GiaNhap DECIMAL(20,0),
	GiaBan DECIMAL(20,0),
	NgayThem DATE,
	NgaySuaCuoi DATE,
	TrangThai INT
)

-- Chức Vụ
CREATE TABLE CHUCVU (
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(50) DEFAULT NULL
)

-- Người dùng
CREATE TABLE NGUOIDUNG (
	Id INT PRIMARY KEY IDENTITY(1,1),
	IdCV INT,
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(50),
	Email VARCHAR(MAX),
	Sdt VARCHAR(20),
	DiaChi NVARCHAR(255),
	GioiTinh INT,
	MatKhau VARCHAR(MAX),
	TrangThai INT,
	HinhAnh NVARCHAR(50)
)

-- Khách hàng
CREATE TABLE KHACHHANG (
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(50),
	Sdt VARCHAR(20),
	DiaChi NVARCHAR(255),
	DiemTichLuy INT,
	TongDiemTichLuy INT
)

-- Hóa đơn
CREATE TABLE HOADON (
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20) UNIQUE,
	IdND INT,
	IdNDTT INT,
	IdKH INT,
	IdKM INT,
	DiemTichLuy INT,
	NgayTao DATE,
	NgayThanhToan DATE,
	NgayNhanYC DATE,
	NgayGiaoHang DATE,
	NgayNhanHang DATE,
	TongTien DECIMAL(20,0) DEFAULT 0,
	TrangThai INT
)

-- Hóa đơn chi tiết
CREATE TABLE HOADONCHITIET (
	Id INT PRIMARY KEY IDENTITY(1,1),
	IdCTD INT,
	IdHD INT,
	DonGia DECIMAL(20,0) DEFAULT 0,
	SoLuong INT,
	TrangThai INT
)

-- KHUYẾN MÃI
CREATE TABLE KHUYENMAI (
	Id INT IDENTITY(1,1) PRIMARY KEY,
	Ma VARCHAR(50) UNIQUE,
	Ten NVARCHAR(50),
	PhanTramGiam FLOAT,
	SoLuong INT,
	HinhAnh NVARCHAR(50),
	NgayBatDau DATE,
	NgayKetThuc DATE
)


ALTER TABLE CHITIETDEP ADD CONSTRAINT FK_CTD_DEP FOREIGN KEY (IdDep) REFERENCES Dep(Id)

ALTER TABLE CHITIETDEP ADD CONSTRAINT FK_CTD_LOAIDEP FOREIGN KEY (IdLoaiDep) REFERENCES LoaiDep(Id)

ALTER TABLE CHITIETDEP ADD CONSTRAINT FK_CTD_MAUSAC FOREIGN KEY (IdMauSac) REFERENCES MauSac(Id)

ALTER TABLE CHITIETDEP ADD CONSTRAINT FK_CTD_CHATLIEU FOREIGN KEY (IdChatLieu) REFERENCES ChatLieu(Id)

ALTER TABLE CHITIETDEP ADD CONSTRAINT FK_CTD_NSX FOREIGN KEY (IdNsx) REFERENCES NSX(Id)

ALTER TABLE CHITIETDEP ADD CONSTRAINT FK_CTD_SIZE FOREIGN KEY (IdSize) REFERENCES Size(Id)

ALTER TABLE NGUOIDUNG ADD CONSTRAINT FK_ND_CV FOREIGN KEY (IdCV) REFERENCES ChucVu(Id)

ALTER TABLE HOADON ADD CONSTRAINT FK_HD_ND FOREIGN KEY (IdNd) REFERENCES NguoiDung(Id)

ALTER TABLE HOADON ADD CONSTRAINT FK_HD_ND_1 FOREIGN KEY (IdNDTT) REFERENCES NguoiDung(Id)

ALTER TABLE HOADON ADD CONSTRAINT FK_HD_KH FOREIGN KEY (IdKh) REFERENCES KhachHang(Id)

ALTER TABLE HOADON ADD CONSTRAINT FK_HD_KM FOREIGN KEY (IdKM) REFERENCES KhuyenMai (Id)

ALTER TABLE HOADONCHITIET ADD CONSTRAINT FK_HDCT_HD FOREIGN KEY (IdHd) REFERENCES HoaDon (Id)

ALTER TABLE HOADONCHITIET ADD CONSTRAINT FK_HDCT_CTD FOREIGN KEY (IdCtd) REFERENCES ChiTietDep (Id)

-- INSERT DATA

-- Data Chức vụ
INSERT INTO CHUCVU (Ma, Ten) VALUES(N'CV1', N'Quản lý');
INSERT INTO CHUCVU (Ma, Ten) VALUES(N'CV2', N'Nhân viên');

-- Data Người dùng
INSERT INTO NGUOIDUNG (IdCV, Ma, Ten, Email, Sdt, DiaChi, GioiTinh, MatKhau, TrangThai, HinhAnh) VALUES(1, N'huongvn', N'Vũ Nguyên Hướng', N'huongvnph27229@fpt.edu.vn', N'0395080513', N'Nam Định', 0, N'123123123', 0, N'mtkh.jpg');
INSERT INTO NGUOIDUNG (IdCV, Ma, Ten, Email, Sdt, DiaChi, GioiTinh, MatKhau, TrangThai, HinhAnh) VALUES(1, N'kimchi', N'Lại Thị Kim Chi', N'chiltkph26384@fpt.edu.vn', N'0999888999', N'Nam Định', 0, N'123123', 0, N'kimchi.jpg');
INSERT INTO NGUOIDUNG (IdCV, Ma, Ten, Email, Sdt, DiaChi, GioiTinh, MatKhau, TrangThai, HinhAnh) VALUES(2, N'994317385846', N'Cao Văn Việt', N'vietcv88@fpt.edu.vn', N'0999888999', N'Giao Thủy, Nam Định', 0, N'0c9ec222', 1, N'defaultavt.jpg');
INSERT INTO NGUOIDUNG (IdCV, Ma, Ten, Email, Sdt, DiaChi, GioiTinh, MatKhau, TrangThai, HinhAnh) VALUES(2, N'026203001126', N'Hoàng Vĩnh Giang', N'huongvn@gmail.com', N'0983103663', N'Đan Thượng, Tân Phú,Vĩnh Tường,Vĩnh Phúc', 0, N'ee103db9', 0, N'defaultavt.jpg');


-- Data Chất liệu
INSERT INTO CHATLIEU (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'CL1', N'Cao su', '2022-11-11', '2022-11-11', 0);
INSERT INTO CHATLIEU (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'CL2', N'Vải', '2022-11-11', '2022-11-11', 0);
INSERT INTO CHATLIEU (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'CL3', N'Bông', '2022-11-11', '2022-11-11', 0);
INSERT INTO CHATLIEU (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'CL4', N'Vải nhựa', '2022-11-11', '2022-11-11', 0);
INSERT INTO CHATLIEU (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'CL5', N'Nhựa PVC', '2022-11-11', '2022-11-11', 0);
INSERT INTO CHATLIEU (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'CL0', N'Mẹ của Vải', '2022-12-01', '2022-12-01', 0);
INSERT INTO CHATLIEU (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'CL6', N'Bố của Nhựa', '2022-12-01', '2022-12-01', 0);

-- Data Dép
INSERT INTO DEP (Ma, Ten, HinhAnh, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'SP1', N'Tổ ong 36 lỗ', N'1.jpg', '2022-11-11', '2022-11-11', 0);
INSERT INTO DEP (Ma, Ten, HinhAnh, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'SP2', N'Tông lào VN', N'2.jpg', '2022-11-11', '2022-11-11', 0);
INSERT INTO DEP (Ma, Ten, HinhAnh, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'SP3', N'Crocs Unisex', N'3.jpg', '2022-11-11', '2022-11-11', 0);
INSERT INTO DEP (Ma, Ten, HinhAnh, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'SP4', N'Tổ ong 72 lỗ', N'4.jpg', '2022-11-11', '2022-11-11', 0);
INSERT INTO DEP (Ma, Ten, HinhAnh, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'SP5', N'Dép bánh mì', N'5.jpg', '2022-11-11', '2022-11-11', 0);
INSERT INTO DEP (Ma, Ten, HinhAnh, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'SP0', N'Cờ rốc', N'9.jpg', '2022-12-01', '2022-12-01', 0);

-- Data Loại Dép
INSERT INTO LOAIDEP (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'LD1', N'Sandal', '2022-11-11', '2022-11-11', 0);
INSERT INTO LOAIDEP (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'LD2', N'Tông lào', '2022-11-11', '2022-11-11', 0);
INSERT INTO LOAIDEP (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'LD3', N'Crocs', '2022-11-11', '2022-11-11', 0);
INSERT INTO LOAIDEP (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'LD4', N'Tổ ong', '2022-11-11', '2022-11-11', 0);
INSERT INTO LOAIDEP (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'LD5', N'Xỏ ngón', '2022-11-11', '2022-11-28', 0);
INSERT INTO LOAIDEP (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'LD0', N'Mẹ của tông lào', '2022-11-28', '2022-11-28', 0);
INSERT INTO LOAIDEP (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'LD6', N'Bố của tông lào', '2022-11-28', '2022-11-28', 0);
INSERT INTO LOAIDEP (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'LD7', N'Bố của Sandal', '2022-11-28', '2022-11-28', 0);
INSERT INTO LOAIDEP (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'LD8', N'Mẹ của Sandal', '2022-11-28', '2022-11-28', 0);
INSERT INTO LOAIDEP (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'LD9', N'Anh của Sandal', '2022-11-28', '2022-11-28', 0);
INSERT INTO LOAIDEP (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'LD10', N'Chị của Sandal', '2022-11-28', '2022-11-28', 0);

-- Data Màu sắc
INSERT INTO MAUSAC (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'MS1', N'Trắng', '2022-11-11', '2022-11-11', 0);
INSERT INTO MAUSAC (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'MS2', N'Đen', '2022-11-11', '2022-11-11', 0);
INSERT INTO MAUSAC (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'MS3', N'Đỏ', '2022-11-11', '2022-11-11', 0);
INSERT INTO MAUSAC (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'MS4', N'Vàng', '2022-11-11', '2022-11-11', 0);
INSERT INTO MAUSAC (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'MS5', N'Tím than', '2022-11-11', '2022-12-04', 0);
INSERT INTO MAUSAC (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'MS0', N'Xanh', '2022-11-28', '2022-11-28', 0);

-- Data NSX
INSERT INTO NSX (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'NX1', N'Puma', '2022-11-11', '2022-11-11', 0);
INSERT INTO NSX (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'NX2', N'Nike', '2022-11-11', '2022-11-11', 0);
INSERT INTO NSX (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'NX3', N'Balenciaga', '2022-11-11', '2022-11-11', 0);
INSERT INTO NSX (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'NX4', N'Adidas', '2022-11-11', '2022-11-11', 0);
INSERT INTO NSX (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'NX5', N'Jordan', '2022-11-11', '2022-11-11', 0);
INSERT INTO NSX (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'NX0', N'Bà của Jordan', '2022-11-28', '2022-11-28', 0);
INSERT INTO NSX (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'NX6', N'Ông ngoại của Jordan', '2022-11-28', '2022-11-28', 0);
INSERT INTO NSX (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'NX7', N'Cháu của Jordan', '2022-11-28', '2022-11-28', 0);

-- Data Size
INSERT INTO [SIZE] (Ma, KichCo, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'SZ1', 36.0, '2022-11-09', '2022-11-09', 0);
INSERT INTO [SIZE] (Ma, KichCo, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'SZ2', 37.0, '2022-11-11', '2022-11-11', 0);
INSERT INTO [SIZE] (Ma, KichCo, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'SZ3', 38.0, '2022-11-11', '2022-11-11', 0);
INSERT INTO [SIZE] (Ma, KichCo, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'SZ4', 39.0, '2022-11-11', '2022-11-11', 0);
INSERT INTO [SIZE] (Ma, KichCo, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'SZ5', 40.0, '2022-11-11', '2022-11-11', 0);
INSERT INTO [SIZE] (Ma, KichCo, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'SZ6', 41.0, '2022-11-11', '2022-11-11', 0);
INSERT INTO [SIZE] (Ma, KichCo, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'SZ7', 42.0, '2022-11-11', '2022-11-11', 0);
INSERT INTO [SIZE] (Ma, KichCo, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'SZ8', 43.0, '2022-11-11', '2022-11-11', 0);
INSERT INTO [SIZE] (Ma, KichCo, NgayThem, NgaySuaCuoi, TrangThai) VALUES(N'SZ9', 44.0, '2022-11-11', '2022-11-11', 0);

-- Data Chi Tiết Dép
INSERT INTO CHITIETDEP (IdDep, IdLoaiDep, IdMauSac, IdChatLieu, IdNsx, IdSize, MoTa, SoLuong, SoLuongBanRa, GiaNhap, GiaBan, NgayThem, NgaySuaCuoi, TrangThai) VALUES(1, 1, 3, 2, 1, 2, N'Đẹp', 1580, 340, 1000, 2000, '2022-12-07', '2022-12-07', 0);
INSERT INTO CHITIETDEP (IdDep, IdLoaiDep, IdMauSac, IdChatLieu, IdNsx, IdSize, MoTa, SoLuong, SoLuongBanRa, GiaNhap, GiaBan, NgayThem, NgaySuaCuoi, TrangThai) VALUES(2, 2, 2, 2, 5, 3, N'Rất đẹp', 3400, 440, 1500, 2500, '2022-12-07', '2022-12-07', 0);
INSERT INTO CHITIETDEP (IdDep, IdLoaiDep, IdMauSac, IdChatLieu, IdNsx, IdSize, MoTa, SoLuong, SoLuongBanRa, GiaNhap, GiaBan, NgayThem, NgaySuaCuoi, TrangThai) VALUES(3, 3, 3, 4, 3, 2, N'Rất rất đẹp', 902, 238, 2000, 3000, '2022-12-07', '2022-12-07', 0);
INSERT INTO CHITIETDEP (IdDep, IdLoaiDep, IdMauSac, IdChatLieu, IdNsx, IdSize, MoTa, SoLuong, SoLuongBanRa, GiaNhap, GiaBan, NgayThem, NgaySuaCuoi, TrangThai) VALUES(5, 4, 4, 3, 1, 3, N'Sang chảnh', 940, 260, 2000, 4000, '2022-12-07', '2022-12-07', 0);
INSERT INTO CHITIETDEP (IdDep, IdLoaiDep, IdMauSac, IdChatLieu, IdNsx, IdSize, MoTa, SoLuong, SoLuongBanRa, GiaNhap, GiaBan, NgayThem, NgaySuaCuoi, TrangThai) VALUES(4, 4, 4, 5, 2, 3, N'Rất sang chảnh', 1100, 370, 2000, 5500, '2022-12-07', '2022-12-07', 0);


-- Data Khách Hàng
INSERT INTO KHACHHANG (Ma, Ten, Sdt, DiaChi, DiemTichLuy, TongDiemTichLuy) VALUES(N'KH1', N'Đinh Hải Dương', N'0666777555', N'Giao Thủy', 1, 7);
INSERT INTO KHACHHANG (Ma, Ten, Sdt, DiaChi, DiemTichLuy, TongDiemTichLuy) VALUES(N'KH2', N'Phạm Tiến Đạt', N'0333222444', N'Hà Nội', 2, 6);
INSERT INTO KHACHHANG (Ma, Ten, Sdt, DiaChi, DiemTichLuy, TongDiemTichLuy) VALUES(N'KH0', N'Phạm Đức Anh', N'0999888999', N'Hà Nội', 2, 2);

-- Data Khuyến Mãi
INSERT INTO KHUYENMAI (Ma, Ten, PhanTramGiam, SoLuong, HinhAnh, NgayBatDau, NgayKetThuc) VALUES(N'NGVN2011', N'Chào mừng ngày nhà giáo Việt Nam', 20.0, 11, N'NGVN2011.png', '2022-11-28', '2022-12-05');
INSERT INTO KHUYENMAI (Ma, Ten, PhanTramGiam, SoLuong, HinhAnh, NgayBatDau, NgayKetThuc) VALUES(N'NOEL2022', N'Noel 2022', 10.0, 11, N'NOEL2022.png', '2022-12-02', '2022-12-02');
INSERT INTO KHUYENMAI (Ma, Ten, PhanTramGiam, SoLuong, HinhAnh, NgayBatDau, NgayKetThuc) VALUES(N'KM2011', N'KM2011 NHA GIAO VN', 10.0, 11, N'KM2011.png', '2022-12-05', '2022-12-29');

-- Data Hóa đơn
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD0', 2, 2, 1, NULL, 0, '2020-01-01', '2022-12-07', NULL, NULL, NULL, 160000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD1', 2, 2, NULL, NULL, 0, '2022-01-01', '2022-11-11', NULL, NULL, NULL, 392000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD2', 2, 2, NULL, NULL, 0, '2022-01-01', '2022-10-10', NULL, NULL, NULL, 184000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD3', 2, 2, NULL, NULL, 0, '2022-01-01', '2022-09-09', NULL, NULL, NULL, 220000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD4', 2, 2, NULL, NULL, 0, '2022-01-01', '2022-08-08', NULL, NULL, NULL, 60000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD5', 2, 2, NULL, NULL, 0, '2022-01-01', '2022-07-07', NULL, NULL, NULL, 100000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD6', 2, 2, NULL, NULL, 0, '2022-01-01', '2022-06-06', NULL, NULL, NULL, 165000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD7', 2, 2, NULL, NULL, 0, '2022-01-01', '2022-05-05', NULL, NULL, NULL, 60000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD8', 2, 2, NULL, NULL, 0, '2022-01-01', '2022-04-04', NULL, NULL, NULL, 240000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD9', 2, 2, NULL, NULL, 0, '2022-01-01', '2022-03-15', NULL, NULL, NULL, 165000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD10', 2, 2, NULL, NULL, 0, '2022-01-01', '2022-02-09', NULL, NULL, NULL, 220000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD11', 2, 2, NULL, NULL, 0, '2022-01-01', '2022-01-30', NULL, NULL, NULL, 100000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD12', 2, 2, NULL, NULL, 0, '2021-01-01', '2021-12-12', NULL, NULL, NULL, 355000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD13', 2, 2, NULL, NULL, 0, '2021-01-01', '2021-11-11', NULL, NULL, NULL, 150000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD14', 2, 2, NULL, NULL, 0, '2021-01-01', '2021-10-10', NULL, NULL, NULL, 150000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD15', 2, 2, NULL, NULL, 0, '2021-01-01', '2021-09-09', NULL, NULL, NULL, 210000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD16', 2, 2, NULL, NULL, 0, '2021-01-01', '2021-08-08', NULL, NULL, NULL, 220000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD17', 2, 2, NULL, NULL, 0, '2021-01-01', '2021-07-07', NULL, NULL, NULL, 355000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD18', 2, 2, NULL, NULL, 0, '2021-01-01', '2021-06-01', NULL, NULL, NULL, 170000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD19', 2, 2, NULL, NULL, 0, '2021-01-01', '2021-05-27', NULL, NULL, NULL, 240000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD20', 2, 2, NULL, NULL, 0, '2021-01-01', '2021-04-01', NULL, NULL, NULL, 143000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD21', 2, 2, NULL, NULL, 0, '2021-01-01', '2021-03-15', NULL, NULL, NULL, 80000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD22', 2, 2, NULL, NULL, 0, '2021-01-01', '2021-02-09', NULL, NULL, NULL, 315000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD23', 2, 2, NULL, NULL, 0, '2020-01-01', '2021-01-01', NULL, NULL, NULL, 270000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD24', 2, 2, NULL, NULL, 0, '2020-01-01', '2020-12-12', NULL, NULL, NULL, 245000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD25', 1, 1, NULL, NULL, 0, '2022-12-08', '2020-11-01', NULL, NULL, NULL, 480000, 1);
INSERT INTO HOADON (Ma, IdND, IdNDTT, IdKH, IdKM, DiemTichLuy, NgayTao, NgayThanhToan, NgayNhanYC, NgayGiaoHang, NgayNhanHang, TongTien, TrangThai) VALUES(N'HD26', 1, 1, NULL, NULL, 0, '2022-12-08', '2020-10-01', NULL, NULL, NULL, 120000, 1);

-- Data HDCT

INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(3, 8, 3000, 20, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(5, 7, 5500, 30, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(2, 6, 2500, 40, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(1, 5, 2000, 30, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(4, 4, 4000, 40, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(1, 4, 2000, 30, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(2, 3, 2500, 34, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(3, 3, 3000, 33, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(5, 2, 5500, 44, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(3, 2, 3000, 50, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(1, 1, 2000, 80, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(2, 15, 2500, 60, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(2, 14, 2500, 60, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(1, 13, 2000, 40, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(5, 13, 5500, 50, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(4, 9, 4000, 60, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(3, 10, 3000, 55, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(5, 11, 5500, 40, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(2, 12, 2500, 40, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(2, 24, 2500, 60, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(2, 23, 2500, 60, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(1, 22, 2000, 40, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(1, 21, 2000, 55, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(4, 20, 4000, 50, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(3, 20, 3000, 10, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(1, 20, 2000, 5, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(5, 21, 5500, 6, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(5, 23, 5500, 30, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(4, 24, 4000, 30, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(1, 19, 2000, 30, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(5, 19, 5500, 20, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(5, 18, 5500, 50, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(4, 18, 4000, 20, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(3, 16, 3000, 70, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(4, 17, 4000, 30, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(2, 17, 2500, 40, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(2, 25, 2500, 30, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(1, 25, 2000, 30, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(5, 25, 5500, 20, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(2, 26, 2500, 16, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(5, 26, 5500, 80, 1);
INSERT INTO HOADONCHITIET (IdCTD, IdHD, DonGia, SoLuong, TrangThai) VALUES(4, 27, 4000, 30, 1);



SELECT * FROM NGUOIDUNG

SELECT * FROM CHUCVU

SELECT * FROM DEP

SELECT * FROM LOAIDEP

SELECT * FROM CHATLIEU

SELECT * FROM SIZE

SELECT * FROM NSX

SELECT * FROM MAUSAC

SELECT * FROM CHITIETDEP

SELECT * FROM KHACHHANG

SELECT * FROM KHUYENMAI

SELECT * FROM HOADON

SELECT * FROM HOADONCHITIET

