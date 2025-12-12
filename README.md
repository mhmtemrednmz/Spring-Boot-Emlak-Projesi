# 🏠 Spring Boot Emlak Otomasyon Projesi

Bu proje, Spring Boot ile geliştirilmiş, kullanıcıların konut ve arsa ilanı verebildiği, ilanları favorilerine ekleyebildiği ve satıcılarla mesajlaşabildiği kapsamlı bir **Emlak Yönetim Sistemi** REST API uygulamasıdır.

## 🛠 Kullanılan Teknolojiler

Proje modern backend standartlarına uygun olarak geliştirilmiştir:

* **Java 17** - Programlama Dili
* **Spring Boot 3.x** - Ana Framework
* **Spring Security & JWT** - Güvenli Kimlik Doğrulama
* **Spring Data JPA** - Veritabanı İlişkilendirme (ORM)
* **PostgreSQL** - Veritabanı Yönetimi
* **Lombok** - Kod tekrarını önlemek için
* **Maven** - Bağımlılık Yönetimi

---

## 💻 Proje Özellikleri

Uygulama, farklı emlak türlerini yönetebilen ve kullanıcı etkileşimini sağlayan modüller içerir.

### 🔐 Kimlik ve Yetkilendirme
* **JWT Authentication:** Kullanıcı kayıt (Register) ve giriş (Login) işlemleri güvenli token yapısıyla yönetilir.
* **Rol Bazlı Erişim:** (Opsiyonel) Kullanıcı ve yönetici yetkilendirmeleri için altyapı mevcuttur.

### 🏘 İlan Yönetimi
* **Konut (Housing):** Daire, Villa, Müstakil Ev gibi konut tipleri için özel alanlar (Oda sayısı, kat, ısınma tipi vb.) içeren ilan yönetimi.
* **Arsa (Land):** Tarla, İmarlı Arsa gibi gayrimenkuller için ada/parsel ve imar durumu bilgilerini içeren ilan yönetimi.
* **Görsel Yönetimi:** İlanlara birden fazla fotoğraf yüklenebilir.

### ❤️ Kullanıcı Etkileşimi
* **Favoriler:** Kullanıcılar beğendikleri ilanları favori listelerine ekleyip çıkarabilirler.
* **Mesajlaşma:** Alıcılar ve satıcılar arasında sistem içi mesajlaşma altyapısı bulunur.

### ⚙️ Teknik Detaylar
* **Global Exception Handling:** Hatalı istekler veya sunucu hataları merkezi bir yapıda yakalanıp anlamlı mesajlar döndürülür.
* **Enums:** İlan durumu (`AdvertStatus`), Isınma tipi (`HeatingType`) ve Arsa tipi (`LandType`) gibi sabit veriler enum yapılarıyla yönetilir.

---

## 🚀 Kurulum ve Çalıştırma

1.  Projeyi bilgisayarınıza klonlayın:
    ```bash
    git clone [https://github.com/mhmtemrednmz/Spring-Boot-Emlak-Projesi.git](https://github.com/mhmtemrednmz/Spring-Boot-Emlak-Projesi.git)
    ```
2.  **PostgreSQL** üzerinde `emlakapp` (veya `application.properties` dosyasında belirtilen isimde) bir veritabanı oluşturun.
3.  `src/main/resources/application.properties` dosyasını kendi veritabanı bilgilerinizle güncelleyin:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/emlakapp
    spring.datasource.username=postgres
    spring.datasource.password=Sifreniz
    ```
4.  Terminal veya IDE üzerinden projeyi ayağa kaldırın:
    ```bash
    ./mvnw spring-boot:run
    ```

---

## 🔌 API Uç Noktaları (Endpoints)

Ana servisler `rest/api/` altında toplanmıştır.

| Modül | Metot | URL | Açıklama |
| --- | --- | --- | --- |
| **Auth** | POST | `/register` | Kullanıcı kaydı |
| | POST | `/authenticate` | Giriş yap ve Token al |
| **Housing** | POST | `/rest/api/housing/save` | Yeni konut ilanı ekle |
| | GET | `/rest/api/housing/list` | Tüm konutları listele |
| **Land** | POST | `/rest/api/land/save` | Yeni arsa ilanı ekle |
| **Favorite** | POST | `/rest/api/favorite/add` | İlanı favorilere ekle |
| **Message** | POST | `/rest/api/message/send` | Satıcıya mesaj gönder |
| **Image** | POST | `/rest/api/image/upload` | İlana resim yükle |

---

## 📂 Veritabanı Modelleri

Projedeki temel veri yapıları:

* **Advert (Abstract):** `Housing` ve `Land` sınıflarının miras aldığı temel ilan sınıfı (Başlık, Fiyat, Açıklama).
* **Housing:** Konut detaylarını tutar (Oda sayısı, Isınma tipi vb.).
* **Land:** Arsa detaylarını tutar (Metrekare, İmar durumu vb.).
* **User:** Kullanıcı bilgileri.
* **Favorite:** Kullanıcı ve İlan arasındaki ilişkiyi tutar.
* **Message:** Gönderici ve Alıcı arasındaki mesaj trafiğini tutar.

---

## 📞 İletişim

Sorularınız veya katkılarınız için:

* **Geliştirici:** Mehmet Emre Dönmez
* **GitHub:** [mhmtemrednmz](https://github.com/mhmtemrednmz)
