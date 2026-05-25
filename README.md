# Database Practice - Android Studio (Praktikum 3)

Repositori ini berisi proyek latihan Android Studio yang berfokus pada implementasi penyimpanan data lokal menggunakan **SharedPreferences** dan **SQLite Database** (`SQLiteAssetHelper`).

## Fitur Aplikasi
- **Halaman Utama (`MainActivity`)**: Menampilkan teks selamat datang berdasarkan nama pengguna yang tersimpan di penyimpanan lokal.
- **Halaman Profil (`ProfileActivity`)**: Digunakan untuk menginput, memperbarui, dan menyimpan data pengguna seperti **Nama**, **NIM**, dan **Device ID**. Data otomatis tersimpan ganda ke *SharedPreferences* dan *SQLite*.
- **Halaman Komentar (`PostCommentActivity`)**: Mengirim pesan/komentar dengan memanfaatkan *Device ID* pengguna yang diambil langsung dari sesi aktif penyimpanan lokal.

## Teknologi & Library yang Digunakan
- **Bahasa Pemrograman**: Kotlin
- **User Interface (UI)**: XML Layout (dengan komponen `LinearLayout`, `Button`, `EditText`, `TextView`)
- **Penyimpanan Lokal 1**: `SharedPreferences` (untuk data sesi ringan seperti nama)
- **Penyimpanan Lokal 2**: SQLite Database dengan library `com.readystatesoftware.sqliteasset:sqliteassethelper` (untuk manajemen database eksternal `.sqlite3` / `ensureTableExists`)
- **Target SDK**: Android 36 (compileSdk 36)
- **Gradle**: Ver. 9.3.1 (Kotlin DSL)

## Struktur Penting Proyek
- `app/src/main/java/com/example/praktikum3/`
  - `MainActivity.kt` — Logika halaman utama & siklus `onResume()` data.
  - `ProfileActivity.kt` — Pengisian form profil, enkapsulasi `editSharedPref`, dan pemanggilan `DatabaseHelper`.
  - `PostCommentActivity.kt` — Logika pengiriman komentar menggunakan ID perangkat.
  - `database/DatabaseHelper.kt` — Kelas pembantu SQLite (`insertOrUpdateProfile` & `readData`).
- `app/src/main/res/layout/` — File desain tampilan XML aplikasi.
