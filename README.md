# Laptop Shop

Web aplikacija za prikaz laptopa, dodatne opreme i narudžbi. Rađeno u sklopu predmeta Web programiranje (Lab 1 i Lab 2).

## Autori

- [Emir Šabanović]
- [Delila Osmančević]

---

# Lab 1 – Mini MVC aplikacija

## Modeli

### Model A – `Laptop`

| Atribut | Tip | Opis |
|---------|-----|------|
| id | Long | primarni ključ (auto-generisan) |
| brand | String | proizvođač |
| model | String | naziv modela |
| price | double | cijena |
| ramGb | int | RAM u GB |
| storageGb | int | pohrana u GB |

### Model B – `Accessory` (dodatna oprema)

| Atribut | Tip | Opis |
|---------|-----|------|
| id | Long | primarni ključ |
| name | String | naziv opreme |
| type | String | vrsta opreme (miš, torba, dock stanica, punjač...) |
| price | double | cijena |
| inStock | boolean | da li je na stanju |
| laptop | Laptop | laptop kojem oprema pripada |

## Relacija između modela A i B (1:N)

Jedan `Laptop` ima više komada opreme `Accessory`, a svaki `Accessory` pripada tačno jednom `Laptop`-u.
U kodu: `@OneToMany(mappedBy = "laptop")` u klasi `Laptop` i `@ManyToOne` + `@JoinColumn(name = "laptop_id")` u klasi `Accessory`.

## Podjela posla (Lab 1)

- **[Emir Šabanović]:** [UPISATI: šta je radio/la, npr. Model A, ruta i view liste A]
- **[Delila Osmančević]:** [UPISATI: šta je radio/la, npr. Model B, ruta i view liste B]
- **Zajedno:** akcija u kontroleru i stranica akcije

---

# Lab 2 – REST API i baza podataka

## Novi model – Model C: `Narudzba`

| Atribut | Tip | Opis |
|---------|-----|------|
| id | Long | primarni ključ (auto-generisan) |
| imeKupca | String | ime kupca |
| email | String | email kupca |
| kolicina | int | naručena količina |
| datum | LocalDate | datum narudžbe |
| status | String | status narudžbe |
| laptop | Laptop | naručeni laptop |

## Logika dodavanja novog modela i ostvarena relacija (N:1)

Model `Narudzba` je povezan s modelom `Laptop` vezom više-na-jedan: jedan laptop može biti u više narudžbi, a svaka narudžba se odnosi na tačno jedan laptop.
U kodu: `@ManyToOne` + `@JoinColumn(name = "laptop_id")` u klasi `Narudzba`, pa tabela `narudzbe` ima strani ključ `laptop_id`.

[UPISATI: kako se laptop bira pri dodavanju narudžbe, npr. padajući meni u formi]

## Običan kontroler (Thymeleaf) za Narudzba

[UPISATI: šta radi običan kontroler i koje rute ima, npr. prikaz liste narudžbi, forma za dodavanje, spremanje nove narudžbe, forma za izmjenu i update]

## REST kontroler za Narudzba

[UPISATI: šta radi REST kontroler, koji endpoint ima i šta vraća, npr. GET /api/narudzbe vraća sve narudžbe kao JSON]

## Konfiguracija baze

- **Baza:** MySQL, šema `web_programiranje` (localhost:3306)
- **`pom.xml`:** dodane zavisnosti `spring-boot-starter-data-jpa` i `mysql-connector-j`
- **`application.properties`:**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/web_programiranje?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

- Lozinka baze se čita iz environment varijable `DB_PASSWORD`, pa nije upisana u repozitorij.
- `ddl-auto=update` automatski kreira i ažurira tabele prema entitetima.
- In-memory `DemoData` iz Laba 1 zamijenjen je repozitorijima (`LaptopRepository`, `AccessoryRepository`, `NarudzbaRepository`), a `DataLoader` pri prvom pokretanju puni bazu početnim podacima.

## Podjela posla (Lab 2)

- **[Emir Šabanović]:** [UPISATI: šta je radio/la]
- **[Delila Osmančević]:** [UPISATI: šta je radio/la]

---

# Screenshotovi

[UPISATI: ovdje prevući slike aplikacije u GitHub editor (lista laptopa, lista opreme, akcija, narudžbe, REST JSON), a ovu liniju obrisati]
