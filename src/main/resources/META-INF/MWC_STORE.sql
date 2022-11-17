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
	DiemTichLuy INT
)

-- Hóa đơn
CREATE TABLE HOADON (
	Id INT PRIMARY KEY IDENTITY(1,1),
	MaHD VARCHAR(20) UNIQUE,
	IdND INT,
	IdKH INT,
	IdKM INT,
	NgayTao DATE,
	NgayThanhToan DATE,
	NgayNhanYC DATE,
	NgayGiaoHang DATE,
	NgayNhanHang DATE,
	TrangThai INT
)

-- Hóa đơn chi tiết
CREATE TABLE HOADONCHITIET (
	Id INT PRIMARY KEY IDENTITY(1,1),
	IdCTD INT,
	IdHD INT,
	DonGia DECIMAL(20,0) DEFAULT 0,
	SoLuong INT,
	TRANGTHAI INT
)

-- KHUYẾN MÃI
CREATE TABLE KHUYENMAI (
	Id INT IDENTITY(1,1) PRIMARY KEY,
	Ma VARCHAR(50) UNIQUE,
	Ten NVARCHAR(50),
	PhanTramGiam FLOAT,
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

ALTER TABLE HOADON ADD CONSTRAINT FK_HD_KH FOREIGN KEY (IdKh) REFERENCES KhachHang(Id)

ALTER TABLE HOADON ADD CONSTRAINT FK_HD_KM FOREIGN KEY (IdKM) REFERENCES KhuyenMai (Id)

ALTER TABLE HOADONCHITIET ADD CONSTRAINT FK_HDCT_HD FOREIGN KEY (IdHd) REFERENCES HoaDon (Id)

ALTER TABLE HOADONCHITIET ADD CONSTRAINT FK_HDCT_CTD FOREIGN KEY (IdCtd) REFERENCES ChiTietDep (Id)



-- INSERT DATA
GO
INSERT CHATLIEU (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'CL1', N'Cao su', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT CHATLIEU (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'CL2', N'Vải', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT CHATLIEU (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'CL3', N'Bông', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT CHATLIEU (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'CL4', N'Vải nhựa', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT CHATLIEU (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'CL5', N'Nhựa PVC', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)

GO
INSERT CHUCVU (Ma, Ten) VALUES (N'CV1', N'Quản lý')
GO
INSERT CHUCVU (Ma, Ten) VALUES (N'CV2', N'Nhân viên')

GO
INSERT DEP (Ma, Ten, HinhAnh, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'SP1', N'Tổ ong 36 lỗ', N'1.jpg', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT DEP (Ma, Ten, HinhAnh, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'SP2', N'Tông lào VN', N'2.jpg', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT DEP (Ma, Ten, HinhAnh, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'SP3', N'Crocs Unisex', N'3.jpg', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT DEP (Ma, Ten, HinhAnh, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'SP4', N'Tổ ong 72 lỗ', N'4.jpg', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT DEP (Ma, Ten, HinhAnh, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'SP5', N'Dép bánh mì', N'5.jpg', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)

GO
INSERT LOAIDEP (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'LD1', N'Sandal', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT LOAIDEP (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'LD2', N'Tông lào', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT LOAIDEP (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'LD3', N'Crocs', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT LOAIDEP (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'LD4', N'Tổ ong', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT LOAIDEP (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'LD5', N'Xỏ ngón', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)

GO
INSERT MAUSAC (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'MS1', N'Trắng', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT MAUSAC (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'MS2', N'Đen', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT MAUSAC (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'MS3', N'Đỏ', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT MAUSAC (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'MS4', N'Vàng', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT MAUSAC (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'MS5', N'Xanh', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)

GO
INSERT NGUOIDUNG (IdCV, Ma, Ten, Email, Sdt, DiaChi, GioiTinh, MatKhau, TrangThai, HinhAnh) VALUES (1, N'huongvn', N'Vũ Nguyên Hướng', N'huongvnph27229@fpt.edu.vn', N'0395080513', N'Nam Định', 0, N'123123', 0, N'mtkh.jpg')
GO
INSERT NGUOIDUNG (IdCV, Ma, Ten, Email, Sdt, DiaChi, GioiTinh, MatKhau, TrangThai, HinhAnh) VALUES (1, N'kimchi', N'Lại Thị Kim Chi', N'chiltkph26384@fpt.edu.vn', N'0999888999', N'Nam Định', 0, N'123123', 0, N'kimchi.jpg')

GO
INSERT NSX (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'NX1', N'Puma', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT NSX (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'NX2', N'Nike', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT NSX (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'NX3', N'Balenciaga', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT NSX (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'NX4', N'Adidas', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT NSX (Ma, Ten, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'NX5', N'Jordan', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)

GO
INSERT SIZE (Ma, KichCo, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'SZ1', 36, CAST(N'2022-11-09' AS Date), CAST(N'2022-11-09' AS Date), 0)
GO
INSERT SIZE (Ma, KichCo, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'SZ2', 37, CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT SIZE (Ma, KichCo, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'SZ3', 38, CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT SIZE (Ma, KichCo, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'SZ4', 39, CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT SIZE (Ma, KichCo, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'SZ5', 40, CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT SIZE (Ma, KichCo, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'SZ6', 41, CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT SIZE (Ma, KichCo, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'SZ7', 42, CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT SIZE (Ma, KichCo, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'SZ8', 43, CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT SIZE (Ma, KichCo, NgayThem, NgaySuaCuoi, TrangThai) VALUES (N'SZ9', 44, CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)

GO
INSERT CHITIETDEP (IdDep, IdLoaiDep, IdMauSac, IdChatLieu, IdNsx, IdSize, MoTa, SoLuong, GiaNhap, GiaBan, NgayThem, NgaySuaCuoi, TrangThai) VALUES (1, 1, 3, 2, 1, 2, N'Đẹp', 5, CAST(1000 AS Decimal(20, 0)), CAST(2000 AS Decimal(20, 0)), CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT CHITIETDEP (IdDep, IdLoaiDep, IdMauSac, IdChatLieu, IdNsx, IdSize, MoTa, SoLuong, GiaNhap, GiaBan, NgayThem, NgaySuaCuoi, TrangThai) VALUES (2, 2, 2, 2, 5, 3, N'Rất đẹp', 10, CAST(1500 AS Decimal(20, 0)), CAST(2500 AS Decimal(20, 0)), CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT CHITIETDEP (IdDep, IdLoaiDep, IdMauSac, IdChatLieu, IdNsx, IdSize, MoTa, SoLuong, GiaNhap, GiaBan, NgayThem, NgaySuaCuoi, TrangThai) VALUES (3, 3, 3, 4, 3, 2, N'Rất rất đẹp', 30, CAST(2000 AS Decimal(20, 0)), CAST(3000 AS Decimal(20, 0)), CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT CHITIETDEP (IdDep, IdLoaiDep, IdMauSac, IdChatLieu, IdNsx, IdSize, MoTa, SoLuong, GiaNhap, GiaBan, NgayThem, NgaySuaCuoi, TrangThai) VALUES (5, 4, 4, 5, 2, 3, N'Sang chảnh', 25, CAST(2000 AS Decimal(20, 0)), CAST(4000 AS Decimal(20, 0)), CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)

GO
INSERT KHACHHANG (Ma, Ten, Sdt, DiaChi, DiemTichLuy) VALUES (N'KH1', N'Đinh Hải Dương', N'0666777555', N'Giao Thủy', 0)
GO
INSERT KHACHHANG (Ma, Ten, Sdt, DiaChi, DiemTichLuy) VALUES (N'KH2', N'Phạm Tiến Đạt', N'0333222444', N'Hà Nội', 0)
GO
INSERT KHACHHANG (Ma, Ten, Sdt, DiaChi, DiemTichLuy) VALUES (N'KH3', N'Phạm Đức Anh', N'0888666444', N'Hải Dương', 0)


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