# Handout Kasir Sederhana - Android Jetpack Compose

Proyek **SimpleCashier App** ini adalah aplikasi kasir sederhana berbasis Android yang dikembangkan menggunakan **Kotlin** dan **Jetpack Compose**. Fokus utama dari proyek ini adalah pengimplementasian *State Management* menggunakan ViewModel serta pemodelan alur sistem yang terstruktur berdasarkan *Statechart*.

##  Fitur Utama
Sesuai dengan panduan praktikum, aplikasi ini mencakup fitur-fitur inti berikut :
- **Daftar Produk**: Menampilkan katalog produk yang tersedia untuk dijual.
- **Manajemen Keranjang**: Menambah produk ke keranjang, menambah jumlah, atau mengurangi jumlah item secara dinamis.
- **Perhitungan Otomatis**: Sistem secara otomatis menghitung subtotal, pajak (10%), dan total harga belanja.
- **Checkout**: Validasi transaksi untuk memastikan keranjang tidak kosong sebelum menyelesaikan pembelian.
- **Reset Transaksi**: Fitur untuk mengosongkan keranjang dan memulai transaksi baru dari awal.

##  Screenshot Aplikasi
Berikut adalah tampilan antarmuka aplikasi saat dijalankan:
<img width="1920" height="1080" alt="Screenshot 2026-05-06 140413" src="https://github.com/user-attachments/assets/ddc481d8-3ba0-4191-8f5d-bcca21d4c27d" />
<img width="1920" height="1080" alt="Screenshot 2026-05-06 140439" src="https://github.com/user-attachments/assets/4da718de-85e0-4387-bce9-23a91c80fa64" />
<img width="1920" height="1080" alt="Screenshot 2026-05-06 140446" src="https://github.com/user-attachments/assets/19fd9560-54e0-497a-b8cb-02947fbf8ad1" />

##  Teknologi & Arsitektur
- **Bahasa**: https://kotlinlang.org/)
- **UI Framework**: https://developer.android.com/jetpack/compose
- **Arsitektur**: Model-View-ViewModel
- **Minimum SDK**: API 24 (Android 7.0 Nougat) atau lebih tinggi 

##  Struktur Proyek
Kode diatur secara modular sesuai standar industri untuk memisahkan data, logika, dan tampilan:
```text
com.catherinenathania.tugascashier
├── MainActivity.kt          # Entry point aplikasi & State holder 
├── model/                   # Data model dan definisi UI State 
│   ├── Product.kt
│   ├── CartItem.kt
│   └── CashierUiState.kt
├── data/                    # Sumber data (Dummy Data) 
│   └── DummyProductData.kt
├── viewmodel/               # Logika bisnis aplikasi
│   └── CashierViewModel.kt
└── ui/                      # Antarmuka pengguna (Compose) 
    ├── screen/
    │   └── CashierScreen.kt
    └── component/           # Komponen UI yang dapat digunakan kembali 
        ├── ProductCard.kt
        ├── CartItemRow.kt
        └── SummarySection.kt
```

## ⚙️ Cara Menjalankan
1. Clone repository ini:
   ```bash
   git clone https://github.com/catherinenathania/Handout-Kasir-sederhana.git
   ```
2. Buka folder proyek menggunakan **Android Studio** (versi stabil terbaru disarankan).
3. Lakukan **Sync Project with Gradle Files** dan tunggu hingga selesai.
4. Jalankan aplikasi menggunakan Emulator atau Perangkat Android fisik.

---
*Proyek ini disusun sebagai pemenuhan tugas mata kuliah Pemrograman Sistem Interaktif.* 
```
