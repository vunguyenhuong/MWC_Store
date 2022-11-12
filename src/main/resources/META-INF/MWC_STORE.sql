CREATE DATABASE MWC_STORE
GO
USE MWC_STORE
GO

-- Dép
CREATE TABLE DEP (
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(50) DEFAULT NULL,
	HinhAnh NVARCHAR(50),
	NgayThem DATE,
	NgaySuaCuoi DATE,
	TrangThai INT
)

-- Loại dép
CREATE TABLE LOAIDEP (
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(50) DEFAULT NULL,
	NgayThem DATE,
	NgaySuaCuoi DATE,
	TrangThai INT
)

-- Màu sắc
CREATE TABLE MAUSAC (
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(50) DEFAULT NULL,
	NgayThem DATE,
	NgaySuaCuoi DATE,
	TrangThai INT
)

-- Chất liệu
CREATE TABLE CHATLIEU (
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(50) DEFAULT NULL,
	NgayThem DATE,
	NgaySuaCuoi DATE,
	TrangThai INT
)

-- Nhà sản xuất
CREATE TABLE NSX (
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(50) DEFAULT NULL,
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
	MoTa NVARCHAR(50) DEFAULT NULL,
	SoLuong INT,
	GiaNhap DECIMAL(20,0) DEFAULT NULL,
	GiaBan DECIMAL(20,0) DEFAULT NULL,
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
	Ten NVARCHAR(50) DEFAULT NULL,
	Email VARCHAR(MAX),
	Sdt VARCHAR(20) DEFAULT NULL,
	DiaChi NVARCHAR(255) DEFAULT NULL,
	GioiTinh INT,
	MatKhau VARCHAR(MAX),
	TrangThai INT,
	HinhAnh NVARCHAR(50)
)

-- Khách hàng
CREATE TABLE KHACHHANG (
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(50) DEFAULT NULL,
	Sdt VARCHAR(20) DEFAULT NULL,
	DiaChi NVARCHAR(255) DEFAULT NULL,
	DiemTichLuy INT
)

-- Hóa đơn
CREATE TABLE HOADON (
	Id INT PRIMARY KEY IDENTITY(1,1),
	IdND INT,
	IdKH INT,
	NgayTao DATE DEFAULT NULL,
	NgayThanhToan DATE DEFAULT NULL,
	TrangThai INT
)

-- Hóa đơn chi tiết
CREATE TABLE HOADONCHITIET (
	IdCTD INT,
	IdHD INT,
	DonGia DECIMAL(20,0) DEFAULT 0,
	SoLuong INT
	CONSTRAINT FK_HDCT_HD FOREIGN KEY (IdHd) REFERENCES HoaDon (Id),
	CONSTRAINT FK_HDCT_CTD FOREIGN KEY (IdCtd) REFERENCES ChiTietDep (Id),
	CONSTRAINT PK_HDCT PRIMARY KEY (IdCTD,IdHD)
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

/*
INSERT INTO CHUCVU (Ma, Ten) VALUES ('CV01',N'Quản lý')
INSERT INTO CHUCVU (Ma, Ten) VALUES ('CV02',N'Nhân viên')

INSERT INTO NGUOIDUNG
             (IdCV, Ma, Ten, Email, Sdt, DiaChi, GioiTinh, MatKhau, TrangThai, HinhAnh)
VALUES ('1','huongvn',N'Vũ Nguyên Hướng','huongvnph27229@fpt.edu.vn','0395080513',N'Nam Định',0,'123456',0,'mtkh.jpg')

INSERT INTO NGUOIDUNG
             (IdCV, Ma, Ten, Email, Sdt, DiaChi, GioiTinh, MatKhau, TrangThai, HinhAnh)
VALUES ('1','kimchi',N'Lại Thị Kim Chi','chiltkph26384@fpt.edu.vn','0999888999',N'Nam Định',0,'123456',0,'kimchi.jpg')
*/
GO
SET IDENTITY_INSERT [dbo].[CHATLIEU] ON
GO
INSERT [dbo].[CHATLIEU] ([Id], [Ma], [Ten], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (1, N'CL01', N'Cao su', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[CHATLIEU] ([Id], [Ma], [Ten], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (2, N'CL02', N'Vải', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[CHATLIEU] ([Id], [Ma], [Ten], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (3, N'CL03', N'Bông', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[CHATLIEU] ([Id], [Ma], [Ten], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (4, N'CL04', N'Vải nhựa', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[CHATLIEU] ([Id], [Ma], [Ten], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (5, N'CL05', N'Nhựa PVC', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
SET IDENTITY_INSERT [dbo].[CHATLIEU] OFF
GO
SET IDENTITY_INSERT [dbo].[CHUCVU] ON 
GO
INSERT [dbo].[CHUCVU] ([Id], [Ma], [Ten]) VALUES (1, N'CV01', N'Quản lý')
GO
INSERT [dbo].[CHUCVU] ([Id], [Ma], [Ten]) VALUES (2, N'CV02', N'Nhân viên')
GO
SET IDENTITY_INSERT [dbo].[CHUCVU] OFF
GO
SET IDENTITY_INSERT [dbo].[DEP] ON 
GO
INSERT [dbo].[DEP] ([Id], [Ma], [Ten], [HinhAnh], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (1, N'SP01', N'Tổ ong 36 lỗ', N'1.jpg', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[DEP] ([Id], [Ma], [Ten], [HinhAnh], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (2, N'SP02', N'Tông lào VN', N'2.jpg', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[DEP] ([Id], [Ma], [Ten], [HinhAnh], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (3, N'SP03', N'Crocs Unisex', N'3.jpg', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[DEP] ([Id], [Ma], [Ten], [HinhAnh], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (4, N'SP04', N'Tổ ong 72 lỗ', N'4.jpg', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[DEP] ([Id], [Ma], [Ten], [HinhAnh], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (5, N'SP05', N'Dép bánh mì', N'5.jpg', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
SET IDENTITY_INSERT [dbo].[DEP] OFF
GO
SET IDENTITY_INSERT [dbo].[LOAIDEP] ON 
GO
INSERT [dbo].[LOAIDEP] ([Id], [Ma], [Ten], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (1, N'LD01', N'Sandal', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[LOAIDEP] ([Id], [Ma], [Ten], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (2, N'LD02', N'Tông lào', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[LOAIDEP] ([Id], [Ma], [Ten], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (3, N'LD03', N'Crocs', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[LOAIDEP] ([Id], [Ma], [Ten], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (4, N'LD04', N'Tổ ong', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[LOAIDEP] ([Id], [Ma], [Ten], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (5, N'LD05', N'Xỏ ngón', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
SET IDENTITY_INSERT [dbo].[LOAIDEP] OFF
GO
SET IDENTITY_INSERT [dbo].[MAUSAC] ON 
GO
INSERT [dbo].[MAUSAC] ([Id], [Ma], [Ten], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (1, N'MS01', N'Trắng', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[MAUSAC] ([Id], [Ma], [Ten], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (2, N'MS02', N'Đen', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[MAUSAC] ([Id], [Ma], [Ten], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (3, N'MS03', N'Đỏ', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[MAUSAC] ([Id], [Ma], [Ten], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (4, N'MS04', N'Vàng', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[MAUSAC] ([Id], [Ma], [Ten], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (5, N'MS05', N'Xanh', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
SET IDENTITY_INSERT [dbo].[MAUSAC] OFF
GO
SET IDENTITY_INSERT [dbo].[NGUOIDUNG] ON 
GO
INSERT [dbo].[NGUOIDUNG] ([Id], [IdCV], [Ma], [Ten], [Email], [Sdt], [DiaChi], [GioiTinh], [MatKhau], [TrangThai], [HinhAnh]) VALUES (1, 1, N'huongvn', N'Vũ Nguyên Hướng', N'huongvnph27229@fpt.edu.vn', N'0395080513', N'Nam Định', 0, N'83fb4a1f', 0, N'mtkh.jpg')
GO
INSERT [dbo].[NGUOIDUNG] ([Id], [IdCV], [Ma], [Ten], [Email], [Sdt], [DiaChi], [GioiTinh], [MatKhau], [TrangThai], [HinhAnh]) VALUES (2, 1, N'kimchi', N'Lại Thị Kim Chi', N'chiltkph26384@fpt.edu.vn', N'0999888999', N'Nam Định', 0, N'12345678', 0, N'kimchi.jpg')
GO
SET IDENTITY_INSERT [dbo].[NGUOIDUNG] OFF
GO
SET IDENTITY_INSERT [dbo].[NSX] ON 
GO
INSERT [dbo].[NSX] ([Id], [Ma], [Ten], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (1, N'NX01', N'Puma', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[NSX] ([Id], [Ma], [Ten], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (2, N'NX02', N'Nike', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[NSX] ([Id], [Ma], [Ten], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (3, N'NX03', N'Balenciaga', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[NSX] ([Id], [Ma], [Ten], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (4, N'NX04', N'Adidas', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[NSX] ([Id], [Ma], [Ten], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (5, N'NX05', N'Jordan', CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
SET IDENTITY_INSERT [dbo].[NSX] OFF
GO
SET IDENTITY_INSERT [dbo].[SIZE] ON 
GO
INSERT [dbo].[SIZE] ([Id], [Ma], [KichCo], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (1, N'S36', 36, CAST(N'2022-11-09' AS Date), CAST(N'2022-11-09' AS Date), 0)
GO
INSERT [dbo].[SIZE] ([Id], [Ma], [KichCo], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (2, N'S37', 37, CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[SIZE] ([Id], [Ma], [KichCo], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (3, N'S38', 38, CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[SIZE] ([Id], [Ma], [KichCo], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (4, N'S39', 39, CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[SIZE] ([Id], [Ma], [KichCo], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (5, N'S40', 40, CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[SIZE] ([Id], [Ma], [KichCo], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (6, N'S41', 41, CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[SIZE] ([Id], [Ma], [KichCo], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (7, N'S42', 42, CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[SIZE] ([Id], [Ma], [KichCo], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (8, N'S43', 43, CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[SIZE] ([Id], [Ma], [KichCo], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (9, N'S44', 44, CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
SET IDENTITY_INSERT [dbo].[SIZE] OFF 
GO
SET IDENTITY_INSERT [dbo].[CHITIETDEP] ON 
GO
INSERT [dbo].[CHITIETDEP] ([Id], [IdDep], [IdLoaiDep], [IdMauSac], [IdChatLieu], [IdNsx], [IdSize], [MoTa], [SoLuong], [GiaNhap], [GiaBan], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (1, 1, 1, 3, 2, 1, 2, N'Đẹp', 5, CAST(1000 AS Decimal(20, 0)), CAST(2000 AS Decimal(20, 0)), CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[CHITIETDEP] ([Id], [IdDep], [IdLoaiDep], [IdMauSac], [IdChatLieu], [IdNsx], [IdSize], [MoTa], [SoLuong], [GiaNhap], [GiaBan], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (2, 2, 2, 2, 2, 5, 3, N'Rất đẹp', 10, CAST(1500 AS Decimal(20, 0)), CAST(2500 AS Decimal(20, 0)), CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[CHITIETDEP] ([Id], [IdDep], [IdLoaiDep], [IdMauSac], [IdChatLieu], [IdNsx], [IdSize], [MoTa], [SoLuong], [GiaNhap], [GiaBan], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (3, 3, 3, 3, 4, 3, 2, N'Rất rất đẹp', 30, CAST(2000 AS Decimal(20, 0)), CAST(3000 AS Decimal(20, 0)), CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
INSERT [dbo].[CHITIETDEP] ([Id], [IdDep], [IdLoaiDep], [IdMauSac], [IdChatLieu], [IdNsx], [IdSize], [MoTa], [SoLuong], [GiaNhap], [GiaBan], [NgayThem], [NgaySuaCuoi], [TrangThai]) VALUES (4, 5, 4, 4, 5, 2, 3, N'Sang chảnh', 25, CAST(2000 AS Decimal(20, 0)), CAST(4000 AS Decimal(20, 0)), CAST(N'2022-11-11' AS Date), CAST(N'2022-11-11' AS Date), 0)
GO
SET IDENTITY_INSERT [dbo].[CHITIETDEP] OFF
GO


SELECT * FROM NGUOIDUNG
SELECT * FROM CHUCVU
SELECT * FROM DEP
SELECT * FROM LOAIDEP
SELECT * FROM CHATLIEU
SELECT * FROM SIZE
SELECT * FROM NSX
SELECT * FROM MAUSAC
SELECT * FROM CHITIETDEP