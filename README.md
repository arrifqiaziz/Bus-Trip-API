# Final Project Java Springboot - Bus Trip API
Final Project Java Springboot in BTDP feat Hactiv8 batch 1. A project REST API about Bus Trip, the result is Accessable End-Point API

<br>

## Informasi Dasar
Aplikasi Bus Trip API adalah sebuah Final Project dari `BFI Technology Development Program (BTDP) feat Hactiv8 using Java Springboot`, aplikasi ini terfokus pada bagaimana cara kerja API dan membuat End Point API, yang dibuat oleh\
Nama		 : `Arrifqi Aziz Ardhiansyah`\
Kode Peserta : `JVSB001ONL009`

<br>

## Screenshot Aplikasi
[Screenshot API](https://github.com/arrifqiaziz/Bus-Trip-API/tree/main/Screenshot%20Swagger)

## Panduan Penggunaan Aplikasi

1. Masuk ke Home / Welcome
2. Masuk ke Swagger untuk masuk ke API 
http://localhost:8080/swagger-ui.html#/
3. Register
   a. Masuk pada End-Point user-controller
   b. Saat register isilah semua kolom yang diminta
   c. Pada kolom Role isi dengan (ROLE_ADMIN atau ROLE_USER)
   d. Seletah register, untuk login harus mendapatkan token untuk autentikasi pada auth-controller
4. Authorization
   a. Masuk pada End-Point auth-controller
   b. Isikan form pada auth
   c. Jika user dan password benar pun terdaftar akan keluar Token, copy semua token tersebut
5. Login
   a. Klik Authorize pada atas kanan
   b. Ketik `Bearer isitoken` pada value
6. Jika Token benar, login sukses dan Api dapat dijalankan

# Penjelasan Role
Admin dapat menjalankan semua API (Get, Post, Put, Delete)
User hanya dapat menjalankan API GET dan Post pada Trip

<br>

## End Point API
1. Agency Controller
2. Auth Controller
3. Bus Controller
4. Stop Controller
5. Ticket Controller
6. Trip Controller
7. Trip Schedulle Controller
8. User Controller

<br>

## Penjelasan End Point API

### Agency Controller
Agensi Bus adalah agen atau perusahaan yang menyediakan jasa transportasi bus
- `POST /api/v1/agency/` 		-> Input Data Agency
- `GET /api/v1/agency/`			-> Output All Data Agency
- `GET /api/v1/agency/{id}`		-> Output Data Agency by ID
- `PUT /api/v1/agency/{id}`		-> Edit Data Agency by ID
- `DELETE /api/v1/agency/{id}`	-> Delete Data Agency by ID

Penjelasan Form Post Agency
 code	  	: Kode Agency
 details	: Detail Agency
 name		: Nama Agency
 owner	: Pemilik Agency

<br>

### Auth Controller
Untuk autentikasi login, dengan mendapatkan token
- `POST /api/auth` 	-> Get Token

Penjelasan Form Post Auth
username	: Username user
password	: Password user

<br>

### Bus Controller
Unit bus secara detail dijelaskan disini
- `POST /api/v1/bus/{id}`		-> Input Data Bus by ID
- `GET /api/v1/bus/`			-> Output All Data Bus
- `GET /api/v1/bus/{id}`		-> Output Data Bus by ID
- `PUT /api/v1/bus/{id}`		-> Edit Data Bus by ID
- `DELETE /api/v1/bus/{id}`		-> Delete Data Bus by ID

Penjelasan Form Post Bus
id		: ID Bus
capacity	: Kapasitas Bus
code		: Kode Bus
make		: Memuat berapa penumpang

<br>

### Stop Controller
Tempat Pemberhentian (untuk Keberangkatan dan juga Tujuan)
- `POST /api/v1/stop/`			-> Input Data Stop
- `GET /api/v1/stop/`			-> Output All Data Stop
- `GET /api/v1/stop/{id}`		-> Output Data Stop by ID
- `GET /api/v1/stop/code/{code}`	-> Output Data Stop by Code
- `GET /api/v1/stop/name/{name}`	-> Output Data Stop by Name
- `PUT /api/v1/stop/{id}`		-> Edit Data Stop by ID
- `DELETE /api/v1/stop/{id}`		-> Delete Data Stop by ID

Penjelasan Form Post Stop
id		: ID Tempat
code		: Kode Tempat
detail	: Detail Tempat
name		: Nama Tempat

<br>

### Ticket Controller
Pembelian tiket dan pengisian data perjalanan
- `POST /api/v1/bus/`			-> Input Data Tiket by ID
- `GET /api/v1/bus/`			-> Output All Data Tiket
- `GET /api/v1/bus/{id}`		-> Output Data Tiket by ID
- `PUT /api/v1/bus/{id}`		-> Edit Data Tiket by ID
- `DELETE /api/v1/bus/{id}`		-> Delete Data Tiket by ID

Penjelasan Form Post Ticket
cancellable	: Apakah tiket dapat di cancel atau tidak
journeyDate	: Tanggal keberangkatan
passegerId	: ID Penumpang
seatNumber	: Nomor tempat duduk
tripScheduleId : ID Jadwal Perjalanan

<br>

### Trip Controller
Data Perjalanan
- `POST /api/v1/trip/`			-> Input Data Trip by ID
- `GET /api/v1/trip/`			-> Output All Data Trip
- `GET /api/v1/trip/{id}`		-> Output Data Trip by ID
- `PUT /api/v1/trip/{id}`		-> Edit Data Trip by ID
- `DELETE /api/v1/trip/{id}`		-> Delete Data Trip by ID

Penjelasan Form Post Trip
agencyId	: ID Agency
busId		: ID Bus
destStopId	: ID Tempat Tujuan
fare		: Ongkos Perjalanan
journeyTime	: Lama perjalanan (dalam satuan Jam)
sourceStopId: ID Tempat Pemberhentian

<br>

### Trip Schedule Controller
Jadwal Perjalanan Bus
- `POST /api/v1/trip_schedule/`		-> Input Data Jadwal Trip by ID
- `GET /api/v1/trip_schedule/`		-> Output All Data Jadwal Trip
- `GET /api/v1/trip_schedule/{id}`		-> Output Data Jadwal Trip by ID
- `PUT /api/v1/trip_schedule/{id}`		-> Edit Data Jadwal Trip by ID
- `DELETE /api/v1/trip_schedule/{id}`	-> Delete Data Jadwal Trip by ID

Penjelasan Form Post Trip Schedule
available_seats	: Jumlah kursi tersedia
tripDate		: Tanggal perjalanan
trip_detail		: Detail Perjalanan

<br>

### User Controller
Setiap orang yang akan registrasi/update data
- `POST /api/v1/user/signup`			-> Input Data User (Daftar)
- `PUT /api/v1/user/{id}`			-> Edit Data User by ID
- `PUT /api/v1/user/password/{id}`		-> Edit Password User by ID
- `DELETE /api/v1/user/{id}`			-> Delete Data User by ID

Penjelasan Form Signup User dapat dilakukan dengan 2 cara
1. Standart User
email		: Email User
firstName	: Nama Depan
lastName	: Nama Belakang
mobileNumber: Nomor HP
password	: Password
role		: Role (admin / user)
username	: username untuk login

2. Custom User
code		: Kode User
details	: Detail User
email		: Email User
firstName	: Nama Depan
lastName	: Nama Belakang
mobileNumber: Nomor HP
name		: Nama
password	: Password
role		: Role (admin / user)
username	: username untuk login

Format yang diinit awal
admin
username	: arrifqiaziz
password	: arrifqi123

user
fahmi		hoiri		dessy
fahmi123	hoiri123	dessy123


<br>

### Welcome Controller
Untuk Landing page belum


<br>

##### Signature
Made with Heart, Hard Work, Smart Think and Whole Soul <3

Name  : Arrifqi Aziz Ardhiansyah\
Participant Code Java Springboot  : JVSB001ONL009\
Participant Code Katalon : KSAT006ONL009


[LinkedIn](https://www.linkedin.com/in/arrifqiaziz/) | [GitHub](https://github.com/arrifqiaziz)
